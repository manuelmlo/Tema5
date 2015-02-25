/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horariosdeclase;

/**
 *
 * @author Manuel Manzano López
 */
public class SesionClase {

    private String asignatura;
    private String aula;
    private String profesorado;

    public SesionClase(String asignatura, String aula, String profesorado) {
        this.asignatura = asignatura;
        this.aula = aula;
        this.profesorado = profesorado;
    }

    @Override
    public String toString() {

        return asignatura + ";" + aula + ";" + profesorado + "\r\n";

    }

}

