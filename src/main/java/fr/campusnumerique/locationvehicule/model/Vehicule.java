package fr.campusnumerique.locationvehicule.model;

public class Vehicule {
    private int id;
    private String modele;
    private String marque;
    private int prix;

    //constructeur par défaut
    public Vehicule() {
    }

    //constructeur pour nos tests

    public Vehicule(int id, String modele, String marque, int prix) {
        this.id=id;
        this.modele = modele;
        this.marque = marque;
        this.prix=prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String model) {
        this.marque = marque;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix=prix;
    }

    @Override
    public String toString(){
        return "Vehicule{"+
                "id=" + id +
                ", modele='"+ modele + '\'' +
                ", marque='"+ marque + '\'' +
                ", prix=" + prix+ '}';
    }
}