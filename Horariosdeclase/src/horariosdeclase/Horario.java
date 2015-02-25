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
public class Horario {

    SesionClase[][] horario;

    public Horario(int sesionesDia, int dias) {
        horario = new SesionClase[sesionesDia][dias];
    }

    public void setSesionClase(int sesionDia, int dia, String asignatura, String aula, String profesorado) {
        horario[sesionDia][dia] = new SesionClase(asignatura, aula, profesorado);
    }

    public String toString() {
        String aux = "";
        for (int i = 0; i < horario[0].length; i++) {
            aux += "Dia " + (i + 1) + ":\n";
            for (int j = 0; j < horario.length; j++) {
                System.out.println("valor de Dia :"+ i);
                System.out.println("valor de Hora :"+ j);
                if (horario[j][i] == null) {
                    aux += "Sección " + (j + 1) + " : Vacío.\n";
                } else {
                    aux += "Sección " + (j + 1)+" : " + horario[j][i].toString();
                }
            }
        }
        return aux;
    }
}