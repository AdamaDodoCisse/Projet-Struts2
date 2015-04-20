package fr.appli.qcm.app.implement;

import fr.appli.qcm.app.dao.QuestionnaireDAO;

public class QuestionnaireImplement extends CRUDImplement implements QuestionnaireDAO {

    public static String TABLE = "questionnaire.table";


    @Override
    protected String nomTable() {
        return TABLE;
    }

    @Override
    protected boolean autoIncremente() {
        return true;
    }

}