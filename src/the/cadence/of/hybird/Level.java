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
    private int[][] exitPortal;
    private int[][] levelCoordinates = new int[12][21];
    
    public Level(String n, int[][] e, int[][] l){
        name = n;
        exitPortal = e;
        levelCoordinates = l;
    }
    
}

