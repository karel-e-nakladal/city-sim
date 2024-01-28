/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.karel.Game;

import com.karel.GameObjects.ObjectId;
import com.karel.Inputs.KeyInput;
import com.karel.Inputs.MouseInput;
import com.karel.Objects.FPSCounter;
import com.karel.Objects.Test;
import com.karel.GameObjects.Handler;
import java.awt.Canvas;
import com.karel.Render.Window;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 *
 * @author nakla
 */
public class Game extends Canvas implements Runnable{
    
    public static int WIDTH, HEIGHT;
    public static int menuSize = 5;
    
    public static int FPS = 00;
    public static int TPS = 00;
    
    public static int sizeMultiplier = 2;
    public static int cellSize = 64;
    
    private boolean running = false;
    private Thread thread;
    private double amoutOfTicks = 60.0;
    
    
    Handler handler;
    
    private void init(){
        HEIGHT = getHeight();
        WIDTH = getWidth();
        
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        this.addMouseListener(new MouseInput(handler));
        
        handler.createLevel();
        handler.addObject(new FPSCounter(0,0,ObjectId.FPSCounter));
    }
    
    public static void main(String[] args) {
        new Window(cellSize * 19 * sizeMultiplier,cellSize * 10 * sizeMultiplier, "Game", new Game());
    }
    
    public synchronized void start(){
        if(running)
            return;
        
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    @Override
    public void run(){
        long lastTime = System.nanoTime();
        double ns = 1000000000 / amoutOfTicks;
        double delta = 0;
        double tickTimer = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        init();
        
        this.createBufferStrategy(3);
        BufferStrategy bs = this.getBufferStrategy();
        
        while(running){
            long now = System.nanoTime();
            delta = (now - lastTime) / ns;
            tickTimer += delta;
            lastTime = now;
            while(tickTimer >= 1){
                tick(delta);
                updates++;
                tickTimer--;
            }
            render(delta, bs);
            frames++;
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                FPS = frames;
                TPS = updates;
                frames = 0;
                updates = 0;
            }
        }
    }
    
    private void tick(double delta){
        handler.tick();
    }
    private void render(double delta, BufferStrategy bs){
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        handler.render(g);
        
        g.dispose();
        bs.show();
    }
    
    
    
    
}
