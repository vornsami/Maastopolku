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
        return Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
    }
    
    public void compareAdd(List<MapPoint> list, MapPoint point) {
        for (int i = 0; 0 < list.size(); i++) {
            if (list.get(i).getDistanceScore() > point.getDistanceScore()) {
                list.add(i, point);
                break;
            } else if (i == list.size() - 1) {
                list.add(i + 1, point);
                break;
            }
        }
        if (list.isEmpty()) {
            list.add(point);
        }
    }
    
    public void removeDuplicatePoints(List<MapPoint> list, MapPoint point){
        double[] pointCoords = point.getCoordinates();
        for (int i = 0; i < list.size(); i++) {
            double[] coords =  list.get(i).getCoordinates();
            if ((coords[0] == pointCoords[0] && coords[1] == pointCoords[1]) && list.get(i).getDistanceScore() >= point.getDistanceScore()) {
                list.remove(i);
            }
        }
    }
    
    public List<MapPoint> buildPath(MapPoint point) {
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
