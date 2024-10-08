package com.mycompany.crud.recipes;

import com.mycompany.crud.connection.Database;
import java.sql.*;

import static com.mycompany.main.Main.verificarErrorInt;
import static com.mycompany.main.Main.verificarIngrediente;


public class InsertRecipes
{

    public static void insert(int idProducto, int harina, int azucarBlanca, int azucarMorena, int polvoHornear, int canelaPolvo, int sal, int cacaoPolvo, int nueces, int chocolateBlanco, int chocolate, int mantequilla, int huevo, int naranja, int leche, int esenciaVainilla, int cremaLeche, int limon)
    {
        Connection connection = Database.connectDatabase();
        try {
            String query = "INSERT INTO public.recetas(id_producto, harina, azucar_blanca, azucar_morena, polvo_hornear, canela_polvo, sal, cacao_polvo, nueces, chocolate_blanco, chocolate, mantequilla, huevo, naranja, leche, esencia_vainilla, crema_leche, limon) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idProducto);
            preparedStatement.setInt(2, harina);
            preparedStatement.setInt(3, azucarBlanca);
            preparedStatement.setInt(4, azucarMorena);
            preparedStatement.setInt(5, polvoHornear);
            preparedStatement.setInt(6, canelaPolvo);
            preparedStatement.setInt(7, sal);
            preparedStatement.setInt(8, cacaoPolvo);
            preparedStatement.setInt(9, nueces);
            preparedStatement.setInt(10, chocolateBlanco);
            preparedStatement.setInt(11, chocolate);
            preparedStatement.setInt(12, mantequilla);
            preparedStatement.setInt(13, huevo);
            preparedStatement.setInt(14, naranja);
            preparedStatement.setInt(15, leche);
            preparedStatement.setInt(16, esenciaVainilla);
            preparedStatement.setInt(17, cremaLeche);
            preparedStatement.setInt(18, limon);

            preparedStatement.executeUpdate();

            System.out.println("Registro insertado correctamente");
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.getErrorCode();
        }
    }

    public static void pedirDatos()
    {
        System.out.println("Ingresa el ID del producto");
        int ID = 0;
        ID = verificarErrorInt(ID);
        System.out.println("Ingresa la cantidad de harina (si no utilizará este ingrediente, ingrese 0)");
        int harina = 0;
        harina = verificarIngrediente(harina);
        System.out.println("Ingresa la cantidad de azúcar blanca (si no utilizará este ingrediente, ingrese 0)");
        int azucarBlanca = 0;
        azucarBlanca = verificarIngrediente(azucarBlanca);
        System.out.println("Ingresa la cantidad de azúcar morena (si no utilizará este ingrediente, ingrese 0)");
        int azucarMorena = 0;
        azucarMorena = verificarIngrediente(azucarMorena);
        System.out.println("Ingresa la cantidad de polvo de hornear (si no utilizará este ingrediente, ingrese 0)");
        int polvoHornear = 0;
        polvoHornear = verificarIngrediente(polvoHornear);
        System.out.println("Ingresa la cantidad de canela en polvo (si no utilizará este ingrediente, ingrese 0)");
        int canelaPolvo = 0;
        canelaPolvo = verificarIngrediente(canelaPolvo);
        System.out.println("Ingresa la cantidad de sal (si no utilizará este ingrediente, ingrese 0)");
        int sal = 0;
        sal = verificarIngrediente(sal);
        System.out.println("Ingresa la cantidad de cacao en polvo (si no utilizará este ingrediente, ingrese 0)");
        int cacaoPolvo = 0;
        cacaoPolvo = verificarIngrediente(cacaoPolvo);
        System.out.println("Ingresa la cantidad de nueces (si no utilizará este ingrediente, ingrese 0)");
        int nueces = 0;
        nueces = verificarIngrediente(nueces);
        System.out.println("Ingresa la cantidad de chocolate blanco (si no utilizará este ingrediente, ingrese 0)");
        int chocolateBlanco = 0;
        chocolateBlanco = verificarIngrediente(chocolateBlanco);
        System.out.println("Ingresa la cantidad de chocolate (si no utilizará este ingrediente, ingrese 0)");
        int chocolate = 0;
        chocolate = verificarIngrediente(chocolate);
        System.out.println("Ingresa la cantidad de mantequilla (si no utilizará este ingrediente, ingrese 0)");
        int mantequilla = 0;
        mantequilla = verificarIngrediente(mantequilla);
        System.out.println("Ingresa la cantidad de huevo (si no utilizará este ingrediente, ingrese 0)");
        int huevo = 0;
        huevo = verificarIngrediente(huevo);
        System.out.println("Ingresa la cantidad de naranja (si no utilizará este ingrediente, ingrese 0)");
        int naranja = 0;
        naranja = verificarIngrediente(naranja);
        System.out.println("Ingresa la cantidad de leche (si no utilizará este ingrediente, ingrese 0)");
        int leche = 0;
        leche = verificarIngrediente(leche);
        System.out.println("Ingresa la cantidad de esencia de vainilla (si no utilizará este ingrediente, ingrese 0)");
        int esenciaVainilla = 0;
        esenciaVainilla = verificarIngrediente(esenciaVainilla);
        System.out.println("Ingresa la cantidad de crema de leche (si no utilizará este ingrediente, ingrese 0)");
        int cremaLeche = 0;
        cremaLeche = verificarIngrediente(cremaLeche);
        System.out.println("Ingresa la cantidad de limón (si no utilizará este ingrediente, ingrese 0)");
        int limon = 0;
        limon = verificarIngrediente(limon);
        insert(ID, harina, azucarBlanca, azucarMorena, polvoHornear, canelaPolvo, sal, cacaoPolvo, nueces, chocolateBlanco, chocolate, mantequilla, huevo, naranja, leche, esenciaVainilla, cremaLeche, limon);
    }
}
