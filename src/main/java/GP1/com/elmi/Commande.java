package GP1.com.elmi;

public class Commande {

	private String num;
	private String date;
	ProdAliement PA;
	ProdElectro PE;
	Caisse c;

	public Commande(ProdAliement Pa, ProdElectro Pe, Caisse c1, String n, String date) {

		this.date = date;
		this.num = n;

		this.PA = Pa;

		this.PE = Pe;

		this.c = c1;
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

	public ProdAliement getPA() {
		return PA;
	}

	public void setPA(ProdAliement pA) {
		PA = pA;
	}

	public ProdElectro getPE() {
		return PE;
	}

	public void setPE(ProdElectro pE) {
		PE = pE;
	}

	public Caisse getC() {
		return c;
	}

	public void setC(Caisse c) {
		this.c = c;
	}

}