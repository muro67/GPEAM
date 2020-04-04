package GP1.com.elmi;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

//import produit.com.dupont.categoriedeproduit;

//import produit.com.dupont.CATE;

public class gestiondeproduitclient {

	Clients c = new Clients("elmi", "M", "14 voie cite viotte", 29);

// ProdAliement P=new ProdAliement(25,14,"yaourt");

	ProdAliement PA = new ProdAliement(25, 14, "yarout");

	ProdElectro pE = new ProdElectro("cres", "TV", "B");

	Caisse ce = new Caisse(24, 15);

	categoriedeproduit l1 = new categoriedeproduit(PA, pE, ce, "125er", "20/03/2020");

	public gestiondeproduitclient() {

		JFrame f = new JFrame("A window");

		f.setTitle("BIENVENU");
		f.setSize(1000, 10000);
		 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(new FlowLayout());
		//f.setResizable(false);
		// this.getContentPane().add(bouton1);
	//	setLayout(null);

		// Les données du tableau

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		 JLabel label = new JLabel("Bienvenue dans ma modeste application");

		 final JButton bouton1 = new JButton("Enregistre");

		final JButton bouton2 = new JButton("Supprime");

		final JButton bouton3 = new JButton("Recherche");

  final		 JButton bouton4 = new JButton("Modifer");
		// panel.add(label);
		// f.add(label,BorderLayout.AFTER_LAST_LINE);

		//f.add(label).setLocation(25, 45);;

			bouton1.setBounds(15,50,100,14);
		       
			bouton2.setBounds(15,100,100,15);
			
			bouton3.setBounds(15,150,100,15);
			
			bouton4.setBounds(50,200,10,20);
		
		String url = "jdbc:mysql://localhost:3308/nouveaudonne?autoReconnect=true&useSSL=false";
		String login = "root";
		String password = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, password);
			st = cn.createStatement();
			String sql = "SELECT * FROM Mesclients";
			rs = st.executeQuery(sql);

			Class.forName("com.mysql.jdbc.Driver");

			cn = DriverManager.getConnection(url, login, password);

			st = cn.createStatement();
			// String query = "SELECT * FROM mesclients where chacolat=" + 58;
			String s = " SELECT * FROM mesclients";
			rs = st.executeQuery(s);
			ResultSetMetaData rsmt = rs.getMetaData();
			int c = rsmt.getColumnCount();
			Vector column = new Vector(c);

			for (int i = 1; i <= c; i++) {
				column.add(rsmt.getColumnName(i));
			}

			Vector data = new Vector();
			Vector row = new Vector();
			while (rs.next()) {
				row = new Vector(c);

				for (int i = 1; i <= c; i++) {
					row.add(rs.getString(i));
				}

				data.add(row);
			}

			
      
			//f.add(bouton1);
			//JPanel panel = new JPanel();
			JTable table = new JTable(data, column);
			JScrollPane jsp = new JScrollPane(table);
			panel.setLayout(new BorderLayout());
			panel.add(jsp, BorderLayout.SOUTH);
			f.setContentPane(panel);
			f.setVisible(true);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		
		
       // retablir.setEnabled(false);

	//	 f.getContentPane().add(label);

		f.getContentPane().add(bouton1,BorderLayout.NORTH);
		bouton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		        

				String yaourt = "15";
				String chacolat = "122";
				String TV = "155";
				String Ordinateur = "266";
				String coca = "500";
				String nom = "elmi";
				String IDclient = "34e";
				String address = "14 voie de la cite viotte";
				String telp = "0751413840";
				String Réference = "12wht";

				String url = "jdbc:mysql://localhost:3308/nouveaudonne?autoReconnect=true&useSSL=false";
				String login = "root";
				String password = "";
				Connection cn = null;
				Statement st = null;

