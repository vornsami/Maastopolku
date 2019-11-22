/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

import java.util.LinkedList;
import java.util.List;
import map.MapHandler;
import map.MapPoint;

/**
 *
 * @author Sami
 */
public class AStar implements PathFinder{
    
    @Override
    public List<MapPoint> findPath(double x1,double y1,double x2,double y2,MapHandler map, int unit){
        
        LinkedList<MapPoint> llStack = new LinkedList<>();
        
        Tools t = new Tools();
        
        int w = (int) map.getMap().getWidth()/unit;
        int h = (int) map.getMap().getHeight()/unit;
        MapPoint[][] mapPoints = new MapPoint[w][h];
        
        int ix = (int) x1/unit;
        int iy = (int) y1/unit;
        
        
        mapPoints[ix][iy] = new MapPoint(x1,y1);
        mapPoints[ix][iy].setDistance(0.0);
        
        mapPoints[ix][iy].setDistanceScore(t.calcHeurestic(x1, y1, x2, y2));
        
        llStack.add(mapPoints[ix][iy]);
        int arvo = 0;
        while(!llStack.isEmpty()){
            arvo++;
            MapPoint next = llStack.pollFirst();
            double[] coords = next.getCoordinates();
            if(next.getDistanceScore() - next.getDistance() < unit){
                System.out.println("Points visited: " + arvo);
                return t.buildPath(next);
            }
            
            int pX =(int)coords[0]/unit;
            int pY =(int)coords[1]/unit;
            
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){ //Lis�t��n viereiset pisteet
                    if(pX <= 0 && i == -1 || pY <= 0 && j == -1) continue;
                    if(pX >= w-2 && i == 1 || pY >= h-2 && j == 1) continue;
                            
                    if((i == j || -i == j) && i == 0) continue; // ohitetaan sama piste
                                
                    if(mapPoints[pX+i][pY+j] == null){
                        mapPoints[pX+i][pY+j] = new MapPoint(coords[0]+i*unit,coords[1]+j*unit,next); //Mik�li karttapiste ei olemassa, se luodaan
                    }
                    double d = next.getDistance() + map.distance(coords[0], coords[1], coords[0]+i*unit, coords[1]+j*unit); // lasketaan pisteen et�isyys
                       
                    if(mapPoints[pX+i][pY+j].trySetDistance(d)){
                        mapPoints[pX+i][pY+j].setPrevious(next);
                        double[] mpCoords = mapPoints[pX+i][pY+j].getCoordinates();
                        mapPoints[pX+i][pY+j].setDistanceScore(d+t.calcHeurestic(mpCoords[0], mpCoords[1], x2, y2));
                        t.compareAdd(llStack, mapPoints[pX+i][pY+j]);
                    }
                }
            }
        }
        
        return null;
    }
    
}
