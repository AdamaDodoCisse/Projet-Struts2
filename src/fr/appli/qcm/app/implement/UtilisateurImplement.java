package fr.appli.qcm.app.implement;


import fr.appli.qcm.app.dao.UtilisateurDAO;
import fr.appli.qcm.app.modeles.ModeleCRUD;
import fr.appli.qcm.app.modeles.UtilisateurModele;

public class UtilisateurImplement extends CRUDImplement implements UtilisateurDAO {

    public static final String TABLE = "utilisateur.table";

    @Override
    public boolean existe(int login, String password) {
        if(existe(login))
            return ((UtilisateurModele) get(login)).getPassword().equals(password);
        return false;
    }

    @Override
    public boolean creer(ModeleCRUD modeleCRUD) {
        if(modeleCRUD instanceof UtilisateurModele)
        {
           try
           {
               if(((UtilisateurModele) modeleCRUD).getPassword().length() > 2 &&
                       ((UtilisateurModele) modeleCRUD).getNom().length() > 2 &&
                       ((UtilisateurModele) modeleCRUD).getPrenom().length() > 2
                       )
                    return super.creer(modeleCRUD);
           }catch (Exception e){}
        }
        return false;
    }

    @Override
    protected String nomTable() {
        return TABLE;
    }

    @Override
    protected boolean autoIncremente() {
        return false;
    }

}
