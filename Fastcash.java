package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener {
    
    JButton onehundred,fivehundrad,onethousand,twothousand,fivethousand,tenthousand,back;
    String pinnumber;
     Fastcash(String pinnumber) {
        this.pinnumber=pinnumber;
         
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
         Image i2 = i1.getImage().getScaledInstance(771, 900, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel atm = new JLabel(i3);
         add(atm);
        
         JLabel name = new JLabel("SELECT WITHDRAWL AMOUNT");
         name.setFont(new Font("Osward",Font.BOLD,15));
         name.setForeground(Color.WHITE);
         name.setBounds(195,250,250,100);
         atm.add(name);
         
         onehundred = new JButton("Rs 100");
         onehundred.setBounds(130,393,120,30);
         onehundred.addActionListener(this);
         atm.add(onehundred);
         
         fivehundrad = new JButton("Rs 500");
         fivehundrad.setBounds(130,425,120,30);
         fivehundrad.addActionListener(this);
         atm.add(fivehundrad);
         
         onethousand = new JButton("Rs 1000");
         onethousand.setBounds(130,457,120,30);
         onethousand.addActionListener(this);
         atm.add(onethousand);
         
         twothousand = new JButton("Rs 2000");
         twothousand.setBounds(310,393,120,30);
         twothousand.addActionListener(this);
         atm.add(twothousand);
         
         fivethousand = new JButton("Rs 5000");
         fivethousand.setBounds(310,425,120,30);
         fivethousand.addActionListener(this);
         atm.add(fivethousand);
         
         tenthousand = new JButton("Rs 10000");
         tenthousand.setBounds(310,457,120,30);
         tenthousand.addActionListener(this);
         atm.add(tenthousand);
         
         back = new JButton(" BACK");
         back.setBounds(310,489,120,30);
         back.addActionListener(this);
         atm.add(back);
       
         setSize(771,900);
         setLocation(200,0);
         setVisible(true); 
     }
             
     public void actionPerformed(ActionEvent ae){
         
         if(ae.getSource()==back){
             setVisible(false);
             new Transaction(pinnumber).setVisible(true);
         } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try {
                ResultSet rs= c.s.executeQuery("select * from bank where pinnumber='"+pinnumber+"'");
                int balance =0;
                while(rs.next()){
                 if(rs.getString("type").equals("deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                 }else{
                     balance -= Integer.parseInt(rs.getString("amount"));
                 }
            }
                if(ae.getSource()!=back && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insyfficent Balance");
                    return;
                }
                Date date = new Date();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+amount+" Debited Successfully");
                
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
                
            }catch(Exception e){
                System.out.println(e);
            }
         }
}
     
    public static void main(String args[]) {
      new Fastcash("");  
    }
}

