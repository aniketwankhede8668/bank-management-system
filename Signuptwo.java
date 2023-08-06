package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Signuptwo extends JFrame implements ActionListener{
   
    JTextField categoryTextField,incomeTextField,educationTextField,occupationTextField,pannotField,adhaarTextField;
    JButton save;
    JRadioButton yes,no;
    String formno;
    JComboBox religion;
    
Signuptwo(String formno){
    this.formno = formno;
    
    setLayout(null);
    
    setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
    
    JLabel personalDetails = new JLabel("Page 2: Additinal Details");
    personalDetails.setFont(new Font("Osward",Font.BOLD,20));
    personalDetails.setBounds(300,10,250,100);
    add(personalDetails);
    
    JLabel name = new JLabel("Religion");
    name.setFont(new Font("Osward",Font.BOLD,20));
    name.setBounds(100,70,250,100);
    add(name);
     
    String valreligion[] = {"Hindu","Muslim","Sikh","Christen","Budhist","Jain"};
    religion  = new JComboBox(valreligion);
    religion.setBounds(300, 110,400,30);
    religion.setBackground(Color.WHITE);
    add(religion);
        
    JLabel category = new JLabel("Category");
    category.setFont(new Font("Osward",Font.BOLD,20));
    category.setBounds(100,140,250,100);
    add(category);
    
    categoryTextField = new JTextField();
    categoryTextField.setFont(new Font("osward",Font.BOLD,14));
    categoryTextField.setBounds(300,180,400,30);
    add(categoryTextField);
    
    JLabel income = new JLabel("Income");
    income.setFont(new Font("Osward",Font.BOLD,20));
    income.setBounds(100,210,250,100);
    add(income);
    
    incomeTextField = new JTextField();
    incomeTextField.setFont(new Font("osward",Font.BOLD,14));
    incomeTextField.setBounds(300,260,400,30);
    add(incomeTextField);
   
    JLabel education = new JLabel("Education \n Qualification");
    education.setFont(new Font("Osward",Font.BOLD,18));
    education.setBounds(80,280,250,100);
    add(education);
    
    educationTextField = new JTextField();
    educationTextField.setFont(new Font("Osward",Font.BOLD,14));
    educationTextField.setBounds(300, 330,400,30);
    add(educationTextField);
    
    
    JLabel occupation = new JLabel("Occupation");
    occupation.setFont(new Font("Osward",Font.BOLD,20));
    occupation.setBounds(100,350,250,100);
    add(occupation);
    
    occupationTextField = new JTextField();
    occupationTextField.setFont(new Font("Osward",Font.BOLD,14));
    occupationTextField.setBounds(300, 400,400,30);
    add(occupationTextField);
    
    JLabel pan = new JLabel("Pan Number");
    pan.setFont(new Font("Osward",Font.BOLD,20));
    pan.setBounds(100,420,250,100);
    add(pan);
    
    pannotField = new JTextField();
    pannotField.setFont(new Font("Osward",Font.BOLD,14));
    pannotField.setBounds(300, 470,400,30);
    add(pannotField);
    
    JLabel adhaar = new JLabel("Adhar Number");
    adhaar.setFont(new Font("Osward",Font.BOLD,20));
    adhaar.setBounds(100,490,250,100);
    add(adhaar);
   
    adhaarTextField = new JTextField();
    adhaarTextField.setFont(new Font("Osward",Font.BOLD,14));
    adhaarTextField.setBounds(300, 540,400,30);
    add(adhaarTextField);
    
    JLabel citizen = new JLabel("Senior Citizen");
    citizen.setFont(new Font("Osward",Font.BOLD,20));
    citizen.setBounds(100,560,250,100);
    add(citizen);
    
    yes = new JRadioButton("Yes");
    yes.setBackground(Color.WHITE);
    yes.setBounds(300,600,80,30);
    add(yes);
    
    no = new JRadioButton("No");
    no.setBackground(Color.WHITE);
    no.setBounds(450,600,80,30);
    add(no);
    
    
    ButtonGroup citizengroup = new ButtonGroup();
    citizengroup.add(yes);
    citizengroup.add(no);
    
    JLabel account = new JLabel("Existing Account");
    account.setFont(new Font("Osward",Font.BOLD,20));
    account.setBounds(100,630,250,100);
    add(account);
    
    
    yes = new JRadioButton("Yes");
    yes.setBackground(Color.WHITE);
    yes.setBounds(300,670,80,30);
    add(yes);
    
    no = new JRadioButton("No");
    no.setBackground(Color.WHITE);
    no.setBounds(450,670,80,30);
    add(no);
    
    
    ButtonGroup accountgroup = new ButtonGroup();
    accountgroup.add(yes);
    accountgroup.add(no);
    
  
    save = new JButton("save");
    save.setBackground(Color.BLACK);
    save.setForeground(Color.WHITE);
    save.setFont(new Font("Raylway",Font.BOLD,10));
    save.setBounds(640,710,60,30);
    save.addActionListener(this);
    add(save);
    
    getContentPane().setBackground(Color.cyan);
    setSize(850,800);
    setLocation(350,10);
    setVisible(true);
   
}
    
public void actionPerformed(ActionEvent ae){
    String sreligion = (String)religion.getSelectedItem();
    String category = categoryTextField.getText();
    String income = incomeTextField.getText();
    String education = educationTextField.getText();
    String occupation = occupationTextField.getText();
    String pan = pannotField.getText();
    String adhaar = adhaarTextField.getText();
    
    String citizen = null;
    if (yes.isSelected()){
        citizen = "Yes";
    }else if (no.isSelected()){
        citizen = "No";
    }
    
     String account = null;
    if (yes.isSelected()){
        account = "Yes";
    }else if (no.isSelected()){
        account = "No";
    }
 
    
    try {
            Conn c = new Conn();
            String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+adhaar+"','"+citizen+"','"+account+"')";
            c.s.executeUpdate(query);
            
            setVisible(false);
            new Signupthree(formno).setVisible(true);
    }catch (Exception e){
        System.out.println(e);
    }
    
}

    public static void main(String args[]) {
       new Signuptwo("");
    }
}
