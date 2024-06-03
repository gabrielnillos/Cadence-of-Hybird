/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package thecadenceofhybird;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Gabriel Nillos
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //reading levelProgress file
        InputStream is = getClass().getClassLoader().getResourceAsStream("thecadenceofhybird/saveFile.csv");
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(isr);
        
        String line;
        // gonna need to fix this reader to include coordinates soon
        while ((line = reader.readLine()) != null) {
            String[] details = line.split(",");
            new Level(details[0], details[1]);
        }
        
        reader.close();
        
        //reading currentLevel file
        InputStream is2 = getClass().getClassLoader().getResourceAsStream("thecadenceofhybird/currentLevel.csv");
        InputStreamReader isr2 = new InputStreamReader(is2);
        BufferedReader reader2 = new BufferedReader(isr2);
        
        String line2;
        // gonna need to fix this reader to include coordinates soon
        while ((line2 = reader2.readLine()) != null) {
            String details = line2;
            Level.currentLevel = Integer.valueOf(details);
        }
        
        reader.close();
        
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        
        
        int[][] coordinates = new int[9][16];
        int[][] coordinatesTwo = new int[9][16];
        int[][] coordinatesThree = new int[9][16];
        Snakebird snakebird1 = new Snakebird(3, "Arthur", 1, 1, 5 ,7); 
        Snakebird snakebird2 = new Snakebird(2, "Benedict", 1, 1, 5 ,4);
        Snakebird snakebird3 = new Snakebird(2, "Carlos", 1, 1, 10 ,5); 
        Food food1 = new Food(1, "Cherry", 11, 6, "cherry.png"); 
        Food food2 = new Food(1, "Apple", 8, 5, "apple.png");
        Food food3 = new Food(2, "Banana", 11, 6, "banana.png");
        
        coordinates[4][3] = 1;coordinates[4][4] = 1;coordinates[4][5] = 1;coordinates[4][6] = 1;coordinates[3][9] = 1;coordinates[8][3] = 1;
        coordinates[8][4] = 1;coordinates[8][5] = 1;coordinates[8][6] = 1;coordinates[7][7] = 1;coordinates[7][8] = 1;coordinates[7][9] = 1;
        coordinates[7][10] = 1;coordinates[7][11] = 1;coordinates[7][12] = 1;
        
        coordinates[8][7] = 9;coordinates[8][8] = 9;coordinates[8][9] = 9;coordinates[8][10] = 9;coordinates[8][11] = 9;coordinates[8][12] = 9;
        
        coordinates[1][9] = 10;
        
        Level level1 = new Level("Beyond the Walls", coordinates, snakebird1, food1);
        
        
        
        coordinatesTwo[1][2] = 1;coordinatesTwo[2][5] = 1;coordinatesTwo[2][7] = 1;coordinatesTwo[4][3] = 1;coordinatesTwo[5][4] = 1;coordinatesTwo[5][5] = 1;
        coordinatesTwo[5][6] = 1;coordinatesTwo[5][11] = 1;coordinatesTwo[3][12] = 1;
        
        coordinatesTwo[5][3] = 9;coordinatesTwo[6][3] = 9;coordinatesTwo[7][3] = 9;coordinatesTwo[8][3] = 9;coordinatesTwo[6][4] = 9;coordinatesTwo[7][4] = 9;
        coordinatesTwo[8][4] = 9;coordinatesTwo[6][5] = 9;coordinatesTwo[7][5] = 9;coordinatesTwo[8][5] = 9;coordinatesTwo[6][6] = 9;coordinatesTwo[6][11] = 9;
        coordinatesTwo[7][11] = 9;coordinatesTwo[8][11] = 9;coordinatesTwo[4][12] = 9;coordinatesTwo[5][12] = 9;coordinatesTwo[6][12] = 9;coordinatesTwo[7][12] = 9;
        coordinatesTwo[8][12] = 9;
        
        coordinatesTwo[1][12] = 10;
        
        food1.setFoodXIndex(6);
        food1.setFoodYIndex(2);
        food2.setFoodXIndex(2);
        food2.setFoodYIndex(2);
        
        Level level2 = new Level("The Precipice", coordinatesTwo, snakebird2, food1, food2);
        
        coordinatesThree[8][4] = 1; coordinatesThree[4][4] = 1; coordinatesThree[2][5] = 1; coordinatesThree[1][6] = 1; coordinatesThree[1][7] = 1; coordinatesThree[7][6] = 1; 
        coordinatesThree[7][7] = 1; coordinatesThree[6][8] = 1; coordinatesThree[6][9] = 1; coordinatesThree[6][10] = 1; coordinatesThree[6][11] = 1; coordinatesThree[6][12] = 1; 
        
        coordinatesThree[5][4] = 9; coordinatesThree[8][5] = 9; coordinatesThree[7][5] = 9; coordinatesThree[6][5] = 9; coordinatesThree[5][5] = 9; coordinatesThree[4][5] = 9; 
        coordinatesThree[3][5] = 9; coordinatesThree[8][6] = 9; coordinatesThree[8][7] = 9; coordinatesThree[8][8] = 9; coordinatesThree[8][9] = 9; coordinatesThree[8][10] = 9; 
        coordinatesThree[8][11] = 9; coordinatesThree[8][12] = 9; coordinatesThree[7][8] = 9; coordinatesThree[7][9] = 9; coordinatesThree[7][10] = 9; coordinatesThree[7][11] = 9; 
        coordinatesThree[7][12] = 9; coordinatesThree[3][6] = 9; coordinatesThree[3][7] = 9; coordinatesThree[3][8] = 9; coordinatesThree[4][8] = 9; coordinatesThree[2][6] = 9; 
        coordinatesThree[2][7] = 9; coordinatesThree[2][8] = 9;
        
        coordinatesThree[1][3] = 10;
        
        food2.setFoodXIndex(7);
        food2.setFoodYIndex(4);
        food3.setFoodXIndex(14);
        food3.setFoodYIndex(5);
        
        Level level3 = new Level("Fruit Loops", coordinatesThree, snakebird3, food2, food3);
        Snakebird l4snakebird = new Snakebird(3, "Vincent", 1, 1, 5 ,7);
        Food l4food1 = new Food(1, "Cherry", 11, 6, "images/cherry.png");
        Food l4food2 = new Food(2, "Apple", 8, 5, "images/cherry.png");
        Level lvl4 = new Level("Level 4", coordinates, snakebird1, l4food1);
        
        Snakebird l5snakebird = new Snakebird(3, "Vincent", 1, 1, 5 ,7);
        Food l5food1 = new Food(1, "Cherry", 11, 6, "images/cherry.png");
        Food l5food2 = new Food(2, "Apple", 8, 5, "images/cherry.png");
        Level lvl5 = new Level("Level 5", coordinates, snakebird1, l5food1);
        
        Snakebird l6snakebird = new Snakebird(3, "Vincent", 1, 1, 5 ,7);
        Food l6food1 = new Food(1, "Cherry", 11, 6, "images/cherry.png");
        Food l6food2 = new Food(2, "Apple", 8, 5, "images/cherry.png");
        Level lvl6 = new Level("Level 6", coordinates, snakebird1, l6food1);
        
        Snakebird l7snakebird = new Snakebird(3, "Vincent", 1, 1, 5 ,7);
        Food l7food1 = new Food(1, "Cherry", 11, 6, "images/cherry.png");
        Food l7food2 = new Food(2, "Apple", 8, 5, "images/cherry.png");
        Level lvl7 = new Level("Level 7", coordinates, snakebird1, l7food1);
        
        Snakebird l8snakebird = new Snakebird(3, "Vincent", 1, 1, 5 ,7);
        Food l8food1 = new Food(1, "Cherry", 11, 6, "images/cherry.png");
        Food l8food2 = new Food(2, "Apple", 8, 5, "images/cherry.png");
        Level lvl8 = new Level("Level 8", coordinates, snakebird1, l8food1);
        
        Snakebird l9snakebird = new Snakebird(3, "Vincent", 1, 1, 5 ,7);
        Food l9food1 = new Food(1, "Cherry", 11, 6, "images/cherry.png");
        Food l9food2 = new Food(2, "Apple", 8, 5, "images/cherry.png");
        Level lvl9 = new Level("Level 9", coordinates, snakebird1, l9food1);
        
        Snakebird l10snakebird = new Snakebird(3, "Vincent", 1, 1, 5 ,7);
        Food l10food1 = new Food(1, "Cherry", 11, 6, "images/cherry.png");
        Food l10food2 = new Food(2, "Apple", 8, 5, "images/cherry.png");
        Level lvl10 = new Level("Level 10", coordinates, snakebird1, l10food1);
        
        Snakebird l11snakebird = new Snakebird(3, "Vincent", 1, 1, 5 ,7);
        Food l11food1 = new Food(1, "Cherry", 11, 6, "images/cherry.png");
        Food l11food2 = new Food(2, "Apple", 8, 5, "images/cherry.png");
        Level lvl11 = new Level("Level 11", coordinates, snakebird1, l11food1);
        
        Snakebird l12snakebird = new Snakebird(3, "Vincent", 1, 1, 5 ,7);
        Food l12food1 = new Food(1, "Cherry", 11, 6, "images/cherry.png");
        Food l12food2 = new Food(2, "Apple", 8, 5, "images/cherry.png");
        Level lvl12 = new Level("Level 12", coordinates, snakebird1, l12food1);
        
      
    }

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) { 
        // Accessing the levelList
        ArrayList<Level> levels = Level.getLevelList();
        // Debugging: Access each level using .get() and print its name
        
        System.out.println("Accessing levels using .get():"); 
        for (int i = 0; i < levels.size(); i++) {
            Level level = levels.get(i);
            System.out.println("Level at index " + i + ": " + level.getName());
        } 

        launch(args);
    }
    
}
