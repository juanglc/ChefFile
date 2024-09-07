package com.mycompany.crud.products;

import com.mycompany.crud.connection.Database;

import java.util.Scanner;
import java.sql.*;

import static com.mycompany.main.Main.verificarErrorInt;

public class InsertProducts
{
    static Scanner sc = new Scanner(System.in);

    public static void insert(String nombre, int precio)
    {
        Connection connection = Database.connectDatabase();
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
            e.getErrorCode();
        }
    }

    public static void pedirDatos()
    {
        System.out.println("Ingrese el nombre del producto: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el precio del producto: ");
        int precio = 0;
        precio = verificarErrorInt(precio);
        insert(nombre, precio);
    }
}
