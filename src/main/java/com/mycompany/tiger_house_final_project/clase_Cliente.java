
package com.mycompany.tiger_house_final_project;

import java.util.InputMismatchException;
import java.util.Scanner;

class Cliente 
{
    private String nombre;
    private long tiempoLlegada;
    Cliente siguiente; // Puntero al siguiente nodo en la cola

    public Cliente(String nombre) 
    {
        this.nombre = nombre;
        this.tiempoLlegada = System.currentTimeMillis();
        this.siguiente = null;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public long getTiempoEspera() 
    {
        return System.currentTimeMillis() - tiempoLlegada;
    }
}

public class clase_Cliente 
{
    private Cliente frente;
    private Cliente fin;
    private Scanner sc;

    public clase_Cliente() 
    {
        this.frente = null;
        this.fin = null;
        this.sc = new Scanner(System.in);
    }

    // Verifica si un cliente ya está en la cola
    private boolean clienteExiste(String nombre) 
    {
        Cliente actual = frente;
        while (actual != null) {
            if (actual.getNombre().equalsIgnoreCase(nombre)) 
            {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    // Agrega un cliente a la cola (evita duplicados)
    public void agregarCliente(String nombre) 
    {
        try 
        {
            if (clienteExiste(nombre)) 
            {
                System.out.println("Error: El cliente " + nombre + " ya está en la cola.");
                return;
            }

            Cliente nuevo = new Cliente(nombre);
            if (frente == null) 
            { // La cola está vacía
                frente = nuevo;
                fin = nuevo;
            } else 
            {
                fin.siguiente = nuevo;
                fin = nuevo;
            }
            System.out.println("Cliente " + nombre + " agregado a la cola.");
            mostrarEstadoCola();
        } catch (Exception e) 
        {
            System.out.println("Error inesperado al agregar cliente: " + e.getMessage());
        }
    }

    // Atiende al primer cliente en la cola
    public void atenderCliente() 
    {
        try {
            if (frente == null) 
            {
                System.out.println("No hay clientes en la cola.");
                return;
            }

            Cliente atendido = frente;
            frente = frente.siguiente;
            if (frente == null) 
            {
                fin = null;
            }

            System.out.println("Atendiendo a: " + atendido.getNombre());
            System.out.println("Tiempo de espera: " + atendido.getTiempoEspera() / 1000.0 + " segundos.");
            mostrarEstadoCola();
        } catch (Exception e) 
        {
            System.out.println("Error inesperado al atender cliente: " + e.getMessage());
        }
    }

    // Muestra los clientes en espera y el tiempo promedio
    public void mostrarEstadoCola() 
    {
        try 
        {
            if (frente == null) 
            {
                System.out.println("La cola está vacía.");
                return;
            }

            System.out.println("\nClientes en espera:");
            Cliente actual = frente;
            int count = 0;
            long tiempoTotal = 0;

            while (actual != null) 
            {
                count++;
                long tiempoEspera = actual.getTiempoEspera() / 1000;
                tiempoTotal += tiempoEspera;
                System.out.println(count + ". " + actual.getNombre() + " - Espera: " + tiempoEspera + "s");
                actual = actual.siguiente;
            }

            System.out.println("Tiempo promedio de espera: " + (tiempoTotal / count) + " segundos.");
        } catch (Exception e) 
        {
            System.out.println("Error inesperado al mostrar el estado de la cola: " + e.getMessage());
        }
    }

    // Menú principal con manejo de errores
    public static void menuAtencionCliente() 
    {
        Scanner sc = new Scanner(System.in);
        clase_Cliente cola = new clase_Cliente();
        int opcion = 0;

        do 
        {
            try 
            {
                System.out.println("\n1. Agregar cliente");
                System.out.println("2. Atender cliente");
                System.out.println("3. Mostrar estado de la cola");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");

                opcion = sc.nextInt();
                sc.nextLine(); // Limpiar buffer

                switch (opcion) 
                {
                    case 1 -> 
                    {
                        System.out.print("Ingrese el nombre del cliente: ");
                        String nombre = sc.nextLine();
                        if (nombre.trim().isEmpty()) 
                        {
                            System.out.println("Error: El nombre no puede estar vacío.");
                        } else 
                        {
                            cola.agregarCliente(nombre);
                        }
                    }
                    case 2 -> cola.atenderCliente();
                    case 3 -> cola.mostrarEstadoCola();
                    case 4 -> System.out.println("Saliendo del programa...");
                    default -> System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (InputMismatchException e) 
            {
                System.out.println("Error: Debe ingresar un número válido.");
                sc.nextLine(); // Limpiar buffer
            } catch (Exception e) 
            {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        } while (opcion != 4);
    }
}