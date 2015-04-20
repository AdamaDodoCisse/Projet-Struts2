package fr.appli.qcm.app.implement;

import fr.appli.qcm.app.Factories.DAOFactory;
import fr.appli.qcm.app.dao.QuestionDAO;
import fr.appli.qcm.app.dao.QuestionnaireDAO;
import fr.appli.qcm.app.dao.ReponseDAO;
import fr.appli.qcm.app.modeles.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ReponseImplement extends CRUDImplement implements ReponseDAO {

    public static final String TABLE_REPONSE = "reponse.table";

    public ReponseImplement() {
    }

    @Override
    public boolean creer(ModeleCRUD modeleCRUD) {

        QuestionDAO questionDAO = DAOFactory.getQuestionDAO();
        QuestionnaireDAO questionnaireDAO  = DAOFactory.getQuestionnaireDAO();
        if(modeleCRUD instanceof ReponseModele)
        {
            ReponseModele r = (ReponseModele) modeleCRUD;
            QuestionModele q = r.getQuestion();
            QuestionnaireModele qn = r.getQuestionnaire();
            if(questionDAO.existe(q.getIdentifiant())
                    && questionnaireDAO.existe(qn.getIdentifiant()))
            return super.creer(modeleCRUD);
        }
        return false;
    }

    @Override
    public boolean supprimerQuestion(int idQuestion)
    {
        HashMap<Integer , ModeleCRUD> cruds = new HashMap<Integer, ModeleCRUD>();
        for(Integer integer : this.table.modeleCRUDs.keySet())
        {
            ReponseModele reponse = (ReponseModele) this.table.modeleCRUDs.get(integer);
            if(reponse.getQuestion().getIdentifiant() != idQuestion)
            {
                cruds.put(integer , reponse);
            }
        }
        this.table.modeleCRUDs = new HashMap<Integer, ModeleCRUD>();
        this.table.modeleCRUDs.putAll(cruds);
        __serialise();
        return true;
    }
    @Override
    public boolean supprimerQuestionnaire(int idQuestionnaire)
    {
        HashMap<Integer , ModeleCRUD> cruds = new HashMap<Integer, ModeleCRUD>();
        for(Integer integer : this.table.modeleCRUDs.keySet())
        {
            ReponseModele reponse = (ReponseModele) this.table.modeleCRUDs.get(integer);
            if(reponse.getQuestionnaire().getIdentifiant() != idQuestionnaire)
            {
                cruds.put(integer , reponse);
            }
        }
        this.table.modeleCRUDs = new HashMap<Integer, ModeleCRUD>();
        this.table.modeleCRUDs.putAll(cruds);
        __serialise();
        return true;
    }

    @Override
    public boolean modifier(ModeleCRUD modeleCRUD) {
        QuestionDAO questionDAO = DAOFactory.getQuestionDAO();
        QuestionnaireDAO questionnaireDAO  = DAOFactory.getQuestionnaireDAO();

        if(modeleCRUD instanceof ReponseModele)
        {
            ReponseModele r = (ReponseModele) modeleCRUD;
            QuestionModele q = r.getQuestion();
            QuestionnaireModele qn = r.getQuestionnaire();
            if(questionDAO.existe(q.getIdentifiant())
                    && questionnaireDAO.existe(qn.getIdentifiant()))
                return super.creer(modeleCRUD);
        } return false;
    }

    @Override
    public ModeleCRUD get(int identifiant) {

        QuestionDAO questionDAO = DAOFactory.getQuestionDAO();
        QuestionnaireDAO questionnaireDAO  = DAOFactory.getQuestionnaireDAO();

        ModeleCRUD modeleCRUD = super.get(identifiant);

        ReponseModele reponse = (ReponseModele) modeleCRUD;
        if(questionDAO.existe(reponse.getQuestion().getIdentifiant()) &&
                questionnaireDAO.existe(reponse.getQuestionnaire().getIdentifiant()))
        {
            reponse.setQuestion((QuestionModele) questionDAO.get(reponse.getQuestion().getIdentifiant()));
            reponse.setQuestionnaire((QuestionnaireModele) questionnaireDAO.get(reponse.getQuestionnaire().getIdentifiant()));
            __serialise();
            return reponse;
        } else
        {
            this.supprimer(identifiant);
            __serialise();
        }
        return null;
    }
    @Override
    public ArrayList<ReponseModele> listViaQuestionnaire(int idQuestionnaire)
    {

        QuestionnaireDAO questionnaireDAO = DAOFactory.getQuestionnaireDAO();
        ArrayList<ReponseModele> reponseModeles = new ArrayList<ReponseModele>();
        if(questionnaireDAO.existe(idQuestionnaire))
        {
            for(ModeleCRUD modeleCRUD : list())
            {
                ReponseModele reponse = (ReponseModele) modeleCRUD;

                if(reponse.getQuestionnaire().getIdentifiant() == idQuestionnaire)
                {
                    reponseModeles.add(reponse);
                }
            }
        }
        return reponseModeles;
    }

    public ArrayList<QuestionModele> listQuestions(int idQuestionnaire)
    {
        HashSet<Integer> integers = new HashSet<Integer>();

        for(ModeleCRUD r : list())
        {
            ReponseModele reponseModele = (ReponseModele) r;
            if(reponseModele.getQuestionnaire().getIdentifiant() == idQuestionnaire)
            {
                integers.add(reponseModele.getQuestion().getIdentifiant());
            }
        }

        QuestionDAO questionDAO = DAOFactory.getQuestionDAO();
        ArrayList<QuestionModele> questionModeles = new ArrayList<QuestionModele>();

        for(Integer i : integers)
        {
            if(questionDAO.existe(i))
                questionModeles.add((QuestionModele) questionDAO.get(i));
        }

        return questionModeles;
    }



    public ArrayList<ReponseModele> list(int idQuestionnaire , int idQuestion)
    {
        ArrayList<ReponseModele> reponseModeles = new ArrayList<ReponseModele>();

        QuestionnaireDAO questionnaireDAO = DAOFactory.getQuestionnaireDAO();
        QuestionDAO questionDAO = DAOFactory.getQuestionDAO();

        if(questionnaireDAO.existe(idQuestionnaire) && questionDAO.existe(idQuestion))
        {
            for(ModeleCRUD modeleCRUD : this.list())
            {
                ReponseModele reponse = (ReponseModele) modeleCRUD;

                if(reponse.getQuestionnaire().getIdentifiant() == idQuestionnaire &&
                        reponse.getQuestion().getIdentifiant() == idQuestion)
                {
                    reponseModeles.add(reponse);
                }
            }
        }

        return reponseModeles;
    }

    @Override
    protected String nomTable() {
        return TABLE_REPONSE;
    }

    @Override
    protected boolean autoIncremente() {
        return true;
    }

}
