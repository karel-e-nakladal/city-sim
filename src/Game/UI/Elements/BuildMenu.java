/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game.UI.Elements;

import Game.Objects.GameObject;
import Game.UI.UI;
import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

/**
 *
 * @author Karel
 */
public class BuildMenu extends UI{

    
    public BuildMenu(int x, int y, int w, int h) {
        super(x, y, w, h);
    }
    public BuildMenu(int x, int y, int w, int h, Color color) {
        super(x, y, w, h, color);
    }


    @Override
    public void animation(double animationTimer) {
    }
    
}
