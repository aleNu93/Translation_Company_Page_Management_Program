package com.mycompany.tiger_house_final_project;

import java.util.Scanner;

class Nodo 
{
    int codigo;
    Nodo siguiente;

    public Nodo(int codigo) 
    {
        this.codigo = codigo;
        this.siguiente = null;
    }
}

class ListaEnlazada 
{
    private Nodo cabeza;
    private Nodo cola;

    public ListaEnlazada() 
    {
        this.cabeza = null;
        this.cola = null;
    }
    
    public void agregar(int codigo) 
    {
        Nodo nuevoNodo = new Nodo(codigo);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else 
        {
            cola.siguiente = nuevoNodo;
            cola = nuevoNodo;
        }
        imprimir();
    }
    
    public void imprimir() 
    {
        Nodo actual = cabeza;
        System.out.print("Estado actual de la lista: ");
        while (actual != null) 
        {
            System.out.print(actual.codigo + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}

class PilaHojas 
{
    private Nodo cima;
    private int contadorHojas;
    private ListaEnlazada hojasEliminadas;
    private Scanner sc = new Scanner(System.in);

    public PilaHojas() 
    {
        this.cima = null;
        this.contadorHojas = 0;
        this.hojasEliminadas = new ListaEnlazada();
    }

    public void agregarBloque() 
    {
        for (int i = 100; i >= 1; i--) {
            Nodo nuevaHoja = new Nodo(i);
            nuevaHoja.siguiente = cima;
            cima = nuevaHoja;
            contadorHojas++;
        }
        System.out.println("Bloque de 100 hojas agregado a la pila.");
        verHojasDisponibles();
    }

    public void eliminarHojas(int cantidad) 
    {
        for (int i = 0; i < cantidad; i++) 
        {
            if (cima == null) 
            {
                System.out.println("No hay más hojas en la pila.");
                break;
            }
            hojasEliminadas.agregar(cima.codigo);
            cima = cima.siguiente;
            contadorHojas--;
        }
        System.out.println("Se han eliminado " + cantidad + " hojas.");
        verHojasDisponibles();
    }

    public void verHojasDisponibles() 
    {
        Nodo actual = cima;
        System.out.print("Hojas disponibles en la pila: ");
        while (actual != null) {
            System.out.print(actual.codigo + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    public void verHojasEliminadas() 
    {
        System.out.println("Hojas utilizadas:");
        hojasEliminadas.imprimir();
    }
}
