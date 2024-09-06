package com.mycompany.crud.orders;

import com.mycompany.crud.connection.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import static com.mycompany.main.Main.verificarErrorInt;

public class SelectOrders
{
    static Scanner sc = new Scanner(System.in);

    public static void selectAll() {
        Connection connection = Database.connectDatabase();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM pedidos");
            while (resultSet.next()) {
                System.out.println("ID Pedido: " + resultSet.getInt("id_pedido") +
                        ", ID Cliente: " + resultSet.getInt("id_cliente") +
                        ", Fecha Creacion: " + resultSet.getDate("fecha_creacion") +
                        ", Fecha Entrega: " + resultSet.getTimestamp("fecha_entrega") +
                        ", Producto 1: " + resultSet.getInt("producto_1") +
                        ", Producto 2: " + resultSet.getInt("producto_2") +
                        ", Estado Pedido: " + resultSet.getInt("estado_pedido") +
                        ", Direccion Entrega: " + resultSet.getString("direccion_entrega"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void selectByID(int ID) {
        Connection connection = Database.connectDatabase();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM pedidos WHERE id_pedido = " + ID);
            while (resultSet.next()) {
                System.out.println("ID Pedido: " + resultSet.getInt("id_pedido") +
                        ", ID Cliente: " + resultSet.getInt("id_cliente") +
                        ", Fecha Creacion: " + resultSet.getDate("fecha_creacion") +
                        ", Fecha Entrega: " + resultSet.getTimestamp("fecha_entrega") +
                        ", Producto 1: " + resultSet.getInt("producto_1") +
                        ", Producto 2: " + resultSet.getInt("producto_2") +
                        ", Estado Pedido: " + resultSet.getInt("estado_pedido") +
                        ", Direccion Entrega: " + resultSet.getString("direccion_entrega"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void selectByStatus() {
        Connection connection = Database.connectDatabase();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM pedidos WHERE estado_pedido = 1");
            while (resultSet.next()) {
                System.out.println("ID Pedido: " + resultSet.getInt("id_pedido") +
                        ", ID Cliente: " + resultSet.getInt("id_cliente") +
                        ", Fecha Creacion: " + resultSet.getDate("fecha_creacion") +
                        ", Fecha Entrega: " + resultSet.getTimestamp("fecha_entrega") +
                        ", Producto 1: " + resultSet.getInt("producto_1") +
                        ", Producto 2: " + resultSet.getInt("producto_2") +
                        ", Estado Pedido: " + resultSet.getInt("estado_pedido") +
                        ", Direccion Entrega: " + resultSet.getString("direccion_entrega"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void selectByDueDate() {
        Connection connection = Database.connectDatabase();
        try
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM pedidos ORDER BY fecha_entrega");
            while (resultSet.next())
            {
                System.out.println("ID Pedido: " + resultSet.getInt("id_pedido") +
                        ", ID Cliente: " + resultSet.getInt("id_cliente") +
                        ", Fecha Creacion: " + resultSet.getDate("fecha_creacion") +
                        ", Fecha Entrega: " + resultSet.getTimestamp("fecha_entrega") +
                        ", Producto 1: " + resultSet.getInt("producto_1") +
                        ", Producto 2: " + resultSet.getInt("producto_2") +
                        ", Estado Pedido: " + resultSet.getInt("estado_pedido") +
                        ", Direccion Entrega: " + resultSet.getString("direccion_entrega"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void selectByClient(int ID)
    {
        Connection connection = Database.connectDatabase();
        try
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM pedidos WHERE id_cliente = " + ID);
            while (resultSet.next())
            {
                System.out.println("ID Pedido: " + resultSet.getInt("id_pedido") +
                        ", ID Cliente: " + resultSet.getInt("id_cliente") +
                        ", Fecha Creacion: " + resultSet.getDate("fecha_creacion") +
                        ", Fecha Entrega: " + resultSet.getTimestamp("fecha_entrega") +
                        ", Producto 1: " + resultSet.getInt("producto_1") +
                        ", Producto 2: " + resultSet.getInt("producto_2") +
                        ", Estado Pedido: " + resultSet.getInt("estado_pedido") +
                        ", Direccion Entrega: " + resultSet.getString("direccion_entrega"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void selectByCreationDate()
    {
        Connection connection = Database.connectDatabase();
        try
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM pedidos ORDER BY fecha_creacion");
            while (resultSet.next())
            {
                System.out.println("ID Pedido: " + resultSet.getInt("id_pedido") +
                        ", ID Cliente: " + resultSet.getInt("id_cliente") +
                        ", Fecha Creacion: " + resultSet.getDate("fecha_creacion") +
                        ", Fecha Entrega: " + resultSet.getTimestamp("fecha_entrega") +
                        ", Producto 1: " + resultSet.getInt("producto_1") +
                        ", Producto 2: " + resultSet.getInt("producto_2") +
                        ", Estado Pedido: " + resultSet.getInt("estado_pedido") +
                        ", Direccion Entrega: " + resultSet.getString("direccion_entrega"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void selectByProduct(int ID) {
        Connection connection = Database.connectDatabase();
        try
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM pedidos WHERE producto_1 = " + ID + " OR producto_2 = " + ID);
            while (resultSet.next())
            {
                System.out.println("ID Pedido: " + resultSet.getInt("id_pedido") +
                        ", ID Cliente: " + resultSet.getInt("id_cliente") +
                        ", Fecha Creacion: " + resultSet.getDate("fecha_creacion") +
                        ", Fecha Entrega: " + resultSet.getTimestamp("fecha_entrega") +
                        ", Producto 1: " + resultSet.getInt("producto_1") +
                        ", Producto 2: " + resultSet.getInt("producto_2") +
                        ", Estado Pedido: " + resultSet.getInt("estado_pedido") +
                        ", Direccion Entrega: " + resultSet.getString("direccion_entrega"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> selectArray(int ID) {
        ArrayList<String> order = new ArrayList<>();
        Connection connection = Database.connectDatabase();
        try
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM pedidos WHERE id_pedido = " + ID);
            while (resultSet.next())
            {
                order.add(String.valueOf(resultSet.getInt("id_pedido")));
                order.add(String.valueOf(resultSet.getInt("id_cliente")));
                order.add(String.valueOf(resultSet.getDate("fecha_creacion")));
                order.add(String.valueOf(resultSet.getTimestamp("fecha_entrega")));
                order.add(String.valueOf(resultSet.getInt("producto_1")));
                order.add(String.valueOf(resultSet.getInt("producto_2")));
                order.add(String.valueOf(resultSet.getInt("estado_pedido")));
                order.add(resultSet.getString("direccion_entrega"));
            }
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return order;
    }

    public static void pedirDatos()
    {
        System.out.println("¿Qué operación de consulta quiere realizar?");
        System.out.println("1. Ver todos los pedidos");
        System.out.println("2. Ver un pedido por ID");
        System.out.println("3. Ver pedidos por estado activo");
        System.out.println("4. Ver pedidos por fecha de creación");
        System.out.println("5. Ver pedidos por fecha de entrega");
        System.out.println("6. Ver pedidos por ID de cliente");
        System.out.println("7. Ver pedidos por ID de producto");
        System.out.println("8. Regresar al menú principal");
        int opc = 0;
        opc = verificarErrorInt(opc);
        switch (opc)
        {
            case 1:
                selectAll();
                break;
            case 2:
                System.out.println("Ingrese el ID del pedido a consultar: ");
                int ID = 0;
                ID = verificarErrorInt(ID);
                selectByID(ID);
                break;
            case 3:
                selectByStatus();
                break;
            case 4:
                selectByCreationDate();
                break;
            case 5:
                selectByDueDate();
                break;
            case 6:
                System.out.println("Ingrese el ID del cliente a consultar: ");
                int IDCliente = 0;
                IDCliente = verificarErrorInt(IDCliente);
                selectByClient(IDCliente);
                break;
            case 7:
                System.out.println("Ingrese el ID del producto a consultar: ");
                int IDProducto = 0;
                IDProducto = verificarErrorInt(IDProducto);
                selectByProduct(IDProducto);
                break;
            case 8:
                break;
        }
    }
}