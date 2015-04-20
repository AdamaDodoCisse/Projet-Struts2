package fr.appli.qcm.app.modeles;

import java.util.Arrays;
import java.util.Date;

public class EvaluationModele extends Modele {

    private ParticipantModele participant;
    private ReponseModele reponse;
    private Date date;
    private boolean abandon = false;

    private final String [] erreurs = {"identifiant deux questionnaires incompatible"};
    public EvaluationModele(){}

    public EvaluationModele(ParticipantModele participant, ReponseModele reponse)
    {
        this.participant = participant;
        this.reponse = reponse;
        this.date = new Date();
    }

    public EvaluationModele(ParticipantModele participant, ReponseModele reponse , boolean abandon)
    {
        this.participant = participant;
        this.reponse = reponse;
        this.date = new Date();
        this.abandon = abandon;
    }

    public ParticipantModele getParticipant() {
        return participant;
    }

    public void setParticipant(ParticipantModele participant){
        this.participant = participant;
    }

    public ReponseModele getReponse() {
        return reponse;
    }

    @Override
    public String toString() {
        return "EvaluationModele{" +
                "participant=" + participant +
                ", reponse=" + reponse +
                ", date=" + date +
                ", erreurs=" + Arrays.toString(erreurs) +
                '}';
    }

    public void setReponse(ReponseModele reponse)  {

        this.reponse = reponse;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}