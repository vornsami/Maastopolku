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
    
    /** Sets the distance of the point from the startpoint
     *
     * @param d distance
     */
    public void setDistance(double d) {
        distance = d;
    }

    /** Sets the distance score of the point
     *
     * @param hd distance score
     */
    public void setDistanceScore(double hd) {
        distanceScore = hd;
    }

    /**Sets the given point as previous to this point
     *
     * @param p the point to be setted
     */
    public void setPrevious(MapPoint p) {
        previous = p;
    }

    /**Sets the distance to given value, if it is smaller than the one already given
     *
     * @param d distance
     * @return returns true if value was changed
     */
    public boolean trySetDistance(double d) {
        if (distance > d) {
            distance = d;
            return true;
        }
        return false;
    }
    
    /**
     *
     * @return returns an array with length of 2 containing the coordinate values of the point {x,y}
     */
    public double[] getCoordinates() {
        return new double[]{x, y};
    }
    
    /**
     *
     * @return returns the distance value of point
     */
    public double getDistance() {
        return distance; 
    }

    /**
     *
     * @return returns the distance score of point
     */
    public double getDistanceScore() {
        return distanceScore; 
    }
    
    /**
     *
     * @return returns the previous point
     */
    public MapPoint getPrevious() {
        return previous;
    } 
    
    /**
     *
     * @return returns true if the point has a previous point. Else returns false.
     */
    public boolean hasPrevious() {
        return this.previous != null;
    }
    @Override
    public String toString() {
        return  x + ";" + y + ", distance: " + distance;
    }
}
