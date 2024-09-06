package com.mycompany.crud.products;

import java.util.ArrayList;
import java.util.Scanner;
import com.mycompany.crud.connection.Database;
import java.sql.*;

import static com.mycompany.main.Main.verificarErrorInt;

public class SelectProducts
{
    static Scanner sc = new Scanner(System.in);

    public static void selectSearchBar(String option)
    {
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

    public static void selectByID(int ID)
    {
        Connection connection = Database.connectDatabase();
        try
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM productos WHERE id_producto = " + ID);
            while (resultSet.next())
            {
                System.out.println(resultSet.getInt("id_producto") + " | " + resultSet.getString("nombre") + " | " + resultSet.getInt("precio"));
            }
            statement.close();
            connection.close();
        }
        catch (SQLException e)
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

    public static void pedirDatos()
    {
        System.out.println("¿Qué deseas hacer?");
        System.out.println("1. Buscar un producto por su ID");
        System.out.println("2. Ver todos los productos");
        System.out.println("3. Buscar un producto por su nombre o precio");
        System.out.println("4. Regresar al menú principal");
        int opc = 0;
        opc = verificarErrorInt(opc);
        switch (opc)
        {
            case 1:
                System.out.println("Ingrese el ID del producto que desea buscar: ");
                int ID = 0;
                ID = verificarErrorInt(ID);
                selectByID(ID);
                break;
            case 2:
                selectAll();
                break;
            case 3:
                System.out.println("Ingrese la opción de búsqueda: ");
                String option = sc.nextLine();
                selectSearchBar(option);
                break;
        }
    }
}
