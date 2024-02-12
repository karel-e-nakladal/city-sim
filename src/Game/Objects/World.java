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
public class World extends GameObject{
    
    private LinkedList<GameObject> tile = new LinkedList<GameObject>();
    private LinkedList<GameObject> building = new LinkedList<GameObject>();

    public World(int w, int h) {
        super(0, 0, w, h, ObjectType.World);
    }

    @Override
    public void tick(double delta, LinkedList<GameObject> objects) {
    }

    @Override
    public void render(Graphics g, double delta) {
    }
    
}
