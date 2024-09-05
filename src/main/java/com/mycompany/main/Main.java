/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

import com.mycompany.crud.orders.*;
import com.mycompany.crud.products.*;
import com.mycompany.crud.recipes.*;
import com.mycompany.crud.clients.*;
import com.mycompany.crud.ingredients.*;
import com.mycompany.crud.connection.Database;
import java.util.Scanner;

public class Main
{
    static Scanner sc = new Scanner(System.in);

    public static void menuPedidos()
    {
        System.out.println("¿Qué deseas hacer?");
        System.out.println("1. Insertar un pedido");
        System.out.println("2. Actualizar un pedido");
        System.out.println("3. Eliminar un pedido");
        System.out.println("4. Ver los pedidos");
        System.out.println("5. Regresar al menú principal");
        int opc = 0;
        while(true)
        {
            try
            {
                opc = sc.nextInt();
                sc.nextLine();
                break;
            }
            catch (Exception e)
            {
                System.out.println("Por favor, ingrese un número entero");
                sc.nextLine();
            }
        }
        /*switch (opc)
        {
            case 1:
                InsertOrders.pedirDatos();
                break;
            case 2:
                UpdateOrders.pedirDatos();
                break;
            case 3:
                DeleteOrders.pedirDatos();
                break;
            case 4:
                SelectPedidos.select();
                break;
            case 5:
                menu();
                break;
        }*/
    }

    public static void menu()
    {
        System.out.println("¿Qué tabla deseas editar?");
        System.out.println("1. Clientes");
        System.out.println("2. Pedidos");
        System.out.println("3. Productos");
        System.out.println("4. Recetas");
        System.out.println("5. Ingredientes");
        System.out.println("6. Salir");
        int opc = 0;
        while(true)
        {
            try
            {
                opc = sc.nextInt();
                sc.nextLine();
                break;
            }
            catch (Exception e)
            {
                System.out.println("Por favor, ingrese un número entero");
                sc.nextLine();
            }
        }
    }

    public static void main(String[] args)
    {
        UpdateOrders.pedirDatos();
    }
}

