package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame{ 
      
    MiniStatement(String pinnumber){
              setTitle("Mini Statement");
              setLayout(null);
              
              JLabel bank = new JLabel("MAHARASHTA BANK");
              bank.setBounds(140,20,150,20);
              add(bank);
              
              JLabel card = new JLabel();
              card.setBounds(20,80,300,20);
              add(card);
              
              JLabel mini = new JLabel();
              mini.setBounds(20,100,400,200);
              add(mini);
              
              JLabel balance = new JLabel();
              balance.setBounds(20,400,300,20);
              add(balance);
              
             try {
                 Conn c = new Conn();
                 ResultSet rs = c.s.executeQuery("select * from login where pinnumber ='"+pinnumber+"'");
                 while(rs.next()){
                     card.setText("Card Number: "+rs.getString("cardnumber").substring(0,4)+"XXXXX"+rs.getString("cardnumber").substring(9));
                 }
                 
             }catch(Exception e) {
                 System.out.println(e);
             }
             
             try {
                 Conn c = new Conn();
                 int rupee = 0;
                 ResultSet rs = c.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
                 while(rs.next()){
                    mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br></br>");
                    if(rs.getString("type").equals("deposit")){
                    rupee += Integer.parseInt(rs.getString("amount"));
                 }else{
                     rupee -= Integer.parseInt(rs.getString("amount"));
                 }
                 }
                 balance.setText("Your account balance is Rs "+rupee);
             }catch(Exception e){
                 System.out.println(e);
             }
                       
              setSize(400,600);
              setLocation(20,20);
              getContentPane().setBackground(Color.lightGray);
              setVisible(true);
        
    }
    
    public static void main(String args[]) {
     new MiniStatement("");   
    }
}




