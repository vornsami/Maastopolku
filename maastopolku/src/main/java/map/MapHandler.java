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

public class MapHandler {
    
    Image map;
    
    public MapHandler(){
        map = null;
        JFXPanel jfxPanel = new JFXPanel();
    }
    
    public boolean loadMap(String i){
        
        try {
            
            if(i.matches(".(\\|;|.|,|(|)|[|]).")){
                throw new Exception("Input contains illegal characters.");
            }
            
            map = new Image("\\maps\\" + i + ".png");
            
            System.out.println("Map " + i + ".png was loaded!");
            
        } catch(Exception e){
            
            System.out.println(e);
            
            return false;
        }
        
        return true;
    }
    
    public Image getMap(){
        
        return map;
        
    }
    
    public double distance(double ax, double ay, double bx, double by){
        
        double spea = speedCalc(ax,ay);
        double speb = speedCalc(bx,by);
        double speab = speedCalc(ax + (bx - ax)/2 , ay + (by - ay)/2);
        
        double spe = (spea+speb+speab)/3;
        
        double distance = Math.sqrt(Math.pow(ax-bx,2)+Math.pow(ay-by,2));
        
        return distance * spe;
    }
    
    private double speedCalc(double x, double y){
    
        int col = 16777216 + map.getPixelReader().getArgb((int)x, (int)y);
        double spe = 1;
        
        
        switch(col){
            case 0: spe = Double.MAX_VALUE; 
            case 255: spe *= 0.5;
            case 65280: spe *= 2;
            case 16711680: spe *= 4;
            case 16777215: spe *= 1;
        }
        
        
        return spe;
    
    }
    
    
}
