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
public class BellmanFord implements PathFinder {
    MapPoint[][] visited;    
    
    @Override
    public List<MapPoint> findPath(double x1, double y1, double x2, double y2, MapHandler map, int unit) {
        try {
            
            if (map.getMap() == null) {
                throw new Exception("No map loaded");
            }
            
            //Valmistelut
            
            LinkedList<MapPoint> llStack = new LinkedList<>();
            
            int w = (int) map.getMap().getWidth() / unit;
            int h = (int) map.getMap().getHeight() / unit;
            
            MapPoint[][] mapPoints = new MapPoint[w][h];
            Boolean[][] visited = new Boolean[w][h];
            
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    visited[i][j] = false;
                }
            }
            int posX = (int) (x1 / unit);
            int posY = (int) (y1 / unit);
            
            //Asetetaan aloituspiste
            
            MapPoint start = new MapPoint(x1, y1);
            start.setDistance(0);
            
            mapPoints[posX][posY] = start;
            
            llStack.add(start);
            int arvo = 0;
            while (!llStack.isEmpty()) { //loop
                arvo++;
                MapPoint next = llStack.pollFirst();
                double[] coords = next.getCoordinates();
                int pX = (int) coords[0] / unit; //Käännetään karttapiste taulukkoon
                int pY = (int) coords[1] / unit;
                
                if (!visited[pX][pY]) {
                    visited[pX][pY] = true;
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) { //Lisätään viereiset pisteet
                            
                            // Ohitetaan pisteet kartan ulkopuolella
                            if (pX <= 0 && i == -1 || pY <= 0 && j == -1) {
                                continue; 
                            }
                            if (pX >= w - 2 && i == 1 || pY >= h - 2 && j == 1) {
                                continue;
                            }
                            
                            if((i == j || -i == j) && i == 0) {
                                continue; // ohitetaan sama piste
                            } 
                                
                            if (mapPoints[pX + i][pY + j] == null) {
                                mapPoints[pX + i][pY + j] = new MapPoint(coords[0] + i * unit, coords[1] + j * unit, next); //Mikäli karttapiste ei olemassa, se luodaan
                            }
                            double d = next.getDistance() + map.distance(coords[0], coords[1], coords[0] + i * unit, coords[1] + j * unit); // lasketaan pisteen etäisyys
                            
                            if (mapPoints[pX + i][pY + j].trySetDistance(d)) {
                                mapPoints[pX + i][pY + j].setPrevious(next);
                                llStack.add(mapPoints[pX + i][pY + j]);
                            }
                        }
                    }
                }    
            }
            System.out.println("Points visited: " + arvo);
            
            int bX = (int) (x2 / unit);
            int bY = (int) (y2 / unit);
            
            MapPoint point = mapPoints[bX][bY];
            Tools t = new Tools();
            this.visited = mapPoints;
            return t.buildPath(point);
            
        } catch (Exception e) {
            System.out.println("Calculation stopped due to " + e);
        }
        
        return null;
    }
    @Override
    public MapPoint[][] getVisited() {
        return visited;
    }

    @Override
    public String getName() {
        return "bellman-ford";
    }
}
