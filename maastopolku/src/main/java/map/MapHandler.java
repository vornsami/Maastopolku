/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

/**
 *
 * @author Sami
 */

import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;


public class MapHandler {
    
    Image map;
    
    public MapHandler(){
        map = null;
        JFXPanel jfxPanel = new JFXPanel();
    }
    
    public boolean loadMap(int i){
        
        try {
            
            map = new Image("\\maps\\map" + i + ".png");
            
            System.out.println("Map map" + i + ".png was loaded!");
            
        } catch(Exception e){
            
            System.out.println(e);
            
            return false;
        }
        
        return true;
    }
    
    public Image getMap(){
        
        return map;
        
    }
    
    
}
