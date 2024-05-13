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
  private int[][] snakebirdCoords = new int[9][16];

  Scanner sc = new Scanner(System.in);

  public Snakebird(int l, String n, float t, float ti, int x, int y){
    length = l;
    name = n;
    timing = t;
    timeInterval = ti;
    headXIndex = x;
    headYIndex = y;
    
    for (int i = 1; i <= length; i++){
        snakebirdCoords[headYIndex][headXIndex-i+1] = i;
    }

    
  }
  
  

  @Override public void moveLeft(Level level) {
      Boolean status = false;
      int headX, headY;
      outerloop:
      for(int y = 0; y < level.getCoordinates().length; y++){
            for(int x = 0; x < level.getCoordinates()[y].length ; x++){
                if(level.getCoordinates()[y][x] == 3){
                    headX = x;
                    headY = y;
                    if(headX == 0){}
                    else{
                    //checks if snakebird is moving towards itself or a ground block or map border. If yes, snakebird wont be able to move
                    if(level.getCoordinates()[headY][headX-1] == 4 || level.getCoordinates()[headY][headX-1] == 1 || level.getCoordinates()[headY][headX-1] == 9){
                        status = false;
                    }
                    
                    else{
                        status = true;
                        
                                    //System.out.println("1 - 1x");
                        //checks for food
                        switch (level.getCoordinates()[headY][headX-1]) {
                            case 51:
                                eat(level.getFoodList().get(0));
                                break;
                            case 52:
                                eat(level.getFoodList().get(1));
                                break;
                            case 53:
                                eat(level.getFoodList().get(2));
                                break;
                            default:
                                break;
                        }
                        break outerloop;
                        
                    }
                }
                    
                }
            }
        } 
      
      if(status == true){
                        //next lines removes all snakebird coordinates from levelCoordinates
                        for(int b = 0; b < level.getCoordinates().length; b++){  
                            for(int a = 0; a < level.getCoordinates()[b].length; a++){
                                 if(level.getCoordinates()[b][a] == 3 || level.getCoordinates()[b][a] == 4){
                                    level.getCoordinates()[b][a] = 0;
                                }
                            }
                        }
                        
                        outerloop:
                        for(int b = 0; b < level.getCoordinates().length; b++){  
                            for(int a = 0; a < level.getCoordinates()[b].length; a++){
                                if(this.snakebirdCoords[b][a] == 1) {
                                    //1 means head of snakebird
                                    this.snakebirdCoords[b][a-1] = 1;
                                    //sets new head location
                                    this.snakebirdCoords[b][a] = 50;
                                    //temporary placeholder 
                                    
                                    break outerloop;
                                }
                            }
                        }
                        
                        for(int i = 2; i<=this.getLength(); i++){
                            firstouterloop:
                            for(int b = 0; b < level.getCoordinates().length; b++){  
                                for(int a = 0; a < level.getCoordinates()[b].length; a++){
                                    if(this.snakebirdCoords[b][a] == i){
                                        secondouterloop:
                                        for(int g = 0; g < level.getCoordinates().length; g++){  
                                            for(int f = 0; f < level.getCoordinates()[g].length; f++){
                                                if(this.snakebirdCoords[g][f] == 50){
                                                    this.snakebirdCoords[g][f] = this.snakebirdCoords[b][a];
                                                    this.snakebirdCoords[b][a] = 50;
                                                    break firstouterloop;
                                                }
                                                
                                            }
                                        }
                                        
                                    }
                                }
                            }
                        }
                        
                        for(int b = 0; b < level.getCoordinates().length; b++){  
                            for(int a = 0; a < level.getCoordinates()[b].length; a++){
                                if(this.snakebirdCoords[b][a] == 50){
                                    this.snakebirdCoords[b][a] = 0;
                                }
                            }
                        }
                        
                        //next lines set the snakebird coordinates at levelCoordinates :)
                        for(int b = 0; b < level.getCoordinates().length; b++){  
                            for(int a = 0; a < level.getCoordinates()[b].length; a++){
                                 if(this.snakebirdCoords[b][a] == 1){
                                    level.getCoordinates()[b][a] = 3;
                                }
                                 else if(this.snakebirdCoords[b][a] > 1){
                                    level.getCoordinates()[b][a] = 4;
                                }
                            }
                        }
      }
  }
  
  @Override public void moveRight(Level level) {
      
      /*
      -Supposed logic sequence:
      
      Loop 1 checks every coordinate of the level towards direction of movement
        -If ground or snakebird, no movement (1,9 ground - 4 snakebird)
        -If food, eat
            - activate movement:
                -Loop 2 (b,a) - remove all levelCoordinate snakebird coordinates (make 0)
                -Loop 3 of coordinates (b,a)
                    -If snakebirdCoords[y][x] = 1, make snakebirdCoords[y][x+1] = 1 and the former = 50
                    -Loop i=2; i <= snakebird.getLength()
                        -If snakebirdCoords[y][x] = 50, get snakebirdCoords[b][a] = i and swap values with snakebirdCoords[y][x]
      
      */
      Boolean status = false;
      int headX, headY;
      outerloop:
      for(int y = 0; y < level.getCoordinates().length; y++){
            for(int x = 0; x < level.getCoordinates()[y].length ; x++){
                if(level.getCoordinates()[y][x] == 3){
                    headX = x;
                    headY = y;
                    if(headX==15){}
                    else{
                    //checks if snakebird is moving towards itself or a ground block or map border. If yes, snakebird wont be able to move
                    if(level.getCoordinates()[headY][headX+1] == 4 || level.getCoordinates()[headY][headX+1] == 1 || level.getCoordinates()[headY][headX+1] == 9){
                        status = false;
                    }
                    
                    else{
                        status = true;
                        
                                    //System.out.println("1 - 1x");
                        //checks for food
                        switch (level.getCoordinates()[headY][headX+1]) {
                            case 51:
                                eat(level.getFoodList().get(0));
                                break;
                            case 52:
                                eat(level.getFoodList().get(1));
                                break;
                            case 53:
                                eat(level.getFoodList().get(2));
                                break;
                            default:
                                break;
                        }
                        break outerloop;
                        
                    }
                    
                }
                }
                
            }
        } 
      
      if(status == true){
          
                                    //System.out.println("2 - 1x");
                        //next lines removes all snakebird coordinates from levelCoordinates
                        for(int b = 0; b < level.getCoordinates().length; b++){  
                            for(int a = 0; a < level.getCoordinates()[b].length; a++){
                                 if(level.getCoordinates()[b][a] == 3 || level.getCoordinates()[b][a] == 4){
                                    //System.out.println("3 - 3x");
                                    //System.out.println(level.getCoordinates()[b][a]);
                                    level.getCoordinates()[b][a] = 0;
                                    //System.out.println(level.getCoordinates()[b][a]);
                                }
                            }
                        }
                        
                        outerloop:
                        for(int b = 0; b < level.getCoordinates().length; b++){  
                            for(int a = 0; a < level.getCoordinates()[b].length; a++){
                                if(this.snakebirdCoords[b][a] == 1) {
                                    //1 means head of snakebird
                                    this.snakebirdCoords[b][a+1] = 1;
                                    //sets new head location
                                    this.snakebirdCoords[b][a] = 50;
                                    //temporary placeholder 
                                    
                                    
                                    //System.out.println("4 - 1x");
                                    //System.out.println(this.snakebirdCoords[b][a+1]);
                                    //System.out.println(this.snakebirdCoords[b][a]);
                                    //System.out.println(b);
                                    //System.out.println(a);
                                    
                                    break outerloop;
                                    
                                }
                            }
                        }
                        
                        for(int i = 2; i<=this.getLength(); i++){
                            firstouterloop:
                            for(int b = 0; b < level.getCoordinates().length; b++){  
                                for(int a = 0; a < level.getCoordinates()[b].length; a++){
                                    if(this.snakebirdCoords[b][a] == i){
                                        //System.out.println("=====");
                                        //System.out.println(snakebirdCoords[b][a]);
                                        //System.out.println(i);
                                        //System.out.println("=====");
                                        secondouterloop:
                                        for(int g = 0; g < level.getCoordinates().length; g++){  
                                            for(int f = 0; f < level.getCoordinates()[g].length; f++){
                                                if(this.snakebirdCoords[g][f] == 50){
                                                    //System.out.println("----------------------");
                                                    //System.out.println(snakebirdCoords[b][a]);
                                                    //System.out.println(snakebirdCoords[g][f]);
                                                    this.snakebirdCoords[g][f] = this.snakebirdCoords[b][a];
                                                    this.snakebirdCoords[b][a] = 50;
                                                    //System.out.println(snakebirdCoords[b][a]);
                                                    //System.out.println(snakebirdCoords[g][f]);
                                                    //System.out.println("----------------------");
                                                    break firstouterloop;
                                                }
                                                
                                            }
                                        }
                                        
                                    }
                                }
                            }
                        }
                        
                        for(int b = 0; b < level.getCoordinates().length; b++){  
                            for(int a = 0; a < level.getCoordinates()[b].length; a++){
                                if(this.snakebirdCoords[b][a] == 50){
                                    this.snakebirdCoords[b][a] = 0;
                                }
                            }
                        }
                        
                        //next lines set the snakebird coordinates at levelCoordinates :)
                        for(int b = 0; b < level.getCoordinates().length; b++){  
                            for(int a = 0; a < level.getCoordinates()[b].length; a++){
                                 if(this.snakebirdCoords[b][a] == 1){
                                    level.getCoordinates()[b][a] = 3;
                                }
                                 else if(this.snakebirdCoords[b][a] > 1){
                                    level.getCoordinates()[b][a] = 4;
                                }
                            }
                        }
      }
      
  }
  
  @Override public void moveDown(Level level){
      Boolean status = false;
      int headX, headY;
      outerloop:
      for(int y = 0; y < level.getCoordinates().length; y++){
            for(int x = 0; x < level.getCoordinates()[y].length ; x++){
                if(level.getCoordinates()[y][x] == 3){
                    headX = x;
                    headY = y;
                    if(headY==8){}
                    else{
                    //checks if snakebird is moving towards itself or a ground block or map border. If yes, snakebird wont be able to move
                    if(level.getCoordinates()[headY+1][headX] == 4 || level.getCoordinates()[headY+1][headX] == 1 || level.getCoordinates()[headY+1][headX] == 9){
                        status = false;
                    }
                    
                    else{
                        status = true;
                        
                                    //System.out.println("1 - 1x");
                        //checks for food
                        switch (level.getCoordinates()[headY+1][headX]) {
                            case 51:
                                eat(level.getFoodList().get(0));
                                break;
                            case 52:
                                eat(level.getFoodList().get(1));
                                break;
                            case 53:
                                eat(level.getFoodList().get(2));
                                break;
                            default:
                                break;
                        }
                        break outerloop;
                        
                    }
                    
                }
                }
            }
        } 
      
      if(status == true){
                        //next lines removes all snakebird coordinates from levelCoordinates
                        for(int b = 0; b < level.getCoordinates().length; b++){  
                            for(int a = 0; a < level.getCoordinates()[b].length; a++){
                                 if(level.getCoordinates()[b][a] == 3 || level.getCoordinates()[b][a] == 4){
                                    level.getCoordinates()[b][a] = 0;
                                }
                            }
                        }
                        
                        outerloop:
                        for(int b = 0; b < level.getCoordinates().length; b++){  
                            for(int a = 0; a < level.getCoordinates()[b].length; a++){
                                if(this.snakebirdCoords[b][a] == 1) {
                                    //1 means head of snakebird
                                    this.snakebirdCoords[b+1][a] = 1;
                                    //sets new head location
                                    this.snakebirdCoords[b][a] = 50;
                                    //temporary placeholder 
                                    
                                    break outerloop;
                                }
                            }
                        }
                        
                        for(int i = 2; i<=this.getLength(); i++){
                            firstouterloop:
                            for(int b = 0; b < level.getCoordinates().length; b++){  
                                for(int a = 0; a < level.getCoordinates()[b].length; a++){
                                    if(this.snakebirdCoords[b][a] == i){
                                        secondouterloop:
                                        for(int g = 0; g < level.getCoordinates().length; g++){  
                                            for(int f = 0; f < level.getCoordinates()[g].length; f++){
                                                if(this.snakebirdCoords[g][f] == 50){
                                                    this.snakebirdCoords[g][f] = this.snakebirdCoords[b][a];
                                                    this.snakebirdCoords[b][a] = 50;
                                                    break firstouterloop;
                                                }
                                                
                                            }
                                        }
                                        
                                    }
                                }
                            }
                        }
                        
                        for(int b = 0; b < level.getCoordinates().length; b++){  
                            for(int a = 0; a < level.getCoordinates()[b].length; a++){
                                if(this.snakebirdCoords[b][a] == 50){
                                    this.snakebirdCoords[b][a] = 0;
                                }
                            }
                        }
                        
                        //next lines set the snakebird coordinates at levelCoordinates :)
                        for(int b = 0; b < level.getCoordinates().length; b++){  
                            for(int a = 0; a < level.getCoordinates()[b].length; a++){
                                 if(this.snakebirdCoords[b][a] == 1){
                                    level.getCoordinates()[b][a] = 3;
                                }
                                 else if(this.snakebirdCoords[b][a] > 1){
                                    level.getCoordinates()[b][a] = 4;
                                }
                            }
                        }
      }
  }
  
  @Override public void moveUp(Level level){
      Boolean status = false;
      int headX, headY;
      outerloop:
      for(int y = 0; y < level.getCoordinates().length; y++){
            for(int x = 0; x < level.getCoordinates()[y].length ; x++){
                if(level.getCoordinates()[y][x] == 3){
                    headX = x;
                    headY = y;
                    if(headY==0){}
                    else{
                    //checks if snakebird is moving towards itself or a ground block or map border. If yes, snakebird wont be able to move
                    if(level.getCoordinates()[headY-1][headX] == 4 || level.getCoordinates()[headY-1][headX] == 1 || level.getCoordinates()[headY-1][headX] == 9){
                        status = false;
                    }
                    
                    else{
                        status = true;
                        
                                    //System.out.println("1 - 1x");
                        //checks for food
                        switch (level.getCoordinates()[headY-1][headX]) {
                            case 51:
                                eat(level.getFoodList().get(0));
                                break;
                            case 52:
                                eat(level.getFoodList().get(1));
                                break;
                            case 53:
                                eat(level.getFoodList().get(2));
                                break;
                            default:
                                break;
                        }
                        break outerloop;
                        
                    }
                    
                    
                }
                }
            }
        } 
      
      if(status == true){
          
                                    //System.out.println("2 - 1x");
                        //next lines removes all snakebird coordinates from levelCoordinates
                        for(int b = 0; b < level.getCoordinates().length; b++){  
                            for(int a = 0; a < level.getCoordinates()[b].length; a++){
                                 if(level.getCoordinates()[b][a] == 3 || level.getCoordinates()[b][a] == 4){
                                    //System.out.println("3 - 3x");
                                    //System.out.println(level.getCoordinates()[b][a]);
                                    level.getCoordinates()[b][a] = 0;
                                    //System.out.println(level.getCoordinates()[b][a]);
                                }
                            }
                        }
                        
                        outerloop:
                        for(int b = 0; b < level.getCoordinates().length; b++){  
                            for(int a = 0; a < level.getCoordinates()[b].length; a++){
                                //System.out.println(this.snakebirdCoords[b][a]);
                                if(this.snakebirdCoords[b][a] == 1) {
                                    //1 means head of snakebird
                                    this.snakebirdCoords[b-1][a] = 1;
                                    //sets new head location
                                    this.snakebirdCoords[b][a] = 50;
                                    //temporary placeholder 
                                    
                                    
                                    //System.out.println("4 - 1x");
                                    //System.out.println(this.snakebirdCoords[b-1][a]);
                                    //System.out.println(this.snakebirdCoords[b][a]);
                                    //System.out.println(b);
                                    //System.out.println(a);
                                    
                                    break outerloop;
                                    
                                }
                            }
                        }
                        
                        for(int i = 2; i<=this.getLength(); i++){
                            firstouterloop:
                            for(int b = 0; b < level.getCoordinates().length; b++){  
                                for(int a = 0; a < level.getCoordinates()[b].length; a++){
                                    if(this.snakebirdCoords[b][a] == i){
                                        //System.out.println("=====");
                                        //System.out.println(snakebirdCoords[b][a]);
                                        //System.out.println(i);
                                        //System.out.println("=====");
                                        secondouterloop:
                                        for(int g = 0; g < level.getCoordinates().length; g++){  
                                            for(int f = 0; f < level.getCoordinates()[g].length; f++){
                                                if(this.snakebirdCoords[g][f] == 50){
                                                    //System.out.println("----------------------");
                                                    //System.out.println(snakebirdCoords[b][a]);
                                                    //System.out.println(snakebirdCoords[g][f]);
                                                    this.snakebirdCoords[g][f] = this.snakebirdCoords[b][a];
                                                    this.snakebirdCoords[b][a] = 50;
                                                    //System.out.println(snakebirdCoords[b][a]);
                                                    //System.out.println(snakebirdCoords[g][f]);
                                                    //System.out.println("----------------------");
                                                    break firstouterloop;
                                                }
                                                
                                            }
                                        }
                                        
                                    }
                                }
                            }
                        }
                        
                        for(int b = 0; b < level.getCoordinates().length; b++){  
                            for(int a = 0; a < level.getCoordinates()[b].length; a++){
                                if(this.snakebirdCoords[b][a] == 50){
                                    this.snakebirdCoords[b][a] = 0;
                                }
                            }
                        }
                        
                        //next lines set the snakebird coordinates at levelCoordinates :)
                        for(int b = 0; b < level.getCoordinates().length; b++){  
                            for(int a = 0; a < level.getCoordinates()[b].length; a++){
                                 if(this.snakebirdCoords[b][a] == 1){
                                    level.getCoordinates()[b][a] = 3;
                                }
                                 else if(this.snakebirdCoords[b][a] > 1){
                                    level.getCoordinates()[b][a] = 4;
                                }
                            }
                        }
      }
      
  }

  public void eat(Food food){
      this.length += food.getLengthIncrease();
  }
   public int[][] getSnakebirdCoords(){
       return snakebirdCoords;
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
    public void fall(Level level){
        int anchoredSegments;
        for(int i = 1; i<=this.getLength(); i++){
                            firstouterloop:
                            for(int b = 0; b < level.getCoordinates().length; b++){  
                                for(int a = 0; a < level.getCoordinates()[b].length; a++){
                                    if(this.snakebirdCoords[b][a] == i){
                                       if(this.snakebirdCoords[b+1][a] == 1 || this.snakebirdCoords[b+1][a] == 9){
                                           
                                       }
                                        
                                    }
                                }
                            }
                        }
    }
}
