package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login,clear,signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
Login(){
    setTitle("Bank Managment System");
    setLayout(null);
    
   ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("logo.jpg"));
   Image i2 = i1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
   ImageIcon i3 = new ImageIcon(i2);
   JLabel label= new JLabel(i3);
   label.setBounds(380,0, 80, 80);
   add(label);
   
    JLabel text = new JLabel("Welcome To Bank");
    text.setFont(new Font("Osward",Font.BOLD,25));
    text.setBounds(298,40,250,100);
    add(text);
    
    JLabel cardno = new JLabel("CARD NUMBER");
    cardno.setFont(new Font("Osward",Font.BOLD,20));
    cardno.setBounds(200,80,250,100);
    add(cardno);
    
    cardTextField = new JTextField();
    cardTextField.setBounds(400,120,230,30);
    add(cardTextField);
    
    JLabel pin = new JLabel("PIN"); 
    pin.setFont(new Font("Osward",Font.BOLD,20));
    pin.setBounds(200,120,200,100);
    add(pin);
    
    pinTextField = new JPasswordField();
    pinTextField.setBounds(400,160,230,30);
    add(pinTextField);
    
    getContentPane().setBackground(Color.white);
    
    
    login = new JButton("SIGN IN");
    login.setBounds(400, 220,100,25);
    login.setBackground(Color.black);
    login.setForeground(Color.white);
    login.addActionListener(this);
    add(login);
    
    clear = new JButton("CLEAR");
    clear.setBounds(510, 220,100,25);
    clear.setBackground(Color.black);
    clear.setForeground(Color.white);
    clear.addActionListener(this);
    add(clear);
    
    signup = new JButton("SIGN UP");
    signup.setBounds(200, 220,100,25);
    signup.setBackground(Color.black);
    signup.setForeground(Color.white);
    signup.addActionListener(this);
    add(signup);
    
    getContentPane().setBackground(Color.white);
    setSize(800,400);
    setLocation(350,200);
    setVisible(true);
  
}
public void actionPerformed(ActionEvent ae){
    if(ae.getSource()== clear){
        cardTextField.setText("");
        pinTextField.setText("");
    }else if (ae.getSource()== login){
        Conn conn = new Conn();
        String cardnumber = cardTextField.getText();
        String pinnumber = pinTextField.getText();
        String  quary = "select * from login where cardnumber='"+cardnumber+"' and pinnumber='"+pinnumber+"'";
        try{
            ResultSet rs= conn.s.executeQuery(quary);
            if(rs.next()){
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null,"Invald Id & Password");
            } 
        }catch(Exception e){
            System.out.println(e);
        }
    }else if (ae.getSource()==signup){
        setVisible(false);
        new Signupone().setVisible(true);        
    }
       
}
    public static void main(String args[]) {
       new Login(); 
    }
}
