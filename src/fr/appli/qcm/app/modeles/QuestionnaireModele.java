package fr.appli.qcm.app.modeles;

import java.util.ArrayList;


public class QuestionnaireModele extends ModeleCRUD {

    private String libelle;
    public boolean attente;
    private int duree;
    private int nombreQuestion;

    public int getDuree() {
        return duree;
    }


    public QuestionnaireModele(){}


    public QuestionnaireModele(int identifiant , String libelle , boolean attente , int duree , int nombreQuestion)
    {
        this();
        this.setIdentifiant(identifiant);
        this.setLibelle(libelle);
        this.setAttente(attente);
        this.setDuree(duree);
        this.setNombreQuestion(nombreQuestion);
    }

    public void setNombreQuestion(int nombreQuestion) {
        this.nombreQuestion = nombreQuestion;
    }

    public int getNombreQuestion() {
        return nombreQuestion;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    @Override
    public int getIdentifiant() {
        return super.getIdentifiant();
    }

    public boolean getAttente() {
        return attente;
    }

    public void setAttente(boolean attente) {
        this.attente = attente;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "QuestionnaireModele{" +
                "libelle='" + libelle + '\'' +
                ", attente=" + attente +
                ", duree=" + duree +
                ", nombreQuestion=" + nombreQuestion +
                '}';
    }
}
