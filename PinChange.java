package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class PinChange extends JFrame implements ActionListener {
    JPasswordField amountField2,amountField1;
    JButton change,back;
    String pinnumber;
    PinChange(String pinnumber){
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
         
         JLabel p1 = new JLabel("ENTER NEW PIN");
         p1.setForeground(Color.WHITE);
         p1.setBounds(150,350,100,30);
         atm.add(p1);
         
         amountField1 = new JPasswordField();
         amountField1.setBounds(330,350,100,30);
         atm.add(amountField1);
         
         
         JLabel p2 = new JLabel("RE-ENTER NEW PIN");
         p2.setForeground(Color.WHITE);
         p2.setBounds(150,400,120,30);
         atm.add(p2);
         
         amountField2 = new JPasswordField();
         amountField2.setBounds(330,400,100,30);
         atm.add(amountField2);
         
         change = new JButton("Change");
         change.setBounds(310,457,120,30);
         change.addActionListener(this);
         atm.add(change);
         
         back = new JButton("Back");
         back.setBounds(310,489,120,30);
         back.addActionListener(this);
         atm.add(back);
         
         setSize(771,900);
         setLocation(200,0);
         setVisible(true); 
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
            try {
                String pin1 = amountField1.getText();
                String pin2 = amountField2.getText();
                
                if(!pin1.equals(pin2)){
                    JOptionPane.showMessageDialog(null,"Pin is inccorect");
                    return;
                }
                else if(pin1.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter your pin");
                    return;
                }else if(pin2.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter your pin");
                    return;
                }
                
                Conn c = new Conn();
                String query1 = "update bank set pinnumber='"+pin1+"' where pinnumber='"+pinnumber+"'";
                String query2 = "update login set pinnumber='"+pin1+"' where pinnumber='"+pinnumber+"'";
                String query3 = "update signupthree set pinnumber='"+pin1+"' where pinnumber='"+pinnumber+"'";
                
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                
                setVisible(false);
                new Transaction(pin1).setVisible(true);
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else{
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
      
    }
    
    public static void main(String args[]) {
     new PinChange("");   
    }
}



