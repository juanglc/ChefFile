

package com.mycompany.main;

import com.mycompany.crud.clients.*;
import com.mycompany.crud.products.*;
import com.mycompany.crud.orders.*;
import com.mycompany.crud.recipes.*;
import com.mycompany.crud.ingredients.*;

import java.util.Scanner;

public class Main
{

    static Scanner sc = new Scanner(System.in);

    public static boolean verificarUpdate()
    {
        System.out.println("¿Quiere realizar otra actualización de registros?");
        System.out.println("1. Sí");
        System.out.println("2. No");
        int opc = 0;
        opc = verificarErrorInt(opc);
        if(opc == 1)
        {
            return true;
        }
        return false;
    }

    public static boolean verificarDelete()
    {
        System.out.println("¿Quiere realizar otra eliminación de registros?");
        System.out.println("1. Sí");
        System.out.println("2. No");
        int opc = 0;
        opc = verificarErrorInt(opc);
        if(opc == 1)
        {
            return true;
        }
        return false;
    }

    public static boolean verificarSelect()
    {
        System.out.println("¿Quiere realizar otra consulta de registros?");
        System.out.println("1. Sí");
        System.out.println("2. No");
        int opc = 0;
        opc = verificarErrorInt(opc);
        if(opc == 1)
        {
            return true;
        }
        return false;
    }

    public static boolean verificarInsert()
    {
        System.out.println("¿Quiere realizar otra inserción de registros?");
        System.out.println("1. Sí");
        System.out.println("2. No");
        int opc = 0;
        opc = verificarErrorInt(opc);
        if(opc == 1)
        {
            return true;
        }
        return false;
    }

    public static boolean verificarTabla()
    {
        System.out.println("¿Desea realizar otra consulta en la misma tabla?");
        System.out.println("1. Sí");
        System.out.println("2. No");
        int opc = 0;
        opc = verificarErrorInt(opc);
        if(opc == 1)
        {
            return true;
        }
        return false;
    }

    public static boolean verificarMenu()
    {
        System.out.println("¿Desea realizar consultas en otra tabla?");
        System.out.println("1. Sí");
        System.out.println("2. No");
        int opc = 0;
        opc = verificarErrorInt(opc);
        if(opc == 1)
        {
            return true;
        }
        return false;
    }

    public static int verificarErrorInt(int variable)
    {
        while(true)
        {
            try
            {
                variable = sc.nextInt();
                if(variable < 0)
                {
                    System.out.println("Por favor, ingrese un número entero positivo");
                    sc.nextLine();
                    continue;
                }
                sc.nextLine();
                break;
            }
            catch (Exception e)
            {
                System.out.println("Por favor, ingrese un número entero");
                sc.nextLine();
            }
        }
        return variable;
    }

    public static void menuClientes()
    {
        do {
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Insertar un cliente");
            System.out.println("2. Actualizar un cliente");
            System.out.println("3. Eliminar un cliente");
            System.out.println("4. Ver los clientes");
            System.out.println("5. Regresar al menú principal");
            int opc = 0;
            while (true)
            {
                opc = verificarErrorInt(opc);
                if (opc >= 1 && opc <= 5)
                {
                    break;
                }
                System.out.println("Opción inválida");
            }
            switch (opc)
            {
                case 1:
                    do {
                        InsertClients.pedirDatos();
                    } while (verificarInsert());
                    break;
                case 2:
                    do {
                        UpdateClients.pedirDatos();
                    } while (verificarUpdate());
                    break;
                case 3:
                    do {
                        DeleteClients.pedirDatos();
                    } while (verificarDelete());
                    break;
                case 4:
                    do {
                        SelectClients.pedirDatos();
                    } while (verificarSelect());
                    break;
                case 5:
                    break;
            }
        } while (verificarTabla());
    }

