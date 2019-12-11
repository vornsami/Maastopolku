package systems;


import functions.AStar;
import functions.BellmanFord;
import functions.Dijkstra;
import functions.PathFinder;
import java.awt.MouseInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
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
public class Main extends Application {
    
    double start[];
    double end[];
    
    public static void main(String[] args) {
        
        
        Application.launch(args);
        
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        MapHandler map = this.askMap();
        if (map != null) {
            int unit = this.askUnit();
            if(unit > 0) {
                setup(stage, map, unit);
            }
        }
    }
    
    public void setup(Stage stage, MapHandler map, int unit) {
        
        AnchorPane pane = new AnchorPane();
        Scene scene = new Scene(pane);
        
        Image mapImage = map.getMap();
        ImageView imgView = new ImageView(mapImage); 
        
        imgView.setOnMousePressed((event) -> {
            if (start == null) {
                start = new double[2];
                start[0] = event.getX();
                start[1] = event.getY();
                
                System.out.println(start[0] + ", " + start[1]);
            } else if (end == null) {
                end = new double[2];
                end[0] = event.getX();
                end[1] = event.getY();
                
                this.runPathfinders(map, unit, start, end);
                stage.close();
            }
        });
        
        
        
        
        
        
        
        AnchorPane.setTopAnchor(imgView, 10.0);
        AnchorPane.setLeftAnchor(imgView, 10.0);
        AnchorPane.setRightAnchor(imgView, 10.0);
        AnchorPane.setBottomAnchor(imgView, 10.0);
        
        pane.getChildren().add(imgView);
        
        stage.setScene(scene);
        stage.setMinWidth(250);
        stage.setMinHeight(200);
        stage.show();
        
    }
    
    
    private MapHandler askMap() {
        Scanner reader = new Scanner(System.in);
        
        System.out.println("Which map do you want to load?");
        String input = reader.nextLine();
        MapHandler map = new MapHandler();
        
        if (input.equals("run tests")) {
            (new Tester()).test();
        } else if (map.loadMap(input)) {
            return map;
        } else {
            System.out.println("Failed to load map with name \"" + input + "\". Please note that maps have to be in .png format. Maps are to be inputted without their file formats.");
        }
        return null;
    }
    
    private int askUnit() {
        Scanner reader = new Scanner(System.in);
    
        System.out.println("Please input the unit distance.");
        String input = reader.nextLine();
        if (input.matches("\\d+") && !input.equals("0")) {
            return Integer.parseInt(input);
        } else {
            System.out.println("Please input a valid number");
        }
        return -1;
    }
    
    private void runPathfinders(MapHandler map, int unit, double[] start, double[] end){
        List<PathFinder> pathfinder = new ArrayList<>();
        Collections.addAll(pathfinder, new BellmanFord(), new Dijkstra(), new AStar());

        pathfinder.forEach(a -> {
            long s = System.currentTimeMillis();
            List<MapPoint> path = a.findPath(start[0], start[1], end[0], end[1], map, unit);
            long t = System.currentTimeMillis() - s;
            if (path == null) {
                System.out.println("No path found for " + a.getName());
            } else { 
                System.out.println(a.getName() + ": Points visited: " + a.getVisitCount() + ", Distance to target: " + path.get(path.size() - 1).getDistance() + ", Time taken to reach " + t + "ms");
                (new PathDrawer()).draw(map, path, a.getName() + "Path", a.getVisited());
            }
        });
    }
}

