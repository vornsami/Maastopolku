/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systems;

import functions.AStar;
import functions.BellmanFord;
import functions.Dijkstra;
import functions.PathFinder;
import java.util.ArrayList;
import java.util.Collections;
import map.MapHandler;

/**
 *
 * @author Sami
 */
public class Tester {
    public void test() {
        MapHandler map100 = new MapHandler();
        MapHandler map500 = new MapHandler();
        MapHandler map1000 = new MapHandler();
        
        map100.loadMap("blank100");
        map500.loadMap("blank500");
        map1000.loadMap("blank1000");
        
        
        MapHandler[] maps = new MapHandler[]{map100, map500, map1000};
        
        
        ArrayList<PathFinder> pathfinder = new ArrayList<>();
        Collections.addAll(pathfinder, new BellmanFord(), new Dijkstra(), new AStar());
        
        System.out.println("Blanks, across\t\t\t100\t\t\t\t500\t\t\t\t1000\n---------------------------------");
        pathfinder.forEach(a -> runTests(maps, a, 1.0));
        System.out.println();
        System.out.println("Blanks, middle\t\t\t100\t\t\t\t500\t\t\t\t1000\n---------------------------------");
        pathfinder.forEach(a -> runTests(maps, a, 0.5));
        System.out.println();
        map100.loadMap("test100");
        map500.loadMap("test500");
        map1000.loadMap("test1000");
        System.out.println();
        System.out.println("Tests, across\t\t\t100\t\t\t\t500\t\t\t\t1000\n---------------------------------");
        pathfinder.forEach(a -> runTests(maps, a, 1.0));
        
        
    }
    
    private void runTests(MapHandler[] maps, PathFinder pathfinder, double percent) {
        System.out.print(pathfinder.getName() + "   \t");
        for (MapHandler map : maps) {
            long s = System.currentTimeMillis();
            pathfinder.findPath(0, 0, map.getMap().getWidth() * percent - 1, map.getMap().getHeight() * percent - 1, map, 1);
            long t = System.currentTimeMillis() - s;
            System.out.print("\t|\t" + t + "ms, " + pathfinder.getVisitCount() + " visited ");
        }
        System.out.println();
        
        
    }
}
