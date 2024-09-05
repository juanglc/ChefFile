package com.mycompany.crud.products;

import java.util.ArrayList;
import java.util.Scanner;
import com.mycompany.crud.connection.Database;
import java.sql.*;

public class SelectProducts
{
    static Scanner sc = new Scanner(System.in);

    public static void select()
    {

        System.out.println("Ingrese la opción de búsqueda: ");
        String option = sc.nextLine();

        try
        {
            Connection connection = Database.connectDatabase();
            String query = "SELECT * FROM productos WHERE id_producto::text LIKE ? OR nombre LIKE ? OR precio::text LIKE ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            String likeOption = "%" + option + "%";
            preparedStatement.setString(1, likeOption);
            preparedStatement.setString(2, likeOption);
            preparedStatement.setString(3, likeOption);

            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                System.out.println(resultSet.getInt("id_producto") + " | " + resultSet.getString("nombre") + " | " + resultSet.getInt("precio"));
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
            statement.executeQuery("SELECT * FROM productos");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM productos");
            while (resultSet.next())
            {
                System.out.println(resultSet.getInt("id_producto") + " | " + resultSet.getString("nombre") + " | " + resultSet.getInt("precio"));
            }
            statement.close();
            connection.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> selectArray(int ID)
    {
        ArrayList<String> product = new ArrayList<>();
        Connection connection = Database.connectDatabase();
        try
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM productos WHERE id_producto = " + ID);
            while (resultSet.next())
            {
                product.add(resultSet.getString("nombre"));
                product.add(String.valueOf(resultSet.getInt("precio")));
            }
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return product;
    }
}
