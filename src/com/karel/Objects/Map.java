/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.karel.Objects;

import com.karel.GameObjects.GameObject;
import com.karel.GameObjects.ObjectId;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 *
 * @author nakla
 */
public class Map extends GameObject{

    public int building = 0;
    
    public Map(float x, float y, ObjectId id) {
        super(x, y, id);
    }

    @Override
    public void tick(LinkedList<GameObject> object) {
    }

    @Override
    public void render(Graphics g) {
        switch(building){
            case 0:
                g.setColor(Color.blue);
                break;
            case 1:
                g.setColor(Color.red);
        }
        if(building == 0){
            g.drawRect((int)x, (int)y, cellSize, cellSize);
        }else{
            g.fillRect((int)x, (int)y, cellSize, cellSize);
        }
        /*g.setColor(Color.red);
        g.drawChars(("X:" + x).toCharArray(), 0, ("X:" + x).toCharArray().length, (int)x, (int) y+10);
        g.drawChars(("Y: " + y).toCharArray(), 0, ("Y: " + y).toCharArray().length, (int)x, (int) y+20);
        */
    }

    @Override
    public Rectangle getBounds() {
    return null;
    }
    
    public void setBuilding(int building){
        this.building = building;
    }
    
    public int getBuilding(){
        return building;
    }
}
