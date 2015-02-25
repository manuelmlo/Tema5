/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rssreader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Manuel Manzano López
 */
public class RssReader {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory fábricaCreadorDocumento = DocumentBuilderFactory.newInstance();
            DocumentBuilder creadorDocumento = fábricaCreadorDocumento.newDocumentBuilder();
            URL dir = new URL("http://estaticos.elmundo.es/elmundo/rss/portada.xml");
            Document documento = creadorDocumento.parse(dir.openStream());
            
            NodeList listatitulos = documento.getElementsByTagName("title");
            
            for(int i=2;i<listatitulos.getLength();i++){
                
                Node nodotitulo=listatitulos.item(i);
                Node titulo= nodotitulo.getFirstChild();
                System.out.println((i-1)+titulo.getNodeValue()+"\n");
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(RssReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException | ParserConfigurationException | IOException ex) {
            Logger.getLogger(RssReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
