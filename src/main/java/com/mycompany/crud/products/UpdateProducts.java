package com.mycompany.crud.products;

import com.mycompany.crud.connection.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import static com.mycompany.main.Main.verificarErrorInt;

public class UpdateProducts
{

    static Scanner sc = new Scanner(System.in);

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
                if (comparison.get(i).isEmpty())
                {
                    continue;
                }
                if (!first)
                {
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
            e.getErrorCode();
        }
    }

    public static void pedirDatos()
    {
        System.out.println("Ingrese el ID del producto a actualizar: ");
        int ID = 0;
        ID = verificarErrorInt(ID);
        ArrayList<String> product = SelectProducts.selectArray(ID);
        ArrayList<String> comparison = new ArrayList<String>();
        System.out.println("Ingrese el nuevo nombre del producto: ");
        comparison.add(sc.nextLine());
        System.out.println("Ingrese el nuevo precio del producto: ");
        comparison.add(sc.nextLine());
        update(ID, product, comparison);
    }
}
