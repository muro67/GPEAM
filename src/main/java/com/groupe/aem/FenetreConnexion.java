package com.groupe.aem;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class FenetreConnexion extends JFrame implements ActionListener {
    JButton boutonConnexion;
    JPanel panel;
    JLabel labelUtilisateur, labelMotDePasse;
    final JTextField inputUtilisateur, inputMotDePasse;

    FenetreConnexion() {
        setTitle("Connexion");

        labelUtilisateur = new JLabel();
        labelUtilisateur.setText("Utilisateur :");
        inputUtilisateur = new JTextField(15);

        labelMotDePasse = new JLabel();
        labelMotDePasse.setText("Mot de passe:");
        inputMotDePasse = new JPasswordField(15);

        boutonConnexion = new JButton("Connexion");
        boutonConnexion.addActionListener(this);

        panel = new JPanel(new GridLayout(3, 1));
        panel.add(labelUtilisateur);
        panel.add(inputUtilisateur);
        panel.add(labelMotDePasse);
        panel.add(inputMotDePasse);
        panel.add(boutonConnexion);

        add(panel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent ae) {
        String nomUtilisateur = inputUtilisateur.getText();
        String motDePasse = inputMotDePasse.getText();
        if (nomUtilisateur.equals("admin") && motDePasse.equals("admin")) {
            FenetreGestionDeProduitClient page = new FenetreGestionDeProduitClient();
            setVisible(true);
        } else {
            System.out.println("Entrer un nom d'utilisateur et un mot de passe valide");
            JOptionPane.showMessageDialog(this, "Mot de passe ou utilisateur incorrecte", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
 