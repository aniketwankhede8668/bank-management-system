package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Signupthree extends JFrame implements ActionListener{
   
    JButton submit,cancel;
    JRadioButton saving,recovred,current,fixed;
    JCheckBox internet,atm,mobile,checkbook,estatement,email,confirm;
    String formno;
    
    
Signupthree(String formno){
    this.formno = formno;
    
    setLayout(null);
    
    setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
    
    JLabel personalDetails = new JLabel("Page 3: Account Details");
    personalDetails.setFont(new Font("Osward",Font.BOLD,20));
    personalDetails.setBounds(300,10,250,100);
    add(personalDetails);
    
    JLabel type = new JLabel("ACCOUNT TYPE");
    type.setFont(new Font("Osward",Font.BOLD,20));
    type.setBounds(100,70,250,100);
    add(type);
    
    saving = new JRadioButton("Saving Account");
    saving.setBackground(Color.WHITE);
    saving.setBounds(100,140,150,30);
    add(saving);
    
    fixed = new JRadioButton("Fixed Deposite Account");
    fixed.setBackground(Color.WHITE);
    fixed.setBounds(450,140,200,30);
    add(fixed);
    
    current = new JRadioButton("Current Account");
    current.setBackground(Color.WHITE);
    current.setBounds(100,180,150,30);
    add(current);
    
    recovred = new JRadioButton("Recurring Deposite Account");
    recovred.setBackground(Color.WHITE);
    recovred.setBounds(450,180,200,30);
    add(recovred);
    
    
    ButtonGroup acctypegroup = new ButtonGroup();
    acctypegroup.add(saving);
    acctypegroup.add(fixed);
    acctypegroup.add(current);
    acctypegroup.add(recovred);
          
    JLabel card = new JLabel("CARD NUMBER");
    card.setFont(new Font("Osward",Font.BOLD,20));
    card.setBounds(100,200,250,100);
    add(card);
    
    JLabel number= new JLabel(" XXXX-XXXX-XXXX-XX56");
    number.setFont(new Font("Osward",Font.BOLD,20));
    number.setBounds(450,240,400,30);
    add(number);
    
    JLabel carddetails= new JLabel(" Your 13 digit card number");
    carddetails.setFont(new Font("Osward",Font.BOLD,12));
    carddetails.setBounds(99,260,400,20);
    add(carddetails);
    
    
    JLabel pin = new JLabel("PIN");
    pin.setFont(new Font("Osward",Font.BOLD,20));
    pin.setBounds(100,260,250,100);
    add(pin);
    
    JLabel pnumber = new JLabel("XXXX");
    pnumber.setFont(new Font("Osward",Font.BOLD,20));
    pnumber.setBounds(450,300,400,30);
    add(pnumber);
    
    JLabel pindetails= new JLabel(" Your 4 digit pin number");
    pindetails.setFont(new Font("Osward",Font.BOLD,12));
    pindetails.setBounds(99,320,400,20);
    add(pindetails);
   
    
    JLabel services = new JLabel("SRVICES REQUIRED");
    services.setFont(new Font("Osward",Font.BOLD,18));
    services.setBounds(100,320,250,100);
    add(services);
    
    atm = new JCheckBox("ATM CARD");
    atm.setBackground(Color.WHITE);
    atm.setBounds(100,400,200,30);
    add(atm);
       
    internet = new JCheckBox("INTERNET BANKING ");
    internet.setBackground(Color.WHITE);
    internet.setBounds(100,450,150,30);
    add(internet);
    
    mobile = new JCheckBox("MOBILE BANKING");
    mobile.setBackground(Color.WHITE);
    mobile.setBounds(100,500,150,30);
    add(mobile);
    
    checkbook = new JCheckBox("CHECKBOOK");
    checkbook.setBackground(Color.WHITE);
    checkbook.setBounds(450,400,200,30);
    add(checkbook);
    
    estatement = new JCheckBox("E-STATEMENT");
    estatement.setBackground(Color.WHITE);
    estatement.setBounds(450,450,200,30);
    add(estatement);
    
    email = new JCheckBox("EMAIL & SMS ALERT");
    email.setBackground(Color.WHITE);
    email.setBounds(450,500,200,30);
    add(email);
    
    confirm = new JCheckBox("I hereby declear that above detals are correct based on my knowladge");
    confirm.setBackground(Color.WHITE);
    confirm.setBounds(100,550,550,30);
    add(confirm);
    
    submit = new JButton("Submit");
    submit.setBackground(Color.BLACK);
    submit.setForeground(Color.WHITE);
    submit.setFont(new Font("Raylway",Font.BOLD,10));
    submit.setBounds(200,600,80,30);
    submit.addActionListener(this);
    add(submit);
    
  
    cancel = new JButton("Cancel");
    cancel.setBackground(Color.BLACK);
    cancel.setForeground(Color.WHITE);
    cancel.setFont(new Font("Raylway",Font.BOLD,10));
    cancel.setBounds(500,600,80,30);
    cancel.addActionListener(this);
    add(cancel);
    
    getContentPane().setBackground(Color.cyan);
    setSize(800,800);
    setLocation(350,10);
    setVisible(true);
   
}
    
public void actionPerformed(ActionEvent ae){
    if (ae.getSource()== submit){  
    String accounttype = null;
    if (saving.isSelected()){
        accounttype = "saving account";
    }else if (current.isSelected()){
        accounttype = "current account";
    }else if(fixed.isSelected()){
        accounttype = " fixed deposite";
    }else if(recovred.isSelected()){
        accounttype = "recovred account";
    }
    
    Random random = new Random();
    String cardnumber =""+ Math.abs((random.nextLong()% 90000000L)+ 5040936000000L);
    String pinnumber = ""+ Math.abs((random.nextLong()% 9000L)+1000L);
   
    String facility = " ";
    if (atm.isSelected()){
        facility ="ATM";
    }else if (mobile.isSelected()){
        facility ="Mobile Banking";
    }else if(internet.isSelected()){
        facility = "Internet Banking";
    }else if(checkbook.isSelected()){
           facility =  "Checkbook";
    }else if(estatement.isSelected()){
        facility ="E-Statement";
    }else if(email.isSelected()){
        facility = "Email";
    }
    
    try {   
            if(accounttype.equals("")){
            JOptionPane.showMessageDialog(null,"Account type is required");
            }else{
            Conn c = new Conn();
            String q1 = "insert into signupthree values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
            String q2 = "insert into login values ('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
            c.s.executeUpdate(q1);
           c.s.executeUpdate(q2);
          
            JOptionPane.showMessageDialog(null,"Card Number:"+ cardnumber+"\nPin Number:"+ pinnumber);
 
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
            }         
    }catch (Exception e){
        System.out.println(e);
    }  
}
    else if(ae.getSource()==cancel){
        setVisible(false);
        new Login().setVisible(true);
    }
}

    public static void main(String args[]) {
       new Signupthree("");
    }
}

