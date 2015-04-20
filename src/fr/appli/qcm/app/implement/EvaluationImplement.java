package fr.appli.qcm.app.implement;

import fr.appli.qcm.app.Factories.DAOFactory;
import fr.appli.qcm.app.dao.*;
import fr.appli.qcm.app.modeles.*;
import fr.appli.qcm.app.services.FichierService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class EvaluationImplement implements EvaluationDAO {

    private static final String TABLE = "evaluation.table";
    private ArrayList<EvaluationModele> evaluations;

    public EvaluationImplement()
    {
        Object o = FichierService.deserialise(TABLE);

        if(o == null)
            this.evaluations = new ArrayList<EvaluationModele>();
        else
            this.evaluations = (ArrayList) o;

        FichierService.serialise(this.evaluations, TABLE);

    }

    public ArrayList<EvaluationModele> list()
    {
        return this.evaluations;
    }

    @Override
    public ArrayList<ReponseModele> genererQCM(int idUtilisateur, int idQuestionnaire) {
        ArrayList<QuestionModele> QNL = questionNonRepondue(idUtilisateur, idQuestionnaire);
        ArrayList<ReponseModele> RM = new ArrayList<ReponseModele>();
        if(!QNL.isEmpty())
        {
            int rand = 0 + (int)(Math.random() * QNL.size() - 1);
            QuestionModele questionModele = QNL.get(rand);

            ReponseDAO reponseDAO = DAOFactory.getReponseDAO();
            for(ModeleCRUD modeleCRUD : reponseDAO.list())
            {
                ReponseModele reponseModele = (ReponseModele) modeleCRUD;
                if(reponseModele.getQuestion().getIdentifiant() == questionModele.getIdentifiant()
                        && reponseModele.getQuestionnaire().getIdentifiant() == idQuestionnaire)
                {
                    RM.add(reponseModele);
                }
            }
        }

        return RM;
    }

    public ArrayList<QuestionModele> questionRepondue(int idUtilisateur , int idQuestionnaire)
    {
        HashSet<Integer> integers = new HashSet<Integer>();

        for(EvaluationModele evaluation : evaluations)
        {
            if(evaluation.getParticipant().getUtilisateur().getIdentifiant() == idUtilisateur &&
                    evaluation.getParticipant().getQuestionnaire().getIdentifiant() == idQuestionnaire)
            {
                integers.add(evaluation.getReponse().getQuestion().getIdentifiant());
            }
        }

        ArrayList<QuestionModele> questions = new ArrayList<QuestionModele>();
        QuestionDAO questionDAO = DAOFactory.getQuestionDAO();
        for(Integer i : integers)
        {
            questions.add((QuestionModele)questionDAO.get(i));
        }

        return questions;
    }

    public ArrayList<QuestionModele> questionNonRepondue(int idUtilisateur , int idQuestionnaire)
    {
        ArrayList<QuestionModele> questionModeles = new ArrayList<QuestionModele>();
        ReponseDAO reponseDAO = DAOFactory.getReponseDAO();
        ArrayList<QuestionModele> lQ = reponseDAO.listQuestions(idQuestionnaire);
        ArrayList<QuestionModele> qrepondue = this.questionRepondue(idUtilisateur , idQuestionnaire);
        for(QuestionModele question : lQ)
        {
           if(!qrepondue.contains(question))
           {
                questionModeles.add(question);
           }
        }

        return questionModeles;
    }

    @Override
    public boolean supprimerParticipant(int idUtilisateur, int idQuestionnaire) {
        ArrayList<EvaluationModele> evaluationModeles = new ArrayList<EvaluationModele>();
        for(EvaluationModele evaluation : evaluations)
        {
            ParticipantModele participant = evaluation.getParticipant();

                if(!(idUtilisateur == participant.getUtilisateur().getIdentifiant() &&
                        participant.getQuestionnaire().getIdentifiant() == idQuestionnaire))
                {
                    evaluationModeles.add(evaluation);
                }
        }
        evaluations = new ArrayList<EvaluationModele>();
        evaluations.addAll(evaluationModeles);

        FichierService.serialise(evaluations , TABLE);

        return true;
    }

    @Override
    public boolean supprimerParticipant(int idUtilisateur) {
        ArrayList<EvaluationModele> evaluationModeles = new ArrayList<EvaluationModele>();
        for(EvaluationModele evaluation : list())
        {
            if(evaluation.getParticipant().getUtilisateur().getIdentifiant() != idUtilisateur)
            {
                evaluationModeles.add(evaluation);
            }
        }
        this.evaluations = new ArrayList<EvaluationModele>();
        this.evaluations.addAll(evaluationModeles);
        FichierService.serialise(evaluations , TABLE);
        return true;
    }

    @Override
    public boolean supprimerQuestion(int idQuestion) {
        ArrayList<EvaluationModele> evaluationModeles = new ArrayList<EvaluationModele>();
        for(EvaluationModele evaluation : list())
        {
            if(evaluation.getReponse().getQuestion().getIdentifiant() != idQuestion)
            {
                evaluationModeles.add(evaluation);
            }
        }
        this.evaluations = new ArrayList<EvaluationModele>();
        this.evaluations.addAll(evaluationModeles);
        FichierService.serialise(evaluations , TABLE);
        return true;
    }

    @Override
    public boolean supprimerQuestionnaire(int idQuestionnaire) {
        ArrayList<EvaluationModele> evaluationModeles = new ArrayList<EvaluationModele>();
        for(EvaluationModele evaluation : list())
        {
            if(evaluation.getReponse().getQuestionnaire().getIdentifiant() != idQuestionnaire)
            {
                evaluationModeles.add(evaluation);
            }
        }
        this.evaluations = new ArrayList<EvaluationModele>();
        this.evaluations.addAll(evaluationModeles);
        FichierService.serialise(evaluations , TABLE);
        return true;
    }

    @Override
    public boolean evaluer(int idUtilisateur, int idQuestionnaire, ArrayList<Integer> reponses) {
        ParticipantDAO participantDAO = DAOFactory.getParticipantDAO();


        if(participantDAO.existe(idUtilisateur , idQuestionnaire))
        {

            ParticipantModele participant = participantDAO.get(idUtilisateur , idQuestionnaire);

            for(Integer i : reponses)
            {
                ReponseDAO reponseDAO = DAOFactory.getReponseDAO();

                if(reponseDAO.existe(i))
                {
                    try {
                        this.evaluations.add(new EvaluationModele(participant , (ReponseModele) reponseDAO.get(i))) ;
                    } catch (Exception e) {}
                }
            }

            FichierService.serialise(evaluations , TABLE);
            return true;
        }
        return false;
    }

    @Override
    public boolean terminer(int idUtilisateur, int idQuestionnaire) {
        return questionRestante(idUtilisateur , idQuestionnaire) == 0;
    }

    @Override
    public boolean terminer(int idQuestionnaire) {
        ParticipantDAO participantDAO = DAOFactory.getParticipantDAO();
        for(ParticipantModele participant : participantDAO.list())
        {
            if(participant.getQuestionnaire().getIdentifiant() == idQuestionnaire)
            {
                if(!terminer(participant.getUtilisateur().getIdentifiant() , idQuestionnaire))
                    return false;
            }
        }
        return true;
    }

    @Override
    public float score(int idUtilisateur, int idQuestionnaire) {
        ParticipantDAO participantDAO = DAOFactory.getParticipantDAO();
        float score = 0;
        if(participantDAO.existe(idUtilisateur , idQuestionnaire))
        {

        }
        return score;
    }

    public boolean existe(int idUtilisateur , int idQuestionnaire , int idQuestion)
    {
        for(EvaluationModele evaluation :evaluations)
        {
            if(evaluation.getParticipant().getUtilisateur().getIdentifiant() == idUtilisateur &&
                evaluation.getParticipant().getQuestionnaire().getIdentifiant() == idQuestionnaire
                    && evaluation.getReponse().getQuestion().getIdentifiant() == idQuestion
            )
                return true;
        } return false;
    }

    public int questionRestante(int idUtilisateur , int idQuestionnaire)
    {
        ParticipantDAO participantDAO = DAOFactory.getParticipantDAO();
        int nombreQCM = -1;
        if(participantDAO.existe(idUtilisateur , idQuestionnaire))
        {
            QuestionDAO questionDAO = DAOFactory.getQuestionDAO();
            QuestionnaireDAO questionnaireDAO = DAOFactory.getQuestionnaireDAO();

            nombreQCM =((QuestionnaireModele) questionnaireDAO.get(idQuestionnaire)).getNombreQuestion();

            ArrayList<ModeleCRUD> questions = questionDAO.list();

            for(ModeleCRUD question : questions)
            {
                if(existe(idUtilisateur , idQuestionnaire, question.getIdentifiant()))
                    nombreQCM--;

            }
        }
        return nombreQCM;
    }

    public int nombrePersonneTerminer(int idQuestionnaire)
    {
        int cpt = 0;
        ParticipantDAO participantDAO = DAOFactory.getParticipantDAO();

        for(ParticipantModele participant : participantDAO.list())
        {
            if(participant.getQuestionnaire().getIdentifiant() == idQuestionnaire)
            {
                if(terminer(participant.getUtilisateur().getIdentifiant() , idQuestionnaire))
                    cpt++;
            }
        }
        return cpt;
    }
}
