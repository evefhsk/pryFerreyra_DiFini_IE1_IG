/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autogestionestudiantil;

/**
 *
 * @author eve
 */
public class MateriaAnual extends Materia
{
    private double notaPrimerCuatrimestre;
    private double notaSegundoCuatrimestre;

    private double asistenciaPrimerCuatrimestre;
    private double asistenciaSegundoCuatrimestre;

    public MateriaAnual(String nombre, String codigo, int anio) {

        super(nombre, codigo, 0, anio);

        this.notaPrimerCuatrimestre = 0;
        this.notaSegundoCuatrimestre = 0;

        this.asistenciaPrimerCuatrimestre = 0;
        this.asistenciaSegundoCuatrimestre = 0;
}
    

