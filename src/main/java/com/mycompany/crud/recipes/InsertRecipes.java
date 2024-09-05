package com.mycompany.crud.recipes;

import com.mycompany.crud.connection.Database;
import java.sql.*;



public class InsertRecipes
{
    public static void insert(int idReceta, int idProducto, int harina, int azucarBlanca, int azucarMorena, int polvoHornear, int canelaPolvo, int sal, int cacaoPolvo, int nueces, int chocolateBlanco, int chocolate, int mantequilla, int huevo, int naranja, int leche, int esenciaVainilla, int cremaLeche, int limon)
    {
        Connection connection = Database.connectDatabase();
        try {
            String query = "INSERT INTO public.recetas(id_producto, harina, azucar_blanca, azucar_morena, polvo_hornear, canela_polvo, sal, cacao_polvo, nueces, chocolate_blanco, chocolate, mantequilla, huevo, naranja, leche, esencia_vainilla, crema_leche, limon) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idProducto);
            preparedStatement.setInt(2, harina);
            preparedStatement.setInt(3, azucarBlanca);
            preparedStatement.setInt(4, azucarMorena);
            preparedStatement.setInt(5, polvoHornear);
            preparedStatement.setInt(6, canelaPolvo);
            preparedStatement.setInt(7, sal);
            preparedStatement.setInt(8, cacaoPolvo);
            preparedStatement.setInt(9, nueces);
            preparedStatement.setInt(10, chocolateBlanco);
            preparedStatement.setInt(11, chocolate);
            preparedStatement.setInt(12, mantequilla);
            preparedStatement.setInt(13, huevo);
            preparedStatement.setInt(14, naranja);
            preparedStatement.setInt(15, leche);
            preparedStatement.setInt(16, esenciaVainilla);
            preparedStatement.setInt(17, cremaLeche);
            preparedStatement.setInt(18, limon);

            preparedStatement.executeUpdate();

            System.out.println("Registro insertado correctamente");
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
