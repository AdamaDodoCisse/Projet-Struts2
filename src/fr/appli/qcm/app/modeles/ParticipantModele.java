package fr.appli.qcm.app.modeles;

import java.util.Date;

public class ParticipantModele extends Modele {

    private QuestionnaireModele questionnaire;
    private UtilisateurModele utilisateur;
    private Date date;

    @Override
    public String toString() {
        return "ParticipantModele{" +
                "questionnaire=" + questionnaire +
                ", utilisateur=" + utilisateur +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParticipantModele)) return false;

        ParticipantModele that = (ParticipantModele) o;

        if (!questionnaire.equals(that.questionnaire)) return false;
        if (!utilisateur.equals(that.utilisateur)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = questionnaire.hashCode();
        result = 31 * result + utilisateur.hashCode();
        return result;
    }

    public ParticipantModele(QuestionnaireModele questionnaire, UtilisateurModele utilisateur, Date date) {
        this.questionnaire = questionnaire;
        this.utilisateur = utilisateur;
        this.date = date;
    }

    public QuestionnaireModele getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(QuestionnaireModele questionnaire) {
        this.questionnaire = questionnaire;
    }

    public UtilisateurModele getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurModele utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}