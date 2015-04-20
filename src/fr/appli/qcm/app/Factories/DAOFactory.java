package fr.appli.qcm.app.Factories;

import fr.appli.qcm.app.dao.*;
import fr.appli.qcm.app.implement.*;


public class DAOFactory {

    private static QuestionDAO questionDAO;
    private static UtilisateurDAO utilisateurDAO;
    private static EvaluationDAO evaluationDAO;
    private static QuestionnaireDAO questionnaireDAO;
    private static ReponseDAO reponseDAO;
    private static ParticipantDAO participantDAO;

    public static QuestionDAO getQuestionDAO()
    {
        if(questionDAO == null)
            questionDAO = new QuestionImplement();
        return questionDAO;
    }

    public static UtilisateurDAO getUtilisateurDAO()
    {
        if(utilisateurDAO == null)
            utilisateurDAO = new UtilisateurImplement();
        return utilisateurDAO;
    }

    public static QuestionnaireDAO getQuestionnaireDAO()
    {
        if(questionnaireDAO == null)
            questionnaireDAO = new QuestionnaireImplement();
        return questionnaireDAO;
    }

    public static ReponseDAO getReponseDAO()
    {
        if(reponseDAO == null)
            reponseDAO = new ReponseImplement();
        return reponseDAO;
    }

    public static ParticipantDAO getParticipantDAO()
    {
        if(participantDAO == null)
            participantDAO = new ParticipantImplement();
        return participantDAO;
    }

    public static EvaluationDAO getEvaluationDAO()
    {
        if(evaluationDAO == null)
           evaluationDAO = new EvaluationImplement();
        return evaluationDAO;
    }
}
