/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import map.MapHandler;
import map.MapPoint;
import map.MapPointComparator;

/**
 *
 * @author Sami
 */
public class Dijkstra implements PathFinder {
    MapPoint[][] visited;    
    
    @Override
    public List<MapPoint> findPath(double x1, double y1, double x2, double y2, MapHandler map, int unit) {
        
        try {
            
            if (map.getMap() == null) {
                throw new Exception("No map loaded");
            }
        
            Comparator comparator = new MapPointComparator();
            PriorityQueue<MapPoint> pQueue = new PriorityQueue<>(comparator);
            
            Tools t = new Tools();

            int w = (int) map.getMap().getWidth() / unit;
            int h = (int) map.getMap().getHeight() / unit;
            MapPoint[][] mapPoints = new MapPoint[w][h];

            int ix = (int) x1 / unit;
            int iy = (int) y1 / unit;

            mapPoints[ix][iy] = new MapPoint(x1, y1);
            mapPoints[ix][iy].setDistance(0.0);
            mapPoints[ix][iy].setDistanceScore(0.0);

            pQueue.add(mapPoints[ix][iy]);
            int arvo = 0;
            
            while (!pQueue.isEmpty()) {
                arvo++;
                MapPoint next = pQueue.poll();
                double[] coords = next.getCoordinates();
                
                int pX = (int) coords[0] / unit;
                int pY = (int) coords[1] / unit;
                
                if (pX == (int) (x2 / unit) && pY == (int) (y2 / unit)) {
                    System.out.println("Points visited: " + arvo);
                    visited = mapPoints; // talletetaan tutkitut pisteet niiden piirtoa varten
                    return t.buildPath(next, unit);
                }
                this.checkNext(pQueue, next, mapPoints, map, unit, w, h, coords);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    private void checkNext(PriorityQueue pQueue, MapPoint next, MapPoint[][] mapPoints, MapHandler map, int unit, int width, int heigth, double[] coords){ // tarkastelee kaikki pisteen viereiset pisteet
        
        int pX = (int) coords[0] / unit;
        int pY = (int) coords[1] / unit;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) { //Lisätään viereiset pisteet

                // Ohitetaan pisteet kartan ulkopuolella
                if (pX <= 0 && i == -1 || pY <= 0 && j == -1) {
                    continue;
                }
                if (pX >= width - 2 && i == 1 || pY >= heigth - 2 && j == 1) {
                    continue;
                }

                if ((i == j || -i == j) && i == 0) {
                    continue; // ohitetaan sama piste
                } 

                if (mapPoints[pX + i][pY + j] == null) {
                    mapPoints[pX + i][pY + j] = new MapPoint(coords[0] + i * unit, coords[1] + j * unit, next); //Mikäli karttapiste ei olemassa, se luodaan
                }
                double distance = next.getDistance() + map.distance(coords[0], coords[1], coords[0] + i * unit, coords[1] + j * unit); // lasketaan pisteen etäisyys

                if (mapPoints[pX + i][pY + j].trySetDistance(distance)) { // paras etäisyys
                    mapPoints[pX + i][pY + j].setPrevious(next);
                    mapPoints[pX + i][pY + j].setDistanceScore(distance);
                    pQueue.add(mapPoints[pX + i][pY + j]);
                }
            }
        }
    }
    
    @Override
    public MapPoint[][] getVisited() {
        return visited;
    }

    @Override
    public String getName() {
        return "dijkstra";
    }
}
