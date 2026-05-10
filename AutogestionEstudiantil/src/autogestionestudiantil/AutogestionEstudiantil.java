/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package autogestionestudiantil;

/**
 *
 * @author ferre
 */
public class AutogestionEstudiantil {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
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
         
    }
    
}
