package com.mycompany.crud.connection;

import java.sql.Connection;
import java.sql.DriverManager;


public class Database {
    
    public static Connection connectDatabase() {
        Connection con_obj = null;
        String url= "jdbc:postgresql://localhost:5432/";
        String dbName="ChefFile";
        String user = "postgres";
        String password = "Juan0606";
        
        try
        {
            con_obj=DriverManager.getConnection(url+dbName,user,password);
            if(con_obj!=null)
            {
                System.out.println("Connection established properly");
            }
            else
            {
                System.out.println("Connection failed");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return con_obj;
    }
}
