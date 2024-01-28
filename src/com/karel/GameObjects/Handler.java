/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.karel.GameObjects;

import com.karel.GameObjects.GameObject;
import com.karel.GameObjects.ObjectId;
import com.karel.Objects.Test;
import java.awt.Graphics;
import java.util.LinkedList;
import com.karel.Game.Game;
import com.karel.Objects.BuildMenu;
import com.karel.Objects.Map;

/**
 *
 * @author nakla
 */
public class Handler {
    public LinkedList<GameObject> object = new LinkedList<GameObject>();
    
    private GameObject tmpObject;
    
    public void tick(){
        for(int i = 0; i < object.size(); i++){
            tmpObject = object.get(i);
            
            tmpObject.tick(object);
        }
    }
    
    public void render(Graphics g){
        for(int i = 0; i < object.size(); i++){
            tmpObject = object.get(i);
            
            tmpObject.render(g);
        }
    }
    
    public void addObject(GameObject object){
        this.object.add(object);
    }
    
    public void removeObject(GameObject object){
        this.object.remove(object);
    }
    
    public void createLevel(){
        
        addObject(new BuildMenu(0,0,ObjectId.BuildMenu));
        for(int xx = Game.menuSize * Game.cellSize; xx < Game.WIDTH; xx += Game.cellSize){
            for(int yy = 0; yy < Game.HEIGHT; yy += Game.cellSize)
            addObject(new Map(xx,yy,ObjectId.Map));
        }
        
    }
    
    
}
