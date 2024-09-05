package com.mycompany.crud.recipes;

import com.mycompany.crud.connection.Database;
import java.sql.*;
import java.util.ArrayList;

public class SelectRecipes
{
    public static void selectSearchBar(String option)
    {
        try
        {
            Connection connection = Database.connectDatabase();
            String query = "SELECT * FROM recetas_productos WHERE nombre LIKE ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            String likeOption = "%" + option + "%";
            preparedStatement.setString(1, likeOption);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                System.out.println("Receta: " + resultSet.getString("nombre") +
                        ", ID Receta: " + resultSet.getInt("id_receta") +
                        ", Harina: " + resultSet.getInt("harina") +
                        ", Azucar Blanca: " + resultSet.getInt("azucar_blanca") +
                        ", Azucar Morena: " + resultSet.getInt("azucar_morena") +
                        ", Polvo de Hornear: " + resultSet.getInt("polvo_hornear") +
                        ", Canela en Polvo: " + resultSet.getInt("canela_polvo") +
                        ", Sal: " + resultSet.getInt("sal") +
                        ", Cacao en Polvo: " + resultSet.getInt("cacao_polvo") +
                        ", Nueces: " + resultSet.getInt("nueces") +
                        ", Chocolate Blanco: " + resultSet.getInt("chocolate_blanco") +
                        ", Chocolate: " + resultSet.getInt("chocolate") +
                        ", Mantequilla: " + resultSet.getInt("mantequilla") +
                        ", Huevo: " + resultSet.getInt("huevo") +
                        ", Naranja: " + resultSet.getInt("naranja") +
                        ", Leche: " + resultSet.getInt("leche") +
                        ", Esencia de Vainilla: " + resultSet.getInt("esencia_vainilla") +
                        ", Crema de Leche: " + resultSet.getInt("crema_leche") +
                        ", Limon: " + resultSet.getInt("limon"));
            }
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
            statement.executeQuery("SELECT * FROM recetas_productos");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM recetas_productos");

            while (resultSet.next())
            {
                System.out.println("Receta: " + resultSet.getString("nombre") +
                        ", ID Receta: " + resultSet.getInt("id_receta") +
                        ", Harina: " + resultSet.getInt("harina") +
                        ", Azucar Blanca: " + resultSet.getInt("azucar_blanca") +
                        ", Azucar Morena: " + resultSet.getInt("azucar_morena") +
                        ", Polvo de Hornear: " + resultSet.getInt("polvo_hornear") +
                        ", Canela en Polvo: " + resultSet.getInt("canela_polvo") +
                        ", Sal: " + resultSet.getInt("sal") +
                        ", Cacao en Polvo: " + resultSet.getInt("cacao_polvo") +
                        ", Nueces: " + resultSet.getInt("nueces") +
                        ", Chocolate Blanco: " + resultSet.getInt("chocolate_blanco") +
                        ", Chocolate: " + resultSet.getInt("chocolate") +
                        ", Mantequilla: " + resultSet.getInt("mantequilla") +
                        ", Huevo: " + resultSet.getInt("huevo") +
                        ", Naranja: " + resultSet.getInt("naranja") +
                        ", Leche: " + resultSet.getInt("leche") +
                        ", Esencia de Vainilla: " + resultSet.getInt("esencia_vainilla") +
                        ", Crema de Leche: " + resultSet.getInt("crema_leche") +
                        ", Limon: " + resultSet.getInt("limon"));
            }
        }
        catch (SQLException e)
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
            ResultSet resultSet = statement.executeQuery("SELECT * FROM recetas_productos WHERE id_receta = " + ID);
            while (resultSet.next())
            {
                System.out.println("Receta: " + resultSet.getString("nombre") +
                        ", ID Receta: " + resultSet.getInt("id_receta") +
                        ", Harina: " + resultSet.getInt("harina") +
                        ", Azucar Blanca: " + resultSet.getInt("azucar_blanca") +
                        ", Azucar Morena: " + resultSet.getInt("azucar_morena") +
                        ", Polvo de Hornear: " + resultSet.getInt("polvo_hornear") +
                        ", Canela en Polvo: " + resultSet.getInt("canela_polvo") +
                        ", Sal: " + resultSet.getInt("sal") +
                        ", Cacao en Polvo: " + resultSet.getInt("cacao_polvo") +
                        ", Nueces: " + resultSet.getInt("nueces") +
                        ", Chocolate Blanco: " + resultSet.getInt("chocolate_blanco") +
                        ", Chocolate: " + resultSet.getInt("chocolate") +
                        ", Mantequilla: " + resultSet.getInt("mantequilla") +
                        ", Huevo: " + resultSet.getInt("huevo") +
                        ", Naranja: " + resultSet.getInt("naranja") +
                        ", Leche: " + resultSet.getInt("leche") +
                        ", Esencia de Vainilla: " + resultSet.getInt("esencia_vainilla") +
                        ", Crema de Leche: " + resultSet.getInt("crema_leche") +
                        ", Limon: " + resultSet.getInt("limon"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> selectArray(int ID)
    {
        ArrayList<String> recipe = new ArrayList<>();
        Connection connection = Database.connectDatabase();
        try
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM recetas_productos WHERE id_receta = " + ID);
            while (resultSet.next())
            {
                recipe.add(resultSet.getString("nombre"));
                recipe.add(String.valueOf(resultSet.getInt("harina")));
                recipe.add(String.valueOf(resultSet.getInt("azucar_blanca")));
                recipe.add(String.valueOf(resultSet.getInt("azucar_morena")));
                recipe.add(String.valueOf(resultSet.getInt("polvo_hornear")));
                recipe.add(String.valueOf(resultSet.getInt("canela_polvo")));
                recipe.add(String.valueOf(resultSet.getInt("sal")));
                recipe.add(String.valueOf(resultSet.getInt("cacao_polvo")));
                recipe.add(String.valueOf(resultSet.getInt("nueces")));
                recipe.add(String.valueOf(resultSet.getInt("chocolate_blanco")));
                recipe.add(String.valueOf(resultSet.getInt("chocolate")));
                recipe.add(String.valueOf(resultSet.getInt("mantequilla")));
                recipe.add(String.valueOf(resultSet.getInt("huevo")));
                recipe.add(String.valueOf(resultSet.getInt("naranja")));
                recipe.add(String.valueOf(resultSet.getInt("leche")));
                recipe.add(String.valueOf(resultSet.getInt("esencia_vainilla")));
                recipe.add(String.valueOf(resultSet.getInt("crema_leche")));
                recipe.add(String.valueOf(resultSet.getInt("limon")));
            }
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return recipe;
    }
}
