package GP1.com.elmi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

//import produit.com.dupont.categoriedeproduit;

//import produit.com.dupont.CATE;

public class gestiondeproduitclient {

	String url = "jdbc:mysql://localhost:3308/nouveaudonne?autoReconnect=true&useSSL=false";
	String login = "root";
	String password = "";
	Connection cn = null;
	Statement st = null;
	ResultSet rs = null;

	public gestiondeproduitclient() {

		// Construction de l'interface graphique swing

		JFrame f = new JFrame("A window");

		f.setTitle("BIENVENU");
		f.setSize(550, 550);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(new FlowLayout());
		f.setResizable(false);
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		JLabel label1 = new JLabel("Bienvenue dans  mon application de Gestion de produit Développe et test");

		panel.add(label1);

		final JButton bouton1 = new JButton("Enregistre");

		final JButton bouton2 = new JButton("Supprime");

		final JButton bouton3 = new JButton("Recherche");

		final JButton bouton4 = new JButton("Modifer");

		// Connection de la base de donneé avec l'interface graphique
		// et affichage du table client en tableau

		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, password);
			st = cn.createStatement();

			Class.forName("com.mysql.jdbc.Driver");

			cn = DriverManager.getConnection(url, login, password);

			st = cn.createStatement();
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
			JTable table = new JTable(data, column);
			JScrollPane jsp = new JScrollPane(table);
			panel.add(jsp);
			jsp.setSize(800, 500);
			f.setContentPane(panel);

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

		// Enregistre le donne dans la table via le bouton l'interface swing

		f.getContentPane().add(bouton1, BorderLayout.WEST);
		bouton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					Class.forName("com.mysql.jdbc.Driver");

					cn = DriverManager.getConnection(url, login, password);

					st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
					System.out.println("Connected database successfully...");
					// String sql = "INSERT INTO client(nom,Telp,address,IDclient) VALUES (" + "nom"
					// + "," + "Telp" + "," + "address"+ "," + "IDclient" + ")";

					// STEP 4: Execute a query

					System.out.println("Inserting records into the table...");

					String sql = "INSERT INTO Mesclients "
							+ "VALUES ('5' ,'12','15','25','Elmi', '0751413840', '14 Rue Berlioz', '12chx')";
					st.executeUpdate(sql);
					sql = "INSERT INTO Mesclients "
							+ "VALUES ('6' ,'10','11','28','leny', '0758961556', '28 rue jules vernes', '12cex')";
					st.executeUpdate(sql);
					sql = "INSERT INTO Mesclients "
							+ "VALUES ('3' ,'2','4','7','Muriel', '0678952051', '16 Rue de l''Observatoire', '56ptg')";
					st.executeUpdate(sql);
					sql = "INSERT INTO Mesclients "
							+ "VALUES('11', '15','2','26','Emma', '0789564783', '2 Rue de la Porte de l''Hôpital', '98hnr')";
					st.executeUpdate(sql);

					sql = "INSERT INTO Mesclients "
							+ "VALUES('20' ,'58','1','coca','Pascal', '0797694305', '9 Rue de la Fonderie', '78ldr')";

					st.executeUpdate(sql);

				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}

		});

		// Supprime un donne dans la table via le bouton l'interface swing

		f.getContentPane().add(bouton2);
		bouton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					Class.forName("com.mysql.jdbc.Driver");

					cn = DriverManager.getConnection(url, login, password);

					st = cn.createStatement();

					String query = "DELETE FROM mesclients where TV=" + 4;

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

		// Recherche un produit dans la table via le bouton l'interface swing

		f.getContentPane().add(bouton3);
		bouton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					Class.forName("com.mysql.jdbc.Driver");

					cn = DriverManager.getConnection(url, login, password);

					st = cn.createStatement();

					String query = "SELECT * FROM mesclients where TV=" + 11;

					st = cn.createStatement();
					rs = st.executeQuery(query);

					rs.last();

					int nbrRow = rs.getRow();

					if (nbrRow != 1) {
						System.out.println("Produit  trouver");
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

		// Modifier des donnes dans la table via le bouton l'interface swing

		f.getContentPane().add(bouton4);
		bouton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					Class.forName("com.mysql.jdbc.Driver");

					cn = DriverManager.getConnection(url, login, password);

					st = cn.createStatement();

					String query = "UPDATE mesclients SET chacolat=18, TV=2";

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

}