package fr.appli.qcm.actions.client;

import fr.appli.qcm.actions.AbstractAction;
import fr.appli.qcm.app.Factories.DAOFactory;
import fr.appli.qcm.app.dao.UtilisateurDAO;

import fr.appli.qcm.app.modeles.UtilisateurModele;


public class AuthentificationAction extends AbstractAction {

    private UtilisateurModele utilisateur;

    public static final String UTILISATEUR = "utilisateur";

    private UtilisateurDAO utilisateurDAO;

    public AuthentificationAction()
    {
        this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
    }

    public void setUtilisateur(UtilisateurModele utilisateur) {
        this.utilisateur = utilisateur;
    }

    public UtilisateurModele getUtilisateur() {
        return utilisateur;
    }

    public String connection()
    {
        if(session.containsKey(UTILISATEUR))
        {
            return SUCCESS;
        }

        if(utilisateur != null)
        {
            if(utilisateurDAO.existe(utilisateur.getIdentifiant() , utilisateur.getPassword()))
            {

                this.session.put(UTILISATEUR , this.utilisateurDAO.get(utilisateur.getIdentifiant()));
                return  SUCCESS;
            }
            utilisateur = null;
            addActionError("Echec de la connection votre <strong>Identifant</strong> ou <strong>Mot de passe</strong> est incorrect");
            return ERROR;
        }
        return LOGIN;
    }

    public String deconnection()
    {
        this.session.remove(UTILISATEUR);
        return SUCCESS;
    }
}
