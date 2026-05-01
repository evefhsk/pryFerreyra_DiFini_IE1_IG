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

public class Estudiante extends PersonaAcademica implements Consultable {

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


   
}
  


    

