package GP1.com.elmi;


import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
 
public class Connect extends JFrame implements ActionListener{
 JButton Connect;
 JPanel panel;
 JLabel label1,label2;
 final JTextField  text1,text2;
 
  Connect()
  {
  label1 = new JLabel();
  label1.setText("Username:");
  text1 = new JTextField(15);

  label2 = new JLabel();
  label2.setText("Password:");
  text2 = new JPasswordField(15);
 
  Connect=new JButton("Connect");
  
  panel=new JPanel(new GridLayout(3,1));
  panel.add(label1);
  panel.add(text1);
  panel.add(label2);
  panel.add(text2);
  panel.add(Connect);
  add(panel,BorderLayout.CENTER);
  Connect.addActionListener(this);
  setTitle("LOGIN FORM");
  }
 public void actionPerformed(ActionEvent ae)
  {
  String value1=text1.getText();
  String value2=text2.getText();
  if (value1.equals("admin") && value2.equals("admin")) {
  gestiondeproduitclient page=new gestiondeproduitclient();
  setVisible(true);
 
  }
  else{
  System.out.println("enter the valid username and password");
  JOptionPane.showMessageDialog(this,"Incorrect login or password",
  "Error",JOptionPane.ERROR_MESSAGE);
  }
}
}
 