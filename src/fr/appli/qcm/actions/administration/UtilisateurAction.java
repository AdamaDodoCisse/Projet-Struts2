package fr.appli.qcm.actions.administration;

import fr.appli.qcm.actions.AbstractAction;
import fr.appli.qcm.app.Factories.DAOFactory;
import fr.appli.qcm.app.dao.EvaluationDAO;
import fr.appli.qcm.app.dao.ParticipantDAO;
import fr.appli.qcm.app.dao.UtilisateurDAO;
import fr.appli.qcm.app.modeles.UtilisateurModele;

import java.util.ArrayList;

public class UtilisateurAction extends AbstractAction {

    private UtilisateurModele utilisateur;
    private UtilisateurDAO utilisateurDAO;
    private ParticipantDAO participantDAO;
    private EvaluationDAO evaluationDAO;

    public void setUtilisateurDAO(UtilisateurDAO utilisateurDAO) {
        this.utilisateurDAO = utilisateurDAO;
    }

    public UtilisateurDAO getUtilisateurDAO() {
        return utilisateurDAO;
    }

    public UtilisateurAction()
    {
        this.evaluationDAO = DAOFactory.getEvaluationDAO();
        this.participantDAO = DAOFactory.getParticipantDAO();
        this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
    }

    public String ajouterUtilisateur()
    {
        ArrayList<String>  list = new ArrayList<String>();
        if(this.utilisateur != null)
        {
            if(this.utilisateurDAO.creer(this.utilisateur))
            {
                this.addActionMessage("");
            } else {
                this.addActionError("");
            }
        }

        return SUCCESS;
    }

    public String supprimerUtilisateur()
    {
        if(utilisateur != null)
        {
            this.participantDAO.supprimer(utilisateur.getIdentifiant());
            this.evaluationDAO.supprimerParticipant(utilisateur.getIdentifiant());
            this.utilisateurDAO.supprimer(utilisateur.getIdentifiant());

        }
        return SUCCESS;
    }

    public void setUtilisateur(UtilisateurModele utilisateur) {
        this.utilisateur = utilisateur;
    }

    public UtilisateurModele getUtilisateur() {
        return utilisateur;
    }

}
