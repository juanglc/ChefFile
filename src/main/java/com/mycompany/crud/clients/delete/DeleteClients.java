package com.mycompany.crud.clients.delete;

import com.mycompany.crud.connection.Database;

import java.sql.*;
import java.util.Scanner;

public class DeleteClients
{
    static Scanner sc = new Scanner(System.in);

    public static void delete()
    {
        int ID = 0;
        Connection connection = Database.connectDatabase();
        while(true)
        {
            System.out.println("Ingrese el ID del cliente que desea eliminar: ");
            try
            {
                ID = sc.nextInt();
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
