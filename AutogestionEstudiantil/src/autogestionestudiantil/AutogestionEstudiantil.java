/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package autogestionestudiantil;

import java.util.Scanner;

public class AutogestionEstudiantil 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        // Objeto base del estudiante
        Estudiante alumno = new Estudiante("Ana Garcia", "22001", "Interfaz Grafica", 2023);

        int opcion;

        // MENU PRINCIPAL (SOLO ESTRUCTURA INICIAL)
        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Ver perfil");
            System.out.println("2. Gestion de materias");
            System.out.println("3. Registrar asistencia");
            System.out.println("4. Registrar calificacion");
            System.out.println("5. Ver reportes");
            System.out.println("0. Salir");
            System.out.println("-------------");

            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) 
            {
                case 1:
                    System.out.println("PERFIL DE ALUMNO:");
                    verPerfil(alumno, sc);
                    break;

                case 2:
                    System.out.println("Gestión de materias próximamente disponible.");
                    break;

                case 3:
                    System.out.println("Función próximamente disponible.");
                    break;

                case 4:
                    System.out.println("Función próximamente disponible.");
                    break;

                case 5:
                    System.out.println("Función próximamente disponible.");
                    break;

                case 0:
                    System.out.println("Hasta luego!");
                    break;

                default:
                    System.out.println("Opción invalida. Intente nuevamente.");
                    break;
            }

        } while (opcion != 0);

        sc.close();
    }

    // Opción 1: Ver perfil
    public static void verPerfil(Estudiante alumno, Scanner sc) 
    {
        alumno.mostrarResumen();

        System.out.println("Presione ENTER para volver...");
        sc.nextLine();
    }
} 
