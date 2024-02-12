/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game.Inputs;

import Game.Objects.GameObject;
import Game.Objects.Handler;
import Game.Objects.ObjectType;
import Game.UI.Button;
import Game.UI.UI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Karel
 */
public class MouseInput extends MouseAdapter{
    Handler handler;
    
    
    
    public MouseInput(Handler handler){
        this.handler = handler;
    }
    
    @Override
    public void mouseClicked(MouseEvent e){
        int x = e.getX();
        int y = e.getY();
        for(int i = 0; i < handler.getObjects().size(); i++){
            GameObject tmpObject = handler.getObjects().get(i);
            
            if(tmpObject.getType()== ObjectType.Button && tmpObject.interactable()){
                if((tmpObject.getX() < x && tmpObject.getX() + tmpObject.getHeight()> x) && (tmpObject.getY() < y && tmpObject.getY() + tmpObject.getWidth() > y)){
                    Button tmpButton  =  (Button)tmpObject;
                    System.out.println("Button pressed");
                    tmpButton.onClick();
                    
                }
            }
        }
    }
    
    @Override
    public void mouseReleased(MouseEvent e){
        int x = e.getX();
        int y = e.getY();
        for(int i = 0; i < handler.getObjects().size(); i++){
            GameObject tmpObject = handler.getObjects().get(i);
            
            if(tmpObject.getType()== ObjectType.Button){
                Button tmpButton  =  (Button)tmpObject;
                tmpButton.onRelease();
            }
        }
    }
}
