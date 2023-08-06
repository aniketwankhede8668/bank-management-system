package bank.managment.system;
import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    
    public Conn(){
    try {
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagmentsystem","root","startup@code@withanni");
        s = c.createStatement();
    }
    catch(Exception e){
    System.out.println(e);
}
}
}
