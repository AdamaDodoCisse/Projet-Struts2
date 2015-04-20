package fr.appli.qcm.app.modeles;


public class UtilisateurModele extends ModeleCRUD {

    public static enum Genre {
        HOMME , FEMME
    }

    public static enum Role
    {
        ADMIN, ETUDIANT
    }
    private String password;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private Genre genre;
    private boolean administrateur;

    public UtilisateurModele(){}

    public UtilisateurModele(int login, String password, String nom, String prenom, String adresse, String email, Genre genre , boolean admin) {
        this.setIdentifiant(login);
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.genre = genre;
        this.administrateur = admin;
    }

    public UtilisateurModele(int login, String password, String nom, String prenom) {
        this.setIdentifiant(login);
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public boolean isAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(boolean administrateur) {
        this.administrateur = administrateur;
    }

}
