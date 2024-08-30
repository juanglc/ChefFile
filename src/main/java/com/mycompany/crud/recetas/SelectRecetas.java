package com.mycompany.crud.recetas;

import com.mycompany.crud.connection.Database;
import java.sql.*;

public class SelectRecetas
{
    public static void selectSearchBar(String option)
    {
        try {
            Connection connection = Database.connectDatabase();
            String[] columns = {"nombre", "id_receta", "id_producto", "harina", "azucar_blanca", "azucar_morena", "polvo_hornear", "canela_polvo", "sal", "cacao_polvo", "nueces", "chocolate_blanco", "chocolate", "mantequilla", "huevo", "naranja", "leche", "esencia_vainilla", "crema_leche", "limon"};
            String query = "SELECT * FROM recetas_productos WHERE nombre LIKE ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            String likeOption = "%" + option + "%";
            preparedStatement.setString(1, likeOption);

            ResultSet resultSet = preparedStatement.executeQuery();

            // Print column names as header
            String header = String.join(" | ", columns);
            System.out.println(header);

            while (resultSet.next()) {
                String result = "";
                for (String column : columns) {
                    String value = resultSet.getString(column);
                    value = (value == null) ? "0" : value;
                    result += value + " | ";
                }
                // Remove the last " | "
                if (result.length() > 0) {
                    result = result.substring(0, result.length() - 3);
                }
                System.out.println(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
