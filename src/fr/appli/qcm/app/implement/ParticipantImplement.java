package fr.appli.qcm.app.implement;

import fr.appli.qcm.app.Factories.DAOFactory;
import fr.appli.qcm.app.dao.ParticipantDAO;
import fr.appli.qcm.app.dao.QuestionnaireDAO;
import fr.appli.qcm.app.dao.UtilisateurDAO;
import fr.appli.qcm.app.modeles.ParticipantModele;
import fr.appli.qcm.app.services.FichierService;

import java.util.ArrayList;

public class ParticipantImplement implements ParticipantDAO {

    public static String TABLE = "participant.table";
    private ArrayList<ParticipantModele> participants;

    public ParticipantImplement()
    {
        Object o = FichierService.deserialise(TABLE);
        if(o == null)
            this.participants = new ArrayList<ParticipantModele>();
        else
            participants = (ArrayList<ParticipantModele>) o;

        FichierService.serialise(participants , TABLE);
    }

    public ParticipantModele get(int idUtilisateur , int idQuestionnaire)
    {
        for(ParticipantModele participant : participants)
        {
            if(participant.getUtilisateur().getIdentifiant() == idUtilisateur
                    && participant.getQuestionnaire().getIdentifiant() == idQuestionnaire)
                return participant;
        }
        return null;
    }

    @Override
    public ArrayList<ParticipantModele> list() {
        return this.participants;
    }

    @Override
    public int nombreParticipant(int idQuestionnaire) {
        int cpt = 0;
        for(ParticipantModele participant : list())
        {
            if(participant.getQuestionnaire().getIdentifiant() == idQuestionnaire)
                cpt++;
        }
        return cpt;
    }

    @Override
    public boolean existe(int idUtilisateur, int idQuestionnaire) {
            for(ParticipantModele participant : participants)
            {
                if(participant.getUtilisateur().getIdentifiant() == idUtilisateur
                        && participant.getQuestionnaire().getIdentifiant() == idQuestionnaire)
                    return true;
            }
        return false;
    }

    @Override
    public boolean ajouter(ParticipantModele participant) {
        int idUtilisateur = participant.getUtilisateur().getIdentifiant();
        int idQuestionnaire = participant.getQuestionnaire().getIdentifiant();
        UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
        QuestionnaireDAO questionnaireDAO = DAOFactory.getQuestionnaireDAO();
        if(utilisateurDAO.existe(idUtilisateur) && questionnaireDAO.existe(idQuestionnaire))
        {
            if(!existe(idUtilisateur , idQuestionnaire))
            {
                boolean b = this.participants.add(participant);
                if(b)
                    FichierService.serialise(participants , TABLE);
                return b;
            }
        }
        return false;
    }

    @Override
    public boolean supprimer(int idParticipant) {
        ArrayList<ParticipantModele> participantModeles = new ArrayList<ParticipantModele>();
        for(ParticipantModele participant : list())
        {
            if(participant.getUtilisateur().getIdentifiant() != idParticipant)
            {
                participantModeles.add(participant);
            }
        }
        this.participants = new ArrayList<ParticipantModele>();
        this.participants.addAll(participantModeles);
        FichierService.serialise(participants , TABLE);
        return true;
    }

    @Override
    public boolean supprimer(int idUtilisateur, int idQuestionnaire) {
        ArrayList<ParticipantModele> participantModeles = new ArrayList<ParticipantModele>();
        for(ParticipantModele participant : participants)
        {
            if(!(idUtilisateur == participant.getUtilisateur().getIdentifiant() &&
                    participant.getQuestionnaire().getIdentifiant() == idQuestionnaire))
            {
                participantModeles.add(participant);
            }
        }
        this.participants = new ArrayList<ParticipantModele>();
        this.participants.addAll(participantModeles);
        FichierService.serialise(this.participants , TABLE);
        return false;
    }

    @Override
    public boolean supprimerQuestionnaire(int idQuestionnaire) {
        ArrayList<ParticipantModele> participantModeles = new ArrayList<ParticipantModele>();
        for(ParticipantModele participant : list())
        {
            if(participant.getQuestionnaire().getIdentifiant() != idQuestionnaire)
            {
                participantModeles.add(participant);
            }
        }
        this.participants = new ArrayList<ParticipantModele>();
        this.participants.addAll(participantModeles);
        FichierService.serialise(participants , TABLE);
        return true;
    }

}