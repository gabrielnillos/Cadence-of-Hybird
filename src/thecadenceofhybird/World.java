/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thecadenceofhybird;

/**
 * @author Rafael Tagle
 */

public class World {
    private static String name, fileName, gui;
    
    public World (String n, String f, String g){
        name = n;
        fileName = f;
        gui = g;
    }
    
    public static String getName(){
        return name;
    }
    public static String getFileName(){
        return fileName;
    }
    public static String getFXML(){
        return gui;
    }
}
