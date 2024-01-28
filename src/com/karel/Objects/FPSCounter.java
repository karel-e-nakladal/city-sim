/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.karel.Objects;

import com.karel.Game.Game;
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
public class FPSCounter extends GameObject{

    public FPSCounter(float x, float y, ObjectId id) {
        super(x, y, id);
    }

    @Override
    public void tick(LinkedList<GameObject> object) {
    
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        String FPSPrefix = "FPS: ";
        String TPCPrefix = "TPS: ";
        g.drawChars((FPSPrefix + Game.FPS).toCharArray() , 0, (FPSPrefix + Game.FPS).toCharArray().length, 5, 15);
        g.drawChars((TPCPrefix + Game.TPS).toCharArray() , 0, (TPCPrefix + Game.TPS).toCharArray().length, 5, 30);
    }

    @Override
    public Rectangle getBounds() {
    return null;
    }
    
}
