
import functions.AStar;
import functions.Dijkstra;
import functions.PathFinder;
import java.util.List;
import java.util.Scanner;
import map.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sami
 */
public class Main {
    public static void main(String[] args) {
        
        Scanner reader = new Scanner(System.in);
        
            
        System.out.println("Which map do you want to load?");
            
        String input = reader.nextLine();
        
        MapHandler map = new MapHandler();
        
        if(map.loadMap(input)){
                
             
            System.out.println("Please input the unit distance.");
                
            input = reader.nextLine();
                
            if(input.matches("\\d+")){
                    
                int num = Integer.parseInt(input);
                    
                System.out.println("Please input the start point.(a1;a2)");
               
                input = reader.nextLine();
                
                if(input.matches("\\d+;\\d+")){
                    String[] start = input.split(";");
                    
                    System.out.println("Please input the end point.(b1;b2)");
               
                    input = reader.nextLine();
                    
                    if(input.matches("\\d+;\\d+")){
                        
                        String[] end = input.split(";");
                        
                        long s = System.currentTimeMillis(); 
                        
                        PathFinder pathfinder = new Dijkstra();
                        
                        List<MapPoint> path = pathfinder.findPath(Double.parseDouble(start[0]), Double.parseDouble(start[1]), Double.parseDouble(end[0]), Double.parseDouble(end[1]), map, num);
                        
                        long e = System.currentTimeMillis(); 
                        
                        System.out.println("Dijkstra: Distance to target: " + path.get( path.size()-1).getDistance() + ", Time taken to reach " + (e-s) + "ms");
                        
                        PathDrawer drawer = new PathDrawer();
                        
                        drawer.draw(map,path,"dijkstraPath");
                        
                        s = System.currentTimeMillis(); 
                        
                        pathfinder = new AStar();
                        path = pathfinder.findPath(Double.parseDouble(start[0]), Double.parseDouble(start[1]), Double.parseDouble(end[0]), Double.parseDouble(end[1]), map, num);
                        
                        e = System.currentTimeMillis();
                        System.out.println("A*: Distance to target: " + path.get( path.size()-1).getDistance() + ", Time taken to reach " + (e-s) + "ms");
                        
                        drawer.draw(map,path,"aStarPath");
                        
                    }else  System.out.println("Incorrect format.");
                }else  System.out.println("Incorrect format.");
                    
                    
                    
            } else  System.out.println("Please input a number.");
        } else  System.out.println("Failed to load map with name \"" + input +"\". Please note that maps have to be in .png format. Maps are to be inputted without their file formats.");
            
        System.out.println("Run stopped.");
            
    }
}

