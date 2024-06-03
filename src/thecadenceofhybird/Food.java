/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thecadenceofhybird;

/**
 *
 * @author Gabriel Nillos
 */
public class Food {
  private int lengthIncrease;
  private String foodName;
  private int foodXIndex,  foodYIndex;
  public String imageSrc;

  public Food (int l, String n, int foodXIndex, int foodYIndex,  String i){
    lengthIncrease = l;
    foodName = n;
    this.foodXIndex = foodXIndex;
    this.foodYIndex = foodYIndex;
    imageSrc = i;
  }

    public int getLengthIncrease() {
        return lengthIncrease;
    }
   
    public String getFoodName() {
        return foodName;
    }
    
    public int getFoodX(){
        return foodXIndex;
    }
    
    public int getFoodY(){
        return foodYIndex;
    }

    
    public void setFoodXIndex(int foodXIndex) {
        this.foodXIndex = foodXIndex;
    }

    public void setFoodYIndex(int foodYIndex) {
        this.foodYIndex = foodYIndex;
    }
    
  
  
}