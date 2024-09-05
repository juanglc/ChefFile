package com.mycompany.crud.recipes;

import com.mycompany.crud.connection.Database;

import java.sql.*;

public class DeleteRecipes
{
    public static void delete(int ID)
    {
        Connection connection = Database.connectDatabase();
        try
        {
            String query = "DELETE FROM recetas WHERE id_receta = ?";
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
