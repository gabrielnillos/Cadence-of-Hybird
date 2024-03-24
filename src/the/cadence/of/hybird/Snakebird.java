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
  private int headXIndex;
  private int headYIndex;
  private float timing;
  private float timeInterval;

  Scanner sc = new Scanner(System.in);

  public Snakebird(int l, String n, float t, float ti, int x, int y){
    length = l;
    name = n;
    timing = t;
    timeInterval = ti;
    headXIndex = x;
    headYIndex = y;
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
        return headXIndex;
    }
    public int getHeadY() {
        return headYIndex;
    }
    
}
