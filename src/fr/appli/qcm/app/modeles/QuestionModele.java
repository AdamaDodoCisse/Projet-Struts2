package fr.appli.qcm.app.modeles;

public class QuestionModele extends ModeleCRUD {

    private String contexte;

    public QuestionModele(){}

    public QuestionModele(int identitifiant , String contexte)
    {
        this.setIdentifiant(identitifiant);
        this.setContexte(contexte);
    }

    public void setContexte(String contexte) {
        this.contexte = contexte;
    }

    public String getContexte() {
        return contexte;
    }

    @Override
    public String toString() {
        return "QuestionModele{" +
                "contexte='" + contexte + '\'' +
                '}';
    }
}
