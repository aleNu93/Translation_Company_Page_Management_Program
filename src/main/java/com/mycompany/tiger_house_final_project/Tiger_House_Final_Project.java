
package com.mycompany.tiger_house_final_project;
import java.util.Scanner;

public class Tiger_House_Final_Project   
{
    public static void main(String[] args) 
    {
        mensaje_Bienvenida();
        menu ();
    }
        
    public static void mensaje_Bienvenida ()
        {
        // Mensaje de bienvenida
        Scanner sc = new Scanner(System.in);
        System.out.println("************************************************");
        System.out.println("*                                              *");
        System.out.println("*   Bienvenido a Traducciones TigerHouse LATAM *");
        System.out.println("*                                              *");
        System.out.println("*       Presione ENTER para continuar          *");
        System.out.println("*                                              *");
        System.out.println("************************************************");        
        sc.nextLine(); // Espera a que el usuario presione ENTER
        }
        
        public static void menu ()
        {
            //Menu de opciones
            try // Manejo de errores
            {
                boolean men = true;
                Scanner sc = new Scanner(System.in);
                PilaHojas pila = new PilaHojas();
                while (men) // {Permite repetir el menu las veces que sea necesarias
                {
                System.out.println("Elija 1. Si desea realizar una traducción inmediata.");
                System.out.println("Elija 2. Si desea agregar páginas de traducción.");
                System.out.println("Elija 3. Si desea ver las páginas de traducción.");
                System.out.println("Elija 4. Si desea utilizar páginas de traducción.");
                System.out.println("Elija 5. Si desea ver las páginas de traducción utilizadas");
                System.out.println("Elija 6. Si desea salir del sistema");
                int opcion = sc.nextInt();
                switch (opcion) // Menu de opciones por medio de switch
                {
                    case 1 -> 
                    {
                        clase_Cliente.menuAtencionCliente();

                    }
                    case 2 -> 
                    {
                        pila.agregarBloque();
                    }
                    case 3 -> 
                    {
                        pila.verHojasDisponibles();
                    }
                    case 4 -> 
                    {
                        System.out.println("Indique la cantidad de hojas que se utilizaran");
                        int hojasUtilizadas = sc.nextInt();
                        pila.eliminarHojas(hojasUtilizadas);
                        System.out.println("Se han utilizado " + hojasUtilizadas + " hojas.");
                    }
                    case 5 -> 
                    {
                        pila.verHojasEliminadas();
                    }
                    case 6 -> 
                    {
                        //Mensaje de despedida
                        System.out.println("************************************************");
                        System.out.println("*                                              *");
                        System.out.println("*            Saliendo del sistema...           *");
                        System.out.println("*                                              *");
                        System.out.println("*          Gracias por su preferencia          *");
                        System.out.println("*                                              *");
                        System.out.println("************************************************"); 
                        men = false; // Sale del sistema
                    }

                    default ->
                    { 
                        System.out.println("El valor indicado no está dentro de las opciones de menú.");
                    }
                    
                }
                }
            }
            catch (Exception ex)
            {
                System.out.println("Ocurrió un error inesperado: " + ex.getMessage());
            }
        }
}