package fr.appli.qcm.app.modeles;


public class ReponseModele extends ModeleCRUD {

    private QuestionModele question;
    private QuestionnaireModele questionnaire;
    private String proposition;
    private boolean vrai;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReponseModele)) return false;
        if (!super.equals(o)) return false;

        ReponseModele that = (ReponseModele) o;

        if (!question.equals(that.question)) return false;
        if (!questionnaire.equals(that.questionnaire)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + question.hashCode();
        result = 31 * result + questionnaire.hashCode();
        return result;
    }

    public ReponseModele(){}

    public ReponseModele(int identifiant , QuestionModele question, QuestionnaireModele questionnaire , String proposition, boolean vrai)
    {
        this.setIdentifiant(identifiant);
        this.question = question;
        this.questionnaire = questionnaire;
        this.vrai = vrai;
        this.proposition = proposition;
    }

    public QuestionModele getQuestion() {
        return question;
    }

    public void setQuestion(QuestionModele question) {
        this.question = question;
    }

    public QuestionnaireModele getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(QuestionnaireModele questionnaire) {
        this.questionnaire = questionnaire;
    }

    public void setVrai(boolean vrai) {
        this.vrai = vrai;
    }

    public boolean getVrai() {
        return vrai;
    }

    public void setProposition(String proposition) {
        this.proposition = proposition;
    }

    public String getProposition() {
        return proposition;
    }

    @Override
    public String toString() {
        return "ReponseModele{" +
                "question=" + question +
                ", questionnaire=" + questionnaire +
                ", proposition='" + proposition + '\'' +
                ", vrai=" + vrai +
                '}';
    }
}
