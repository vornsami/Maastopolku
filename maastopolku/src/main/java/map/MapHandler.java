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
    Double[][] array;
    
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
    
    public boolean generateArray(int unit){
        try{
            int w = (int) map.getWidth()/unit;
            int h = (int) map.getHeight()/unit;
            
            array = new Double[w][h];
            
            for(int i=0;i<w;i++){
                for(int j=0;j<h;j++){
                    
                    array[i][j] = Double.MAX_VALUE;
                    
                }
            }
            
        } catch(Exception e){
             System.out.println("Generation failed due to " + e);
             return false;
        }
        
        return true;
    }
    
    public double distance(double ax, double ay, double bx, double by){
        return distance(ax,ay,bx,by,1);
    }
    
    public double distance(double ax, double ay, double bx, double by, double mul){
        
        double spea = speedCalc(ax,ay,mul);
        double speb = speedCalc(bx,by,mul);
        double speab = speedCalc(ax + (bx - ax)/2 , ay + (by - ay)/2,mul);
        
        
        return (spea+speb+speab)/3;
    }
    
    private double speedCalc(double x, double y, double mul){
    
        int col = 16777216 + map.getPixelReader().getArgb((int)x, (int)y);
        double spe = mul;
        
        
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
