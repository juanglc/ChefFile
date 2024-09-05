package com.mycompany.crud.clients;

import com.mycompany.crud.connection.Database;

import java.sql.*;
import java.util.ArrayList;

public class UpdateClients
{
    public static void update(int ID, ArrayList<String> client, ArrayList<String> comparison)
    {
        Connection connection = Database.connectDatabase();
        String query = "UPDATE clientes SET ";
        String[] columns = {"primer_nombre", "primer_apellido", "segundo_apellido", "numero_telefonico", "correo_electronico"};
        boolean first = true;
        for (int i = 0; i < columns.length; i++)
        {
            if (!client.get(i).equals(comparison.get(i)))
            {
                if (!first)
                {
                    query = query + ", ";
                }
                query = query + columns[i] + " = '" + comparison.get(i) + "'";
                first = false;
            }
        }
        query = query + " WHERE id_cliente = " + (ID);
        try
        {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            System.out.println("Registro actualizado correctamente");
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    /*
    public static void updateNombre(int ID)
    {
        Connection connection = Database.connectDatabase();
        System.out.println("Ingrese el nombre: ");
        String nombre = sc.nextLine();
        try
        {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE clientes SET primer_nombre = '" + nombre + "' WHERE id_cliente = " + ID);
                /*ResultSet resultSet = statement.executeQuery("SELECT * FROM clientes WHERE id_cliente = " + ID);
                while (resultSet.next())
                {
                    System.out.println(resultSet.getInt("id_cliente") + " | " + resultSet.getString("primer_nombre") + " | " + resultSet.getString("primer_apellido") + " | " + resultSet.getString("segundo_apellido") + " | " + resultSet.getString("numero_telefonico") + " | " + resultSet.getString("correo_electronico"));
                }
            statement.close();
            System.out.println("Registro actualizado correctamente");
            connection.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void updatePrimerApellido(int ID)
    {
        Connection connection = Database.connectDatabase();
        System.out.println("Ingrese el apellido: ");
        String apellido = sc.nextLine();
        try
        {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE clientes SET primer_apellido = '" + apellido + "' WHERE id_cliente = " + ID);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM clientes WHERE id_cliente = " + ID);
            while (resultSet.next())
            {
                System.out.println(resultSet.getInt("id_cliente") + " | " + resultSet.getString("primer_nombre") + " | " + resultSet.getString("primer_apellido") + " | " + resultSet.getString("segundo_apellido") + " | " + resultSet.getString("numero_telefonico") + " | " + resultSet.getString("correo_electronico"));
            }
            statement.close();
            System.out.println("Registro actualizado correctamente");
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void updateSegundoApellido(int ID)
    {
        Connection connection = Database.connectDatabase();
        System.out.println("Ingrese el segundo apellido: ");
        String apellido = sc.nextLine();
        try
        {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE clientes SET segundo_apellido = '" + apellido + "' WHERE id_cliente = " + ID);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM clientes WHERE id_cliente = " + ID);
            while (resultSet.next())
            {
                System.out.println(resultSet.getInt("id_cliente") + " | " + resultSet.getString("primer_nombre") + " | " + resultSet.getString("primer_apellido") + " | " + resultSet.getString("segundo_apellido") + " | " + resultSet.getString("numero_telefonico") + " | " + resultSet.getString("correo_electronico"));
            }
            statement.close();
            System.out.println("Registro actualizado correctamente");
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void updateTelefono(int ID)
    {
        Connection connection = Database.connectDatabase();
        System.out.println("Ingrese el número telefónico: ");
        String telefono = sc.nextLine();
        try
        {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE clientes SET numero_telefonico = '" + telefono + "' WHERE id_cliente = " + ID);
                ResultSet resultSet = statement.executeQuery("SELECT * FROM clientes WHERE id_cliente = " + ID);
                while (resultSet.next())
                {
                    System.out.println(resultSet.getInt("id_cliente") + " | " + resultSet.getString("primer_nombre") + " | " + resultSet.getString("primer_apellido") + " | " + resultSet.getString("segundo_apellido") + " | " + resultSet.getString("numero_telefonico") + " | " + resultSet.getString("correo_electronico"));
                }
            statement.close();
            System.out.println("Registro actualizado correctamente");
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void updateCorreo(int ID)
    {
        Connection connection = Database.connectDatabase();
        System.out.println("Ingrese el correo electrónico: ");
        String correo = sc.nextLine();
        try
        {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE clientes SET correo_electronico = '" + correo + "' WHERE id_cliente = " + ID);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM clientes WHERE id_cliente = " + ID);
            while (resultSet.next())
            {
                System.out.println(resultSet.getInt("id_cliente") + " | " + resultSet.getString("primer_nombre") + " | " + resultSet.getString("primer_apellido") + " | " + resultSet.getString("segundo_apellido") + " | " + resultSet.getString("numero_telefonico") + " | " + resultSet.getString("correo_electronico"));
            }

            System.out.println("Registro actualizado correctamente");
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }*/
}
