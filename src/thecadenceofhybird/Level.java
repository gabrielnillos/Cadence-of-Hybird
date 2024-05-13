/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thecadenceofhybird;

import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author Gabriel Nillos
 */
public class Level {
    private String name;
    private boolean escaped = false;
    private int[][] levelCoordinates = new int[9][16];
    private ArrayList<Food> foodList = new ArrayList<>();

    private ArrayList<Snakebird> snakebirdList = new ArrayList<>();
    public static ArrayList<Level> levelList = new ArrayList<>();
    public static int currentLevel = 1;
    public Snakebird snakebirdInControl;
    
    public Level(String n, int[][] l){
        name = n;
        escaped = false;
        levelCoordinates = l;
        levelList.add(this);
    }
    
  public Level(String name, int[][] ground, Snakebird sb1, Food f1) {
    escaped = false;
    snakebirdList.add(sb1);
    foodList.add(f1);
    levelList.add(this);

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
  }  
  
    public Level(String name, int[][] ground, Snakebird sb1, Food f1, Food f2) {
    snakebirdList.add(sb1);
    foodList.add(f1);
    foodList.add(f2);
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
  }  
  
   public int[][] getCoordinates(){
       return levelCoordinates;
   }
   
   public static Level getCurrentLevel() {
        return levelList.get(currentLevel - 1);
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
    public static ArrayList<Level> getLevelList(){
        return levelList;
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

