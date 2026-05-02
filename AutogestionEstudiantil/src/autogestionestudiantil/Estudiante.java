/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autogestionestudiantil;

/**
 *
 * @author Eve
 */


import java.util.ArrayList;

public class Estudiante extends PersonaAcademica implements Consultable{

    private String carrera;
    private int anioIngreso;
    private ArrayList<InscripcionMateria> materias;

    public Estudiante(String nombre, String legajo, String carrera, int anioIngreso) {
        super(nombre, legajo);
        this.carrera = carrera;
        this.anioIngreso = anioIngreso;
        this.materias = new ArrayList<>();
    }


    public String getCarrera() {
        return carrera;
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }

    public ArrayList<InscripcionMateria> getMaterias() {
        return materias;
    }
    
     public void inscribirse(Materia m) {

        // Validar duplicados
        for (InscripcionMateria insc : materias) {
            if (insc.getMateria().getCodigo().equals(m.getCodigo())) {
                System.out.println("Ya estás inscripto en esta materia.");
                return;
            }
        }

        InscripcionMateria nueva = new InscripcionMateria(m);
        materias.add(nueva);

        System.out.println("Inscripción realizada.");
    }

    public void darDeBaja(String codigo) {

        InscripcionMateria insc = getInscripcion(codigo);

        if (insc != null) {
            materias.remove(insc);
            System.out.println("Materia eliminada.");
        } else {
            System.out.println("Materia no encontrada.");
        }
    }

    public InscripcionMateria getInscripcion(String codigo) {

        for (InscripcionMateria insc : materias) {
            if (insc.getMateria().getCodigo().equalsIgnoreCase(codigo)) {
                return insc;
            }
        }

        return null;
    }
    
    @Override
    public void mostrarResumen() {
    
}

   
}
  


    

