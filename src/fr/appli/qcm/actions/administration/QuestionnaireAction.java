package fr.appli.qcm.actions.administration;

import fr.appli.qcm.actions.AbstractAction;
import fr.appli.qcm.app.Factories.DAOFactory;
import fr.appli.qcm.app.dao.*;
import fr.appli.qcm.app.modeles.QuestionnaireModele;


public class QuestionnaireAction extends AbstractAction {

    private QuestionnaireDAO questionnaireDAO;
    private QuestionDAO questionDAO;
    private QuestionnaireModele questionnaire;
    private ParticipantDAO participantDAO;
    private EvaluationDAO evaluationDAO;
    private ReponseDAO reponseDAO;

    public void setQuestionnaire(QuestionnaireModele questionnaire) {
        this.questionnaire = questionnaire;
    }

    public void setQuestionnaireDAO(QuestionnaireDAO questionnaireDAO) {
        this.questionnaireDAO = questionnaireDAO;
    }

    public QuestionnaireDAO getQuestionnaireDAO() {
        return questionnaireDAO;
    }

    public QuestionnaireModele getQuestionnaire() {
        return questionnaire;
    }

    public QuestionnaireAction()
    {
        this.questionnaireDAO = DAOFactory.getQuestionnaireDAO();
        this.questionDAO      = DAOFactory.getQuestionDAO();
        this.participantDAO   = DAOFactory.getParticipantDAO();
        this.reponseDAO       = DAOFactory.getReponseDAO();
        this.evaluationDAO    = DAOFactory.getEvaluationDAO();
    }

    public String ajouterQuestionnaire()
    {

        if(questionnaire != null)
        {
            this.questionnaireDAO.creer(this.questionnaire);
        }
        return SUCCESS;
    }

    public String supprimerQuestionnaire()
    {
        if(this.questionnaire != null)
        {
            this.questionnaireDAO.supprimer(this.questionnaire.getIdentifiant());
            this.evaluationDAO.supprimerQuestionnaire(this.questionnaire.getIdentifiant());
            this.reponseDAO.supprimerQuestionnaire(this.questionnaire.getIdentifiant());
            this.participantDAO.supprimerQuestionnaire(this.questionnaire.getIdentifiant());
        }

        return SUCCESS;
    }

    public String stopperQuestionnaire()
    {
        modifierAttente(true);
        return SUCCESS;
    }

    private void modifierAttente(boolean etat)
    {
        if(this.questionnaire != null)
        {
            if(this.questionnaireDAO.existe(this.questionnaire.getIdentifiant()))
            {
                this.questionnaire = (QuestionnaireModele)
                        this.questionnaireDAO.get(this.questionnaire.getIdentifiant());
                this.questionnaire.setAttente(etat);
                this.questionnaireDAO.modifier(this.questionnaire);
            }
        }
    }

    public String demarrerQuestionnaire()
    {
        modifierAttente(false);
        return SUCCESS;
    }
}
