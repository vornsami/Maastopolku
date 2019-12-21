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

import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;

public class MapHandler {
    
    Image map;
    
    public MapHandler() {
        map = null;
        JFXPanel jfxPanel = new JFXPanel();
    }
    
    /** Loads map with given name i.
     * Returns true if a valid map was loaded.
     * @param i image name
     * @return returns true if a map was loaded
     */
    public boolean loadMap(String i) {
        try {
            if (i.matches(".(\\|;|.|,|(|)|[|]).")) {
                throw new Exception("Input contains illegal characters."); // Hylataan laittomat merkit
            }
            String fs = System.getProperty("file.separator"); // Pyydetaan erottaja
            Path filepath = Paths.get("maps" + fs + i + ".png"); // Etsitaan tiedostopolku
            
            map = new Image(filepath.toUri().toString());  // haetaan kuva
            if (map.getHeight() == 0) { // tarkastetaan kuvan olemassaolo
                throw new Exception("No such map."); 
            }
            System.out.println("Map " + i + ".png was loaded!");
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    /**
     *
     * @return Returns map
     */
    public Image getMap() {
        
        return map;
        
    }
    
    /**
     * Calculates the distance between points a and b on the map.
     * @param ax x coordinate of point a
     * @param ay y coordinate of point a
     * @param bx x coordinate of point b
     * @param by y coordinate of point b
     * @return the calculated distance
     */
    public double distance(double ax, double ay, double bx, double by) {
        double spea = speedCalc(ax, ay); // laskee maastossa liikkumisnopeuden alussa
        double speb = speedCalc(bx, by); // laskee maastossa liikkumisnopeuden lopussa
        double spe = (spea + speb) / 2; // laskee keskinopeuden
        double distance = Math.sqrt(Math.pow(ax - bx, 2) + Math.pow(ay - by, 2)); // laskee pisteiden etaisyyden toisistaan
        return distance * spe; // palauttaa "liikkumisajan"
    }
    
    private double speedCalc(double x, double y) { // palauttaa maaston liikkumisnopeuden pisteessa 
    
        int col = 16777216 + map.getPixelReader().getArgb((int) x, (int) y); // hae pikselin vari (palauttaa negatiivisen arvon, niin lisataan 16777216)
        double spe = 1;
        switch (col) {
            case 0: 
                spe = Double.MAX_VALUE; // seina, ei liikuttavissa lapi
                break;
            case 255: 
                spe *= 0.3; // sininen, nopea liikkua
                break;
            case 65280: 
                spe *= 5; // vihrea, hidas liikkua
                break;
            case 16711680: 
                spe *= 20; // punainen, erittain hidas liikkua
                break;
            case 16777215: 
                spe *= 1; // valkoinen, ei muutosta
                break;
        }
        return spe;
    }
}
