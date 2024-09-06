package com.mycompany.crud.orders;

import com.mycompany.crud.connection.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import static com.mycompany.main.Main.verificarErrorInt;

public class UpdateOrders
{
    static Scanner sc = new Scanner(System.in);

    public static void update(int ID, ArrayList<String> order, ArrayList<String> comparison)
    {
        String[] columns = {"id_cliente", "fecha_creacion", "fecha_entrega", "producto_1", "producto_2", "estado_pedido", "direccion_entrega"};
        Connection connection = Database.connectDatabase();
        String query = "UPDATE pedidos SET ";
        boolean first = true;
        for (int i = 0; i < columns.length; i++)
        {
            if (!order.get(i).equals(comparison.get(i)))
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
        query = query + " WHERE id_pedido = " + ID;
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
        System.out.println("Ingrese el ID del pedido a actualizar: ");
        int ID = 0;
        ID = verificarErrorInt(ID);
        ArrayList<String> order = SelectOrders.selectArray(ID);
        ArrayList<String> comparison = new ArrayList<>();
        System.out.println("Ingrese el ID del cliente: ");
        comparison.add(sc.nextLine());
        System.out.println("Ingrese la fecha de creación del pedido: ");
        comparison.add(sc.nextLine());
        System.out.println("Ingrese la fecha de entrega del pedido: ");
        comparison.add(sc.nextLine());
        System.out.println("Ingrese el producto 1 del pedido: ");
        comparison.add(sc.nextLine());
        System.out.println("Ingrese el producto 2 del pedido: ");
        comparison.add(sc.nextLine());
        System.out.println("Ingrese el estado del pedido: ");
        comparison.add(sc.nextLine());
        System.out.println("Ingrese la dirección de entrega del pedido: ");
        comparison.add(sc.nextLine());
        update(ID, order, comparison);
    }
}
