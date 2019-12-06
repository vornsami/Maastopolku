/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import map.MapPoint;

/**
 *
 * @author Sami
 */
public class Tools {
    
    public double calcHeurestic(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
    
    public void compareAdd(List<MapPoint> list, MapPoint point) { // Lis‰‰ pisteen listaan distanceScore-arvo j‰rjesstykseen.
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
    
    public void removeDuplicatePoints(List<MapPoint> list, MapPoint point) { // poistaa listasta annetun pisteen duplikaatit, mik‰li niiden et‰isyysarvo on huonompi.
        double[] pointCoords = point.getCoordinates();
        for (int i = 0; i < list.size(); i++) {
            double[] coords =  list.get(i).getCoordinates();
            if ((coords[0] == pointCoords[0] && coords[1] == pointCoords[1]) && list.get(i).getDistanceScore() >= point.getDistanceScore()) {
                list.remove(i);
            }
        }
    }
    
    
    public List<MapPoint> buildPath(MapPoint point, int unit) { // Palauttaa polun alusta loppuun listana.
        List<MapPoint> finalPath = new ArrayList<>();
        MapPoint tempPoint = point;
        while (true) {
            finalPath.add(0, tempPoint);
                
            if (!tempPoint.hasPrevious()) {
                break;
            }
            tempPoint = tempPoint.getPrevious();
        }
        this.checkCorrectness(finalPath, unit);
        return finalPath;    
    }
    
    private void checkCorrectness(List<MapPoint> path, int unit) { // korjaa virheen, jossa et‰isyydet ovat tietyiss‰ tilanteissa jostakin syyst‰ v‰‰rin Astar-luokassa
        Iterator iterator = path.iterator();
        iterator.next();
        while (true) {
            MapPoint point = (MapPoint) iterator.next();
            MapPoint previous = point.getPrevious();
            
            int x1 = (int) previous.getCoordinates()[0];
            int y1 = (int) previous.getCoordinates()[1];
            
            int x2 = (int) point.getCoordinates()[0];
            int y2 = (int) point.getCoordinates()[1];
            
            double delta = point.getDistance() - previous.getDistance();
            
            if (x1 == x2 || y1 == y2) {
                if (delta >= unit + 0.0001 || delta <= unit - 0.0001) {
                    // System.out.println("There is a mistake, expected " + unit + ", was " + delta);
                    this.fixDistances(path, point, unit - delta);
                }
            } else {
                if (delta >= (Math.sqrt(2) * unit) + 0.0001 || delta <= (Math.sqrt(2) * unit) - 0.0001) {
                    // System.out.println("There is a mistake, expected " + Math.sqrt(2) + ", was " + delta);
                    this.fixDistances(path, point, (Math.sqrt(2) * unit) - delta);
                }
            }
            
            if (!iterator.hasNext()) {
                break;
            }
        }
    }
    private void fixDistances(List<MapPoint> path, MapPoint point, double amount) {
        MapPoint p = path.get(path.size() - 1);
        
        p.setDistance(p.getDistance() + amount);
        
        while (p != point) {
            p.getPrevious();
            p.setDistance(p.getDistance() + amount);
        }
    }
}
