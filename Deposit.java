package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {
    JTextField amountField;
    JButton deposit,back;
    String pinnumber;
    Deposit(String pinnumber){
        this.pinnumber=pinnumber;
        
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
         Image i2 = i1.getImage().getScaledInstance(771, 900, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel atm = new JLabel(i3);
         add(atm);
         
         JLabel text = new JLabel("Enter Your Amounnt you Want To Deposit");
         text.setFont(new Font("Osward",Font.BOLD,12));
         text.setForeground(Color.WHITE);
         text.setBounds(158,250,250,100);
         atm.add(text);
         
         amountField = new JTextField();
         amountField.setBounds(150,350,250,30);
         atm.add(amountField);
         
         deposit = new JButton("Deposit");
         deposit.setBounds(310,457,120,30);
         deposit.addActionListener(this);
         atm.add(deposit);
         
         back = new JButton("Back");
         back.setBounds(310,489,120,30);
         back.addActionListener(this);
         atm.add(back);
         
         setSize(771,900);
         setLocation(200,0);
         setVisible(true); 
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== deposit){
            String number = amountField.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposit" );
                setVisible(false);
                new Login().setVisible(true);
            }
            else{
                try {
                Conn conn = new Conn();
                String query="insert into bank values('"+pinnumber+"','"+date+"','deposit','"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+number+" Deposited Successfully");
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }else if(ae.getSource()==back){
           setVisible(false);
           new Transaction(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]) {
     new Deposit("");   
    }
}
