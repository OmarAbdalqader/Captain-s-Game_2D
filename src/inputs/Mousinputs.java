/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import pkg2dgame_2.GamePanel;



/**
 *
 * @author Omar
 */
public class Mousinputs implements MouseMotionListener,MouseListener{

    private GamePanel gamePanel;
    public Mousinputs( GamePanel gamePanel) {
    this.gamePanel=gamePanel;
    
    }

    
    
    
    
    @Override
    public void mouseDragged(MouseEvent e) {
       
    
    }

    @Override
    public void mouseMoved(MouseEvent e) {
//       gamePanel.setRectPos(e.getX(),e.getY());
      
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton()==MouseEvent.BUTTON1) {
            gamePanel.getGame().getPlayer().setAttack(true);
        }
       }

    @Override
    public void mousePressed(MouseEvent e) {
       }

    @Override
    public void mouseReleased(MouseEvent e) {
       }

    @Override
    public void mouseEntered(MouseEvent e) {
       }

    @Override
    public void mouseExited(MouseEvent e) {
        }
    
}
