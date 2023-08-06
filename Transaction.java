package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transaction extends JFrame implements ActionListener {
    
    JButton Deposit,Withdrawl,Check,Statement,fastcash,pinchange,exit;
    String pinnumber;
     Transaction(String pinnumber) {
        this.pinnumber=pinnumber;
         
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2 = i1.getImage().getScaledInstance(771, 900, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel atm = new JLabel(i3);
         add(atm);
        
         JLabel name = new JLabel("Please select your transaction");
         name.setFont(new Font("Osward",Font.BOLD,15));
         name.setForeground(Color.WHITE);
         name.setBounds(195,250,250,100);
         atm.add(name);
         
         Deposit = new JButton("Diposit");
         Deposit.setBounds(130,393,120,30);
         Deposit.addActionListener(this);
         atm.add(Deposit);
         
         fastcash = new JButton("Fastcash");
         fastcash.setBounds(130,425,120,30);
         fastcash.addActionListener(this);
         atm.add(fastcash);
         
         pinchange = new JButton("Pinchange");
         pinchange.setBounds(130,457,120,30);
         pinchange.addActionListener(this);
         atm.add(pinchange);
         
         Withdrawl = new JButton("Cash Widrawl");
         Withdrawl.setBounds(310,393,120,30);
         Withdrawl.addActionListener(this);
         atm.add(Withdrawl);
         
         Check = new JButton("Check Balance");
         Check.setBounds(310,425,120,30);
         Check.addActionListener(this);
         atm.add(Check);
         
         Statement = new JButton("Mini Statement");
         Statement.setBounds(310,457,120,30);
         Statement.addActionListener(this);
         atm.add(Statement);
         
         exit = new JButton(" Exit");
         exit.setBounds(310,489,120,30);
         exit.addActionListener(this);
         atm.add(exit);
       
         setSize(771,900);
         setLocation(400,0);
         setVisible(true); 
     }
             
     public void actionPerformed(ActionEvent ae){
         
         if(ae.getSource()==exit){
             System.exit(0);
         }else if(ae.getSource()==Deposit){
             setVisible(false);
             new Deposit(pinnumber).setVisible(true);
         }else if(ae.getSource()==Withdrawl){
             setVisible(false);
             new Withdrawl(pinnumber).setVisible(true);
         }else if(ae.getSource()==fastcash){
             setVisible(false);
             new Fastcash(pinnumber).setVisible(true);
         }else if(ae.getSource()==Check){
             setVisible(false);
             new BalanceInquiry(pinnumber).setVisible(true);
         }else if(ae.getSource()==pinchange){
             setVisible(false);
             new PinChange(pinnumber).setVisible(true);
         }else if(ae.getSource()==Statement){
             new MiniStatement(pinnumber).setVisible(true);
         }
    
}
     
    public static void main(String args[]) {
      new Transaction("");  
    }
}
