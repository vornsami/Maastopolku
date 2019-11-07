
import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;
import map.MapHandler;

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
            
        
        if(input.matches("\\d+")){
                
            int num = Integer.parseInt(input);
                
                //TODO: lataa oikea kartta
               
            MapHandler map = new MapHandler();
            map.loadMap(num);
                
                
            System.out.println("Please input the unit distance");
                
            input = reader.nextLine();
                
            if(input.matches("\\d+")){
                    
                num = Integer.parseInt(input);
                    
                    //TODO käynnistä haku
                    
                    
                    int col = 16777216 + map.getMap().getPixelReader().getArgb(num, num);
                System.out.println("Leveys on: " + map.getMap().getWidth() + "Korkeus on: " + map.getMap().getHeight() + "num: " + num);
                System.out.println(col);
                    
                    
                    
            } else  System.out.println("Please input a number.");
                
                
        } else  System.out.println("Please input a number.");
            
            
            
    }
        
        
}

