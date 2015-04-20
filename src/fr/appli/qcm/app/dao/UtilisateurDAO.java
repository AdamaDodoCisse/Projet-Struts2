package fr.appli.qcm.app.dao;

public interface UtilisateurDAO extends CRUDDAO {

    public boolean existe(int login, String password);
}

