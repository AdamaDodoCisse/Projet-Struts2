package fr.appli.qcm.app.implement;

import fr.appli.qcm.app.dao.CRUDDAO;
import fr.appli.qcm.app.modeles.ModeleCRUD;
import fr.appli.qcm.app.services.FichierService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public abstract class CRUDImplement implements CRUDDAO{

    protected abstract String nomTable();
    protected abstract boolean autoIncremente();

    protected Table table;

    public CRUDImplement()
    {
        Object o = FichierService.deserialise(nomTable());

        if( o == null)
        {
            this.table = new Table();
        } else {
            this.table = (Table) o;
        }
        this.__serialise();
    }


    protected class Table implements Serializable
    {
        public HashMap<Integer , ModeleCRUD> modeleCRUDs;

        private int generateur = 1;

        public Table()
        {
            this.modeleCRUDs = new HashMap<Integer, ModeleCRUD>();
        }

        public void incrementer(){ this.generateur += 1; }

    }


    @Override
    public boolean creer(ModeleCRUD modeleCRUD) {
        if(autoIncremente())
        {
            modeleCRUD.setIdentifiant(this.table.generateur);
        }

        if(!existe(modeleCRUD.getIdentifiant()))
        {
            this.table.modeleCRUDs.put(modeleCRUD.getIdentifiant() , modeleCRUD);

            if(autoIncremente())
            {
                this.table.incrementer();
            }
            this.__serialise(); return true;

        }
        return false;
    }

    @Override
    public boolean supprimer(int identifiant) {
        if(existe(identifiant))
        {
            this.table.modeleCRUDs.remove(identifiant);
            __serialise(); return true;
        }
        return false;
    }

    @Override
    public boolean existe(int identifiant) {

        return this.table.modeleCRUDs.containsKey(identifiant);
    }

    @Override
    public boolean modifier(ModeleCRUD modeleCRUD) {
        if(existe(modeleCRUD.getIdentifiant()))
        {
            this.table.modeleCRUDs.put(modeleCRUD.getIdentifiant() , modeleCRUD);
            __serialise();
            return true;
        }
        return false;
    }

    protected void __serialise()
    {
        FichierService.serialise(this.table, nomTable());
    }

    @Override
    public ArrayList<ModeleCRUD> list() {
        Iterator<ModeleCRUD> iterator = this.table.modeleCRUDs.values().iterator();
        ArrayList<ModeleCRUD> modeleCRUDs = new ArrayList<ModeleCRUD>();
        while(iterator.hasNext())
        {
            modeleCRUDs.add(iterator.next());
        }
        Collections.sort(modeleCRUDs);
        return modeleCRUDs;
    }

    @Override
    public ModeleCRUD get(int identifiant) {
        return this.table.modeleCRUDs.get(identifiant) ;
    }
}