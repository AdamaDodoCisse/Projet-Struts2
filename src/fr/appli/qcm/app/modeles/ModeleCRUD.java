package fr.appli.qcm.app.modeles;

public  class ModeleCRUD extends Modele implements Comparable<ModeleCRUD> {

    private int identifiant;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ModeleCRUD)) return false;

        ModeleCRUD that = (ModeleCRUD) o;

        if (identifiant != that.identifiant) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return identifiant;
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    @Override
    public int compareTo(ModeleCRUD o) {
        return Integer.compare(this.getIdentifiant() , o.getIdentifiant());
    }
}
