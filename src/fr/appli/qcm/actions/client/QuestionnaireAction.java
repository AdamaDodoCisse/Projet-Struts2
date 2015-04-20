package fr.appli.qcm.actions.client;

import fr.appli.qcm.actions.AbstractAction;
import fr.appli.qcm.app.Factories.DAOFactory;
import fr.appli.qcm.app.dao.QuestionnaireDAO;
import fr.appli.qcm.app.modeles.QuestionnaireModele;
import fr.appli.qcm.app.modeles.UtilisateurModele;

public class QuestionnaireAction extends AbstractAction {

    private QuestionnaireDAO questionnaireDAO;

    private QuestionnaireModele questionnaire;

    private UtilisateurModele utilisateur;

    public UtilisateurModele getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurModele utilisateur) {
        this.utilisateur = utilisateur;
    }

    public QuestionnaireModele getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(QuestionnaireModele questionnaire) {
        this.questionnaire = questionnaire;
    }

    public QuestionnaireAction()
    {
    }

    public QuestionnaireDAO getQuestionnaireDAO() {
        return questionnaireDAO;
    }

    public void setQuestionnaireDAO(QuestionnaireDAO questionnaireDAO) {
        this.questionnaireDAO = questionnaireDAO;
    }

    public String listeQuestionnaire()
    {
        this.questionnaireDAO = DAOFactory.getQuestionnaireDAO();

        if(!this.session.containsKey(AuthentificationAction.UTILISATEUR))
        {
            return LOGIN;
        }
        this.utilisateur = (UtilisateurModele) this.session.get(AuthentificationAction.UTILISATEUR);

        return SUCCESS;
    }


}
