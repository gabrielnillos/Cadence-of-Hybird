/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package the.cadence.of.hybird;

/**
 *
 * @author Gabriel Nillos
 */
import java.util.*;

    

public class Snakebird implements Moves{
  private String name;
  private int length;
  private int headX;
  private int headY;
  private int[][] snakebirdCoordinates = new int[12][21];
  private float timing;
  private float timeInterval;

  Scanner sc = new Scanner(System.in);

  public Snakebird(int l, String n, float t, float ti, int x, int y){
    length = l;
    name = n;
    timing = t;
    timeInterval = ti;
    headX = x;
    headY = y;
    snakebirdCoordinates[headY][headX] = 2; //2 = head ; 1 = body
    for(x = 1; x < length; x++ ){
        snakebirdCoordinates[headY][headX-x] = 1;
    }
  }
  
  

  @Override public void moveLeft(Level level) {
      
  }
  
  @Override public void moveRight() {
      
  }
  
  @Override public void moveDown(){
      
  }
  
  @Override public void moveUp(){
      
  }

  public void eat(Food food){
      
  }
   
    public int getHeadX() {
        return headX;
    }
    public int getHeadY() {
        return headY;
    }
    public int[][] getSnakebirdCoordinates() {
        return snakebirdCoordinates;
    }
  
}
