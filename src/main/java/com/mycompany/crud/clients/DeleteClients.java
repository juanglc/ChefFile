package com.mycompany.crud.clients;

import com.mycompany.crud.connection.Database;

import java.sql.*;
import java.util.Scanner;

public class DeleteClients
{
    static Scanner sc = new Scanner(System.in);

    public static void delete(int ID)
    {
        Connection connection = Database.connectDatabase();
        try
        {
            String query = "DELETE FROM clientes WHERE id_cliente = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, ID);

            preparedStatement.executeUpdate();
            System.out.println("Registro eliminado correctamente");
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
