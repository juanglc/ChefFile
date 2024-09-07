package com.mycompany.crud.clients;

import com.mycompany.crud.connection.Database;

import java.sql.*;

import static com.mycompany.main.Main.verificarErrorInt;

public class DeleteClients
{

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
            e.getErrorCode();
        }
    }

    public static void pedirDatos()
    {
        System.out.println("Ingrese el ID del cliente que desea eliminar: ");
        int ID = 0;
        ID = verificarErrorInt(ID);
        delete(ID);
    }
}
