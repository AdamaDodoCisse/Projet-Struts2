package fr.appli.qcm.app.implement;

import fr.appli.qcm.app.Factories.DAOFactory;
import fr.appli.qcm.app.dao.QuestionDAO;
import fr.appli.qcm.app.dao.ReponseDAO;
import fr.appli.qcm.app.modeles.ModeleCRUD;
import fr.appli.qcm.app.modeles.QuestionModele;
import fr.appli.qcm.app.modeles.QuestionnaireModele;
import fr.appli.qcm.app.modeles.ReponseModele;


public class QuestionImplement extends CRUDImplement implements QuestionDAO {

    public final String TABLE = "questionTable.table";

    @Override
    public boolean creer(ModeleCRUD modeleCRUD) {
        if(modeleCRUD instanceof QuestionModele)
            return super.creer(modeleCRUD);
        return false;
    }

    @Override
    protected String nomTable() {
        return TABLE;
    }

    @Override
    protected boolean autoIncremente() {
        return true;
    }
}
