/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package champions;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author Manuel Manzano López
 */
public class Partidos {
    
    protected String team1;
    protected String team2;
    
    public Partidos( String Equipo1, String Equipo2){
        this.team1=Equipo1;
        this.team2=Equipo2;
    }
    
    public Element getGameXML(Document document, Element element){
        
        Element game= document.createElement("Partido");
        element.appendChild(game);
        
        Element teamone = document.createElement("Equipo");
        game.appendChild(teamone);
        Text teamnum1 = document.createTextNode(this.team1);
        teamone.appendChild(teamnum1);
        
        Element teamtwo = document.createElement("Equipo");
        game.appendChild(teamtwo);
        Text teamnum2 = document.createTextNode(this.team2);
        teamtwo.appendChild(teamnum2);
        
        return game;
    }
        
  
    
    }