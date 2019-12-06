/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.util.Comparator;

/**
 *
 * @author Sami
 */
public class MapPoint {
    
    double x;
    double y;
    double distance;
    double distanceScore;
    MapPoint previous;
    
    public MapPoint(double x, double y) {
        
        this.x = x;
        this.y = y;
        distance = Double.MAX_VALUE;
        distanceScore = Double.MAX_VALUE;
    }
    
    public MapPoint(double x, double y, MapPoint p) {
        
        this.x = x;
        this.y = y;
        distance = Double.MAX_VALUE;
        previous = p;
        
    }
    
    public void setDistance(double d) {
        distance = d;
    }
    public void setDistanceScore(double hd) {
        distanceScore = hd;
    }
    public void setPrevious(MapPoint p) {
        previous = p;
    }
    public boolean trySetDistance(double d) {
        if (distance > d) {
            distance = d;
            return true;
        }
        return false;
    }
    
    public double[] getCoordinates() {
        return new double[]{x, y};
    }
    
    public double getDistance() {
        return distance; 
    }
    public double getDistanceScore() {
        return distanceScore; 
    }
    
    public MapPoint getPrevious() {
        return previous;
    } 
    
    public boolean hasPrevious() {
        return this.previous != null;
    }
    @Override
    public String toString() {
        return  x + ";" + y + ", distance: " + distance;
    }
}
