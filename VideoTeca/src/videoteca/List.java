/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoteca;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Manuel Manzano López
 */
public class List {
    
    protected ArrayList<Peliculas> listfilm;
    
    public List(){
        listfilm= new ArrayList();
    }
    
    public void setSave(String Title, String Director, String year){
            listfilm.add(new Peliculas(Title, Director, year));
    }
    public void setSave(int Position, String Title, String Director, String year ){
        if(listfilm.size()>Position){
            listfilm.add(Position, new Peliculas (Title, Director, year));
        }else{
            JOptionPane.showMessageDialog(null, "No se puede insertar en \n"
                    + " esta posición.", Title, Position);
        }
            
    }
    public Peliculas getShow(int Position){
             return listfilm.get(Position);

    }
    public String getShowString(int Position){
        return listfilm.get(Position).toString();
        
    }
    
    protected boolean isCorrect(int Position){
        try{
            return !(listfilm.get(Position)==null);
        }catch(NumberFormatException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "La posición :"+ Position+
                    "\n No existe.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }  
    }
    public void setDelete(int Position){
        if(this.isCorrect(Position)){
            listfilm.remove(Position);
        }else{
            JOptionPane.showMessageDialog(null, "La posición :"+ Position+
                    "\n No existe.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    } 
    
    public void setModify(int Position, String Title, String Director, String year){
        if(!this.isCorrect(Position)){
            listfilm.set(Position, new Peliculas(Title, Director, year));
        }else{}
    }
    
    public int getFind(String Title){
        for(int i=0; i<listfilm.size();i++){
            if(listfilm.get(i).getTitulo().equals(Title)){
                return i;
            }
        }
        return -1;
    }
    public String getAll(){
        String tmp="";
        if((listfilm.size()>0)){
            for(int i=0; i<listfilm.size();i++){
                tmp+=listfilm.get(i).toString()+"\n";
            }
        }else{
            JOptionPane.showMessageDialog(null, "La Base de datos está vacía.\n"
                    + "Introduce datos.", "Atención.", JOptionPane.WARNING_MESSAGE);
        }
        return tmp;
    }
}
