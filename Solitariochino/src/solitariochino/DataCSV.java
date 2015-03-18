/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitariochino;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manuel Manzano López.
 */
public class DataCSV {

    private Calendar[] date = new Calendar[3];
    private Calendar[] time = new Calendar[3];
    private int numItem;
    private String typeElement;
    private File file=new File("dategame"+this.getDate()+this.getTime()+".csv");

    private final String HEADBOARD = "DATE,TIME,ELMENT,TYPE";

    public DataCSV(Calendar[] Date, Calendar[] Time, int numItem, String typeElement) {
        this.date = Date;
        this.time = Time;
        this.numItem = numItem;
        this.typeElement = typeElement;

    }

    private void generate() {
        OutputStream out = null;
        try {
            out = new FileOutputStream(file);
            try (BufferedOutputStream bufferedout = new BufferedOutputStream(out)) {
                bufferedout.write(this.getByte());
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataCSV.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(DataCSV.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private byte[] getByte() {
        String aux = HEADBOARD + "\n";
        aux += date[0] + "/" + date[1] + "/" + date[2] + ",";
        aux += time[0] + ":" + time[1] + ":" + time[2] + ",";
        aux += String.valueOf(this.numItem) + ",";
        aux += this.typeElement + "\n";
        return aux.getBytes();
    }
    public File getFile(){
        return file;
    }
    public File getFile(String namefile){
        File tmp = new File(namefile+".csv");
        this.file.renameTo(tmp);
        return tmp;
    }
    private String getDate(){
        return  "_"+date[0] + "-" + date[1] + "-" + date[2];
    }
    private String getTime(){
        return "_"+time[0] + ":" + time[1] + ":" + time[2];
    }
}
