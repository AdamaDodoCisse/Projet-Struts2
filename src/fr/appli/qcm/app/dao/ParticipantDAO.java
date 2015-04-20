package fr.appli.qcm.app.dao;


import fr.appli.qcm.app.modeles.ParticipantModele;

import java.io.Serializable;
import java.util.ArrayList;

public interface ParticipantDAO extends Serializable {
    public boolean existe(int idUtilisateur , int idQuestionnaire);
    public boolean ajouter(ParticipantModele participant);
    public boolean supprimer(int idParticipant);
    public boolean supprimer(int idUtilisateur , int idQuestionnaire);
    public boolean supprimerQuestionnaire(int idQuestionnaire);
    public ParticipantModele get(int idUtilisateur , int idQuestionnaire);
    public ArrayList<ParticipantModele> list();
    public int nombreParticipant(int idQuestionnaire);
}
