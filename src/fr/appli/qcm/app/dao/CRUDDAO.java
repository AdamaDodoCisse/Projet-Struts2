package fr.appli.qcm.app.dao;

import fr.appli.qcm.app.modeles.ModeleCRUD;

import java.io.Serializable;
import java.util.ArrayList;

public interface CRUDDAO extends Serializable {

    public boolean creer(ModeleCRUD modeleCRUD);
    public boolean supprimer(int identifiant);
    public boolean existe(int identifiant);
    public boolean modifier(ModeleCRUD modeleCRUD);
    public ModeleCRUD get(int identifiant);
    public ArrayList<ModeleCRUD> list();
}
