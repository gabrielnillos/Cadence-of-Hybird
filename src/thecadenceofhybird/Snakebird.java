/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thecadenceofhybird;

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
  
  

  @Override public boolean moveLeft(Level level) {
      int headX, headY;
      for(int y = 0; y <= level.getCoordinates().length -1; y++){
            for(int x = 0; x <= level.getCoordinates()[y].length -1; x++){
                if(level.getCoordinates()[y][x] == 3){
                    headX = x;
                    headY = y;
                    
                    //checks if snakebird is moving towards itself or a ground block. If yes, snakebird wont be able to move
                    if(level.getCoordinates()[headY][headX-1] == 4 || level.getCoordinates()[headY][headX-1] == 1 || level.getCoordinates()[headY][headX-1] == 9){
                        return false;
                    }
                    else{
                        
                        //checks for food
                        if(level.getCoordinates()[headY][headX-1] == 51){
                            eat(level.getFoodList().get(0));
                        }
                        if(level.getCoordinates()[headY][headX-1] == 52){
                            eat(level.getFoodList().get(1));
                        }
                        if(level.getCoordinates()[headY][headX-1] == 53){
                            eat(level.getFoodList().get(2));
                        }
                    }
                    
                    
                }
            }
        }
      
      return true;
      //temporary
  }
  
  @Override public void moveRight() {
      
  }
  
  @Override public void moveDown(){
      
  }
  
  @Override public void moveUp(){
      
  }

  public void eat(Food food){
      this.length += food.getLengthIncrease();
  }
   
    public int getHeadX() {
        return headXIndex;
    }
    public int getHeadY() {
        return headYIndex;
    }
    public int getLength() {
        return length;
    }
}
