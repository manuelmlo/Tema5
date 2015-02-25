/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitariochino;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Manuel Manzano López
 */
public class JLabelX extends JLabel implements MouseListener, MouseMotionListener{
    
    protected static ImageIcon empty;
    protected static ImageIcon full;
    protected static ImageIcon isempty;
    protected Color selected;
    protected Color unselected;
    protected JPanel jPanel;
    private Point posicion = new Point(0,0);
    public int posX= posicion.x;
    public int posY= posicion.y;
    /** Tamaño de imagen */
    private Dimension dimension = new Dimension(150,150);    
    /** variable que sirve para calcular el movimiento del objeto */
    private Point start_location;
    /** variable que sirve para calcular el movimiento del objeto */
    private Point start_draglocation;
    /** variable que sirve para calcular el movimiento del objeto */
    private Point move_offset;
    /** variables auxiliares para el desplazamiento del objeto*/
    private int nuevo_X = 1;
    private int nuevo_Y = 1;
    private JPanel board;
    private String name="Item";
    private boolean movable;
    
    /**
     * 
     * @param jpanel
     * @param x
     * @param y
     * @param type 
     */
    public JLabelX(JPanel jpanel, int x, int y,int type){
        this.name =+ x+"-"+y;
        this.setToolTipText(name);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));        
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        switch(type){
            case 0:
                this.setIcon(empty);
                break;
            case 1:
                this.setIcon(full);
                break;
            case 2:
                this.setIcon(isempty);
                break;
        }
        this.setText("");
        this.setVisible( true );
        this.setLocation( posicion= new Point(x*dimension.height, y*dimension.width));
        //se agregan los listener
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

    }
    /**
     * 
     * @param name 
     */
    public void setName(String name){
        this.name=name;
    }
    
    /**
     * 
     * @return 
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * 
     * @param Imagen_full 
     */
    public void setImageIsEmpty(String Imagen_full){
        isempty=new ImageIcon(getClass().getResource(Imagen_full));
    }
    
    /**
     * 
     * @param Imagen_full 
     */
    public void setImageFull(String Imagen_full){
        full=new ImageIcon(getClass().getResource(Imagen_full));
    }
    
    /**
     * 
     * @param Imagen_full 
     */
    public void setImageEmpty(String Imagen_full){
        empty=new ImageIcon(getClass().getResource(Imagen_full));
    }
    
    /**
     * 
     * @param e 
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * 
     * @param e 
     */
    @Override
    public void mousePressed(MouseEvent e) {
       this.start_draglocation = getScreenLocation(e);
       this.start_location = this.getLocation();
    }
    
    /**
     * 
     * @param e 
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        nuevo_X = (this.getLocation().x);
        nuevo_Y = (this.getLocation().y);
        this.setLocation( nuevo_X, nuevo_Y );
        
    }
    
    /**
     * 
     * @param e 
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
    }
    
    /**
     * 
     * @param e 
     */
    @Override
    public void mouseExited(MouseEvent e) {
        this.setBorder( null );
    }
    
    /**
     * 
     * @param e 
     */
    @Override
    public void mouseDragged(MouseEvent e) {
      Point current = this.getScreenLocation(e);
      move_offset = new Point((int) current.getX() - (int) start_draglocation.getX(),(int) current.getY() - (int) start_draglocation.getY());
      Point new_location = new Point((int) (this.start_location.getX() + move_offset.getX()), (int) (this.start_location.getY() + move_offset.getY()));
      this.setLocation(new_location); 
    }
    
    /**
     * 
     * @param e 
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
    * metodo para obtener la posicion  del frame en la pantalla
    * @param MouseEvent evt
    */
    private Point getScreenLocation(MouseEvent evt) {
        Point cursor = evt.getPoint();
        Point target_location = this.getLocationOnScreen();
        return new Point((int) (target_location.getX() + cursor.getX()),
               (int) (target_location.getY() + cursor.getY()));
    }
    
    
}
