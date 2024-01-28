/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.karel.Inputs;

import com.karel.Game.Game;
import com.karel.GameObjects.GameObject;
import com.karel.GameObjects.ObjectId;
import com.karel.Objects.Map;
import com.karel.GameObjects.Handler;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author nakla
 */
public class MouseInput extends MouseAdapter{
    
    Handler handler;
    
    public MouseInput(Handler handler){
        this.handler = handler;
    }
    
    @Override
    public void mouseClicked(MouseEvent e){
        
    }
    
    @Override
    public void mouseReleased(MouseEvent e){
        int x = e.getX();
        int y = e.getY();
        System.out.println("Clicled --- X: " + x + " | Y: " + y);
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tmpObject = handler.object.get(i);
            
            if(tmpObject.getId() == ObjectId.Map){
                Map tmpMap = (Map) tmpObject;
                if((tmpMap.getX() < x && tmpMap.getX() + Game.cellSize > x && tmpMap.getY() < y && tmpMap.getY() + Game.cellSize > y)){

                    switch(tmpMap.getBuilding()){
                        case 0:
                            tmpMap.setBuilding(1);
                            break;
                        case 1:
                            tmpMap.setBuilding(0);
                            break;
                    }
                }
            }
        }
    }
}
