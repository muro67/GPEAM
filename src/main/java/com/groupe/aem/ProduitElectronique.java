package com.groupe.aem;

public class ProduitElectronique {

    public String code, codeEnergetique, libelle;

    public ProduitElectronique(String code, String libelle, String codeEnergetique) {
        this.code = code;
        this.libelle = libelle;
        this.codeEnergetique = codeEnergetique;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Energetique getType() {

        if (codeEnergetique == "A") {
            return Energetique.Economique;
        } else if (codeEnergetique == "B") {
            return Energetique.Economique;
        } else if (codeEnergetique == "C") {
            return Energetique.Modere;
        } else if (codeEnergetique == "D") {
            return Energetique.Energivore;
        } else
            return Energetique.Abuse;
    }
}
