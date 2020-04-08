package com.groupe.aem;

import java.time.LocalDate;

public class ProduitAlimentaire {

    private LocalDate dateDeFabrication;
    private LocalDate dateLimite;
    public String libelle;

    public ProduitAlimentaire(LocalDate dateDeFabrication, LocalDate dateLimite, String libelle) {
        this.dateDeFabrication = dateDeFabrication;
        this.dateLimite = dateLimite;
        this.libelle = libelle;
    }

    public LocalDate getDateDeFabrication() {
        return dateDeFabrication;
    }

    public void setDateDeFabrication(LocalDate dateDeFabrication) {
        this.dateDeFabrication = dateDeFabrication;
    }

    public void setDateDeFabrication(int annee, int mois, int jourDuMois) {
        this.dateDeFabrication = LocalDate.of(annee, mois, jourDuMois);
    }

    public LocalDate getDateLimite() {
        return dateLimite;
    }

    public void setDateLimite(LocalDate dateLimite) {
        this.dateLimite = dateLimite;
    }

    public void setDateLimite(int annee, int mois, int jourDuMois) {
        this.dateLimite = LocalDate.of(annee, mois, jourDuMois);
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