				try {

					Class.forName("com.mysql.jdbc.Driver");

					cn = DriverManager.getConnection(url, login, password);

					st = cn.createStatement();

					System.out.println("Connected database successfully...");
					// String sql = "INSERT INTO client(nom,Telp,address,IDclient) VALUES (" + "nom"
					// + "," + "Telp" + "," + "address"+ "," + "IDclient" + ")";

					// STEP 4: Execute a query

					System.out.println("Inserting records into the table...");

					String sql = "INSERT INTO Mesclients "
							+ "VALUES ('5' ,'12','15','25','Elmi', '0751413840', '14 Rue Berlioz', '12crx')";
					st.executeUpdate(sql);
					sql = "INSERT INTO Mesclients "
							+ "VALUES ('5' ,'12','15','25','Elmi', '0751413840', '14 Rue Berlioz', '12crx')";
					st.executeUpdate(sql);
					sql = "INSERT INTO Mesclients "
							+ "VALUES ('3' ,'2','4','7','Muriel', '0678952051', '16 Rue de l''Observatoire', '30ptg')";
					st.executeUpdate(sql);
					sql = "INSERT INTO Mesclients "
							+ "VALUES('11', '15','2','26','Emma', '0789564783', '2 Rue de la Porte de l''Hôpital', '58hnr')";
					st.executeUpdate(sql);

					sql = "INSERT INTO Mesclients "
							+ "VALUES('20' ,'58','1','coca','Pascal', '0797694305', '9 Rue de la Fonderie', '58ldr')";
					st.executeUpdate(sql);
					System.out.println("Inserted records into the table...");

					st.executeUpdate(sql);

				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}

		});

	

		f.getContentPane().add(bouton2,BorderLayout.NORTH);
		bouton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				

				String url = "jdbc:mysql://localhost:3308/nouveaudonne?autoReconnect=true&useSSL=false";
				String login = "root";
				String password = "";
				Connection cn = null;
				Connection cnx = null;
				Statement st = null;

				try {

					Class.forName("com.mysql.jdbc.Driver");

					cn = DriverManager.getConnection(url, login, password);

					st = cn.createStatement();

					String query = "DELETE FROM mesclients where chacolat=" + 15;

					cnx = DriverManager.getConnection(url, login, password);

					st = cn.createStatement();
					st.executeUpdate(query);

				} catch (SQLException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

			}

		});


		f.getContentPane().add(bouton3,BorderLayout.NORTH);
		bouton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				

				String url = "jdbc:mysql://localhost:3308/nouveaudonne?autoReconnect=true&useSSL=false";
				String login = "root";
				String password = "";
				Connection cn = null;
				Connection cnx = null;
				Statement st = null;
				ResultSet rst = null;

				try {

					Class.forName("com.mysql.jdbc.Driver");

					cn = DriverManager.getConnection(url, login, password);

					st = cn.createStatement();

					String query = "SELECT * FROM mesclients where chacolat=" + 58;

					cnx = DriverManager.getConnection(url, login, password);

					st = cn.createStatement();
					rst = st.executeQuery(query);

					rst.last();

					int nbrRow = rst.getRow();

					if (nbrRow != 1) {
						System.out.println("Produit trouver");
					} else {

						System.out.println("Produit nom trouver");
					}

				} catch (SQLException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

			}

		});

		//f.add(bouton4);

		f.getContentPane().add(bouton4,BorderLayout.NORTH);
		bouton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				

				String url = "jdbc:mysql://localhost:3308/nouveaudonne?autoReconnect=true&useSSL=false";
				String login = "root";
				String password = "";
				Connection cn = null;
				Connection cnx = null;
				Statement st = null;
				ResultSet rst = null;

				try {

					Class.forName("com.mysql.jdbc.Driver");

					cn = DriverManager.getConnection(url, login, password);

					st = cn.createStatement();

					String query = "UPDATE `mesclients` SET `yaourt`=66 where `coca`=25";

					
					
					st.executeUpdate(query);

				} catch (SQLException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

			}

		});

		

		f.setVisible(true);
	}

	
	public static void sauverEnBaser(String yaourt, String chacolat, String TV, String coca, String Nom, String Telp,
			String address, String Réference) {

		String url = "jdbc:mysql://localhost:3308/nouveaudonne?autoReconnect=true&useSSL=false";
		String login = "root";
		String password = "";
		Connection cn = null;
		Statement st = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			cn = DriverManager.getConnection(url, login, password);

			st = cn.createStatement();

			// String sql = "INSERT INTO Mesclients(yaourt,chacolat,TV,coca,Nom) VALUES (" +
			// yaourt + "," + chacolat + ","
			// + TV + "," + coca + "," + "Nom" + ")";
			//

			System.out.println("Connected database successfully...");
			// String sql = "INSERT INTO client(nom,Telp,address,IDclient) VALUES (" + "nom"
			// + "," + "Telp" + "," + "address"+ "," + "IDclient" + ")";

			// STEP 4: Execute a query

			System.out.println("Inserting records into the table...");

			String sql = "INSERT INTO Mesclients "
					+ "VALUES ('5' ,'12','15','25','Elmi', '0751413840', '14 Rue Berlioz', '12crx')";
			st.executeUpdate(sql);
			sql = "INSERT INTO Mesclients "
					+ "VALUES ('5' ,'12','15','25','Elmi', '0751413840', '14 Rue Berlioz', '12crx')";
			st.executeUpdate(sql);
			sql = "INSERT INTO Mesclients "
					+ "VALUES ('3' ,'2','4','7','Muriel', '0678952051', '16 Rue de l''Observatoire', '30ptg')";
			st.executeUpdate(sql);
			sql = "INSERT INTO Mesclients "
					+ "VALUES('11', '15','2','26','Emma', '0789564783', '2 Rue de la Porte de l''Hôpital', '58hnr')";
			st.executeUpdate(sql);

			sql = "INSERT INTO Mesclients "
					+ "VALUES('20' ,'58','1','coca','Pascal', '0797694305', '9 Rue de la Fonderie', '58ldr')";
			st.executeUpdate(sql);
			System.out.println("Inserted records into the table...");

			st.executeUpdate(sql);
			System.out.println("Inserted records into the table...");

			st.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void supprime() {

		String url = "jdbc:mysql://localhost:3308/nouveaudonne?autoReconnect=true&useSSL=false";
		String login = "root";
		String password = "";
		Connection cn = null;
		Connection cnx = null;
		Statement st = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			cn = DriverManager.getConnection(url, login, password);

			st = cn.createStatement();

			String query = "DELETE FROM mesclients where chacolat=" + 15;

			cnx = DriverManager.getConnection(url, login, password);

			st = cn.createStatement();
			st.executeUpdate(query);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void Recherche() {

		String url = "jdbc:mysql://localhost:3308/nouveaudonne?autoReconnect=true&useSSL=false";
		String login = "root";
		String password = "";
		Connection cn = null;
		Connection cnx = null;
		Statement st = null;
		ResultSet rst = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			cn = DriverManager.getConnection(url, login, password);

			st = cn.createStatement();

			String query = "SELECT * FROM mesclients where chacolat=" + 58;

			cnx = DriverManager.getConnection(url, login, password);

			st = cn.createStatement();
			rst = st.executeQuery(query);

			rst.last();

			int nbrRow = rst.getRow();

			if (nbrRow != 1) {
				System.out.println("Produit trouver");
			} else {

				System.out.println("Produit nom trouver");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void readDatabase() {
		// Database connection informations:

		String url = "jdbc:mysql://localhost:3308/nouveaudonne?autoReconnect=true&useSSL=false";
		String login = "root";
		String password = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, password);
			st = cn.createStatement();
			String sql = "SELECT * FROM Mesclients";
			rs = st.executeQuery(sql);

			while (rs.next()) {
				System.out.print(rs.getString("yaourt"));
				System.out.print(" ; ");
				System.out.print(rs.getString("chacolat"));
				System.out.print(" ; ");
				System.out.print(rs.getString("TV"));
				System.out.print(" ; ");
				System.out.print(rs.getString("coca"));
				System.out.print(" ; ");
				System.out.print(rs.getString("Nom"));
				System.out.print(" ; ");
				System.out.print(rs.getString("Telp"));
				System.out.print(" ; ");
				System.out.print(rs.getString("address"));
				System.out.print(" ; ");
				System.out.print(rs.getString("Réference"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	
			
			

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CATE frame = new CATE();
		frame.setSize(300, 100);
		frame.setVisible(true);

		Clients c = new Clients("elmi", "M", "14 voie cite viotte", 29);

		// ProdAliement P=new ProdAliement(25,14,"yaourt");

		ProdAliement PA = new ProdAliement(25, 14, "yarout");

		ProdElectro pE = new ProdElectro("cres", "TV", "B");

		Caisse ce = new Caisse(24, 15);

		categoriedeproduit cc = new categoriedeproduit(PA, pE, ce, "125er", "20/03/2020");

		System.out.println("=======");

		System.out.println(c.getNom() + "," + c.getSexe() + "," + c.getAdress() + "," + c.getAge() + ","
				+ PA.getDatedefabrication() + "," + PA.getDatelimite() + "," + PA.getLibelle() + "," + pE.getCode()
				+ "," + pE.getLibelle() + "," + pE.getType() + "," + cc.getDate() + "," + cc.getNum() + ","
				+ ce.getPrixA() + "," + ce.getPrixE());

		String yaourt = "5";
		String chacolat = "12";
		String TV = "15";
		String coca = "26";
		String Nom = "Elmi";
		String Telp = "0751413698";

		String address = "14 Rue de la Doller ";

		String Réference = "12wht";

		sauverEnBaser(yaourt, chacolat, TV, coca, Nom, Telp, address, Réference);

		// readDatabase();

		// supprime();

		// Recherche();

		// Modifier();
		
		//affiche();

		// gestiondeproduitclient f = new gestiondeproduitclient();

	}

}