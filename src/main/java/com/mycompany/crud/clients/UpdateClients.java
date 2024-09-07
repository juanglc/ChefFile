package com.mycompany.crud.clients;

import com.mycompany.crud.connection.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import static com.mycompany.main.Main.verificarErrorInt;

public class UpdateClients
{
    static Scanner sc = new Scanner(System.in);

    public static void update(int ID, ArrayList<String> client, ArrayList<String> comparison)
    {
        Connection connection = Database.connectDatabase();
        String query = "UPDATE clientes SET ";
        String[] columns = {"primer_nombre", "primer_apellido", "segundo_apellido", "numero_telefonico", "correo_electronico"};
        boolean first = true;
        for (int i = 0; i < columns.length; i++)
        {
            if (!client.get(i).equals(comparison.get(i)))
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
        query = query + " WHERE id_cliente = " + (ID);
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
        System.out.println("Ingrese el ID del cliente a actualizar: ");
        int ID = 0;
        ID = verificarErrorInt(ID);
        ArrayList<String> client = SelectClients.selectArray(ID);
        ArrayList<String> comparison = new ArrayList<>();
        System.out.println("Ingrese el primer nombre del cliente: ");
        comparison.add(sc.nextLine());
        System.out.println("Ingrese el primer apellido del cliente: ");
        comparison.add(sc.nextLine());
        System.out.println("Ingrese el segundo apellido del cliente: ");
        comparison.add(sc.nextLine());
        System.out.println("Ingrese el número telefónico del cliente: ");
        comparison.add(sc.nextLine());
        System.out.println("Ingrese el correo electrónico del cliente: ");
        comparison.add(sc.nextLine());
        update(ID, client, comparison);
    }
}