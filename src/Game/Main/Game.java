/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Game.Main;

import Game.Inputs.MouseInput;
import Game.Window.Window;
import java.awt.Canvas;
import Game.Objects.Handler;
import Game.Objects.World;
import Game.UI.Elements.BuildMenu;
import Game.UI.Elements.ExitButton;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import Game.UI.UI;
import Game.Objects.ObjectType;
/**
 *
 * @author Karel
 */
public class Game extends Canvas implements Runnable{
    
    protected boolean running = false;
    public int cellSize = 16;
    private Thread thread;
    private float tickSpeed = 60;
    protected Handler handler;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Window(640,640,"Shitty builder", new Game());
    }
    
    /**
     * Start of the app
     * 
     * checks if the app is already running otherwise starts a new thread
     */
    public synchronized void start(){
        if (running) return;
        
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    /**
     * Setup of the game
     */
    public void init(){
        this.handler = new Handler();
        
        this.handler.addObject(new BuildMenu(0, getHeight() - 10 * cellSize, getWidth(), 10 * cellSize), ObjectType.UI);
        this.handler.addObject(new ExitButton(cellSize, cellSize, 2*cellSize, 2*cellSize), ObjectType.Button);
        
        this.handler.addObject(new World(40 * cellSize, 40 * cellSize), ObjectType.World);
        
        this.addMouseListener(new MouseInput(handler));
    }

    /**
     * Game loop
     */
    @Override
    public void run() {
        double lastTime = System.nanoTime();
        double tickSpeedNS = 1000000000 / tickSpeed;
        double tickTimer = 0;
        double now;
        double delta;
        double timer = System.currentTimeMillis(); 
        int updates = 0;
        int frames = 0;
        
        this.createBufferStrategy(2);
        BufferStrategy bs = this.getBufferStrategy();
        
        init();
        
        while(running){
            now = System.nanoTime();
            delta = (now - lastTime);
            lastTime = now;
            tickTimer += delta / tickSpeedNS;
            
            while(tickTimer > 1){
                tick(delta);
                updates++;
                tickTimer--;
            }
            render(delta, bs);
            frames++;
            if(System.currentTimeMillis() - timer > 1000){
                System.out.println("TPS: " + updates  + " FPS: " + frames);
                System.out.println("Count of game objects " + handler.getObjectsCount("all"));
                timer += 1000; 
               frames = 0;
                updates = 0;
            }
            
            
        }
    }
    
    /**
     * Object physics
     * @param delta - difference between last 2 frames
     */
    public void tick(double delta){
        handler.tick(delta);
    }
    
    /**
     * Object visuals
     * @param delta - difference between last 2 frames
     * @param bs - BufferStrategy
     */
    public void render(double delta, BufferStrategy bs){
        Graphics g = bs.getDrawGraphics();
        
        handler.render(g,delta);
        
        g.dispose();
        bs.show();
    }
    
    
}
