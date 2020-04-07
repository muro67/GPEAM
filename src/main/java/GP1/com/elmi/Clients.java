package GP1.com.elmi;

public class Clients {

	public String nom, sexe, Adress;

	public int age, Telp;

	public Clients(String n, String s, String a, int agee) {

		this.Adress = a;
		this.age = agee;
		this.nom = n;
		this.sexe = s;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getAdress() {
		return Adress;
	}

	public int getTelp() {
		return Telp;
	}

	public void setTelp(int telp) {
		Telp = telp;
	}

	public void setAdress(String adress) {
		Adress = adress;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
