package com.mycompany.crud.ingredients;

import java.sql.*;
import java.util.Scanner;

import com.mycompany.crud.connection.Database;

import static com.mycompany.main.Main.verificarErrorInt;

public class SelectIngredients
{
    static Scanner sc = new Scanner(System.in);

    public static void selectByID(int ID)
    {
        Connection connection = Database.connectDatabase();
        try
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM inventario_ingredientes WHERE id_ingrediente = " + ID);
            while (resultSet.next())
            {
                System.out.println(resultSet.getInt("id_ingrediente") + " | " + resultSet.getString("nombre") + " | " + resultSet.getFloat("cantidad"));
            }
            statement.close();
            connection.close();
            resultSet.close();
        }
        catch (SQLException e)
        {
            e.getErrorCode();
        }
    }

    public static void selectAll()
    {
        Connection connection = Database.connectDatabase();
        try
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM inventario_ingredientes");
            while (resultSet.next())
            {
                System.out.println(resultSet.getInt("id_ingrediente") + " | " + resultSet.getString("nombre") + " | " + resultSet.getFloat("cantidad"));
            }
            statement.close();
            connection.close();
            resultSet.close();
        }
        catch (SQLException e)
        {
            e.getErrorCode();
        }
    }

    public static void selectSearchBar(String option)
    {
        Connection connection = Database.connectDatabase();
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM inventario_ingredientes WHERE id_ingrediente::text LIKE ? OR nombre LIKE ? OR cantidad::text LIKE ?");
            String likeOption = "%" + option + "%";
            preparedStatement.setString(1, likeOption);
            preparedStatement.setString(2, likeOption);
            preparedStatement.setString(3, likeOption);
            preparedStatement.executeQuery();
        }
        catch (SQLException e)
        {
            e.getErrorCode();
        }
    }

    public static void pedirDatos()
    {
        System.out.println("¿Qué deseas hacer?");
        System.out.println("1. Ver todos los ingredientes");
        System.out.println("2. Ver un ingrediente por ID");
        System.out.println("3. Buscar un ingrediente");
        int opc = 0;
        opc = verificarErrorInt(opc);
        switch (opc)
        {
            case 1:
                selectAll();
                break;
            case 2:
                System.out.println("Ingresa el ID del ingrediente que deseas buscar");
                int ID = 0;
                ID = verificarErrorInt(ID);
                selectByID(ID);
                break;
            case 3:
                System.out.println("Ingresa el nombre del ingrediente que deseas buscar");
                String option = sc.nextLine();
                selectSearchBar(option);
                break;
        }
    }
}