    public static void menuPedidos()
    {
        do {
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Insertar un pedido");
            System.out.println("2. Actualizar un pedido");
            System.out.println("3. Eliminar un pedido");
            System.out.println("4. Ver los pedidos");
            System.out.println("5. Regresar al menú principal");
            int opc = 0;
            while (true)
            {
                opc = verificarErrorInt(opc);
                if (opc >= 1 && opc <= 5)
                {
                    break;
                }
                System.out.println("Opción inválida");
            }
            switch (opc)
            {
                case 1:
                    do {
                        InsertOrders.pedirDatos();
                    } while (verificarInsert());
                    break;
                case 2:
                    do {
                        UpdateOrders.pedirDatos();
                    } while (verificarUpdate());
                    break;
                case 3:
                    do {
                        DeleteOrders.pedirDatos();
                    } while (verificarDelete());
                    break;
                case 4:
                    do {
                        SelectOrders.pedirDatos();
                    } while (verificarSelect());
                    break;
                case 5:
                    break;
            }
        } while (verificarTabla());
    }

    public static void menuProductos()
    {
        do {
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Insertar un producto");
            System.out.println("2. Actualizar un producto");
            System.out.println("3. Eliminar un producto");
            System.out.println("4. Ver los productos");
            System.out.println("5. Regresar al menú principal");
            int opc = 0;
            while (true)
            {
                opc = verificarErrorInt(opc);
                if (opc >= 1 && opc <= 5)
                {
                    break;
                }
                System.out.println("Opción inválida");
            }
            switch (opc)
            {
                case 1:
                    do {
                        InsertProducts.pedirDatos();
                    } while (verificarInsert());
                    break;
                case 2:
                    do {
                        UpdateProducts.pedirDatos();
                    } while (verificarUpdate());
                    break;
                case 3:
                    do {
                        DeleteProducts.pedirDatos();
                    } while (verificarDelete());
                    break;
                case 4:
                    do {
                        SelectProducts.pedirDatos();
                    } while (verificarSelect());
                    break;
                case 5:
                    break;
            }
        } while (verificarTabla());
    }

    public static void menuRecetas()
    {
        do {
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Insertar una receta");
            System.out.println("2. Actualizar una receta");
            System.out.println("3. Eliminar una receta");
            System.out.println("4. Ver las recetas");
            System.out.println("5. Regresar al menú principal");
            int opc = 0;
            while (true)
            {
                opc = verificarErrorInt(opc);
                if (opc >= 1 && opc <= 5)
                {
                    break;
                }
                System.out.println("Opción inválida");
            }
            switch (opc)
            {
                case 1:
                    do {
                        InsertRecipes.pedirDatos();
                    } while (verificarInsert());
                    break;
                case 2:
                    do {
                        UpdateRecipes.pedirDatos();
                    } while (verificarUpdate());
                    break;
                case 3:
                    do {
                        DeleteRecipes.pedirDatos();
                    } while (verificarDelete());
                    break;
                case 4:
                    do {
                        SelectRecipes.pedirDatos();
                    } while (verificarSelect());
                    break;
                case 5:
                    break;
            }
        } while (verificarTabla());
    }

    public static void menuIngredientes()
    {
        do {
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Ver ingredientes");
            System.out.println("2. Actualizar ingredientes");
            System.out.println("3. Regresar al menú principal");
            int opc = 0;
            while (true)
            {
                opc = verificarErrorInt(opc);
                if (opc >= 1 && opc <= 3)
                {
                    break;
                }
                System.out.println("Opción inválida");
            }
            switch (opc)
            {
                case 1:
                    do {
                        SelectIngredients.pedirDatos();
                    } while (verificarSelect());
                    break;
                case 2:
                    do {
                        UpdateIngredients.pedirDatos();
                    } while (verificarUpdate());
                    break;
                case 3:
                    break;
            }
        } while (verificarTabla());
    }

    public static void menu()
    {
        do {
            System.out.println("¿Qué tabla deseas editar?");
            System.out.println("1. Clientes");
            System.out.println("2. Pedidos");
            System.out.println("3. Productos");
            System.out.println("4. Recetas");
            System.out.println("5. Ingredientes");
            System.out.println("6. Salir");
            int opc = 0;
            while (true)
            {
                opc = verificarErrorInt(opc);
                if (opc >= 1 && opc <= 6)
                {
                    break;
                }
                System.out.println("Opción inválida");
            }
            switch (opc)
            {
                case 1:
                    menuClientes();
                    break;
                case 2:
                    menuPedidos();
                    break;
                case 3:
                    menuProductos();
                    break;
                case 4:
                    menuRecetas();
                    break;
                case 5:
                    menuIngredientes();
                    break;
                case 6:
                    break;
            }
        } while (verificarMenu());
    }

    public static void main(String[] args)
    {
        menu();
    }
}