package com.mycompany.crud.orders;

import com.mycompany.crud.connection.Database;

import java.sql.*;
import java.util.Scanner;

public class InsertOrders
{
    static Scanner sc = new Scanner(System.in);

    public static void insert(int idCliente, java.sql.Date fechaCreacion, java.sql.Timestamp fechaEntrega, int producto1, Integer producto2, int estadoPedido, String direccionEntrega)
    {
        Connection connection = Database.connectDatabase();
        try {
            String query = "INSERT INTO pedidos(id_cliente, fecha_creacion, fecha_entrega, producto_1, producto_2, estado_pedido, direccion_entrega) VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idCliente);
            preparedStatement.setDate(2, fechaCreacion);
            preparedStatement.setTimestamp(3, fechaEntrega);
            preparedStatement.setInt(4, producto1);
            if (producto2 != null) {
                preparedStatement.setInt(5, producto2);
            } else {
                preparedStatement.setNull(5, java.sql.Types.INTEGER);
            }
            preparedStatement.setInt(6, estadoPedido);
            preparedStatement.setString(7, direccionEntrega);

            preparedStatement.executeUpdate();

            System.out.println("Registro insertado correctamente");
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void pedirDatos()
    {
        System.out.println("Ingresa el ID del cliente: ");
        int idCliente = sc.nextInt();
        sc.nextLine();
        Date fechaCreacion = new Date(System.currentTimeMillis());
        System.out.println("Ingresa la fecha de entrega (yyyy-mm-dd hh:mm:ss): ");
        String fechaEntrega = sc.nextLine();
        System.out.println("Ingresa el ID del primer producto: ");
        int producto1 = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingresa el ID del segundo producto (opcional): ");
        String producto2Str = sc.nextLine();
        Integer producto2 = null;
        if (!producto2Str.isEmpty()) {
            producto2 = Integer.parseInt(producto2Str);
        }
        System.out.println("Ingresa el estado del pedido (1 = pendiente, 2 = entregado): ");
        int estadoPedido = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingresa la dirección de entrega: ");
        String direccionEntrega = sc.nextLine();
        insert(idCliente, fechaCreacion, Timestamp.valueOf(fechaEntrega), producto1, producto2, estadoPedido, direccionEntrega);
    }
}
