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
    
    public Level(String n, int[][] l){
        name = n;
        levelCoordinates = l;
    }
    
  public Level(String name, int[][] ground, Snakebird sb1, Food f1) {
    snakebirdList.add(sb1);
    foodList.add(f1);
    this.name = name;
    levelCoordinates = ground;
  }  
  
    public Level(String name, int[][] ground, Snakebird sb1, Food f1, Food f2) {
    snakebirdList.add(sb1);
    foodList.add(f1);
    foodList.add(f2);
    this.name = name;
    levelCoordinates = ground;
  }  
  
  
    
}

