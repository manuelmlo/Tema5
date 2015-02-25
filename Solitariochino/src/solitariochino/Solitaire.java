/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitariochino;

import com.sun.org.apache.xml.internal.serializer.OutputPropertiesFactory;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.ErrorListener;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.URIResolver;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
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
    protected Object empty;
    protected Object full;
    protected Object isnull;
    protected Object[][] boardgraf;
    private final int AUXS = 1;
    private final int AUXCENTER = 3;
    private final int DIMENSION=7;
    protected int coordinatexin= AUXCENTER;
    protected int coordinateyin= AUXCENTER;
    protected int coordinatexout= AUXCENTER;
    protected int coordinateyout= AUXCENTER;
    protected ArrayList<int[]> moves= new ArrayList();
    private JPanel Panel;

    /**
     *
     */
    public Solitaire() {
        
        this.numtype=3;

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
     *
     */
    protected void generategame() {

        board = new Object[DIMENSION][DIMENSION];
        boardgraf= new Object[DIMENSION][DIMENSION];

        for (int x = 0; x < board.length; x++) {

            for (int y = 0; y < board[x].length; y++) {

                if (x == AUXCENTER && y == AUXCENTER) {
                    board[AUXCENTER][AUXCENTER] = empty;

                } else {
                    if (x < (AUXCENTER-AUXS) || x > (AUXCENTER + AUXS)) {
                        if (y < (AUXCENTER-AUXS) || y > (AUXCENTER + AUXS)) {
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
    }

    /**
     *
     * @return
     */
    protected boolean isCorrectMove() {
        boolean tmp = false;
        if (coordinatexin == coordinatexout) {
            if (coordinateyin > coordinateyout) {
                if (coordinateyin == coordinateyout + 2 && 
                    board[coordinateyout][coordinateyout + 1] == full) {
                    tmp = true;
                } else {

                }
            } else {
                if (coordinateyin == coordinateyout - 2 && 
                    board[coordinateyout][coordinateyout - 1] == full) {
                    tmp = true;
                } else {
                    
                }
            }
        } else {
            if (coordinatexin > coordinatexout) {
                if(coordinateyin==coordinateyout && 
                        board[coordinatexout+1][coordinateyout] == full){
                    tmp=true;
                    
                }else{
                    
                }
            } else {
                
            }
            if (coordinatexin < coordinatexout) {
                if(coordinateyin==coordinateyout && 
                        board[coordinatexout-1][coordinateyout] == full){
                    tmp=true;
                }else{
                    
                }
            } else {
                  
            }
        }
        return tmp;
    }

    /**
     *
     * @param empty
     */
    public void setEmpty(Object empty) {
        this.empty = empty;
    }

    /**
     *
     * @param full
     */
    public void setFull(Object full) {
        this.full = full;
    }

    /**
     *
     * @param isnull
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
        if(isvalidcoordinate(coordinatex, coordinatey)&& board[coordinatex][coordinatey]==full){
            this.coordinatexin=coordinatex;
            this.coordinateyin=coordinatey;
        }else{
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
        if(isvalidcoordinate(coordinatex, coordinatey)&& board[coordinatex][coordinatey]==empty){
            if(coordinatexin!=coordinateyout && coordinatexin!=coordinateyout){
                this.coordinatexout=coordinatex;
                this.coordinateyout=coordinatey;
            }else{
                JOptionPane.showMessageDialog(null, "Posición  \n"
                    + "Elija una posición correcta.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }    
        }else{
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
        
            if (coordinatex < (AUXCENTER - AUXS) || coordinatex > (AUXCENTER + AUXS)) {
                if (coordinatey < (AUXCENTER - AUXS) || coordinatey > (AUXCENTER + AUXS)) {
                    return false;
                }else{
                    return true;
                }
            }else{
                return true;
            }
    }
    /**
     * 
     */
    public void setMove(){
        if(this.isCorrectMove()){
            if(this.coordinatexin==this.coordinatexout){
                if(this.coordinateyin>this.coordinateyout){
                    board[coordinatexin][coordinateyin]=empty;
                    board[coordinatexout][coordinateyout+1]=empty;
                    board[coordinatexout][coordinateyout]=full;
                }else{
                    board[coordinatexin][coordinateyin]=empty;
                    board[coordinatexout][coordinateyout-1]=empty;
                    board[coordinatexout][coordinateyout]=full;
                }
            }else{
                if(this.coordinatexin>this.coordinatexout){
                    board[coordinatexin][coordinateyin]=empty;
                    board[coordinatexout+1][coordinateyout]=empty;
                    board[coordinatexout][coordinateyout]=full;
                }else{
                    board[coordinatexin][coordinateyin]=empty;
                    board[coordinatexout-1][coordinateyout]=empty;
                    board[coordinatexout][coordinateyout]=full;
                }
            }
            this.saveMove();
        }
    }

    @Override
   public String toString(){
       String aux="";
        for (Object[] tablero1 : board) {
            for (int y = 0; y<board[0].length; y++) {
                aux += String.valueOf(tablero1[y]);
            }
            aux+="\n";
        }
       System.out.println(aux);
       return aux;
   }
   public void toString(JTextArea jTextArea){
       jTextArea.setText("");
       String aux="";
        for (Object[] tablero1 : board) {
            for (int y = 0; y<board[0].length; y++) {
                aux += String.valueOf(tablero1[y]);
            }
            aux+="\n";
        }
       System.out.println(aux);
       jTextArea.setText(aux);
   }
   /**
    * 
    */
   protected void saveMove(){
       int[]tmp = {coordinatexin,coordinateyin,coordinatexout,coordinateyout};
       moves.add(tmp);
   }
   public void undoMove(){
       if(!moves.isEmpty()){
           int[] tmp;
           tmp=moves.get(moves.size()-1);
           this.setCellUndo(tmp[0], tmp[1], full);
           this.setCellUndo(tmp [2], tmp[3], empty);
           if(tmp[0]==tmp[2]){
               if(tmp[1]>tmp[3]){
                   this.setCellUndo(tmp[0], tmp[3]+1, full);
               }else{
                   this.setCellUndo(tmp[0], tmp[3]-1, full);
               }
           }
           if(tmp[1]==tmp[3]){
               if(tmp[0]>tmp[2]){
                   this.setCellUndo(tmp[2]+1, tmp[1], full);
               }else{
                   this.setCellUndo(tmp[2]-1, tmp[1], full);
               }
           }
           moves.remove(moves.size()-1);
       }else{
           JOptionPane.showMessageDialog(null,"No hay movimientos" , "Información",
                   JOptionPane.INFORMATION_MESSAGE);
       }
   }
   /**
    * 
    * @param numUndoMove 
    */
   public void undoMove(int numUndoMove){
       int aux=moves.size();
       if(!moves.isEmpty()){
           if(numUndoMove<aux){
                for(int i=0; i<numUndoMove; i++){
                     int[] tmp;
                     tmp=moves.get(moves.size()-1);
                     this.setCellUndo(tmp[0], tmp[1], full);
                     this.setCellUndo(tmp [2], tmp[3], empty);
                     if(tmp[0]==tmp[2]){
                         if(tmp[1]>tmp[3]){
                             this.setCellUndo(tmp[0], tmp[1]-tmp[3], full);
                         }else{
                             this.setCellUndo(tmp[0], tmp[3]-tmp[1], full);
                         }
                     }
                     if(tmp[1]==tmp[3]){
                         if(tmp[0]>tmp[2]){
                             this.setCellUndo(tmp[0]-tmp[2], tmp[1], full);
                         }else{
                             this.setCellUndo(tmp[2]-tmp[0], tmp[1], full);
                         }
                     }
                     moves.remove(moves.size());
                }
           }else{
               
               JOptionPane.showMessageDialog(null,"No Suficientes hay movimientos" , "Información",
                   JOptionPane.INFORMATION_MESSAGE);
           }
       }else{
           JOptionPane.showMessageDialog(null,"No hay movimientos" , "Información",
                   JOptionPane.INFORMATION_MESSAGE);
       }
       
   }
   /**
    * 
    * @param coordinatex
    * @param coordinatey
    * @param o 
    */
   protected void setCellUndo(int coordinatex, int coordinatey, Object o){
       board[coordinatex][coordinatey]=o;
   }
   
   /**
    * 
    * @return
    * @throws TransformerConfigurationException
    * @throws TransformerException 
    */
   protected Source generateXml() throws TransformerConfigurationException, TransformerException{
       int[]tmp;
       Source readxml = null;
        try {
            DocumentBuilderFactory makerXML = new DocumentBuilderFactory() {
                @Override
                public DocumentBuilder newDocumentBuilder() throws ParserConfigurationException {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
                
                @Override
                public void setAttribute(String name, Object value) throws IllegalArgumentException {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
                
                @Override
                public Object getAttribute(String name) throws IllegalArgumentException {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
                
                @Override
                public void setFeature(String name, boolean value) throws ParserConfigurationException {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
                
                @Override
                public boolean getFeature(String name) throws ParserConfigurationException {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            DocumentBuilder makedocument = makerXML.newDocumentBuilder();
            Document documentxml = makedocument.newDocument();
            Element itemroot = documentxml.createElement("Movimientos");
            documentxml.appendChild(itemroot);
            for(int i=0; i<moves.size();i++){
                tmp=moves.get(i);
                Element itemmov = documentxml.createElement("Movimiento "+ (i+1));
                itemroot.appendChild(itemmov);
                
                Element coordinatesin = documentxml.createElement("Coordenadas Entrada");
                itemmov.appendChild(coordinatesin);
                
                Element positionxin = documentxml.createElement("Coordenada X");
                coordinatesin.appendChild(positionxin);
                Text coordxin= documentxml.createTextNode(String.valueOf(tmp[0]));
                positionxin.appendChild(coordxin);
                
                Element positionyin = documentxml.createElement("Coordenada Y");
                coordinatesin.appendChild(positionyin);
                Text coordyin= documentxml.createTextNode(String.valueOf(tmp[1]));
                positionyin.appendChild(coordyin);
                
                Element coordinatesout = documentxml.createElement("Coordenadas Salida");
                itemmov.appendChild(coordinatesin);
                
                Element positionxout = documentxml.createElement("Coordenada X");
                coordinatesout.appendChild(positionxout);
                Text coordxout= documentxml.createTextNode(String.valueOf(tmp[2]));
                positionxout.appendChild(coordxout);
                
                Element positionyout = documentxml.createElement("Coordenada Y");
                coordinatesout.appendChild(positionyout);
                Text coordyout= documentxml.createTextNode(String.valueOf(tmp[3]));
                positionyout.appendChild(coordyout);
            }
            readxml = new DOMSource(documentxml);
            
  
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Solitaire.class.getName()).log(Level.SEVERE, null, ex);
        }
      return readxml;
   }
   
   /**
    * 
    * @param moveItem 
    */
   public void setMoveUp(boolean moveItem){
       if(!moveItem){
           this.setcoordinatein(coordinatexin-1, coordinateyin);
       }else{
           this.setcoordinateout(coordinatexin-1, coordinateyin);
       }
   
   }
   /**
    * 
    * @param moveItem 
    */
   public void setMoveDown(boolean moveItem){
       if(!moveItem){
           this.setcoordinatein(coordinatexin+1, coordinateyin);
       }else{
           this.setcoordinateout(coordinatexin+1, coordinateyin);
       }
   }
   /**
    * 
    * @param moveItem 
    */
   public void setMoveleft(boolean moveItem){
       if(!moveItem){
           this.setcoordinatein(coordinatexin, coordinateyin-1);
       }else{
           this.setcoordinateout(coordinatexin, coordinateyin-1);
       }
   }
   /**
    * 
    * @param moveItem 
    */
   public void setMoveRight(boolean moveItem){
       if(!moveItem){
           this.setcoordinatein(coordinatexin, coordinateyin+1);
       }else{
           this.setcoordinateout(coordinatexin, coordinateyin+1);
       }
   }
   public void setSelected(String o){

   }
   /**
    * 
    * @param jPanel 
    */
   
   protected void setJPanel(JPanel jPanel){
       this.Panel=jPanel;

   }
   public void generateJPanel(){
       
   
   }
   
}
   
