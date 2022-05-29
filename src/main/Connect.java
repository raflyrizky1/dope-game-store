package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    
    private static Connection ct=null;
    
        public static Connection getConnection(){
        if(ct!=null)
            return ct;
        else{
        	
            try{
                Class.forName("com.mysql.jdbc.Driver");
                ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"create+insert?user=root&password");
                
            }
            catch(ClassNotFoundException | SQLException e){
                System.out.println("Fail");
            }
            return ct;
        }
    }
    public static void main(String[] args) {
        getConnection();
    }
    
}
