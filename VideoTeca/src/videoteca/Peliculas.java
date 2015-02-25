/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoteca;

/**
 *
 * @author Manuel Manzano López
 */
public class Peliculas {
    
    private String titulo;
    private String director;
    private String anio;

    public Peliculas(String titulo, String director, String anio) {
        this.titulo = titulo;
        this.director = director;
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Peliculas:" + "Titulo:" + titulo + "\n Director:" + director + "\n Año:" + anio + '\n';
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDirector() {
        return director;
    }

    public String getAnio() {
        return anio;
    }
    
    
    
}
