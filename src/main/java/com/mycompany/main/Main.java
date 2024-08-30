/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

import java.util.ArrayList;
import com.mycompany.crud.recetas.SelectRecetas;
import com.mycompany.crud.clients.update.UpdateClients;

import java.sql.SQLException;

public class Main
{
    public static void main(String[] args)
    {
        /*ArrayList<String> client = SelectClients.selectByID(10);
        ArrayList<String> comparison = new ArrayList<>();
        comparison.add(client.get(0));
        comparison.add(client.get(1));
        comparison.add(client.get(2));
        comparison.add(client.get(3));
        comparison.add(client.get(4));
        comparison.set(0, "Patricia");
        UpdateClients.update(10, client, comparison);
        ArrayList<String> newClient = SelectClients.selectByID(10);
        System.out.println("Registro anterior: " + client);
        System.out.println("Registro actualizado: " + newClient);*/
        SelectRecetas.selectSearchBar("Torta");
    }
}

