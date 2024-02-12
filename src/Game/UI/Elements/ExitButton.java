/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game.UI.Elements;

import Game.Objects.ObjectType;
import Game.UI.Button;
import Game.UI.UI;
import java.awt.Color;

/**
 *
 * @author Karel
 */
public class ExitButton extends UI implements Button{
    

    public ExitButton(int x, int y, int w, int h) {
        super(x, y, w, h, ObjectType.Button, new Color(255, 20, 20, 100));
    }

    @Override
    public void animation(double animationTimer) {
   }

    @Override
    public void onClick() {
        System.exit(0);
    }

    @Override
    public void onRelease() {
    }

}
