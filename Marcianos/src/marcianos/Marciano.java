/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marcianos;

import java.util.Random;

/**
 *
 * @author Manuel Manzano López
 */
public class Marciano {

    public final int ACRUX = 0;
    public final int ELNATH = 1;
    public final int GIRTAB = 2;
    public final int ANCHO = 5;
    public final int ALTO = 5;
    protected String nombre;
    protected int tipo;
    protected int coordenadax;
    protected int coordenaday;
    static protected int movimientos;
    protected static int x = 0;
    protected static int y = 0;

    /**
     *Constructor Marciano recibe Nombre y tipo de marciano.
     * Crea un nuevo tipo de marciano el especificando el nombre del marciano
     * la posición se genera aleato
     * @param nombre parámetro del nombre que se le va asignar al marciano.
     * @param tipo parámetro del tipo de marciano que va ser.
     */
    public Marciano(String nombre, int tipo) {
        this.nombre = nombre;
        switch (tipo) {
            case 0:
                this.tipo = tipo;
                break;
            case 1:
                this.tipo = tipo;
                break;
            case 2:
                this.tipo = tipo;
                break;
            default:
                this.tipo = ACRUX;
        }
        Random posicion = new Random();
        int x;
        int y;
        boolean tmp = true;
        do {
            x = posicion.nextInt(5);
            y = posicion.nextInt(5);
            tmp = iscolisionado(x, y);

        } while (tmp);
        if (!tmp) {
            setPosicion(y, x);
        }
        setX(x);
        setY(y);
    }
    /**
     * Constructor Marciano recibe nombre, tipo, posición x y posición y.
     * Crea un tipo de marciano, con el nombre especificado, tipo, y la posición
     * x e y que va ocupar.
     * @param nombre Nombre asignado al marciano.
     * @param tipo Tipo de marciano asignado.
     * @param x Posición X que ocupará el marciano.
     * @param y Posición Y que ocupará el marciano.
     */
    public Marciano(String nombre, int tipo, int x, int y) {
        this.nombre = nombre;
        switch (tipo) {
            case 0:
                this.tipo = tipo;
                break;
            case 1:
                this.tipo = tipo;
                break;
            case 2:
                this.tipo = tipo;
                break;
            default:
                this.tipo = ACRUX;
        }
        iscolisionado(x, y);
        setPosicion(x, y);
        setX(x);
        setY(y);
    }

    /**
     * Método para posicionar el Marciano.
     * Recibe como parámetros la pocisión Y y la posición X, que ocupará el 
     * marciano, siempre que este dentro de los parámetro definidos en las 
     * constantes ANCHO Y ALTO, no mayor que 5, en ambos casos.
     * @param coordenadaX Nueva posición X que va ocupar.
     * @param coordenadaY Nueva posición Y que va ocupar.
     *
     */
    public void setPosicion(int coordenadaX, int coordenadaY) {

        if (coordenadaX >= 0 && coordenadaY >= 0) {
            if (coordenadaX <= 5) {
                this.coordenadax = coordenadaX;
            } else {
                this.coordenaday = 5;
            }
            if (coordenadaY <= 5) {
                this.coordenaday = coordenadaY;
            } else {
                this.coordenaday = 5;
            }
        } else {
            this.coordenadax = 5;
            this.coordenaday = 5;
        }

    }

    /**
     *Procedimiento que verifica que el la posición introducida, no coincide con
     * la posicion del último elemento posicionado.
     * @param x Parámetro x de la posición a comparar.
     * @param y Parámetro y de la posición a comparar.
     * @return Retorna un booleam si coindice el par de datos que se le introducen
     * con los datos de la nueva posición.
     */
    public boolean iscolisionado(int x, int y) {
        if (x == coordenadax && y == coordenaday) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Método que verifica que la posición introducida, coincide o no coincide, 
     * con la posición que tiene el Marciano.
     * @return Retorna una cadena de caracteres si coincide o en el caso de no 
     * coincidir retorna una cadena vacía
     */
    public String iscolisionado(){
       if (x == coordenadax && y == coordenaday) {
            return "Ha colisionado";
        } else {
            return "";
        } 
    }

    /**
     *Método para introducir la coordenada X a comparar.
     * @param x Coordenada X para comparar.
     */
    public static void setX(int x) {
        Marciano.x = x;
    }

    /**
     *Método para introducir la coordenada Y a comparar.
     * @param y
     */
    public static void setY(int y) {
        Marciano.y = y;
    }

    /**
     *Método que devuelve el tipo de Marciano que tiene asignado, el marciano.
     * @return Retorna una cadena de caractere con el tipo de marciano.
     */
    public String getTipo() {
        switch (tipo) {
            case 0:
                return "ACRUX";

            case 1:
                return "ELNATH";
            case 2:
                return "GIRTAB";
            default:
                return "No existe tipo de Marciano";
        }
    }

    public String getPosicion() {
        return "( " + String.valueOf(coordenadax) + ", "
                + String.valueOf(coordenaday) + ") ";

    }

    /**
     *Método que retorna la posición del Marciano.
     * @return Retorna la posición en formato (X, Y).
     */
    public String getEstado() {
        return "Marciano " + nombre + " (" + getTipo() + ")" + "está en: "
                + getPosicion() + ".";
    }
    /**
     * Método que retorna la posición X del Marciano.
     * @return Retorna la posición X.
     */
    public int getCoordenadax() {
        return coordenadax;
    }
    /**
     Método que retorna la posición Y del Marciano.
     * @return Retorna la posición Y.
     */
    public int getCoordenaday() {
        return coordenaday;
    }
    
}

