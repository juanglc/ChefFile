package com.mycompany.crud.ingredients;

import com.mycompany.crud.connection.Database;

import java.sql.*;

public class UpdateIngredients
{
    public static void update(int ID,  float cantidad)
    {
        Connection connection = Database.connectDatabase();
        try
        {
            String query = "UPDATE inventario_ingredientes SET cantidad = ? WHERE id_ingrediente = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setFloat(1, cantidad);
            preparedStatement.setInt(2, ID);

            preparedStatement.executeUpdate();
            System.out.println("Registro actualizado correctamente");
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}
