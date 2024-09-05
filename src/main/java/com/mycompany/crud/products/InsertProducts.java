package com.mycompany.crud.products;

import com.mycompany.crud.connection.Database;

import java.util.Scanner;
import java.sql.*;

public class InsertProducts
{
    static Scanner sc = new Scanner(System.in);

    public static void insert()
    {
        Connection connection = Database.connectDatabase();
        System.out.println("Ingrese el nombre del producto: ");
        String nombre = sc.nextLine();
        int precio = 0;
        while(true)
        {
            System.out.println("Ingrese el precio del producto:");
            try
            {
                precio = sc.nextInt();
                sc.nextLine();
                break;
            }
            catch (Exception e)
            {
                System.out.println("Por favor, ingrese un número entero");
                sc.nextLine();
            }
        }
        try
        {
            String query = "INSERT INTO productos(nombre, precio) VALUES(?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nombre);
            preparedStatement.setInt(2, precio);

            preparedStatement.executeUpdate();

            System.out.println("Registro insertado correctamente");
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
