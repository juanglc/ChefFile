package com.mycompany.crud.recipes;

import com.mycompany.crud.connection.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UpdateRecipes
{
    public static void update(int ID, ArrayList<String> recipe, ArrayList<String> comparison) {
        Connection connection = Database.connectDatabase();
        String query = "UPDATE recetas SET ";
        String[] columns = {"harina", "azucar_blanca", "azucar_morena", "polvo_hornear", "canela_polvo", "sal", "cacao_polvo", "nueces", "chocolate_blanco", "chocolate", "mantequilla", "huevo", "naranja", "leche", "esencia_vainilla", "crema_leche", "limon"};
        boolean first = true;
        for (int i = 0; i < columns.length; i++) {
            if (!recipe.get(i).equals(comparison.get(i))) {
                if (!first) {
                    query = query + ", ";
                }
                query = query + columns[i] + " = '" + comparison.get(i) + "'";
                first = false;
            }
        }
        query = query + " WHERE id_producto = " + ID;
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

}
