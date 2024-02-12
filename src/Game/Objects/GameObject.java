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
public abstract class GameObject {
    protected int x;
    protected int y;
    protected int w;
    protected int h;
    protected int id;
    protected float velX;
    protected float velY;
    public boolean interactable = true;
    protected ObjectType type;
    
    /**
     * Creates game object
     * @param x - X position of the object
     * @param y - Y position of the object
     * @param w - width of the object
     * @param h - height of the object
     * @param type - type of the object
     */
    public GameObject(int x, int y, int w, int h, ObjectType type){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.type = type;
        this.id++;
    }
    
    /**
     * Returns unique ID of the object
     * @return returns unique id
     */
    public int getID(){
        return id;
    }
    /**
     * Returns type of the game object
     * @return type of the game object
     */
    public ObjectType getType(){
        return type;
    }
    /**
     * Positions functions
     * @param x - X position
     * @param y - Y position
     */
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    /**
     * Returns X
     * @return - X position of the object
     */
    public int getX(){
        return this.x;
    }
    
    /**
     * Returns Y
     * @return - Y position of the object
     */
    public int getY(){
        return this.y;
    }
    
    /**
     * Size functions
     * @param w - width of the object
     * @param h - height of the object
     */
    public void setSize(int w, int h){
        this.w = w;
        this.h = h;
    }
    
    /**
     * Returns Width
     * @return - width of the object
     */
    public int getWidth(){
        return this.w;
    }
    
    /**
     * Returns Height
     * @return - height of the object
     */
    public int getHeight(){
        return this.h;
    }
    
    /**
     * 
     * @return - returns the velocity on X axis
     */
    public float getVelX(){
        return this.velX;
    }
    /**
     * 
     * @return - returns the velocity on Y axis
     */
    public float getVelY(){
        return this.velY;
    }
    
    /**
     * 
     * @param velX - velocity on X axis
     */
    public void setVelX(float velX){
        this.velX = velX;
    }
    /**
     * 
     * @param velY - velocity on the Y axis
     */
    public void setVelY(float velY){
        this.velY = velY;
    }
    
    /**
     * Returns if the Object is interactable
     * @return true if is interactable 
     */
    public boolean interactable() {
        return interactable;
    }
    
    /**
     * Object's physics
     * @param delta - difference between last 2 frames 
     * @param objects - LinkedList of available objects
     */
    public abstract void tick(double delta, LinkedList<GameObject> objects);
    
    /**
     * Object's visuals
     * @param g - Graphics object
     * @param delta - difference between last 2 frames
     */
    public abstract void render(Graphics g,double delta);

    
    
}
