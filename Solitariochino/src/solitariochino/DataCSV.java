/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitariochino;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manuel Manzano López.
 */
public class DataCSV {

    private int[] date ;
    private int numItem;
    private String typeElement;
    private int[] timeGame;
    private String name=("save_data.csv");
    BufferedWriter bufferedout = null;
    private final String HEADBOARD = "DATE"+this.separator+"TIME"+
            this.separator+"ELEMENT"+this.separator+"TYPE"+
            this.separator+"TIMEGAME"+"/n";
    private boolean insert= false;
    private char separator=';';
    private File file;
    
    public DataCSV(File namefile,char separator){
        if(namefile.isDirectory()){
            this.file= new File(namefile, name);
        }else{
            this.file= namefile;
        }
        this.separator=separator;
        this.verific();  
    }
    
    public DataCSV(String namefile, char separator){
        if(new File(namefile).isDirectory()){
            this.file= new File(namefile, name);
        }else{
            this.file= new File(namefile);
        }
        this.separator=separator;
        this.name= namefile;
        this.verific();
    }

    public File setData(int[] date,int numItem,String typeElement,int[] timeGame) {
        this.date = date;
        this.numItem = numItem;
        this.typeElement = typeElement;
        this.timeGame=timeGame;
        this.generate();
        return file;
    }

    private void generate() {
        try {
            bufferedout = new BufferedWriter(new FileWriter(file,insert));
            bufferedout.write(this.getData());
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataCSV.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (bufferedout != null) {
                    bufferedout.close();
                }
            } catch (Exception e) {
                System.out.println("Error.");
                System.out.println(e.getMessage());
            }
        }
    }
    
    private String getData() {
        String aux=null;
        if(!insert){
            aux += HEADBOARD + "\n";
        }
        aux +=  this.getDate()+this.separator;
        aux += this.getTime() + this.separator;
        aux += String.valueOf(this.numItem) + this.separator;
        aux += this.typeElement + this.separator;
        aux +=this.getTimeGame();
        return aux;
    }
    private String getDate(){
        return  date[0] + "/" + date[1] + "/" + date[2];
    }
    private String getTime(){
        return date[3] + ":" + date[4] + ":" + date[5];
    }
    private String getTimeGame(){
        
        return (timeGame[3]-date[3]) + ":" + (timeGame[4]-date[4]) + ":" + (timeGame[5]-date[5]);
    } 
    private void verific(){
        if(file.exists()){
            try {
                BufferedReader bufferedread= new BufferedReader(new FileReader(file));
                if(this.HEADBOARD.equalsIgnoreCase(bufferedread.readLine())){
                    insert= true;
                    bufferedread.close();
                }else{
                    insert =false;
                    bufferedread.close();
                }     
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DataCSV.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DataCSV.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
             
        }
    }
    private void setSeparator(char separator){
        this.separator=separator;
    }
    public void setname(String namefile){
        this.name=namefile;
    }
}
