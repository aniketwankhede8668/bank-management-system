package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;


public class Signupone extends JFrame implements ActionListener{
    
    long random;
    JTextField nameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    JButton next;
    JRadioButton male,female,other,married,unmarried;
    JDateChooser dateChooser;
    
Signupone(){
    setLayout(null);
    setTitle("APPLICATION FORM");
    
    Random ran = new Random();
    random = Math.abs((ran.nextLong()%9000L)+1000L);
 
    
    JLabel formno = new JLabel("APPLICATION FORM NO."+" "+random);
    formno.setFont(new Font("Osward",Font.BOLD,38));
    formno.setBounds(160,10,600,40);
    add(formno);
    
    JLabel personalDetails = new JLabel("Page 1: Personal Details");
    personalDetails.setFont(new Font("Osward",Font.BOLD,20));
    personalDetails.setBounds(300,20,250,100);
    add(personalDetails);
    
    JLabel name = new JLabel("NAME");
    name.setFont(new Font("Osward",Font.BOLD,20));
    name.setBounds(100,70,250,100);
    add(name);
    
    nameTextField = new JTextField();
    nameTextField.setFont(new Font("Osward",Font.BOLD,14));
    nameTextField.setBounds(300, 110,400,30);
    add(nameTextField);
    
    JLabel dob = new JLabel("DOB");
    dob.setFont(new Font("Osward",Font.BOLD,20));
    dob.setBounds(100,140,250,100);
    add(dob);
    
    dateChooser = new JDateChooser();
    dateChooser.setBounds(300,180,400,30);
    dateChooser.setForeground(new Color(105,105,105));
    add(dateChooser);
    
    JLabel gender = new JLabel("GENDER");
    gender.setFont(new Font("Osward",Font.BOLD,20));
    gender.setBounds(100,210,250,100);
    add(gender);
    
    male = new JRadioButton("male");
    male.setBackground(Color.WHITE);
    male.setBounds(300,260,100,30);
    add(male);
    
    female = new JRadioButton("female");
    female.setBackground(Color.WHITE);
    female.setBounds(450,260,100,30);
    add(female);
    
    ButtonGroup gendergroup = new ButtonGroup();
    gendergroup.add(male);
    gendergroup.add(female);
   
    JLabel email = new JLabel("EMAIL");
    email.setFont(new Font("Osward",Font.BOLD,20));
    email.setBounds(100,280,250,100);
    add(email);
    
    emailTextField = new JTextField();
    emailTextField.setFont(new Font("Osward",Font.BOLD,14));
    emailTextField.setBounds(300, 330,400,30);
    add(emailTextField);
    
    
    JLabel marital = new JLabel("MARITAL");
    marital.setFont(new Font("Osward",Font.BOLD,20));
    marital.setBounds(100,350,250,100);
    add(marital);
    
    married = new JRadioButton("married");
    married.setBackground(Color.WHITE);
    married.setBounds(300,400,100,30);
    add(married);
    
    unmarried = new JRadioButton("unmarried");
    unmarried.setBackground(Color.WHITE);
    unmarried.setBounds(400,400,100,30);
    add(unmarried);
    
    other = new JRadioButton("other");
    other.setBackground(Color.WHITE);
    other.setBounds(500,400,100,30);
    add(other);
    
    ButtonGroup maritalgroup = new ButtonGroup();
    maritalgroup.add(married);
    maritalgroup.add(unmarried);
    maritalgroup.add(other);
    
    JLabel address = new JLabel("ADDRESS");
    address.setFont(new Font("Osward",Font.BOLD,20));
    address.setBounds(100,420,250,100);
    add(address);
    
    addressTextField = new JTextField();
    addressTextField.setFont(new Font("Osward",Font.BOLD,14));
    addressTextField.setBounds(300, 470,400,30);
    add(addressTextField);
    
    JLabel city = new JLabel("CITY");
    city.setFont(new Font("Osward",Font.BOLD,20));
    city.setBounds(100,490,250,100);
    add(city);
    
    cityTextField = new JTextField();
    cityTextField.setFont(new Font("Osward",Font.BOLD,14));
    cityTextField.setBounds(300, 540,400,30);
    add(cityTextField);
    
    JLabel state = new JLabel("STATE");
    state.setFont(new Font("Osward",Font.BOLD,20));
    state.setBounds(100,560,250,100);
    add(state);
    
    stateTextField = new JTextField();
    stateTextField.setFont(new Font("Osward",Font.BOLD,14));
    stateTextField.setBounds(300, 610,400,30);
    add(stateTextField);
    
    
    JLabel pincode = new JLabel("PINCODE");
    pincode.setFont(new Font("Osward",Font.BOLD,20));
    pincode.setBounds(100,630,250,100);
    add(pincode);
    
    pinTextField = new JTextField();
    pinTextField.setFont(new Font("Osward",Font.BOLD,14));
    pinTextField.setBounds(300, 680,400,30);
    add(pinTextField);
  
    next = new JButton("Next");
    next.setBackground(Color.BLACK);
    next.setForeground(Color.WHITE);
    next.setFont(new Font("Raylway",Font.BOLD,10));
    next.setBounds(640,710,60,30);
    next.addActionListener(this);
    add(next);
    
    getContentPane().setBackground(Color.cyan);
    setSize(850,800);
    setLocation(350,10);
    setVisible(true);
   
}
    
public void actionPerformed(ActionEvent ae){
    String formno = ""+ random; //"" is used to convert any value in string
    String pname = nameTextField.getText();
    String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
    String gender = null;
    if(male.isSelected()){
        gender = "male";
    } else if (female.isSelected()){
        gender = "female";
    }
    
    String email = emailTextField.getText();
    String marital = null;
    if (married.isSelected()){
        marital = "married";
    }else if (unmarried.isSelected()){
        marital = "unmarried";
    }else if (other.isSelected()){
        marital = "other";
    }
    
    String address = addressTextField.getText();
    String city = cityTextField.getText();
    String state = stateTextField.getText();
    String pin = pinTextField.getText();
    
    
    try {  
        if(pname.equals("")){
            JOptionPane.showMessageDialog(null, "Name is required");
        } else {
            Conn c = new Conn();
            String query = "insert into signup values('"+formno+"','"+pname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
            c.s.executeUpdate(query);
            
            setVisible(false);
            new Signuptwo(formno).setVisible(true);
        }
        } catch (Exception e){
        System.out.println(e);
    }  
}

    public static void main(String args[]) {
       new Signupone();
    }
}
