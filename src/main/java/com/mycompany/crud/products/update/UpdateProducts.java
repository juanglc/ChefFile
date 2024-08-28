package com.mycompany.crud.products.update;

import com.mycompany.crud.connection.Database;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateProducts
{
    static Scanner sc = new Scanner(System.in);

    public static void update(boolean nombre, boolean precio)
    {
        int ID = 0;
        while(true)
        {
            System.out.println("Ingrese el ID del producto que desea actualizar: ");
            try
            {
                ID = sc.nextInt();
                sc.nextLine();
                break;
            }
            catch (Exception e)
            {
                System.out.println("Ingrese un número entero");
            }
        }
        System.out.println("¿Qué desea actualizar?");
        if (nombre)
        {
            updateNombre(ID);
        }
        if (precio)
        {
            updatePrecio(ID);
        }
    }
    
    public static void updateNombre(int ID)
    {
        Connection connection = Database.connectDatabase();
        System.out.println("Ingrese el nombre: ");
        String nombre = sc.nextLine();
        try
        {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE productos SET nombre = '" + nombre + "' WHERE id_producto = " + ID);
            connection.close();
            statement.close();
            System.out.println("Nombre del producto actualizado");
        }
        catch (Exception e)
        {
            System.out.println("Error al actualizar el nombre del producto");
        }
    }

    public static void updatePrecio(int ID)
    {
        int precio = 0;
        Connection connection = Database.connectDatabase();
        while(true)
        {
            System.out.println("Ingrese el precio: ");
            try
            {
                precio = sc.nextInt();
                sc.nextLine();
                break;
            }
            catch (Exception e)
            {
                System.out.println("Ingrese un número entero");
                sc.nextLine();
            }
        }
        try
        {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE productos SET precio = " + precio + " WHERE id_producto = " + ID);
            connection.close();
            statement.close();
            System.out.println("Precio del producto actualizado");
        }
        catch (Exception e)
        {
            System.out.println("Error al actualizar el precio del producto");
        }
    }
}
