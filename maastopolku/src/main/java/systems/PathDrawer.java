/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systems;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javax.imageio.ImageIO;
import map.MapHandler;
import map.MapPoint;

/**
 *
 * @author Sami
 */
public class PathDrawer {
    public void draw(MapHandler map, List<MapPoint> path, String name, MapPoint[][] visited) {
        
        WritableImage wImage = new WritableImage((int) map.getMap().getWidth(), (int) map.getMap().getHeight());
        PixelWriter writer = wImage.getPixelWriter();
        
        writer.setPixels(0, 0, (int) map.getMap().getWidth(), (int) map.getMap().getHeight(), map.getMap().getPixelReader(), 0, 0); // kopioidaan kartta writableImage:ksi
        
        for (int i = 0; i < visited.length; i++) { // piirtaa kaikki kaydyt pisteet
            for (int j = 0; j < visited[0].length; j++) {
                if (visited[i][j] != null) {
                    writer.setColor((int) visited[i][j].getCoordinates()[0], (int) visited[i][j].getCoordinates()[1], Color.YELLOW);
                }
            }
        }
        
        Iterator iterator = path.iterator();
        iterator.next();
        
        while (iterator.hasNext()) { // piirtaa polun reittilistasta
            MapPoint point = (MapPoint) iterator.next();
            
            int x1 = (int) point.getPrevious().getCoordinates()[0];
            int y1 = (int) point.getPrevious().getCoordinates()[1];
            
            int x2 = (int) point.getCoordinates()[0];
            int y2 = (int) point.getCoordinates()[1];
            
            double k = 0;
            if (x1 != x2) { // lasketaan kulmakerroin
                k = (y1 - y2) / (x1 - x2);
            }
            double c = y2 - k * x2; // lasketaan vakio
            
            if (x1 == x2) { // tapaus, jossa siirrytaan pystysuunnassa
                int d = 1;
                if (y1 > y2) {
                    d = -1;
                }
                
                for (int i = y1; i != y2; i += d) {
                    writer.setColor(x1, i, Color.DARKGREY);
                }
                
            } else { // muut tapaukset
                int d = 1;
                if (x1 > x2) {
                    d = -1;
                }
                
                for (int i = x1; i != x2; i += d) { // piirretaan suora
                    writer.setColor(i, (int) (k * i + c), Color.DARKGREY);
                }
            }
        }
        writer.setColor((int) path.get(path.size() - 1).getCoordinates()[0], (int) path.get(path.size() - 1).getCoordinates()[1], Color.DARKGREY); // kohdepisteen varjays
        
        String fs = System.getProperty("file.separator");
            
        File file = new File(fs + "results" + fs  + name + ".png"); 
        
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(wImage, null), "png", file);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}
