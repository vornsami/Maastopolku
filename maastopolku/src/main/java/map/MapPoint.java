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
public class MapPoint implements Comparator<MapPoint>, Comparable<MapPoint> {
    
    double x;
    double y;
    double d;
    MapPoint p;
    
    public MapPoint(double x,double y){
        
        this.x = x;
        this.y = y;
        d = Double.MAX_VALUE;
        
    }
    
    public MapPoint(double x,double y,MapPoint previous){
        
        this.x = x;
        this.y = y;
        d = Double.MAX_VALUE;
        p = previous;
        
    }
    
    public void setDistance(double distance){
        
        d = distance;
        
    }
    public void setPrevious(MapPoint previous){
        p = previous;
    }
    public boolean trySetDistance(double distance){
        if(d>distance){
            d = distance;
            return true;
        }
        return false;
    }
    
    public double[] getCoordinates(){
        return new double[]{x,y};
    }
    
    public double getDistance(){
        
        return d; 
    }
    
    public MapPoint getPrevious(){
        return p;
    } 
    
    public boolean hasPrevious(){
        return this.p != null;
    }
 


    @Override
    public int compare(MapPoint t, MapPoint t1) {
        
        if(t.d != t1.d) return (int)(t.d - t1.d);
        
        if(t.x != t1.x) return (int) (t.x - t1.x);
        
        return (int) (t.y - t1.y);
        
    }

    @Override
    public int compareTo(MapPoint t) {
        
        return compare(this,t);
        
    }
    @Override
    public String toString(){
        return  x+","+y+", distance: "+d;
    }
}
