package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import java.util.Date;

public class BalanceInquiry extends JFrame implements ActionListener {
    JButton exit,back;
    String pinnumber;
    
    BalanceInquiry(String pinnumber){
        this.pinnumber=pinnumber;
        
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
         Image i2 = i1.getImage().getScaledInstance(771, 900, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel atm = new JLabel(i3);
         add(atm);
         
         exit = new JButton("Exit");
         exit.setBounds(310,457,120,30);
         exit.addActionListener(this);
         atm.add(exit);
         
         back = new JButton("Back");
         back.setBounds(310,489,120,30);
         back.addActionListener(this);
         atm.add(back);
         
         int balance =0;
         Conn c=new Conn();
            try {
                ResultSet rs= c.s.executeQuery("select * from bank where pinnumber='"+pinnumber+"'");
                while(rs.next()){
                 if(rs.getString("type").equals("deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                 }else{
                     balance -= Integer.parseInt(rs.getString("amount"));
                 }
                } 
            }catch(Exception e){
                System.out.println(e);
            }
            
            JLabel text = new JLabel("Your account balance is Rs "+balance);
            text.setFont(new Font("Osward",Font.BOLD,12));
            text.setForeground(Color.WHITE);
            text.setBounds(158,250,250,100);
            atm.add(text);
         
         setSize(771,900);
         setLocation(200,0);
         setVisible(true); 
        
    }
    
    public void actionPerformed(ActionEvent ae){
              if(ae.getSource()==exit){
                  System.exit(0);
              }else{
              setVisible(false);
              new Transaction(pinnumber).setVisible(true);
              }
    }
    
    public static void main(String args[]) {
     new BalanceInquiry("");   
    }
}

