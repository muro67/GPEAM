package GP1.com.elmi;

public class ProduitAlimentaire {

    private int dateDeFabrication;
    private int dateLimite;
    public String libelle;

    public ProduitAlimentaire(int dateDeFabrication, int dateLimite, String libelle) {
        this.dateDeFabrication = dateDeFabrication;
        this.dateLimite = dateLimite;
        this.libelle = libelle;
    }

    public int getDateDeFabrication() {
        return dateDeFabrication;
    }

    public void setDateDeFabrication(int dateDeFabrication) {
        this.dateDeFabrication = dateDeFabrication;
    }

    public int getDateLimite() {
        return dateLimite;
    }

    public void setDateLimite(int dateLimite) {
        this.dateLimite = dateLimite;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

}
