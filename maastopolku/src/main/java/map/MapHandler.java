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
    
    public MapHandler() {
        map = null;
        JFXPanel jfxPanel = new JFXPanel();
    }
    
    public boolean loadMap(String i) {
        try {
            if (i.matches(".(\\|;|.|,|(|)|[|]).")) {
                throw new Exception("Input contains illegal characters."); // Hylätään laittomat merkit
            }
            String fs = System.getProperty("file.separator");
            
            map = new Image(fs + "maps" + fs + i + ".png"); 
            
            /*if (System.getProperty("os.name").contains("Windows")) { // Havaitaan käyttöjärjestelmä
                map = new Image(fs + "maps" + fs + i + ".png"); // Ladataan kartta
            } else {
                map = new Image("/src/main/resources/maps/" + i + ".png"); // Ilmeisesti unix- systeemit käsittelevät tiedostojen sijainnit eri tavalla kuin Windows-järjestelmät.
            }*/
            
            System.out.println("Map " + i + ".png was loaded!");
        } catch (Exception e) {
            System.out.println(e + " while trying to load " + i);
            return false;
        }
        return true;
    }
    
    public Image getMap() {
        
        return map;
        
    }
    
    public double distance(double ax, double ay, double bx, double by) {
        double spea = speedCalc(ax, ay); // laskee maastossa liikkumisnopeuden alussa
        double speb = speedCalc(bx, by); // laskee maastossa liikkumisnopeuden lopussa
        // double speab = speedCalc(ax + (bx - ax) / 2, ay + (by - ay) / 2); // laskee maastossa liikkumisnopeuden pisteiden välissä
        double spe = (spea + speb) / 2; // laskee keskinopeuden
        double distance = Math.sqrt(Math.pow(ax - bx, 2) + Math.pow(ay - by, 2)); // laskee pisteiden etäisyyden toisistaan
        return distance * spe; // palauttaa "liikkumisajan"
    }
    
    private double speedCalc(double x, double y) { // palauttaa maaston liikkumisnopeuden pisteessä 
    
        int col = 16777216 + map.getPixelReader().getArgb((int) x, (int) y); // hae pikselin väri (palauttaa negatiivisen arvon, niin lisätään 16777216)
        double spe = 1;
        switch (col) {
            case 0: 
                spe = Double.MAX_VALUE; // seinä, ei liikuttavissa läpi
                break;
            case 255: 
                spe *= 0.3; // sininen, nopea liikkua
                break;
            case 65280: 
                spe *= 5; // vihreä, hidas liikkua
                break;
            case 16711680: 
                spe *= 20; // punainen, erittäin hidas liikkua
                break;
            case 16777215: 
                spe *= 1; // valkoinen, ei muutosta
                break;
        }
        return spe;
    }
}
