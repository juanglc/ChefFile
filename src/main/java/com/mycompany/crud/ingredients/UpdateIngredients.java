package com.mycompany.crud.ingredients;

import com.mycompany.crud.connection.Database;

import java.sql.*;

import static com.mycompany.main.Main.verificarErrorInt;
import static com.mycompany.main.Main.verificarIngrediente;

public class UpdateIngredients
{
    public static void update(int ID,  int cantidad)
    {
        Connection connection = Database.connectDatabase();
        try
        {
            String query = "UPDATE inventario_ingredientes SET cantidad = ? WHERE id_ingrediente = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, cantidad);
            preparedStatement.setInt(2, ID);

            preparedStatement.executeUpdate();
            System.out.println("Registro actualizado correctamente");
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
        System.out.println("Ingresa el ID del ingrediente que deseas actualizar");
        int ID = 0;
        ID = verificarErrorInt(ID);
        System.out.println("Ingresa la nueva cantidad del ingrediente");
        int cantidad = 0;
        cantidad = verificarIngrediente(cantidad);
        update(ID, cantidad);
    }
}
