package GP1.com.elmi;

public class CategorieDeProduit {

    private String num;
    private String date;
    ProduitAlimentaire p1;
    ProduitElectronique pEl;
    Caisse caisse;

    public CategorieDeProduit(ProduitAlimentaire pR, ProduitElectronique pE, Caisse caisse, String num, String date) {

        this.date = date;
        this.num = num;

        this.p1 = pR;

        this.pEl = pE;

        this.caisse = caisse;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public ProduitAlimentaire getP1() {
        return p1;
    }

    public void setP1(ProduitAlimentaire p1) {
        this.p1 = p1;
    }

    public ProduitElectronique getpEl() {
        return pEl;
    }

    public void setpEl(ProduitElectronique pEl) {
        this.pEl = pEl;
    }

}