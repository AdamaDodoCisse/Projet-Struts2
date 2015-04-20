package fr.appli.qcm.actions.administration;

import fr.appli.qcm.actions.AbstractAction;
import fr.appli.qcm.app.Factories.DAOFactory;
import fr.appli.qcm.app.dao.EvaluationDAO;
import fr.appli.qcm.app.dao.QuestionDAO;

import fr.appli.qcm.app.dao.ReponseDAO;
import fr.appli.qcm.app.modeles.QuestionModele;


public class QuestionAction extends AbstractAction {

    private QuestionModele question ;
    private ReponseDAO reponseDAO;
    private EvaluationDAO evaluationDAO;

    public void setQuestion(QuestionModele question) {
        this.question = question;
    }

    public QuestionModele getQuestion() {
        return question;
    }


    private QuestionDAO questionDAO;

    public QuestionDAO getQuestionDAO() {
        return questionDAO;
    }

    public QuestionAction()
    {
        this.reponseDAO = DAOFactory.getReponseDAO();
        this.questionDAO  = DAOFactory.getQuestionDAO();
        this.evaluationDAO = DAOFactory.getEvaluationDAO();
    }

    public String ajouterQuestion()
    {

        if(this.question != null)
        {
            this.questionDAO.creer(this.question);
        }

        return SUCCESS;
    }

    public String supprimerQuestion()
    {
        if(question != null)
        {
            this.questionDAO.supprimer(question.getIdentifiant());
            this.reponseDAO.supprimerQuestion(question.getIdentifiant());
            this.evaluationDAO.supprimerQuestion(question.getIdentifiant());
        }
        return SUCCESS;
    }
}
