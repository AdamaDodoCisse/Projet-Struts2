package fr.appli.qcm.actions.administration;

import fr.appli.qcm.actions.AbstractAction;
import fr.appli.qcm.app.Factories.DAOFactory;
import fr.appli.qcm.app.dao.QuestionDAO;
import fr.appli.qcm.app.dao.QuestionnaireDAO;
import fr.appli.qcm.app.dao.ReponseDAO;
import fr.appli.qcm.app.modeles.QuestionModele;
import fr.appli.qcm.app.modeles.QuestionnaireModele;
import fr.appli.qcm.app.modeles.ReponseModele;

public class ReponseAction extends AbstractAction{

    private ReponseDAO reponseDAO;
    private ReponseModele reponse;
    private QuestionnaireDAO questionnaireDAO;
    private QuestionDAO questionDAO;

    public ReponseModele getReponse() {
        return reponse;
    }

    public QuestionnaireDAO getQuestionnaireDAO() {
        return questionnaireDAO;
    }

    public void setQuestionnaireDAO(QuestionnaireDAO questionnaireDAO) {
        this.questionnaireDAO = questionnaireDAO;
    }

    public QuestionDAO getQuestionDAO() {
        return questionDAO;
    }

    public void setQuestionDAO(QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }

    public void setReponse(ReponseModele reponse) {
        this.reponse = reponse;
    }

    public void setReponseDAO(ReponseDAO reponseDAO) {
        this.reponseDAO = reponseDAO;
    }

    public ReponseDAO getReponseDAO() {
        return reponseDAO;
    }

    public ReponseAction()
    {
        this.questionnaireDAO = DAOFactory.getQuestionnaireDAO();
        this.questionDAO = DAOFactory.getQuestionDAO();
        this.reponseDAO = DAOFactory.getReponseDAO();
    }

    public String ajouterReponse()
    {
        if(reponse != null)
        {
           if(questionDAO.existe(reponse.getQuestionnaire().getIdentifiant()) &&
                   questionDAO.existe(reponse.getQuestion().getIdentifiant()))
           {
               QuestionModele question = (QuestionModele)
                       questionDAO.get(reponse.getQuestion().getIdentifiant());
               QuestionnaireModele questionnaire = (QuestionnaireModele)
                       questionnaireDAO.get(reponse.getQuestionnaire().getIdentifiant());
               reponse.setQuestion(question);
               reponse.setQuestionnaire(questionnaire);

               if(!reponseDAO.creer(reponse))
               {
                    this.addActionError("error");
               } else
               {
                   this.addActionMessage("success");
               }
           } else {

               this.addActionError("error");
           }
        }

        return SUCCESS;
    }
}
