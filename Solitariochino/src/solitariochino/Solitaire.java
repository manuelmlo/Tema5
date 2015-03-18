/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitariochino;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author Manuel Manzano López.
 */
public class Solitaire {

    protected int numtype = 3;
    protected Object[][] board;
    protected Object empty = 'X';
    protected Object full = 1;
    protected Object isnull = 0;
    private final int AUXS = 1;
    private final int AUXCENTER = 3;
    private int DIMENSIONX = 7;
    private int DIMENSIONY = 7;
    protected int coordinatexin = AUXCENTER;
    protected int coordinateyin = AUXCENTER;
    protected int coordinatexout = AUXCENTER;
    protected int coordinateyout = AUXCENTER;
    protected ArrayList<Moves> moves = new ArrayList();
    private File file = null;
    private int level = 0;
    private String[] listlevel = null;
    private int numundo;
    private int all;
    private int numall;
    private int[] winner={3,3};



    /**
     *
     */
    public Solitaire() {

        this.numtype = 3;

    }

    /**
     *
     * @param numtype this numtype is more them 3.
     */
    public Solitaire(int numtype) {
        if (numtype >= 3) {
            if (numtype / 2 == 0) {
                this.numtype = numtype + 1;
            } else {
                this.numtype = numtype;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Numero mayor o igual que 3 \n"
                    + "y número impar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    public Solitaire(String namefile, int level) {
        this.readFile(namefile, level);
    }

    /**
     *
     * @param numtype
     */
    public void setNumtype(int numtype) {
        if (numtype >= 3) {
            if (numtype / 2 == 0) {
                this.numtype = numtype + 1;
            } else {
                this.numtype = numtype;
            }
        }
    }

    /**
     *Método que genera el juego por defecto.
     * Según parametros definidos en las propiedades.
     * 
     */
    protected void generategame() {

        board = new Object[DIMENSIONX][DIMENSIONY];

        for (int x = 0; x < board.length; x++) {

            for (int y = 0; y < board[x].length; y++) {

                if (x == AUXCENTER && y == AUXCENTER) {
                    board[AUXCENTER][AUXCENTER] = empty;

                } else {
                    if (x < (AUXCENTER - AUXS) || x > (AUXCENTER + AUXS)) {
                        if (y < (AUXCENTER - AUXS) || y > (AUXCENTER + AUXS)) {
                            board[x][y] = isnull;
                        } else {
                            board[x][y] = full;
                        }
                    } else {
                        board[x][y] = full;
                    }
                }
            }
        }
        this.setall();
    }

    /**
     *Método que verifica que las posiciones son correctas según la dinámica del
     * juego.
     * @return Booleam si es true es correcto las posiciones, false si no es 
     * correcto las posiciones.
     */
    protected boolean isCorrectMove() {
        boolean tmp = false;
        if (coordinatexin == coordinatexout) {
            if (coordinateyin > coordinateyout) {
                if (coordinateyin == coordinateyout + 2
                        && board[coordinateyout][coordinateyout + 1] == full) {
                    tmp = true;
                } else {

                }
            } else {
                if (coordinateyin == coordinateyout - 2
                        && board[coordinateyout][coordinateyout - 1] == full) {
                    tmp = true;
                } else {

                }
            }
        } else {
            if (coordinatexin > coordinatexout) {
                if (coordinateyin == coordinateyout
                        && board[coordinatexout + 1][coordinateyout] == full) {
                    tmp = true;

                } else {

                }
            } else {

            }
            if (coordinatexin < coordinatexout) {
                if (coordinateyin == coordinateyout
                        && board[coordinatexout - 1][coordinateyout] == full) {
                    tmp = true;
                } else {

                }
            } else {

            }
        }
        return tmp;
    }

    /**
     *Método que introduce el elemento vacio.
     * @param empty Elemento correspondiente a vacio.
     */
    public void setEmpty(Object empty) {
        this.empty = empty;
    }

    /**
     *Método que introduce el elmenteo lleno.
     * @param full Elemento correspondiente a lleno.
     */
    public void setFull(Object full) {
        this.full = full;
    }

    /**
     *Método que introduce el elemento nulo.
     * @param isnull Elemeto correspondiente a nulo.
     */
    public void setIsnull(Object isnull) {
        this.isnull = isnull;
    }

    /**
     *
     * @param coordinatex
     * @param coordinatey
     */
    public void setcoordinatein(int coordinatex, int coordinatey) {
        if (this.isvalidcoordinate(coordinatex, coordinatey)) {
            this.coordinatexin = coordinatex;
            this.coordinateyin = coordinatey;
        } else {
            JOptionPane.showMessageDialog(null, "Posición del elemento está vacia \n"
                    + "Elija una posición correcta.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     *
     * @param coordinatex
     * @param coordinatey
     */
    public void setcoordinateout(int coordinatex, int coordinatey) {
        if (this.isvalidcoordinate(coordinatex, coordinatey)) {
                this.coordinatexout = coordinatex;
                this.coordinateyout = coordinatey;
        } else {
            JOptionPane.showMessageDialog(null, "Posición del elemento está vacia \n"
                    + "Elija una posición correcta.", "Información", JOptionPane.INFORMATION_MESSAGE); 
        }
    }

    /**
     *
     * @param coordinatex
     * @param coordinatey
     * @return
     */
    protected boolean isvalidcoordinate(int coordinatex, int coordinatey) {

        if ((0 <= coordinatex && coordinatex < DIMENSIONX)) {
            if (0 <= coordinatey && coordinatey < DIMENSIONY) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    

    /**
     *Método que realiza el cambio del los elementos de la matriz si todo es 
     * correcto.
     */
    public void setMove() {
        if (this.isCorrectMove()&& 
                (board[coordinatexin][coordinateyin] == full&&
                board[coordinatexout][coordinateyout] == empty)) {
            if (this.coordinatexin == this.coordinatexout) {
                if (this.coordinateyin > this.coordinateyout) {
                    board[coordinatexin][coordinateyin] = empty;
                    board[coordinatexout][coordinateyout + 1] = empty;
                    board[coordinatexout][coordinateyout] = full;
                } else {
                    board[coordinatexin][coordinateyin] = empty;
                    board[coordinatexout][coordinateyout - 1] = empty;
                    board[coordinatexout][coordinateyout] = full;
                }
            } else {
                if (this.coordinatexin > this.coordinatexout) {
                    board[coordinatexin][coordinateyin] = empty;
                    board[coordinatexout + 1][coordinateyout] = empty;
                    board[coordinatexout][coordinateyout] = full;
                } else {
                    board[coordinatexin][coordinateyin] = empty;
                    board[coordinatexout - 1][coordinateyout] = empty;
                    board[coordinatexout][coordinateyout] = full;
                }
            }
            this.saveMove();
            this.numall++;
        }
    }
    /**
     * Método que retorna en formato cadena de caracteres en el caso de que en  
     * la matriz haya carácteres o texto guardado en las posiciones.
     * @return Cadena de caracteres del tablero.
     */
    @Override
    public String toString() {
        String aux = "";
        for (int x = 0; x < board.length; x++) {
            aux += "       ";
            for (int y = 0; y < board[0].length; y++) {
                aux += String.valueOf(board[x][y]) + " ";
            }
            aux += "\n";
        }
        System.out.println(aux);
        return aux;
    }

    public void toString(JTextArea jTextArea) {
        int columns = (board.length);
        int rows = (board[0].length);
        jTextArea.setText("");
        String aux = "";
        for (int i = 0; i < rows; i++) {
            aux = "\n";
        }
        for (Object[] tablero1 : board) {
            for (int i = 0; i < columns; i++) {
                aux = " ";
            }
            for (int y = 0; y < board[0].length; y++) {
                aux += String.valueOf(tablero1[y]);
            }
            
            aux += "\n";
        }
        System.out.println(aux);
        jTextArea.setText(aux);
    }

    /**
     *Método que guarda el último movimiento que se ha realizado en un ArrayList.
     */
    protected void saveMove() {
        if (numundo == 0) {
            moves.add(new Moves(coordinatexin, coordinateyin, coordinatexout, coordinateyout));
        } else {
            if (numundo == moves.size()) {
                moves = null;
                moves.add(new Moves(coordinatexin, coordinateyin, coordinatexout, coordinateyout));
            } else {
                while (numundo > 0) {
                    moves.remove(moves.size() - 1);
                    numundo--;
                }
                moves.add(new Moves(coordinatexin, coordinateyin, coordinatexout, coordinateyout));
            }

        }

    }

    /**
     *Método que deshace el último movimiento que se guardado o rehecho.
     */
    public void undoMove() {
        if (!moves.isEmpty()&& (numundo>=0 && numundo < moves.size())) {
            int[] tmp;
            tmp = moves.get(moves.size() - 1 - numundo).getCoord();
            this.setCellUndo(tmp[0], tmp[1], full);
            this.setCellUndo(tmp[2], tmp[3], empty);
            if (tmp[0] == tmp[2]) {
                if (tmp[1] > tmp[3]) {
                    this.setCellUndo(tmp[0], tmp[3] + 1, full);
                } else {
                    this.setCellUndo(tmp[0], tmp[3] - 1, full);
                }
                numundo++;
                numall--;
            }
            if (tmp[1] == tmp[3]) {
                if (tmp[0] > tmp[2]) {
                    this.setCellUndo(tmp[2] + 1, tmp[1], full);
                } else {
                    this.setCellUndo(tmp[2] - 1, tmp[1], full);
                }
                numundo++;
                numall--;
            }

        } else {
            JOptionPane.showMessageDialog(null, "No hay movimientos que deshacer", "Información",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     *Método que rehace el último movimiento que se a deshecho.
     */
    public void reUndoMove() {
        if (moves.size() > numundo && numundo >=0) {
            int[] tmp;
            tmp = moves.get(moves.size() - numundo).getCoord();
            this.setCellUndo(tmp[0], tmp[1], empty);
            this.setCellUndo(tmp[2], tmp[3], full);
            if (tmp[0] == tmp[2]) {
                if (tmp[1] > tmp[3]) {
                    this.setCellUndo(tmp[0], tmp[3] + 1, empty);
                } else {
                    this.setCellUndo(tmp[0], tmp[3] - 1, empty);
                }
                numundo--;
                numall++;
            }
            if (tmp[1] == tmp[3]) {
                if (tmp[0] > tmp[2]) {
                    this.setCellUndo(tmp[2] + 1, tmp[1], empty);
                } else {
                    this.setCellUndo(tmp[2] - 1, tmp[1], empty);
                }
                numundo--;
                numall++;
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "No hay movimientos rehacer", "Información",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     *Método que sustituye elemento existente en la posiciones de una Matriz por 
     * el elemento o.
     * 
     * @param coordinatex Filas posición de la matriz.
     * @param coordinatey Columnas posición de la matriz.
     * @param o Elemento que sustituye al existente en las posiciones anteriores.
     */
    protected void setCellUndo(int coordinatex, int coordinatey, Object o) {
        board[coordinatex][coordinatey] = o;
    }

    /**
     *Método que genera el archivo XML.
     * Source con los movimientos en formato XML.
     * @return Un elemento Source con el archivo XML.
     */
    protected Source generateXml() {
        int[] tmp;
        Source readxml = null;
        try {
            DocumentBuilderFactory makerXML = DocumentBuilderFactory.newInstance();
            DocumentBuilder makedocument = makerXML.newDocumentBuilder();
            Document documentxml = makedocument.newDocument();
            Element itemroot = documentxml.createElement("Movimientos");
            documentxml.appendChild(itemroot);
            for (int i = 0; i < moves.size(); i++) {
                tmp = moves.get(i).getCoord();
                Element itemmov = documentxml.createElement("Movimiento " + String.valueOf(i + 1));
                itemroot.appendChild(itemmov);

                Element coordinatesin = documentxml.createElement("Coordenadas Entrada");
                itemmov.appendChild(coordinatesin);

                Element positionxin = documentxml.createElement("Coordenada X");
                coordinatesin.appendChild(positionxin);
                Text coordxin = documentxml.createTextNode(String.valueOf(tmp[0]));
                positionxin.appendChild(coordxin);

                Element positionyin = documentxml.createElement("Coordenada Y");
                coordinatesin.appendChild(positionyin);
                Text coordyin = documentxml.createTextNode(String.valueOf(tmp[1]));
                positionyin.appendChild(coordyin);

                Element coordinatesout = documentxml.createElement("Coordenadas Salida");
                itemmov.appendChild(coordinatesin);

                Element positionxout = documentxml.createElement("Coordenada X");
                coordinatesout.appendChild(positionxout);
                Text coordxout = documentxml.createTextNode(String.valueOf(tmp[2]));
                positionxout.appendChild(coordxout);

                Element positionyout = documentxml.createElement("Coordenada Y");
                coordinatesout.appendChild(positionyout);
                Text coordyout = documentxml.createTextNode(String.valueOf(tmp[3]));
                positionyout.appendChild(coordyout);
            }
            readxml = new DOMSource(documentxml);

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Solitaire.class.getName()).log(Level.SEVERE, null, ex);
        }
        return readxml;
    }

    /**
    *Método que mueve la posición del elemento por fila.
    * Desplazamiento hacia arriba.
    * Si el parámetro de entrada es verdadero la posición es la pocisión inicial.
    * Si el parámetro de entrada es false la posición es la posición final.
    * @param moveItem Parámetro de entrada, posición inicial true y final false.
    */
    public void setMoveUp(boolean moveItem) {
        if (!moveItem) {
            this.setcoordinatein(coordinatexin - 1, coordinateyin);
        } else {
            this.setcoordinateout(coordinatexout - 1, coordinateyout);
        }

    }

    /**
     *Método que mueve la posición del elemento por fila.
     * Desplazamiento hacia abajo.
     * Si el parámetro de entrada es verdadero la posición es la pocisión inicial.
     * Si el parámetro de entrada es false la posición es la posición final.
     * @param moveItem Parámetro de entrada, posición inicial true y final false.
     */
    public void setMoveDown(boolean moveItem) {
        if (!moveItem) {
            this.setcoordinatein(coordinatexin + 1, coordinateyin);
        } else {
            this.setcoordinateout(coordinatexout + 1, coordinateyout);
        }
    }

    /**
     *Método que mueve la posición del elemento por columna.
     * Desplazamiento a izquierda.
     * Si el parámetro de entrada es verdadero la posición es la pocisión inicial.
     * Si el parámetro de entrada es false la posición es la posición final.
     * @param moveItem Parámetro de entrada, posición inicial true y final false.
     */
    public void setMoveleft(boolean moveItem) {
        if (!moveItem) {
            this.setcoordinatein(coordinatexin, coordinateyin - 1);
        } else {
            this.setcoordinateout(coordinatexout, coordinateyout - 1);
        }
    }

    /**
     *Método que mueve la posición del elemento por columna.
     * Desplazamiento a derecha.
     * Si el parámetro de entrada es verdadero la posición es la pocisión inicial.
     * Si el parámetro de entrada es false la posición es la posición final.
     * @param moveItem Parámetro de entrada, posición inicial true y final false.
     */
    public void setMoveRight(boolean moveItem) {
        if (!moveItem) {
            this.setcoordinatein(coordinatexin, coordinateyin + 1);
        } else {
            this.setcoordinateout(coordinatexout, coordinateyout + 1);
        }
    }

    /**
     *Método que lee un archivo de niveles mediante la ruta del mismo y configura
     * el nivel.
     * @param namefile ruta del archivo
     * @param level
     */
    public void readFile(String namefile, int level) {
        File file1 = new File(namefile);
        this.readFile(file1, level);
    }

    /**
     *Método que lee un archivo de niveles mediante un File y configura el nivel.
     * @param file Archivo de tipo File.
     * @param level El nivel seleccionado.
     */
    public void readFile(File file, int level) {
        try {
            BufferedReader bufferread = null;
            bufferread = new BufferedReader(new FileReader(file));
            String tmp = bufferread.readLine();
            if (tmp != null) {
                tmp = bufferread.readLine();

                if (tmp.equalsIgnoreCase("DOCUMENT LEVEL") == false) {

                    while (tmp.equalsIgnoreCase("Level" + String.valueOf(level)) == false) {
                        tmp = bufferread.readLine();
                    }

                    while (tmp.equalsIgnoreCase("SIZE") == false) {
                        tmp = bufferread.readLine();
                    }

                    while (tmp.equalsIgnoreCase("X") == false) {
                        tmp = bufferread.readLine();
                    }
                    tmp = bufferread.readLine();

                    if (!(tmp == null)) {
                        DIMENSIONX = Integer.valueOf(tmp);
                    }

                    while (tmp.equalsIgnoreCase("Y") == false) {
                        tmp = bufferread.readLine();
                    }
                    tmp = bufferread.readLine();
                    if (!(tmp == null)) {
                        DIMENSIONY = Integer.valueOf(tmp);
                    }
                    board=null;
                    board = new Object[DIMENSIONX][DIMENSIONY];
                    while (tmp.equalsIgnoreCase("FULL") == false) {
                        tmp = bufferread.readLine();
                    }
                    tmp = bufferread.readLine();
                    if (!(tmp == null)) {
                        full = tmp;
                    }
                    while (tmp.equalsIgnoreCase("EMPTY") == false) {
                        tmp = bufferread.readLine();
                    }
                    tmp = bufferread.readLine();
                    if (!(tmp == null)) {
                        empty = tmp;
                    }
                    while (tmp.equalsIgnoreCase("ISEMPTY") == false) {
                        tmp = bufferread.readLine();
                    }
                    tmp = bufferread.readLine();
                    if (!(tmp == null)) {
                        isnull = tmp;
                    }
                    while (tmp.equalsIgnoreCase("START") == false) {
                        tmp = bufferread.readLine();
                    }
                    if (tmp.equalsIgnoreCase("START") == true) {
                        tmp = bufferread.readLine();
                        int x = 0;
                        while (tmp.equalsIgnoreCase("END") == false) {
                            for (int y = 0; y < tmp.length(); y++) {
                                board[x][y] = tmp.charAt(y);
                            }
                            x++;
                            tmp = bufferread.readLine();
                        }
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Solitaire.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Solitaire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Método que devuelve en un array los nombres de los niveles.
     * @return Array de String contiene el nombres de los niveles.
     */
    public String[] getListlevel() {
        return listlevel;
    }

    /**
     *Introducir un archivo de niveles mediante su ruta.
     * Evalua los niveles incluidos en el archivo.
     * @param namefile
     */
    public void setFile(String namefile) {

        try {
            this.file = new File(namefile);
            BufferedReader bufferread = null;
            bufferread = new BufferedReader(new FileReader(file));
            String tmp = bufferread.readLine();
            if (tmp != null) {
                while (tmp.equalsIgnoreCase("LEVELS") == false) {
                    tmp = bufferread.readLine();
                }
                tmp = bufferread.readLine();
                this.level = Integer.valueOf(tmp);
                listlevel = new String[this.level];
                for (int i = 0; i < listlevel.length; i++) {
                    listlevel[i] = "Nivel " + (i + 1);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Solitaire.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Solitaire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *Introducir el archivo de niveles de tipo File mediante un File.
     * Evalua el número de niveles incluido en el archivo File introducido.
     * @param file
     */
    public void setFile(File file) {
        try {
            this.file = file;
            BufferedReader bufferread = null;
            bufferread = new BufferedReader(new FileReader(file));
            String tmp = bufferread.readLine();
            if (tmp != null) {
                while (tmp.equalsIgnoreCase("LEVELS") == false) {
                    tmp = bufferread.readLine();
                }
                tmp = bufferread.readLine();
                this.level = Integer.valueOf(tmp);
                listlevel = new String[this.level];
                
                for (int i = 0; i < listlevel.length; i++) {
                    while(tmp.equalsIgnoreCase("NAME") == false){
                        tmp = bufferread.readLine();
                    }
                    tmp = bufferread.readLine();
                    listlevel[i] = "Nivel " + (i + 1)+": "+tmp;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Solitaire.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Solitaire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *Configurar el número de nivel de un archivo File introducido.
     * @param level
     */
    public void setLevel(int level) {

        this.readFile(file, level);
    }

    /**
     *Contador de número de elementos a eliminar.
     */
    private void setall() {
        if (!(board == null)) {
            for (Object[] board1 : board) {
                for (Object board11 : board1) {
                    if (board11 == full) {
                        this.all++;
                    }
                }
            }
        }
    }
    /**
     * Número total de elementos.
     * @return 
     */
    public int getAll() {
        return all;
    }
    /**
     * Número total de elementos eleminados.
     * @return 
     */
    public int getNumall() {
        return numall;
    }
    /**
     * Nuevo tablero de juego.
     * @param dimensionX
     * @param dimensionY 
     */
    private void newBoard(int dimensionX, int dimensionY){
        board= null;
        board = new Object[dimensionX][dimensionY];
        
    }
    
//    private boolean isWinner(){
//        boolean tmp= true;
//        for(int i=0; i<board.length;i++){
//            for(int j=0; j<board[i].length;j++){
//                if(j==winner[1] && i==winner[0] && board[i][j]==full){
//                    
//                }else{
//                    
//                }
//            }
//        }
//        return tmp;
//    }
    public ArrayList<Moves> gethistory(){
        return moves;
    }
   /**
    * 
    */
    public void setMoves(){
         moves=null;
    }
    /**
     * 
     * @param numundo 
     */
    private void setNumundo() {
        this.numundo = numundo;
    }
    /**
     * 
     * @param numall 
     */
    private void setNumall() {
        this.numall = numall;
    }
    
    public void setDefault(){
        this.setMoves();
        this.setall();
        this.setNumall();
        this.setNumundo();
    }
}