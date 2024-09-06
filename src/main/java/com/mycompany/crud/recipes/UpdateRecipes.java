package com.mycompany.crud.recipes;

import com.mycompany.crud.connection.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import static com.mycompany.main.Main.verificarErrorInt;

public class UpdateRecipes
{

    static Scanner sc = new Scanner(System.in);

    public static void update(int ID, ArrayList<String> recipe, ArrayList<String> comparison) {
        Connection connection = Database.connectDatabase();
        String query = "UPDATE recetas SET ";
        String[] columns = {"harina", "azucar_blanca", "azucar_morena", "polvo_hornear", "canela_polvo", "sal", "cacao_polvo", "nueces", "chocolate_blanco", "chocolate", "mantequilla", "huevo", "naranja", "leche", "esencia_vainilla", "crema_leche", "limon"};
        boolean first = true;
        for (int i = 0; i < columns.length; i++) {
            if (!recipe.get(i).equals(comparison.get(i)))
            {
                if (comparison.get(i).equals(""))
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
            e.printStackTrace();
        }
    }

    public static void pedirDatos()
    {
        System.out.println("Ingresa el ID de la receta que deseas actualizar");
        int ID = 0;
        ID = verificarErrorInt(ID);
        ArrayList<String> recipe = SelectRecipes.selectArray(ID);
        ArrayList<String> comparison = new ArrayList<>();
        System.out.println("Ingresa los datos de la receta");
        System.out.println("Harina: ");
        comparison.add(sc.nextLine());
        System.out.println("Azucar Blanca: ");
        comparison.add(sc.nextLine());
        System.out.println("Azucar Morena: ");
        comparison.add(sc.nextLine());
        System.out.println("Polvo de Hornear: ");
        comparison.add(sc.nextLine());
        System.out.println("Canela en Polvo: ");
        comparison.add(sc.nextLine());
        System.out.println("Sal: ");
        comparison.add(sc.nextLine());
        System.out.println("Cacao en Polvo: ");
        comparison.add(sc.nextLine());
        System.out.println("Nueces: ");
        comparison.add(sc.nextLine());
        System.out.println("Chocolate Blanco: ");
        comparison.add(sc.nextLine());
        System.out.println("Chocolate: ");
        comparison.add(sc.nextLine());
        System.out.println("Mantequilla: ");
        comparison.add(sc.nextLine());
        System.out.println("Huevo: ");
        comparison.add(sc.nextLine());
        System.out.println("Naranja: ");
        comparison.add(sc.nextLine());
        System.out.println("Leche: ");
        comparison.add(sc.nextLine());
        System.out.println("Esencia de Vainilla: ");
        comparison.add(sc.nextLine());
        System.out.println("Crema de Leche: ");
        comparison.add(sc.nextLine());
        System.out.println("Limon: ");
        comparison.add(sc.nextLine());
        update(ID, recipe, comparison);
    }
}
