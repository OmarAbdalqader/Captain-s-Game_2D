/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import pkg2dgame_2.Game;
import pkg2dgame_2.GamePanel;
import static utilz.Constants.Directions.*;
/**
 *
 * @author Omar
 */
public class KeyboardInputs implements KeyListener{

   private GamePanel gamePanel;
    public KeyboardInputs(GamePanel gamePanel) {
  this.gamePanel=gamePanel;
    
    
    }

    
    
    @Override
    public void keyTyped(KeyEvent e) {
         }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
             case KeyEvent.VK_W:
       gamePanel.getGame().getPlayer().setUp(true);
  break;
     case KeyEvent.VK_A:
       gamePanel.getGame().getPlayer().setLeft(true);
  break;
     case KeyEvent.VK_S:
           gamePanel.getGame().getPlayer().setDown(true);
  break;
     case KeyEvent.VK_D:
  gamePanel.getGame().getPlayer().setRight(true);
  break;
            
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
   
          switch (e.getKeyCode()) {
     case KeyEvent.VK_W:
       gamePanel.getGame().getPlayer().setUp(false);
  break;
     case KeyEvent.VK_A:
       gamePanel.getGame().getPlayer().setLeft(false);
  break;
     case KeyEvent.VK_S:
           gamePanel.getGame().getPlayer().setDown(false);
  break;
     case KeyEvent.VK_D:
  gamePanel.getGame().getPlayer().setRight(false);
  break;
            
        }
    
    }
    
}
