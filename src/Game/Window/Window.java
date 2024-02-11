/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game.Window;

import Game.Main.Game;
import java.awt.Dimension;
import javax.swing.JFrame;
/**
 *
 * @author Karel
 */
public class Window {
    
    
    /**
     * creates window of the app
     * 
     * @param w width
     * @param h height
     * @param title title of the window
     * @param game game
     */
    public Window(int w, int h, String title, Game game){
        game.setPreferredSize(new Dimension(w,h));
        game.setMaximumSize(new Dimension(w,h));
        game.setMinimumSize(new Dimension(w,h));
        
        JFrame frame = new JFrame(title);
        
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setIconImage(image);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        game.start();
    }
}
