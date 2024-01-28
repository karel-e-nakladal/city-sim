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
public class Test extends GameObject{

    public Test(float x, float y, ObjectId id) {
        super(x, y, id);
    }

    @Override
    public void tick(LinkedList<GameObject> object) {
        
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.drawRect((int) x,(int) y, 32, 32);
    }
    
    @Override
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int) y, 32, 32);
    }

    
    
}
