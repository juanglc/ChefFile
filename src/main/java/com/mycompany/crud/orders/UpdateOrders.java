package com.mycompany.crud.orders;

import com.mycompany.crud.connection.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class UpdateOrders
{
    static Scanner sc = new Scanner(System.in);

    public static void update(int ID, ArrayList<String> order, ArrayList<String> comparison)
    {
        Connection connection = Database.connectDatabase();
        String query = "UPDATE pedidos SET ";
        String[] columns = {"id_cliente", "fecha_creacion", "fecha_entrega", "producto_1", "producto_2", "estado_pedido", "direccion_entrega"};
        boolean first = true;
        for (int i = 0; i < columns.length; i++)
        {
            if (!order.get(i).equals(comparison.get(i)))
            {
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
        int ID = sc.nextInt();
        sc.nextLine();
        ArrayList<String> order = SelectOrders.selectArray(ID);
        ArrayList<String> comparison = new ArrayList<>();
        comparison = order;
        System.out.println("Si no desea actualizar un cambio, simplemente presione Enter");
        System.out.println("Ingrese el ID del cliente: ");
        int id_cliente = sc.nextInt();
        if (id_cliente != 0)
        {
            comparison.set(1, String.valueOf(id_cliente));
        }
        sc.nextLine();
        System.out.println("Ingrese la fecha de creación (YYYY-MM-DD): ");
        String fecha_creacion = sc.nextLine();
        if (!fecha_creacion.equals(""))
        {
            comparison.set(2, fecha_creacion);
        }
        System.out.println("Ingrese la fecha de entrega (YYYY-MM-DD HH:MM:SS): ");
        String fecha_entrega = sc.nextLine();
        if (!fecha_entrega.equals(""))
        {
            comparison.set(3, fecha_entrega);
        }
        System.out.println("Ingrese el ID del producto 1: ");
        int producto_1 = sc.nextInt();
        if (producto_1 != 0)
        {
            comparison.set(4, String.valueOf(producto_1));
        }
        sc.nextLine();
        System.out.println("Ingrese el ID del producto 2: ");
        int producto_2 = sc.nextInt();
        if (producto_2 != 0)
        {
            comparison.set(5, String.valueOf(producto_2));
        }
        sc.nextLine();
        System.out.println("Ingrese el estado del pedido: ");
        int estado_pedido = sc.nextInt();
        if(estado_pedido != 0)
        {
            comparison.set(6, Integer.toString(estado_pedido));
        }
        sc.nextLine();
        System.out.println("Ingrese la dirección de entrega: ");
        String direccion_entrega = sc.nextLine();
        if (!direccion_entrega.equals(""))
        {
            comparison.set(7, direccion_entrega);
        }
        update(ID, order, comparison);
    }
}
