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

        //Objetos de prueba Bonus: 
        
        //Probar funcionamiento BONUS (Clase MateriaCuatrimestral, Rankeable):
        Estudiante e = new Estudiante("Zaira", "123", "Analista", 2026);
        
        //Objetos de prueba para la clase MateriaCuatrimestral
        Materia m1 = new Materia("Matematica", "MAT1", 1, 2026);
        Materia m2 = new MateriaCuatrimestral("Programacion", "PRO1", 1, 2026);

        // Polimorfismo, las agrega en la lista
        e.agregarMateria(m1);
        e.agregarMateria(m2);

        // Llama al metodo buscarPorCodigo de Estudiante
        Materia buscada = e.buscarPorCodigo("PRO1");

        //Muestra cual es
        if (buscada != null) {
            System.out.println("Materia encontrada: " + buscada.getNombre());
        }
        
        //Inscribe la materia 
        InscripcionMateria ins = new InscripcionMateria(m2);
        ins.getNotas().add(8.0); //Agrega notas manualmente
        ins.getNotas().add(7.0);
        
        //Calcula sobre esas notas el puntake ranking
        System.out.println("Puntaje ranking: " + ins.getPuntajeRanking());

        
        
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
                    menuMaterias(alumno, sc);
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

    private static void menuMaterias(Estudiante alumno, Scanner sc) 
    {
        int opcionMateria;

        do {
            System.out.println("\n=== GESTIÓN DE MATERIAS ===");
            System.out.println("1. Inscribir materia");
            System.out.println("2. Darse de baja de una materia");
            System.out.println("3. Ver materias");
            System.out.println("4. Buscar materias");
            System.out.println("0. Volver");
            System.out.println("-------------");

            System.out.print("Opción: ");

            while (!sc.hasNextInt()) 
            {
                System.out.println("Opción inválida. Intente nuevamente.");
                sc.nextLine();
                System.out.print("Opción: ");
            }

            opcionMateria = sc.nextInt();
            sc.nextLine();
 
            switch (opcionMateria) 
            {
                case 1:

                    System.out.println("Inscribirse a una materia:");

                    System.out.print("NOMBRE: ");
                    String nombre = sc.nextLine();

                    System.out.print("CODIGO: ");
                    String codigo = sc.nextLine();

                    // Validación longitud código
                    if (codigo.length() < 3 || codigo.length() > 10) 
                    {
                        System.out.println("Error: El código debe tener entre 3 y 10 caracteres.");
                        break;
                    }

                    // Validación código repetido
                    if (alumno.getInscripcion(codigo) != null) 
                    {
                        System.out.println("Error: Ya estás inscripto en una materia con ese código.");
                        break;
                    }

                    System.out.print("CUATRIMESTRE: ");
                    int cuatrimestre = sc.nextInt();

                    // Validación cuatrimestre
                    if (cuatrimestre != 1 && cuatrimestre != 2) 
                    {
                        System.out.println("Error: El cuatrimestre debe ser 1 o 2.");
                        sc.nextLine();
                        break;
                    }

                    System.out.print("AÑO: ");
                    int anio = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.println("TIPO DE MATERIA:");
                    System.out.println("1. Cuatrimestral");
                    System.out.println("2. Anual");
                    System.out.print("Opción: ");

                    int tipoMateria = sc.nextInt();
                    sc.nextLine();

                    Materia nuevaMateria;

                    if (tipoMateria == 2) {

                        MateriaAnual anual = new MateriaAnual(
                                nombre,
                                codigo,
                                anio
                        );

                        System.out.print("Nota 1° cuatrimestre: ");
                        anual.setNotaPrimerCuatrimestre(sc.nextDouble());

                        System.out.print("Nota 2° cuatrimestre: ");
                        anual.setNotaSegundoCuatrimestre(sc.nextDouble());

                        System.out.print("Asistencia 1° cuatrimestre: ");
                        anual.setAsistenciaPrimerCuatrimestre(sc.nextDouble());

                        System.out.print("Asistencia 2° cuatrimestre: ");
                        anual.setAsistenciaSegundoCuatrimestre(sc.nextDouble());

                        sc.nextLine();

                        nuevaMateria = anual;

                    } else {

                        nuevaMateria = new Materia(
                                nombre,
                                codigo,
                                cuatrimestre,
                                anio
                        );
                    }

                    alumno.inscribirse(nuevaMateria);

                    System.out.println("Materia registrada correctamente:");
                    nuevaMateria.mostrarResumen();

                    break;

                case 2:

                    System.out.println("Dar de baja de una materia:");

                    System.out.print("Ingrese el código de la materia: ");
                    String codigoBaja = sc.nextLine();

                    if (alumno.getInscripcion(codigoBaja) != null) 
                    {
                        alumno.darDeBaja(codigoBaja);
                        System.out.println("Materia eliminada correctamente.");
                    } 
                    else 
                    {
                        System.out.println("Materia no encontrada.");
                    }

                    break;

                case 3:

                    if (alumno.getMaterias().isEmpty()) 
                    {
                        System.out.println("No hay materias inscriptas.");
                    } 
                    else 
                    {
                        System.out.println("=== MATERIAS INSCRIPTAS ===");

                        for (InscripcionMateria insc : alumno.getMaterias()) 
                        {
                            Materia mat = insc.getMateria();

                            System.out.println("Materia: " + mat.getNombre());
                            System.out.println("Código: " + mat.getCodigo());
                            System.out.println("Cuatrimestre: " + mat.getCuatrimestre());
                            System.out.println("Año: " + mat.getAnio());
                            System.out.println("Asistencia: " + insc.getPorcentajeAsistencia() + "%");
                            System.out.println("Promedio: " + insc.getPromedio());
                            System.out.println("Condición: " + insc.getCondicion());
                            System.out.println("----------------------");
                        }
                    }

                    break;

                case 4:

                    System.out.println("Buscar materia por:");
                    System.out.println("1. Código");
                    System.out.println("2. Nombre");
                    System.out.print("Opción: ");

                    while (!sc.hasNextInt()) 
                    {
                        System.out.println("Opción inválida. Intente nuevamente.");
                        sc.nextLine();
                        System.out.print("Opción: ");
                    }

                    int tipoBusqueda = sc.nextInt();
                    sc.nextLine();

                    if (tipoBusqueda == 1) 
                    {
                        System.out.print("Ingrese código: ");
                        String codigoBusqueda = sc.nextLine();
                        buscarMateria(alumno, codigoBusqueda, true);
                    } 
                    else if (tipoBusqueda == 2) 
                    {
                        System.out.print("Ingrese nombre: ");
                        String nombreBusqueda = sc.nextLine();
                        buscarMateria(alumno, nombreBusqueda);
                    } 
                    else 
                    {
                        System.out.println("Opción inválida.");
                    }

                    break;

                case 0:

                    System.out.println("Volviendo al menú principal...");
                    break;

                default:

                    System.out.println("Opción inválida.");
                    break;
            }

        } while (opcionMateria != 0);
    }

    //Buscar materia por nombre 
    public static void buscarMateria(Estudiante alumno, String nombre) {
        boolean encontrada = false;

        for (InscripcionMateria insc : alumno.getMaterias()) {
 
            if (insc.getMateria().getNombre().toLowerCase().contains(nombre.toLowerCase().trim())) {
                Materia mat = insc.getMateria();

                System.out.println("Materia encontrada:");
                System.out.println("Materia: " + mat.getNombre());
                System.out.println("Código: " + mat.getCodigo());
                System.out.println("Cuatrimestre: " + mat.getCuatrimestre());
                System.out.println("Año: " + mat.getAnio());
                System.out.println("Asistencia: " + insc.getPorcentajeAsistencia() + "%");
                System.out.println("Promedio: " + insc.getPromedio());
                System.out.println("Condición: " + insc.getCondicion());
                System.out.println("----------------------");

                encontrada = true;
            }
        }

        if (!encontrada) {
            System.out.println("Materia no encontrada.");
        }
    }

    //Buscar materia por código (búsqueda parcial)
    public static void buscarMateria(Estudiante alumno, String codigo, boolean porCodigo) {
        boolean encontrada = false;

        for (InscripcionMateria insc : alumno.getMaterias()) {
            // Verifica si el código ingresado está contenido en el código de la materia
            if (insc.getMateria().getCodigo().toLowerCase().contains(codigo.toLowerCase().trim())) {
                Materia mat = insc.getMateria();

                System.out.println("Materia encontrada:");
                System.out.println("Materia: " + mat.getNombre());
                System.out.println("Código: " + mat.getCodigo());
                System.out.println("Cuatrimestre: " + mat.getCuatrimestre());
                System.out.println("Año: " + mat.getAnio());
                System.out.println("Asistencia: " + insc.getPorcentajeAsistencia() + "%");
                System.out.println("Promedio: " + insc.getPromedio());
                System.out.println("Condición: " + insc.getCondicion());
                System.out.println("----------------------");

                encontrada = true;
            }
        }

        if (!encontrada) {
            System.out.println("Materia no encontrada.");
        }
    }
    
    public static void volverMenu(Estudiante alumno, Scanner sc) 
    {
       
        System.out.println("Presione ENTER para volver...");
        sc.nextLine();
    }
    
    
} 

