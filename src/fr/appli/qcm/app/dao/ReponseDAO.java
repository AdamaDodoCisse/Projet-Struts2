package fr.appli.qcm.app.dao;

import fr.appli.qcm.app.modeles.QuestionModele;
import fr.appli.qcm.app.modeles.ReponseModele;

import java.util.ArrayList;

public interface ReponseDAO extends CRUDDAO {
    public ArrayList<ReponseModele> listViaQuestionnaire(int idQuestionnaire);
    public boolean supprimerQuestionnaire(int idQuestionnaire);
    public boolean supprimerQuestion(int idQuestion);
    public ArrayList<QuestionModele> listQuestions(int idQuestionnaire);
}