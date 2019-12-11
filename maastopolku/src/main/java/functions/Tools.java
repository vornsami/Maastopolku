/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

import java.util.ArrayList;
import java.util.List;
import map.MapPoint;

/**
 *
 * @author Sami
 */
public class Tools {
    
    public double calcHeurestic(double x1, double y1, double x2, double y2) {
        double x = Math.abs(x1 - x2);
        double y = Math.abs(y1 - y2);
        
        if (x > y) {
            return Math.sqrt(2) * y + x - y;
        } else {
            return Math.sqrt(2) * x + y - x;
        }
    }
    
    public List<MapPoint> buildPath(MapPoint point) { // Palauttaa polun alusta loppuun listana.
        List<MapPoint> finalPath = new ArrayList<>();
        MapPoint tempPoint = point;
        while (true) {
            finalPath.add(0, tempPoint);
                
            if (!tempPoint.hasPrevious()) {
                break;
            }
            tempPoint = tempPoint.getPrevious();
        }
        return finalPath;    
    }
}
