package com.mycompany.crud.clients;

import com.mycompany.crud.connection.Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SelectClients
{
    static Scanner sc = new Scanner(System.in);

    public static void selectSearchBar(String option)
    {
        try
        {
            Connection connection = Database.connectDatabase();
            String query = "SELECT * FROM clientes WHERE id_cliente::text LIKE ? OR primer_nombre LIKE ? OR primer_apellido LIKE ? OR segundo_apellido LIKE ? OR numero_telefonico LIKE ? OR correo_electronico LIKE ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            String likeOption = "%" + option + "%";
            preparedStatement.setString(1, likeOption);
            preparedStatement.setString(2, likeOption);
            preparedStatement.setString(3, likeOption);
            preparedStatement.setString(4, likeOption);
            preparedStatement.setString(5, likeOption);
            preparedStatement.setString(6, likeOption);

            preparedStatement.executeQuery();

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                System.out.println(resultSet.getInt("id_cliente") + " | " + resultSet.getString("primer_nombre") + " | " + resultSet.getString("primer_apellido") + " | " + resultSet.getString("segundo_apellido") + " | " + resultSet.getString("numero_telefonico") + " | " + resultSet.getString("correo_electronico"));
            }
            preparedStatement.close();
            connection.close();
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
            statement.executeQuery("SELECT * FROM clientes");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM clientes");
            while (resultSet.next())
            {
                System.out.println(resultSet.getInt("id_cliente") + " | " + resultSet.getString("primer_nombre") + " | " + resultSet.getString("primer_apellido") + " | " + resultSet.getString("segundo_apellido") + " | " + resultSet.getString("numero_telefonico") + " | " + resultSet.getString("correo_electronico"));
            }
            statement.close();
            connection.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static ArrayList selectByID(int ID)
    {
        ArrayList<String> cliente = new ArrayList<>();
        Connection connection = Database.connectDatabase();
        try
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM clientes WHERE id_cliente = " + ID);
            while (resultSet.next())
            {
                cliente.add(resultSet.getString("primer_nombre"));
                cliente.add(resultSet.getString("primer_apellido"));
                cliente.add(resultSet.getString("segundo_apellido"));
                cliente.add(resultSet.getString("numero_telefonico"));
                cliente.add(resultSet.getString("correo_electronico"));
            }
            statement.close();
            connection.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return cliente;
    }
}
