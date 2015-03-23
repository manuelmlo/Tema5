/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitariochino;

import com.sun.glass.ui.Size;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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

    private int numtype = 3;
    private char[][] board;
    private final char EMPTY = 'X';
    private final char FULL = '1';
    private final char ISEMPTY = '0';
    private final int AUXS = 1;
    private final int AUXCENTER = 3;
    private int DIMENSIONX = 7;
    private int DIMENSIONY = 7;
    private int coordinatexin = AUXCENTER;
    private int coordinateyin = AUXCENTER;
    private int coordinatexout = AUXCENTER;
    private int coordinateyout = AUXCENTER;
    private ArrayList<Move> moves = new ArrayList();
    private File file = null ;
    private int level = 0;
    private String[] listlevel = null;
    private int numundo=0;
    private int all=0;
    private int numall=0;
    private char[][] tmp;
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

        board = new char[DIMENSIONX][DIMENSIONY];

        for (int x = 0; x < board.length; x++) {

            for (int y = 0; y < board[x].length; y++) {

                if (x == AUXCENTER && y == AUXCENTER) {
                    board[AUXCENTER][AUXCENTER] = EMPTY;

                } else {
                    if (x < (AUXCENTER - AUXS) || x > (AUXCENTER + AUXS)) {
                        if (y < (AUXCENTER - AUXS) || y > (AUXCENTER + AUXS)) {
                            board[x][y] = ISEMPTY;
                        } else {
                            board[x][y] = FULL;
                        }
                    } else {
                        board[x][y] = FULL;
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
        boolean tmp1 = false;
        if (coordinatexin == coordinatexout) {
            if (coordinateyin > coordinateyout) {
                if (coordinateyin == coordinateyout + 2
                        && board[coordinateyout][coordinateyout + 1] == FULL) {
                    tmp1 = true;
                } else {

                }
            } else {
                if (coordinateyin == coordinateyout - 2
                        && board[coordinateyout][coordinateyout - 1] == FULL) {
                    tmp1 = true;
                } else {

                }
            }
        } else {
            if (coordinatexin > coordinatexout) {
                if (coordinateyin == coordinateyout
                        && board[coordinatexout + 1][coordinateyout] == FULL) {
                    tmp1 = true;

                } else {

                }
            } else {

            }
            if (coordinatexin < coordinatexout) {
                if (coordinateyin == coordinateyout
                        && board[coordinatexout - 1][coordinateyout] == FULL) {
                    tmp1 = true;
                } else {

                }
            } else {

            }
        }
        return tmp1;
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
                (board[coordinatexin][coordinateyin] == FULL &&
                board[coordinatexout][coordinateyout] == EMPTY)) {
            if (this.coordinatexin == this.coordinatexout) {
                if (this.coordinateyin > this.coordinateyout) {
                    board[coordinatexin][coordinateyin] = EMPTY;
                    board[coordinatexout][coordinateyout + 1] = EMPTY;
                    board[coordinatexout][coordinateyout] = FULL;
                } else {
                    board[coordinatexin][coordinateyin] = EMPTY;
                    board[coordinatexout][coordinateyout - 1] = EMPTY;
                    board[coordinatexout][coordinateyout] = FULL;
                }
            } else {
                if (this.coordinatexin > this.coordinatexout) {
                    board[coordinatexin][coordinateyin] = EMPTY;
                    board[coordinatexout + 1][coordinateyout] = EMPTY;
                    board[coordinatexout][coordinateyout] = FULL;
                } else {
                    board[coordinatexin][coordinateyin] = EMPTY;
                    board[coordinatexout - 1][coordinateyout] = EMPTY;
                    board[coordinatexout][coordinateyout] = FULL;
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
        if(board!=null){
        for (char[] board1 : board) {
            aux += "       ";
            for (int y = 0; y < board[0].length; y++) {
                aux += String.valueOf(board1[y]) + " ";
            }
            aux += "\n";
        }
        System.out.println(aux);
        }
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
        for (char[] tablero1 : board) {
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
    
    public void toGraphics(JPanel jpanel) {
        final Dimension size = new Dimension(jpanel.getX() / this.DIMENSIONX, jpanel.getY() / this.DIMENSIONY);
        final Point point = new Point(size.height / 2, size.width / 2);
        Color cEmpty = Color.GRAY;
        Color cFull = Color.green;
        Color cIsempty = Color.WHITE;
        JLabel element = new JLabel();
        element.setSize(size);
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (board[x][y] == this.ISEMPTY) {
                    element.setBackground(cIsempty);
                    element.setLocation(point.x * x+1, point.y * y+1);
                    jpanel.add(element);
                }
                if (board[x][y] == this.EMPTY) {
                    element.setBackground(cEmpty);
                    element.setLocation(point.x * x+1, point.y * y+1);
                    jpanel.add(element);
                }
                if (board[x][y] == this.FULL) {
                    element.setBackground(cFull);
                    element.setLocation(point.x * x+1, point.y * y+1);
                    jpanel.add(element);
                }
            }
        }

    }

    /**      
     *Método que guarda el último movimiento que se ha realizado en un ArrayList.
     */
    protected void saveMove() {
        if (numundo == 0) {
           moves.add(new Move(this.getCoordinatexin(),this.getCoordinateyin(),
                   this.getCoordinatexout(), this.getCoordinateyout()));
           
        } else {
            if (numundo == moves.size()) {
                moves = null;
                moves.add(new Move(this.getCoordinatexin(),this.getCoordinateyin(),
                   this.getCoordinatexout(), this.getCoordinateyout()));
            } else {
                while (numundo > 0) {
                    moves.remove(moves.size() - 1);
                    numundo--;
                }
                moves.add(new Move(this.getCoordinatexin(),this.getCoordinateyin(),
                   this.getCoordinatexout(), this.getCoordinateyout()));
            }

        }

    }

    public int getCoordinatexin() {
        return coordinatexin;
    }

    public int getCoordinateyin() {
        return coordinateyin;
    }

    public int getCoordinatexout() {
        return coordinatexout;
    }

    public int getCoordinateyout() {
        return coordinateyout;
    }

    /**
     *Método que deshace el último movimiento que se guardado o rehecho.
     */
    public void undoMove() {
        if (!moves.isEmpty()&& (numundo>=0 && numundo < moves.size())) {
            int[] tmp2;
            tmp2 = moves.get(moves.size() - 1 - numundo).getCoord();
            this.setCellUndo(tmp2[0], tmp2[1], FULL);
            this.setCellUndo(tmp2[2], tmp2[3], EMPTY);
            if (tmp2[0] == tmp2[2]) {
                if (tmp2[1] > tmp2[3]) {
                    this.setCellUndo(tmp2[0], tmp2[3] + 1, FULL);
                } else {
                    this.setCellUndo(tmp2[0], tmp2[3] - 1, FULL);
                }
                numundo++;
                numall--;
            }
            if (tmp2[1] == tmp2[3]) {
                if (tmp2[0] > tmp2[2]) {
                    this.setCellUndo(tmp2[2] + 1, tmp2[1], FULL);
                } else {
                    this.setCellUndo(tmp2[2] - 1, tmp2[1], FULL);
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
            int[] tmp1;
            tmp1 = moves.get(moves.size() - numundo).getCoord();
            this.setCellUndo(tmp1[0], tmp1[1], EMPTY);
            this.setCellUndo(tmp1[2], tmp1[3], FULL);
            if (tmp1[0] == tmp1[2]) {
                if (tmp1[1] > tmp1[3]) {
                    this.setCellUndo(tmp1[0], tmp1[3] + 1, EMPTY);
                } else {
                    this.setCellUndo(tmp1[0], tmp1[3] - 1, EMPTY);
                }
                numundo--;
                numall++;
            }
            if (tmp1[1] == tmp1[3]) {
                if (tmp1[0] > tmp1[2]) {
                    this.setCellUndo(tmp1[2] + 1, tmp1[1], EMPTY);
                } else {
                    this.setCellUndo(tmp1[2] - 1, tmp1[1], EMPTY);
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
    protected void setCellUndo(int coordinatex, int coordinatey, char o) {
        board[coordinatex][coordinatey] = o;
    }

    /**
     *Método que genera el archivo XML.
     * Source con los movimientos en formato XML.
     * @return Un elemento Source con el archivo XML.
     */
    protected Source generateXml() {
        int[] tmp3;
        Source readxml = null;
        try {
            DocumentBuilderFactory makerXML = DocumentBuilderFactory.newInstance();
            DocumentBuilder makedocument = makerXML.newDocumentBuilder();
            Document documentxml = makedocument.newDocument();
            Element itemroot = documentxml.createElement("Movimientos");
            documentxml.appendChild(itemroot);
            for (int i = 0; i < moves.size(); i++) {
                tmp3 = moves.get(i).getCoord();
                Element itemmov = documentxml.createElement("Movimiento_" + String.valueOf(i + 1));
                itemroot.appendChild(itemmov);

                Element coordinatesin = documentxml.createElement("Coordenadas_Entrada");
                itemmov.appendChild(coordinatesin);

                Element positionxin = documentxml.createElement("Coordenada_X");
                coordinatesin.appendChild(positionxin);
                Text coordxin = documentxml.createTextNode(String.valueOf(tmp3[0]));
                positionxin.appendChild(coordxin);

                Element positionyin = documentxml.createElement("Coordenada_Y");
                coordinatesin.appendChild(positionyin);
                Text coordyin = documentxml.createTextNode(String.valueOf(tmp3[1]));
                positionyin.appendChild(coordyin);

                Element coordinatesout = documentxml.createElement("Coordenadas_Salida");
                itemmov.appendChild(coordinatesout);

                Element positionxout = documentxml.createElement("Coordenada_X");
                coordinatesout.appendChild(positionxout);
                Text coordxout = documentxml.createTextNode(String.valueOf(tmp3[2]));
                positionxout.appendChild(coordxout);

                Element positionyout = documentxml.createElement("Coordenada_Y");
                coordinatesout.appendChild(positionyout);
                Text coordyout = documentxml.createTextNode(String.valueOf(tmp3[3]));
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
            String tmp4 = bufferread.readLine();
            if (tmp4 != null) {
                tmp4 = bufferread.readLine();

                if (tmp4.equalsIgnoreCase("DOCUMENT LEVEL") == false) {

                    while (tmp4.equalsIgnoreCase("Level" + String.valueOf(level)) == false) {
                        tmp4 = bufferread.readLine();
                    }

                    while (tmp4.equalsIgnoreCase("SIZE") == false) {
                        tmp4 = bufferread.readLine();
                    }

                    while (tmp4.equalsIgnoreCase("X") == false) {
                        tmp4 = bufferread.readLine();
                    }
                    tmp4 = bufferread.readLine();

                    if (!(tmp4 == null)) {
                        DIMENSIONX = Integer.valueOf(tmp4);
                    }

                    while (tmp4.equalsIgnoreCase("Y") == false) {
                        tmp4 = bufferread.readLine();
                    }
                    tmp4 = bufferread.readLine();
                    if (!(tmp4 == null)) {
                        DIMENSIONY = Integer.valueOf(tmp4);
                    }
                    board=null;
                    board = new char[DIMENSIONX][DIMENSIONY];
                    while (tmp4.equalsIgnoreCase("START") == false) {
                        tmp4 = bufferread.readLine();
                    }
                    if (tmp4.equalsIgnoreCase("START") == true) {
                        tmp4 = bufferread.readLine();
                        int x = 0;
                        while (tmp4.equalsIgnoreCase("END") == false) {
                            for (int y = 0; y < tmp4.length(); y++) {
                                board[x][y] = tmp4.charAt(y);
                            }
                            x++;
                            tmp4 = bufferread.readLine();
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
            String tmp5 = bufferread.readLine();
            if (tmp5 != null) {
                while (tmp5.equalsIgnoreCase("LEVELS") == false) {
                    tmp5 = bufferread.readLine();
                }
                tmp5 = bufferread.readLine();
                this.level = Integer.valueOf(tmp5);
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
            String tmp6 = bufferread.readLine();
            if (tmp6 != null) {
                while (tmp6.equalsIgnoreCase("LEVELS") == false) {
                    tmp6 = bufferread.readLine();
                }
                tmp6 = bufferread.readLine();
                this.level = Integer.valueOf(tmp6);
                listlevel = new String[this.level];
                
                for (int i = 0; i < listlevel.length; i++) {
                    while(tmp6.equalsIgnoreCase("NAME") == false){
                        tmp6 = bufferread.readLine();
                    }
                    tmp6 = bufferread.readLine();
                    listlevel[i] = "Nivel " + (i + 1)+": "+tmp6;
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
            for (char[] board1 : board) {
                for (char board11 : board1) {
                    if (board11 == FULL) {
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
        board = new char[dimensionX][dimensionY];
        
    }
    
//    private boolean isWinner(){
//        boolean tmp= true;
//        for(int i=0; i<board.length;i++){
//            for(int j=0; j<board[i].length;j++){
//                if(j==winner[1] && i==winner[0] && board[i][j]==FULL){
//                    
//                }else{
//                    
//                }
//            }
//        }
//        return tmp;
//    }
    public ArrayList<Move> gethistory(){
        return moves;
    }
    /**
     * 
     */
    public void setDefault(){
        this.setall();
        this.numall=0;
        this.numundo=0;
        this.moves=null;
    }
    public boolean isFileNull(){
        return file!=null;
    }
    
    public void saveStatusBoard(){
        this.tmp=board;
    }
    public void restoreStatusBoard(){
       board=this.tmp;
    }
}