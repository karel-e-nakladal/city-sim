/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.karel.Inputs;

import com.karel.GameObjects.Handler;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author nakla
 */
public class KeyInput extends KeyAdapter{
    
    Handler handler;
    
    public KeyInput(Handler handler){
        this.handler = handler;
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_ESCAPE){
            
            System.exit(1);
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e){
        
    }
}
