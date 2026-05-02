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
        
        //Datos de prueba
        Materia m = new Materia("Matematica", "22033", 1, 2024);
        Materia a = new Materia("Lengua", "22034", 2, 2024);
        alumno.inscribirse(m);
        alumno.inscribirse(a);

        
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
                    alumno.mostrarResumen();
                    
                    volverMenu(alumno, sc);
                    break;

                case 2:
                    System.out.println("Gestión de materias próximamente disponible.");
                    break;

                case 3:
                    System.out.print("Codigo materia: ");
                    String codA = sc.nextLine();

                    InscripcionMateria inscA = alumno.getInscripcion(codA);

                    if (inscA != null) {
                    System.out.print("Presente? (true/false): ");
                    boolean presente = sc.nextBoolean();
                    sc.nextLine();

                    inscA.registrarAsistencia(presente);
                    System.out.println("Asistencia registrada.");
                    } 
                    else {
                        System.out.println("Materia no encontrada.");
                    }
                    
                    volverMenu(alumno, sc);

                    break;

                case 4:
                    System.out.print("Codigo materia: ");
                    String codN = sc.nextLine();

                    InscripcionMateria inscN = alumno.getInscripcion(codN);

                    if (inscN != null) {
                        
                        boolean cargada;
                        
                        do {
                            System.out.print("Nota: ");
                            double nota = sc.nextDouble();
                            sc.nextLine();

                            cargada = inscN.agregarNota(nota);

                        } while (!cargada);

                        System.out.println("Nota registrada.");
                    } 
                    else {
                        System.out.println("Materia no encontrada.");
                    }
                    
                    volverMenu(alumno, sc);
                    break;

                case 5:
                    System.out.print("Codigo materia: ");
                    String codR = sc.nextLine();

                    InscripcionMateria inscR = alumno.getInscripcion(codR);

                    if (inscR != null) {
                        System.out.println("Porcentaje asistencia: " + inscR.getPorcentajeAsistencia());
                        System.out.println("Condicion: " + inscR.getCondicion());
                        System.out.println("Promedio: " + inscR.getPromedio());
                        System.out.println("Aprobada: " + inscR.estaAprobada());
                    } 
                    else {
                        System.out.println("Materia no encontrada.");
                    }
                    
                    volverMenu(alumno, sc);
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
    public static void volverMenu(Estudiante alumno, Scanner sc) 
    {
       
        System.out.println("Presione ENTER para volver...");
        sc.nextLine();
    }
} 
