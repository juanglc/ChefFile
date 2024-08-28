package com.mycompany.crud.clients.insert;

import com.mycompany.crud.connection.Database;

import java.sql.*;

import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertClients
{
    static Scanner sc = new Scanner(System.in);

    public static void insert()
    {
        Connection connection = Database.connectDatabase();
        System.out.println("Ingrese el nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el primer apellido: ");
        String primerApellido = sc.nextLine();
        System.out.println("Ingrese el segundo apellido: ");
        String segundoApellido = sc.nextLine();
        System.out.println("Ingrese el número telefónico: ");
        String telefono = sc.nextLine();
        System.out.println("Ingrese el correo electrónico: ");
        String correo = sc.nextLine();
        try
        {
            String query = "INSERT INTO clientes(primer_nombre, primer_apellido, segundo_apellido, numero_telefonico, correo_electronico) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, primerApellido);
            preparedStatement.setString(3, segundoApellido);
            preparedStatement.setString(4, telefono);
            preparedStatement.setString(5, correo);

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
