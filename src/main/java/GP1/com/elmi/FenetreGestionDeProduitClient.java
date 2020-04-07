package GP1.com.elmi;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FenetreGestionDeProduitClient {
    static final String SQL_URL = "jdbc:mysql://nas.loehr.fr:3307/notrenouveaudonne?autoReconnect=true&useSSL=false";
    static final String SQL_PASSWORD = "fe*µµµ4z89dez453fds*ù$ù$fd:!,v;,xc:jnkq}}sd&é@@=àçàçA";
    static final String SQL_LOGIN = "root";

    Client c = new Client("aem", "M", "14 voie cite viotte", 29);

    ProduitAlimentaire PA = new ProduitAlimentaire(25, 14, "yarout");

    ProduitElectronique pE = new ProduitElectronique("cres", "TV", "B");

    Caisse ce = new Caisse(24, 15);

    Commande l1 = new Commande(PA, pE, ce, "125er", "20/03/2020");

    public FenetreGestionDeProduitClient() {

        JFrame f = new JFrame("A window");

        f.setTitle("BIENVENU");
        f.setSize(1000, 10000);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.getContentPane().setLayout(new FlowLayout());

        // Les données du tableau

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Bienvenue dans ma modeste application");

        final JButton bouton1 = new JButton("Enregistre");

        final JButton bouton2 = new JButton("Supprimer");

        final JButton bouton3 = new JButton("Recherche");

        final JButton bouton4 = new JButton("Modifier");

        bouton1.setBounds(15, 50, 100, 14);

        bouton2.setBounds(15, 100, 100, 15);

        bouton3.setBounds(15, 150, 100, 15);

        bouton4.setBounds(50, 200, 10, 20);

        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(SQL_URL, SQL_LOGIN, SQL_PASSWORD);
            st = cn.createStatement();
            String sql = "SELECT * FROM mesclients";
            rs = st.executeQuery(sql);

            Class.forName("com.mysql.jdbc.Driver");

            cn = DriverManager.getConnection(SQL_URL, SQL_LOGIN, SQL_PASSWORD);

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

        f.getContentPane().add(bouton1, BorderLayout.NORTH);
        bouton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                String yaourt = "15";
                String chacolat = "122";
                String TV = "155";
                String Ordinateur = "266";
                String coca = "500";
                String nom = "aem";
                String IDclient = "34e";
                String address = "14 voie de la cite viotte";
                String telp = "0751413840";
                String Réference = "12wht";

                String url = SQL_URL;
                String login = "root";
                String password = SQL_PASSWORD;
                Connection cn = null;
                Statement st = null;

                try {

                    Class.forName("com.mysql.jdbc.Driver");

                    cn = DriverManager.getConnection(SQL_URL, SQL_LOGIN, SQL_PASSWORD);

                    st = cn.createStatement();

                    System.out.println("Connected database successfully...");
                    System.out.println("Inserting records into the table...");

                    String sql = "INSERT INTO mesclients " + "VALUES ('5' ,'12','15','25','Elmi', '0751413840', '14 Rue Berlioz', '12crx')";
                    st.executeUpdate(sql);
                    sql = "INSERT INTO mesclients " + "VALUES ('5' ,'12','15','25','Elmi', '0751413840', '14 Rue Berlioz', '12crx')";
                    st.executeUpdate(sql);
                    sql = "INSERT INTO mesclients " + "VALUES ('3' ,'2','4','7','Muriel', '0678952051', '16 Rue de l''Observatoire', '30ptg')";
                    st.executeUpdate(sql);
                    sql = "INSERT INTO mesclients " + "VALUES('11', '15','2','26','Emma', '0789564783', '2 Rue de la Porte de l''Hôpital', '58hnr')";
                    st.executeUpdate(sql);

                    sql = "INSERT INTO mesclients " + "VALUES('20' ,'58','1','coca','Pascal', '0797694305', '9 Rue de la Fonderie', '58ldr')";
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

        f.getContentPane().add(bouton2, BorderLayout.NORTH);
        bouton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                String url = SQL_URL;
                String login = "root";
                String password = SQL_PASSWORD;
                Connection cn = null;
                Connection cnx = null;
                Statement st = null;

                try {

                    Class.forName("com.mysql.jdbc.Driver");

                    cn = DriverManager.getConnection(SQL_URL, SQL_LOGIN, SQL_PASSWORD);

                    st = cn.createStatement();

                    String query = "DELETE FROM mesclients where chacolat=" + 15;

                    cnx = DriverManager.getConnection(SQL_URL, SQL_LOGIN, SQL_PASSWORD);

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

        f.getContentPane().add(bouton3, BorderLayout.NORTH);
        bouton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                String url = SQL_URL;
                String login = "root";
                String password = SQL_PASSWORD;
                Connection cn = null;
                Connection cnx = null;
                Statement st = null;
                ResultSet rst = null;

                try {

                    Class.forName("com.mysql.jdbc.Driver");

                    cn = DriverManager.getConnection(SQL_URL, SQL_LOGIN, SQL_PASSWORD);

                    st = cn.createStatement();

                    String query = "SELECT * FROM mesclients where chacolat=" + 58;

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

        f.getContentPane().add(bouton4, BorderLayout.NORTH);
        bouton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                String url = SQL_URL;
                String login = "root";
                String password = SQL_PASSWORD;
                Connection cn = null;
                Connection cnx = null;
                Statement st = null;
                ResultSet rst = null;

                try {

                    Class.forName("com.mysql.jdbc.Driver");

                    cn = DriverManager.getConnection(SQL_URL, SQL_LOGIN, SQL_PASSWORD);

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

    public static void sauverEnBaser(String yaourt, String chacolat, String TV, String coca, String Nom, String Telp, String address, String Réference) {

        Connection cn = null;
        Statement st = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");

            cn = DriverManager.getConnection(SQL_URL, SQL_LOGIN, SQL_PASSWORD);

            st = cn.createStatement();

            // String sql = "INSERT INTO mesclients(yaourt,chacolat,TV,coca,Nom) VALUES (" +
            // yaourt + "," + chacolat + ","
            // + TV + "," + coca + "," + "Nom" + ")";
            //

            System.out.println("Connected database successfully...");
            // String sql = "INSERT INTO client(nom,Telp,address,IDclient) VALUES (" + "nom"
            // + "," + "Telp" + "," + "address"+ "," + "IDclient" + ")";

            // STEP 4: Execute a query

            System.out.println("Inserting records into the table...");

            String sql = "INSERT INTO mesclients " + "VALUES ('5' ,'12','15','25','Elmi', '0751413840', '14 Rue Berlioz', '12crx')";
            st.executeUpdate(sql);
            sql = "INSERT INTO mesclients " + "VALUES ('5' ,'12','15','25','Elmi', '0751413840', '14 Rue Berlioz', '12crx')";
            st.executeUpdate(sql);
            sql = "INSERT INTO mesclients " + "VALUES ('3' ,'2','4','7','Muriel', '0678952051', '16 Rue de l''Observatoire', '30ptg')";
            st.executeUpdate(sql);
            sql = "INSERT INTO mesclients " + "VALUES('11', '15','2','26','Emma', '0789564783', '2 Rue de la Porte de l''Hôpital', '58hnr')";
            st.executeUpdate(sql);

            sql = "INSERT INTO mesclients " + "VALUES('20' ,'58','1','coca','Pascal', '0797694305', '9 Rue de la Fonderie', '58ldr')";
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
        Connection cn = null;
        Statement st = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");

            cn = DriverManager.getConnection(SQL_URL, SQL_LOGIN, SQL_PASSWORD);

            st = cn.createStatement();

            String query = "DELETE FROM mesclients where chacolat=" + 15;

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
        Connection cn = null;
        Statement st = null;
        ResultSet rst = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");

            cn = DriverManager.getConnection(SQL_URL, SQL_LOGIN, SQL_PASSWORD);

            String query = "SELECT * FROM mesclients where chacolat=" + 58;

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

        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(SQL_URL, SQL_LOGIN, SQL_PASSWORD);
            st = cn.createStatement();
            String sql = "SELECT * FROM mesclients";
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

        FenetreConnexion frame = new FenetreConnexion();
        frame.setSize(300, 100);
        frame.setVisible(true);

        Client c = new Client("aem", "M", "14 voie cite viotte", 29);


        ProduitAlimentaire PA = new ProduitAlimentaire(25, 14, "yarout");
        ProduitElectronique pE = new ProduitElectronique("cres", "TV", "B");

        Caisse ce = new Caisse(24, 15);

        Commande cc = new Commande(PA, pE, ce, "125er", "20/03/2020");

        System.out.println("=======");

        System.out.println(c.getNom() + "," + c.getSexe() + "," + c.getAdresse() + "," + c.getAge() + "," + PA.getDateDeFabrication() + "," + PA.getDateLimite() + "," + PA.getLibelle() + "," + pE.getCode() + "," + pE.getLibelle() + "," + pE.getType() + "," + cc.getDate() + "," + cc.getNum() + "," + ce.getPrixA() + "," + ce.getPrixE());

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