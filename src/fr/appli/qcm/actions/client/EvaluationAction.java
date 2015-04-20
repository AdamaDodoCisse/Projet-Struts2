package fr.appli.qcm.actions.client;

import es.cenobit.struts2.json.annotations.Json;
import fr.appli.qcm.actions.AbstractAction;
import fr.appli.qcm.app.Factories.DAOFactory;
import fr.appli.qcm.app.dao.EvaluationDAO;
import fr.appli.qcm.app.dao.ParticipantDAO;
import fr.appli.qcm.app.dao.QuestionnaireDAO;
import fr.appli.qcm.app.modeles.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class EvaluationAction extends AbstractAction {
    private EvaluationModele evaluation;
    private QuestionnaireModele questionnaire;
    private QuestionnaireDAO questionnaireDAO;
    private ParticipantDAO participantDAO;
    private UtilisateurModele utilisateur;
    private ParticipantModele participant;
    private EvaluationDAO evaluationDAO;
    private ArrayList<ReponseModele> reponses;
    private ArrayList<Integer> choix;
    private String abandon;

    public ArrayList<Integer> getChoix() {
        return choix;
    }

    public void setChoix(ArrayList<Integer> choix) {
        this.choix = choix;
    }

    private QuestionModele question;

    public QuestionModele getQuestion() {
        return question;
    }

    public void setQuestion(QuestionModele question) {
        this.question = question;
    }

    public EvaluationModele getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(EvaluationModele evaluation) {
        this.evaluation = evaluation;
    }

    public QuestionnaireModele getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(QuestionnaireModele questionnaire) {
        this.questionnaire = questionnaire;
    }

    public QuestionnaireDAO getQuestionnaireDAO() {
        return questionnaireDAO;
    }

    public void setQuestionnaireDAO(QuestionnaireDAO questionnaireDAO) {
        this.questionnaireDAO = questionnaireDAO;
    }

    public ParticipantDAO getParticipantDAO() {
        return participantDAO;
    }

    public void setParticipantDAO(ParticipantDAO participantDAO) {
        this.participantDAO = participantDAO;
    }

    public UtilisateurModele getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurModele utilisateur) {
        this.utilisateur = utilisateur;
    }

    public ParticipantModele getParticipant() {
        return participant;
    }

    public void setParticipant(ParticipantModele participant) {
        this.participant = participant;
    }

    public EvaluationDAO getEvaluationDAO() {
        return evaluationDAO;
    }

    public void setEvaluationDAO(EvaluationDAO evaluationDAO) {
        this.evaluationDAO = evaluationDAO;
    }

    public ArrayList<ReponseModele> getReponses() {
        return reponses;
    }

    public void setReponses(ArrayList<ReponseModele> reponses) {
        this.reponses = reponses;
    }

    public void setAbandon(String abandon) {
        this.abandon = abandon;
    }

    public String getAbandon() {
        return abandon;
    }

    public EvaluationAction()
    {

        this.evaluationDAO    = DAOFactory.getEvaluationDAO();
        this.participantDAO = DAOFactory.getParticipantDAO();
        this.questionnaireDAO = DAOFactory.getQuestionnaireDAO();

    }

    public String demarrerQuestionnaire()
    {

        if(!this.session.containsKey(AuthentificationAction.UTILISATEUR))
            return LOGIN;

        if(this.questionnaire == null ||
                !this.questionnaireDAO.existe(this.questionnaire.getIdentifiant()) ||
                ((QuestionnaireModele)this.questionnaireDAO.get(this.questionnaire.getIdentifiant())).getAttente())
            return ERROR;


        this.questionnaire =
                (QuestionnaireModele)
                        this.questionnaireDAO.get(this.questionnaire.getIdentifiant());

        this.utilisateur =(UtilisateurModele) this.session.get(AuthentificationAction.UTILISATEUR);

        if(evaluationDAO.terminer(utilisateur.getIdentifiant() , questionnaire.getIdentifiant()))
            return INPUT;


        if(this.abandon == null)
        {
            if(!participantDAO.existe(this.utilisateur.getIdentifiant() , this.questionnaire.getIdentifiant()))
            {
                this.participant = new ParticipantModele(this.questionnaire , this.utilisateur , new Date());
                this.participantDAO.ajouter(this.participant);
            } else
            {
                this.participant = participantDAO.get(utilisateur.getIdentifiant() , questionnaire.getIdentifiant());
            }
        } else
        {
            if(choix != null)
            {
                evaluationDAO.evaluer(utilisateur.getIdentifiant() , questionnaire.getIdentifiant() , choix);
            } else
            {

            }
        }

        if(evaluationDAO.terminer(utilisateur.getIdentifiant() , questionnaire.getIdentifiant()))
            return INPUT;

        this.reponses = evaluationDAO.genererQCM(utilisateur.getIdentifiant() , questionnaire.getIdentifiant());
        if(reponses.size() > 0)
            this.question = this.reponses.get(0).getQuestion();

        return SUCCESS;
    }

    public String informationParticipant()
    {

        return SUCCESS;
    }
}