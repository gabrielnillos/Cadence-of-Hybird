/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package the.cadence.of.hybird;

import java.util.ArrayList;

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
    
    public Level(String n, int[][] l){
        name = n;
        levelCoordinates = l;
        levelList.add(this);
    }
    
  public Level(String name, int[][] ground, Snakebird sb1, Food f1) {
    snakebirdList.add(sb1);
    foodList.add(f1);
    this.name = name;
    levelCoordinates = ground;
    for(int x = 0; x <= sb1.getLength() - 1; x++){
        if(x==0) levelCoordinates[sb1.getHeadY()][sb1.getHeadX()-x] = 3;
        else levelCoordinates[sb1.getHeadY()][sb1.getHeadX()-x] = 4;
    }
    levelCoordinates[f1.getFoodY()][f1.getFoodX()] = 5;
    
  }  
  
    public Level(String name, int[][] ground, Snakebird sb1, Food f1, Food f2) {
    snakebirdList.add(sb1);
    foodList.add(f1);
    foodList.add(f2);
    this.name = name;
    levelCoordinates = ground;
  }  
  
   public int[][] getCoordinates(){
       return levelCoordinates;
   }
   
   public static Level getCurrentLevel() {
        return levelList.get(currentLevel - 1);
    }
    
}

