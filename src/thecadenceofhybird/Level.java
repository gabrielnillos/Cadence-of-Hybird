/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thecadenceofhybird;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * A level contains the name, escape status, and different ArrayLists of level objects, namely Food, Snakebird 
and the Level object itself.
 * @author Gabriel Nillos
 */ 

public class Level implements Serializable{
    
    private String name;
    
    public boolean escaped = false;
    public int[][] levelCoordinates = new int[9][16];
    public ArrayList<Food> foodList = new ArrayList<>();
    public ArrayList<Snakebird> snakebirdList = new ArrayList<>();
    public static ArrayList<Level> levelList = new ArrayList<>();
    public static ArrayList<Level> levelProgressList = new ArrayList<>();
    public static int currentLevel;
    public Snakebird snakebirdInControl;
    
    /**
   * Creates an instance of an Item and adds it to the itemList
   * @param n Name of item
   * @param s Completion status of a level
   */
    public Level(String n, String s){
        name = n;
        if(s.equals("escaped")){
            escaped = true;
        }
        else if(s.equals("incomplete")){
            escaped = false;
        }
        levelProgressList.add(this);
    }
    
    /**
   * Creates an instance of an Item and adds it to the itemList
   * @param name Name of Level
   * @param ground 2D Array which holds the coordinates of each element in a level.
   * @param sb1 Snake element within a level.
   * @param f1 Food element within a level.
   */
    public Level(String name, int[][] ground, Snakebird sb1, Food f1) {
        escaped = false;
        snakebirdList.add(sb1);
        foodList.add(f1);
        levelList.add(this);

        this.name = name;
        levelCoordinates = ground;
         
        for (int i = 1; i <= sb1.getLength(); i++){
            int x, y;
            x = sb1.coordsX.get(i-1);
            y = sb1.coordsY.get(i-1);
            if(i-1 == 0){
                levelCoordinates[y][x] = 3;
            }
            else{
                levelCoordinates[y][x] = 4;
            }
        }

        levelCoordinates[f1.getFoodY()][f1.getFoodX()] = 51;
        snakebirdInControl = snakebirdList.get(0);
    }  
  
    public Level(String name, int[][] ground, Snakebird sb1, Food f1, Food f2) {
        escaped = false;
        snakebirdList.add(sb1);
        foodList.add(f1);
        foodList.add(f2);
        levelList.add(this);

        this.name = name;
        levelCoordinates = ground;
        /*for(int x = 0; x <= sb1.getLength() - 1; x++){
            if(x==0) levelCoordinates[sb1.getHeadY()][sb1.getHeadX()-x] = 3;
            else levelCoordinates[sb1.getHeadY()][sb1.getHeadX()-x] = 4;
        }*/

        for (int i = 1; i <= sb1.getLength(); i++){
            int x, y;
            x = sb1.coordsX.get(i-1);
            y = sb1.coordsY.get(i-1);
            if(i-1 == 0){
                levelCoordinates[y][x] = 3;
            }
            else{
                levelCoordinates[y][x] = 4;
            }
        }
        levelCoordinates[f1.getFoodY()][f1.getFoodX()] = 51;
        levelCoordinates[f2.getFoodY()][f2.getFoodX()] = 52;
        snakebirdInControl = snakebirdList.get(0);
    }  
    
    public Level(String name, int[][] ground, Snakebird sb1, Food f1, Food f2, Food f3) {
    snakebirdList.add(sb1);
    foodList.add(f1);
    foodList.add(f2);
    foodList.add(f3);
    this.name = name;
    levelCoordinates = ground;
    /*for(int x = 0; x <= sb1.getLength() - 1; x++){
        if(x==0) levelCoordinates[sb1.getHeadY()][sb1.getHeadX()-x] = 3;
        else levelCoordinates[sb1.getHeadY()][sb1.getHeadX()-x] = 4;
    }*/
    
    for(int y = 0; y <= sb1.getSnakebirdCoords().length -1; y++){
            for(int x = 0; x <= sb1.getSnakebirdCoords()[y].length -1; x++){
                if(sb1.getSnakebirdCoords()[y][x] == 1){
                    levelCoordinates[y][x] = 3;
                }
                else if (sb1.getSnakebirdCoords()[y][x] > 1){
                    levelCoordinates[y][x] = 4;
                }
            }
        }
    levelCoordinates[f1.getFoodY()][f1.getFoodX()] = 51;
    levelCoordinates[f2.getFoodY()][f2.getFoodX()] = 52;
    levelCoordinates[f3.getFoodY()][f3.getFoodX()] = 53;
    snakebirdInControl = snakebirdList.get(0);
    } 

     public int[][] getCoordinates(){
         return levelCoordinates;
     }

     public static Level getCurrentLevel() {
          return levelList.get(currentLevel);
     }

     public ArrayList<Food> getFoodList(){
         return foodList;
     }

     public ArrayList<Snakebird> getSnakebirdList(){
         return snakebirdList;
     }
   
    public String getName(){
        return name;
    }
    public boolean getEscaped(){
        return escaped;
    }
    public String convertEscapedToString(){
        String esc = null;
        if(escaped){
            esc = "escaped";
        }
        else if(!escaped){
            esc = "incomplete";
        }
        return esc;
    }
    public static void saveLevels(ArrayList<Level> levelList) throws IOException{
        try{ 
            FileWriter writer = new FileWriter("C:\\Users\\Ghil Tagle\\OneDrive\\Documents\\NetBeansProjects\\Cadence-of-Hybird-branchNEW\\src\\thecadenceofhybird\\saveFile.csv", false);
            // use for each loop and add each level again after the end of a level B)

            for (Level i : levelProgressList) {
                System.out.println("Saving..." + i.getName());
                writer.append(i.getName());
                writer.append(",");
                writer.append(i.convertEscapedToString());
                writer.append(",");
                writer.append("");
                writer.append("\n");
            }    
            writer.flush();
            writer.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void saveCurrentLevel(int cl){
        currentLevel = cl;
        try{ 
            FileWriter writer = new FileWriter("C:\\Users\\Ghil Tagle\\OneDrive\\Documents\\NetBeansProjects\\Cadence-of-Hybird-branchNEW\\src\\thecadenceofhybird\\currentLevel.csv", false);
            System.out.println("Saving current level..." + Level.getLevelByIndex(cl).getName());
            writer.append(String.valueOf(cl));
            writer.flush();
            writer.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static ArrayList<Level> getLevelList(){
        return levelList;
    }
    public static ArrayList<Level> getLevelProgressList(){
        return levelProgressList;
    }
    public static int getListLength() {
        return levelList.size();
    }
    public static Level getLevelByIndex(int index) throws ArrayIndexOutOfBoundsException{
        if (index < 0 || index >= Level.getListLength()) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return levelList.get(index);
    }
    
    
 
    
    public void setEscaped(boolean e){
        escaped = e;
    }
   
}

