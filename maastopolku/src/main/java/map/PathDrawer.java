/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import javafx.embed.swing.JFXPanel;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javax.imageio.ImageIO;

/**
 *
 * @author Sami
 */
public class PathDrawer {
    public void draw(MapHandler map, List<MapPoint> path){
        
        WritableImage wImage = new WritableImage((int)map.getMap().getWidth(),(int)map.getMap().getHeight());
        PixelWriter writer = wImage.getPixelWriter();
        
        writer.setPixels(0, 0, (int)map.getMap().getWidth(),(int)map.getMap().getHeight(), map.getMap().getPixelReader(), 0, 0);
        
        
        Iterator iterator = path.iterator();
        iterator.next();
        
        while(iterator.hasNext()){
            MapPoint point = (MapPoint) iterator.next();
            
            int x1 = (int) point.getPrevious().x;
            int y1 = (int) point.getPrevious().y;
            
            int x2 = (int) point.x;
            int y2 = (int) point.y;
            
            int d=1;
            if(x1>x2) d=-1;
            
            double k = 0;
            if(x1 != x2)k = (y1-y2)/(x1 -x2);
            double c = y2-k*x2;
            
            writer.setColor(x2, y2, Color.DARKGREY);
            
            for(int i=x1;i!=x2;i+=d){
                writer.setColor(i, (int)(k*i+c), Color.DARKGREY);
            }
            
            
        }
        
        File file = new File("results\\path.png");
        
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(wImage, null), "png", file);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}
