/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autogestionestudiantil;

/**
 *
 * @author eve
 */
import java.util.ArrayList;


public class InscripcionMateria {

   
    private Materia materia;
    private int totalClases;
    private int clasesAsistidas;
    private ArrayList<Double> notas;

    public InscripcionMateria(Materia materia) {
        this.materia = materia;
        this.totalClases = 0;
        this.clasesAsistidas = 0;
        this.notas = new ArrayList<>();
    }

    
    public Materia getMateria() {
        return materia;
    }

    public int getTotalClases() {
        return totalClases;
    }

    public int getClasesAsistidas() {
        return clasesAsistidas;
    }

    public ArrayList<Double> getNotas() {
        return notas;
    }

    

    
}



