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
  public ArrayList<Integer> coordsX = new ArrayList<>();
  public ArrayList<Integer> coordsY = new ArrayList<>();
  /*coordsX and coordsY are the coordinates of the <index> segment.
  Ex: CoordsX[0] = 1
        CoordsY[0] = 2
        snakebird head (0th segment) at (1, 2)
  */
  Scanner sc = new Scanner(System.in);

  public Snakebird(int l, String n, float t, float ti, int x, int y){
     this.coordsX.add(x);
     this.coordsY.add(y);
    length = l;
    name = n;
    timing = t;
    timeInterval = ti;
    headXIndex = x;
    headYIndex = y;
    
    for (int i = 1; i < length; i++){
        this.coordsX.add(x-i);
        this.coordsY.add(y);
    }
    
    
    /*
    for (int i = 1; i <= length; i++){
        snakebirdCoords[headYIndex][headXIndex-i+1] = i;
    }
*/
    
  }
  
  

  @Override public void moveLeft(Level level) {
      int headX, headY;
      headX = this.coordsX.get(0);
      headY = this.coordsY.get(0);
      if(level.getCoordinates()[headY][headX-1] != 4 && level.getCoordinates()[headY][headX-1] != 1 && level.getCoordinates()[headY][headX-1] != 9){
          
          if(level.getCoordinates()[headY][headX-1] == 10){
              //panalo na
          }
          else{
          switch (level.getCoordinates()[headY][headX+1]) {
              case 51:
                  eat(level.getFoodList().get(0), level, "left");
                  break;
              case 52:
                  eat(level.getFoodList().get(1), level, "left");
                  break;
              case 53:
                  eat(level.getFoodList().get(2), level, "left");
                  break;
              default:
                  break;
          }
          
          for (int i = 1; i <= this.length; i++){
            //this loop clears the snakebird from the map.
            int x, y;
            x = this.coordsX.get(i-1);
            y = this.coordsY.get(i-1);
            level.getCoordinates()[y][x] = 0;
        }
          
          int previousX = 0, previousY = 0, prevPreviousX = 0, prevPreviousY = 0;
          for (int i = 0; i < this.length; i++){              
            if(i==0){
                previousX = this.coordsX.get(0);
                previousY = this.coordsY.get(0);
                this.coordsX.set(0, this.coordsX.get(0) - 1);
                headX = this.coordsX.get(0);
                level.getCoordinates()[headY][headX] = 3;
            }
            else{
                prevPreviousX = previousX;
                prevPreviousY = previousY;
                previousX = this.coordsX.get(i);
                previousY = this.coordsY.get(i);
                this.coordsX.set(i, prevPreviousX);
                this.coordsY.set(i, prevPreviousY);
                level.getCoordinates()[this.coordsY.get(i)][this.coordsX.get(i)] = 4;
            }
            
        }
      } 
      }
      else{
          
      }
      /*Boolean status = false;
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
                                eat(level.getFoodList().get(0), level, "left");
                                break;
                            case 52:
                                eat(level.getFoodList().get(1), level, "left");
                                break;
                            case 53:
                                eat(level.getFoodList().get(2), level, "left");
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
      }*/
  }
  
  @Override public void moveRight(Level level) {
      int headX, headY;
      headX = this.coordsX.get(0);
      headY = this.coordsY.get(0);
      if(level.getCoordinates()[headY][headX+1] != 4 && level.getCoordinates()[headY][headX+1] != 1 && level.getCoordinates()[headY][headX+1] != 9){
          
          switch (level.getCoordinates()[headY][headX+1]) {
              case 51:
                  eat(level.getFoodList().get(0), level, "right");
                  break;
              case 52:
                  eat(level.getFoodList().get(1), level, "right");
                  break;
              case 53:
                  eat(level.getFoodList().get(2), level, "right");
                  break;
              default:
                  break;
          }
          
          for (int i = 1; i <= this.length; i++){
            //this loop clears the snakebird from the map.
            int x, y;
            x = this.coordsX.get(i-1);
            y = this.coordsY.get(i-1);
            level.getCoordinates()[y][x] = 0;
        }
          
          int previousX = 0, previousY = 0, prevPreviousX = 0, prevPreviousY = 0;
          for (int i = 0; i < this.length; i++){              
            if(i==0){
                previousX = this.coordsX.get(0);
                previousY = this.coordsY.get(0);
                this.coordsX.set(0, this.coordsX.get(0) + 1);
                headX = this.coordsX.get(0);
                level.getCoordinates()[headY][headX] = 3;
            }
            else{
                prevPreviousX = previousX;
                prevPreviousY = previousY;
                previousX = this.coordsX.get(i);
                previousY = this.coordsY.get(i);
                this.coordsX.set(i, prevPreviousX);
                this.coordsY.set(i, prevPreviousY);
                level.getCoordinates()[this.coordsY.get(i)][this.coordsX.get(i)] = 4;
            }
            
        }
          
      }
      /*
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
                        
                        //checks for food. If there is food, snakebird eats it 
                        switch (level.getCoordinates()[headY][headX+1]) {
                            case 51:
                                eat(level.getFoodList().get(0), level, "right");
                                break;
                            case 52:
                                eat(level.getFoodList().get(1), level, "right");
                                break;
                            case 53:
                                eat(level.getFoodList().get(2), level, "right");
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
      }*/
      
  }
  
  @Override public void moveDown(Level level){
      int headX, headY;
      headX = this.coordsX.get(0);
      headY = this.coordsY.get(0);
      if(level.getCoordinates()[headY+1][headX] != 4 && level.getCoordinates()[headY+1][headX] != 1 && level.getCoordinates()[headY+1][headX] != 9){
          
          switch (level.getCoordinates()[headY+1][headX]) {
              case 51:
                  eat(level.getFoodList().get(0), level, "down");
                  break;
              case 52:
                  eat(level.getFoodList().get(1), level, "down");
                  break;
              case 53:
                  eat(level.getFoodList().get(2), level, "down");
                  break;
              default:
                  break;
          }
          
          for (int i = 1; i <= this.length; i++){
            //this loop clears the snakebird from the map.
            int x, y;
            x = this.coordsX.get(i-1);
            y = this.coordsY.get(i-1);
            level.getCoordinates()[y][x] = 0;
        }
          
          int previousX = 0, previousY = 0, prevPreviousX = 0, prevPreviousY = 0;
          for (int i = 0; i < this.length; i++){              
            if(i==0){
                previousX = this.coordsX.get(0);
                previousY = this.coordsY.get(0);
                this.coordsY.set(0, this.coordsY.get(0) + 1);
                headY = this.coordsY.get(0);
                level.getCoordinates()[headY][headX] = 3;
            }
            else{
                prevPreviousX = previousX;
                prevPreviousY = previousY;
                previousX = this.coordsX.get(i);
                previousY = this.coordsY.get(i);
                this.coordsX.set(i, prevPreviousX);
                this.coordsY.set(i, prevPreviousY);
                level.getCoordinates()[this.coordsY.get(i)][this.coordsX.get(i)] = 4;
            }
            
        }
          
      }
      /*
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
                                eat(level.getFoodList().get(0), level, "down");
                                break;
                            case 52:
                                eat(level.getFoodList().get(1), level, "down");
                                break;
                            case 53:
                                eat(level.getFoodList().get(2), level, "down");
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
      }*/
  }
  
  @Override public void moveUp(Level level){
      int headX, headY;
      headX = this.coordsX.get(0);
      headY = this.coordsY.get(0);
      if(level.getCoordinates()[headY-1][headX] != 4 && level.getCoordinates()[headY-1][headX] != 1 && level.getCoordinates()[headY-1][headX] != 9){
          
          switch (level.getCoordinates()[headY-1][headX]) {
              case 51:
                  eat(level.getFoodList().get(0), level, "down");
                  break;
              case 52:
                  eat(level.getFoodList().get(1), level, "down");
                  break;
              case 53:
                  eat(level.getFoodList().get(2), level, "down");
                  break;
              default:
                  break;
          }
          
          for (int i = 1; i <= this.length; i++){
            //this loop clears the snakebird from the map.
            int x, y;
            x = this.coordsX.get(i-1);
            y = this.coordsY.get(i-1);
            level.getCoordinates()[y][x] = 0;
        }
          
          int previousX = 0, previousY = 0, prevPreviousX = 0, prevPreviousY = 0;
          for (int i = 0; i < this.length; i++){              
            if(i==0){
                previousX = this.coordsX.get(0);
                previousY = this.coordsY.get(0);
                this.coordsY.set(0, this.coordsY.get(0) - 1);
                headY = this.coordsY.get(0);
                level.getCoordinates()[headY][headX] = 3;
            }
            else{
                prevPreviousX = previousX;
                prevPreviousY = previousY;
                previousX = this.coordsX.get(i);
                previousY = this.coordsY.get(i);
                this.coordsX.set(i, prevPreviousX);
                this.coordsY.set(i, prevPreviousY);
                level.getCoordinates()[this.coordsY.get(i)][this.coordsX.get(i)] = 4;
            }
            
        }
          
      }
      
      /*
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
                                eat(level.getFoodList().get(0), level, "up");
                                break;
                            case 52:
                                eat(level.getFoodList().get(1), level, "up");
                                break;
                            case 53:
                                eat(level.getFoodList().get(2), level, "up");
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
      */
  }

  public void eat(Food food, Level level, String direction){
      int origLength = this.length;
      int tailX, tailY;
      int temp = 0;
      this.length += food.getLengthIncrease();
        for(int i = 0; i < food.getLengthIncrease(); i++){
            tailX = this.coordsX.get(origLength+i-1);
            tailY = this.coordsY.get(origLength+i-1);
            temp = origLength+i-1;
            System.out.println("temp"+temp);
            System.out.println(tailX + ", " + tailY);
            if("right".equals(direction)){
                if(level.getCoordinates()[tailY][tailX-1] != 1 && level.getCoordinates()[tailY][tailX-1] != 4 && level.getCoordinates()[tailY][tailX-1] != 9){
                    coordsX.add(tailX-1);
                    coordsY.add(tailY);
                }
                else if(level.getCoordinates()[tailY-1][tailX] != 1 && level.getCoordinates()[tailY-1][tailX] != 4 && level.getCoordinates()[tailY-1][tailX] != 9){
                    coordsX.add(tailX);
                    coordsY.add(tailY-1);
                }
                else if(level.getCoordinates()[tailY+1][tailX] != 1 && level.getCoordinates()[tailY+1][tailX] != 4 && level.getCoordinates()[tailY+1][tailX] != 9){
                    coordsX.add(tailX);
                    coordsY.add(tailY+1);
                }
            }
            if("left".equals(direction)){
                if(level.getCoordinates()[tailY][tailX+1] != 1 && level.getCoordinates()[tailY][tailX+1] != 4 && level.getCoordinates()[tailY][tailX+1] != 9){
                    coordsX.add(tailX+1);
                    coordsY.add(tailY);
                }
                else if(level.getCoordinates()[tailY-1][tailX] != 1 && level.getCoordinates()[tailY-1][tailX] != 4 && level.getCoordinates()[tailY-1][tailX] != 9){
                    coordsX.add(tailX);
                    coordsY.add(tailY-1);
                }
                else if(level.getCoordinates()[tailY+1][tailX] != 1 && level.getCoordinates()[tailY+1][tailX] != 4 && level.getCoordinates()[tailY+1][tailX] != 9){
                    coordsX.add(tailX);
                    coordsY.add(tailY+1);
                }
            }
            if("up".equals(direction)){
                if(level.getCoordinates()[tailY+1][tailX] != 1 && level.getCoordinates()[tailY+1][tailX] != 4 && level.getCoordinates()[tailY+1][tailX] != 9){
                    coordsX.add(tailX);
                    coordsY.add(tailY+1);
                }
                else if(level.getCoordinates()[tailY][tailX-1] != 1 && level.getCoordinates()[tailY][tailX-1] != 4 && level.getCoordinates()[tailY][tailX-1] != 9){
                    coordsX.add(tailX-1);
                    coordsY.add(tailY);
                }
                else if(level.getCoordinates()[tailY][tailX+1] != 1 && level.getCoordinates()[tailY][tailX+1] != 4 && level.getCoordinates()[tailY][tailX+1] != 9){
                    coordsX.add(tailX+1);
                    coordsY.add(tailY);
                }
            }
            if("down".equals(direction)){
                if(level.getCoordinates()[tailY-1][tailX] != 1 && level.getCoordinates()[tailY-1][tailX] != 4 && level.getCoordinates()[tailY-1][tailX] != 9){
                    coordsX.add(tailX);
                    coordsY.add(tailY-1);
                }
                else if(level.getCoordinates()[tailY][tailX-1] != 1 && level.getCoordinates()[tailY][tailX-1] != 4 && level.getCoordinates()[tailY][tailX-1] != 9){
                    coordsX.add(tailX-1);
                    coordsY.add(tailY);
                }
                else if(level.getCoordinates()[tailY][tailX+1] != 1 && level.getCoordinates()[tailY][tailX+1] != 4 && level.getCoordinates()[tailY][tailX+1] != 9){
                    coordsX.add(tailX+1);
                    coordsY.add(tailY);
                }
            }
            /*
            for(int b = 0; b < level.getCoordinates().length; b++){
                for(int a = 0; a < level.getCoordinates()[b].length; a++){
                    if(snakebirdCoords[b][a] == i){
                        if("right".equals(direction)){
                                try{snakebirdCoords[b][a-1] = i+1;}
                                catch(NullPointerException e){
                                    try{snakebirdCoords[b-1][a] = i+1;}
                                    catch(NullPointerException f){
                                        snakebirdCoords[b+1][a] = i+1;
                                    }
                                }
                        }
                        else if("left".equals(direction)){
                                try{snakebirdCoords[b][a+1] = this.length;}
                                catch(NullPointerException e){
                                    try{snakebirdCoords[b-1][a] = this.length;}
                                    catch(NullPointerException f){
                                        snakebirdCoords[b+1][a] = this.length;
                                    }
                                }
                        }
                        else if("up".equals(direction)){
                                try{snakebirdCoords[b+1][a] = this.length;}
                                catch(NullPointerException e){
                                    try{snakebirdCoords[b][a-1] = this.length;}
                                    catch(NullPointerException f){
                                        snakebirdCoords[b][a+1] = this.length;
                                    }
                                }
                        }
                        else if("down".equals(direction)){
                                try{snakebirdCoords[b-1][a] = this.length;}
                                catch(NullPointerException e){
                                    try{snakebirdCoords[b][a-1] = this.length;}
                                    catch(NullPointerException f){
                                        snakebirdCoords[b][a+1] = this.length;
                                    }
                                }
                        }
                    }
                }
            }*/
        }
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
    public void setHeadXIndex(int headXIndex) {
        this.headXIndex = headXIndex;
    }
    public void setHeadYIndex(int headYIndex) {
        this.headYIndex = headYIndex;
    }
    
    public int getLength() {
        return length;
    }
    public void fall(Level level){
        ArrayList<Integer> tempCoordsX = new ArrayList<>();
        ArrayList<Integer> tempCoordsY = new ArrayList<>();
        
            for(int i = 0; i < this.getLength(); i++){
                tempCoordsX.add(this.coordsX.get(i));
                tempCoordsY.add(this.coordsY.get(i)+1);
            }
            for (int i = 1; i <= this.length; i++){
                //this loop clears the snakebird location from the level.
                int x, y;
                x = this.coordsX.get(i-1);
                y = this.coordsY.get(i-1);
                level.getCoordinates()[y][x] = 0;
            }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
            coordsX = tempCoordsX;
            coordsY = tempCoordsY;
            //assigns new coordinates from temporary arraylists to the coordinates arraylists
            for(int i = 0; i < this.getLength(); i++){//updates the level coordinates
                if(i==0){
                    System.out.println("new head: " + this.coordsX.get(i) + ", " + this.coordsY.get(i));
                    level.getCoordinates()[this.coordsY.get(i)][this.coordsX.get(i)] = 3;
                }
                else{
                    System.out.println("new segment " + i+1 + ": " + this.coordsX.get(i) + ", " + this.coordsY.get(i));
                    level.getCoordinates()[this.coordsY.get(i)][this.coordsX.get(i)] = 4;
                }
            }
        
        
    }
    
    public Boolean amIAnchored(Level level){
        
        for(int i = 0; i < this.getLength(); i++){
            if(this.coordsY.get(i) == 8){
            return true;
            }
        }
        
        for(int i = 0; i < this.getLength(); i++){
                int underneath = level.getCoordinates()[this.coordsY.get(i)+1][this.coordsX.get(i)];
                if(underneath == 51 || underneath == 52 || underneath == 53 || underneath == 1 || underneath == 2 || underneath == 9){
                    System.out.println("final: true-no more repeat");
                    return true;
                    //true means anchored. no more repeat
                }
        }
        System.out.println("final: false-one more repeat");
        return false;
        //false means not yet anchored. repeat.
    }
    
    public Boolean checkWin(Level level){
        for(int i = 0; i < this.getLength(); i++){
            try{
            if(level.getCoordinates()[this.coordsY.get(i)+1][this.coordsX.get(i)] == 10 || level.getCoordinates()[this.coordsY.get(i)-1][this.coordsX.get(i)] == 10 || level.getCoordinates()[this.coordsY.get(i)][this.coordsX.get(i)+1] == 10 || level.getCoordinates()[this.coordsY.get(i)][this.coordsX.get(i)-1] == 10){
                return true;
            }
            }
            catch(Exception e){}
        }
        return false;
    }
    
    public void setLengthAndCoords(int length, int x, int y) {
        this.length = length;
        this.headXIndex = x;
        this.headYIndex = y;
        this.coordsX.clear();
        this.coordsY.clear();
        for (int i = 1; i < length; i++){
            this.coordsX.add(x-i);
            this.coordsY.add(y);
        }
    }

}

