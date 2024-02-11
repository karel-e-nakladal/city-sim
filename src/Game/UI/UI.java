/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game.UI;

import Game.Objects.GameObject;
import Game.Objects.ObjectType;
import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
/**
 *
 * @author Karel
 */
public abstract class UI extends GameObject{
    
    protected Color backgroundColor = new Color(100, 50, 50, 100);
    private boolean animate = false;
    private double animationTimer = 0;
    protected double animationDuration = 1.0;
    
    /**
     * Class for creating UI elements
     * @param x - x position of the UI element
     * @param y - y position of the UI element
     * @param w - width of the UI element
     * @param h - height of the UI element
     */
    public UI(int x, int y, int w, int h){
        super(x, y, w, h, ObjectType.UI);
    }
    
    /**
     * Class for creating UI elements
     * @param x - x position of the UI element
     * @param y - y position of the UI element
     * @param w - width of the UI element
     * @param h - height of the UI element
     * @param type - type of the UI element
     */
    public UI(int x, int y, int w, int h,ObjectType type){
        super(x, y, w, h, type);
    }
    
    /**
     * Class for creating UI elements
     * @param x - x position of the UI element
     * @param y - y position of the UI element
     * @param w - width of the UI element
     * @param h - height of the UI element
     * @param backgroundColor - new Color(r ,g ,b ,a)
     */
    public UI(int x, int y, int w, int h, Color backgroundColor){
        super(x, y, w, h, ObjectType.UI);
        this.backgroundColor = backgroundColor;
    }
    
    /**
     * Class for creating UI elements
     * @param x - x position of the UI element
     * @param y - y position of the UI element
     * @param w - width of the UI element
     * @param h - height of the UI element
     * @param type - type of the UI element
     * @param backgroundColor - new Color(r ,g ,b ,a)
     */
    public UI(int x, int y, int w, int h, ObjectType type, Color backgroundColor){
        super(x, y, w, h, type);
        this.backgroundColor = backgroundColor;
    }
    
    /**
     * Object's physics
     * @param delta - difference between last 2 frames 
     * @param objects - LinkedList of available objects
     */
    @Override
    public void tick(double delta, LinkedList<GameObject> objects){
        
    }
    /**
     * Object's visuals
     * @param g - Graphics object
     */
    @Override
    public void render(Graphics g, double delta) {
        g.setColor(backgroundColor);
        g.fillRect(x, y, w, h);
        if(animate || animationTimer > 0){
            animationTimer -= delta;
            animation(animationTimer);
        }
    }
    
    /**
     * The animation 
     * @param animationTimer - remaining time of the animation
     */
    public abstract void animation(double animationTimer);
    
    /**
     * Starts the animation player
     */
    public void startAnimation(){
        this.animate = true;
        animationTimer = animationDuration;
    }
    
    /**
     * Sets Background color
     * @param c - new color use [new Color(r,g,b,a)]
     */
    public void setBackground(Color c){
        this.backgroundColor = c;
    }

}
