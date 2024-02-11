/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game.Objects;

import java.awt.Graphics;
import java.util.LinkedList;
/**
 *
 * @author Karel
 */
public class Handler {
    
    private LinkedList<GameObject> objects = new LinkedList<GameObject>();
    private LinkedList<GameObject> userInterface = new LinkedList<GameObject>();
    private LinkedList<GameObject> scene = new LinkedList<GameObject>();
    
    private GameObject tmpObject;
            
    public Handler(){
        
    }
    
    /**
     * Object physics
     * @param delta - difference between last 2 frames
     */
    public void tick(double delta){
        for(int i = 0; i < objects.size(); i++){
            tmpObject = objects.get(i);
            tmpObject.tick(delta, objects);
        }
    }
    
    /**
     * Object visuals
     * @param g Graphics object
     * @param delta - difference between last 2 frames
     */
    public void render(Graphics g,double delta){
        for(int i = 0; i < objects.size(); i++){
            tmpObject = objects.get(i);
            
            tmpObject.render(g, delta);
        }
        for(int i = 0; i < scene.size(); i++){
            tmpObject = scene.get(i);
            
            tmpObject.render(g, delta);
        } 
        for(int i = 0; i < userInterface.size(); i++){
            tmpObject = userInterface.get(i);
            
            tmpObject.render(g, delta);
        } 
    }
    
    /**
     * Function to add game object
     * @param object - game object to add to the array 
     */
    public void addObject(GameObject object){
        objects.add(object);
    }
    /**
     * 
     * @param object - game object to add to the array 
     * @param type - type of object you want to remove
     *  UI - for user interface rendered at the end
     *  scene - for the game
     */
    public void addObject(GameObject object, String type){
        switch(type){
            case"UI":
                userInterface.add(object);
                break;
            case"scene":
                scene.add(object);
            default:
                objects.add(object);
        }
    }
    
    /**
     * Function to remove game object
     * @param id - id of object you want to remove
     */
    public void removeObject(int id){
        objects.remove(id);
    }
    /**
     * 
     * @param id - id of object you want to remove
     * @param type - type of object you want to remove
     */
    public void removeObject(int id, String type){
                switch(type){
            case"UI":
                userInterface.remove(id);
                break;
            case"scene":
                scene.remove(id);
            default:
                objects.remove(id);
        }
    }
    
    /**
     * Returns list of objects
     * @return LinkedList of objects
     */
    public LinkedList<GameObject> getObjects(){
        return objects;
    }
    /**
     * Returns list of objects
     * @param type
     * @return LinkedList of objects by type 
     */
    public LinkedList<GameObject> getObjects(String type){
        switch(type){
            case"UI":
                return userInterface;
            case"scene":
                return scene;
            default:
                return objects;
        }
    }
    
    /**
     * Get objects Count
     * @return returns the amount of all objects
     */
    public int getObjectsCount(){
        return objects.size();
    }
    public int getObjectsCount(String type){
        switch(type){
            case"all":
                return userInterface.size() + scene.size() + objects.size();
            case"UI":
                return userInterface.size();
            case"scene":
                return scene.size();
            default:
                return 0;
        }
    }
}
