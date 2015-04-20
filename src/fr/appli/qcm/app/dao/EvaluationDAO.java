package fr.appli.qcm.app.dao;

import fr.appli.qcm.app.modeles.ReponseModele;

import java.io.Serializable;
import java.util.ArrayList;

public interface EvaluationDAO extends Serializable {
    public ArrayList<ReponseModele> genererQCM(int idUtilisateur , int idQuestionnaire);
    public boolean evaluer(int idUtilisateur , int idQuestionnaire , ArrayList<Integer> reponse);
    public boolean terminer(int idUtilisateur , int idQuestionnaire);
    public boolean terminer(int idQuestionnaire);
    public float score(int idUtilisateur , int idQuestionnaire);
    public boolean supprimerParticipant(int idUtilisateur , int idQuestionnaire);
    public boolean supprimerParticipant(int idUtilisateur);
    public boolean supprimerQuestion(int idQuestion);
    public boolean supprimerQuestionnaire(int idQuestionnaire);
    public int questionRestante(int idUtilisateur , int idQuestionnaire);
    public int nombrePersonneTerminer(int idQuestionnaire);
}