package com.mycompany.crud.orders;

import com.mycompany.crud.connection.Database;

import java.sql.*;
import java.util.Scanner;

import static com.mycompany.main.Main.verificarErrorInt;

public class DeleteOrders
{
    static Scanner sc = new Scanner(System.in);

    public static void delete(int ID)
    {
        Connection connection = Database.connectDatabase();
        try
        {
            String query = "DELETE FROM pedidos WHERE id_pedido = ?";
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

    public static void pedirDatos()
    {
        System.out.println("Ingrese el ID del pedido que desea eliminar: ");
        int ID=0;
        ID = verificarErrorInt(ID);
        delete(ID);
    }
}
