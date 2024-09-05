package com.mycompany.crud.products;

import com.mycompany.crud.connection.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UpdateProducts
{
    public static void update(int ID, ArrayList<String> product, ArrayList<String> comparison)
    {
        Connection connection = Database.connectDatabase();
        String query = "UPDATE productos SET ";
        String[] columns = {"nombre", "precio"};
        boolean first = true;
        for (int i = 0; i < columns.length; i++)
        {
            if (!product.get(i).equals(comparison.get(i)))
            {
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
