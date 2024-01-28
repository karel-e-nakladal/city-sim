/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.karel.Objects;

import com.karel.GameObjects.GameObject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import com.karel.Game.Game;
import com.karel.GameObjects.ObjectId;
/**
 *
 * @author nakla
 */
public class BuildMenu extends GameObject{

    public BuildMenu(float x, float y, ObjectId id) {
        super(x, y, id);
    }

    @Override
    public void tick(LinkedList<GameObject> object) {
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(0, 0,cellSize * Game.menuSize, Game.HEIGHT);
        
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
    
    
}
