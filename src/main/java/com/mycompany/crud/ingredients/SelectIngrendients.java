package com.mycompany.crud.ingredients;

import java.sql.*;
import com.mycompany.crud.connection.Database;

public class SelectIngrendients
{
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            ResultSet resultSet = preparedStatement.executeQuery();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
