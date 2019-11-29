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
    double d;
    double hd;
    MapPoint p;
    
    public MapPoint(double x, double y) {
        
        this.x = x;
        this.y = y;
        d = Double.MAX_VALUE;
        hd = Double.MAX_VALUE;
    }
    
    public MapPoint(double x, double y, MapPoint previous) {
        
        this.x = x;
        this.y = y;
        d = Double.MAX_VALUE;
        p = previous;
        
    }
    
    public void setDistance(double distance) {
        d = distance;
    }
    public void setDistanceScore(double distanceScore) {
        hd = distanceScore;
    }
    public void setPrevious(MapPoint previous) {
        p = previous;
    }
    public boolean trySetDistance(double distance) {
        if (d > distance) {
            d = distance;
            return true;
        }
        return false;
    }
    
    public double[] getCoordinates() {
        return new double[]{x, y};
    }
    
    public double getDistance() {
        return d; 
    }
    public double getDistanceScore() {
        return hd; 
    }
    
    public MapPoint getPrevious() {
        return p;
    } 
    
    public boolean hasPrevious() {
        return this.p != null;
    }
    @Override
    public String toString() {
        return  x + "," + y + ", distance: " + d;
    }
}
