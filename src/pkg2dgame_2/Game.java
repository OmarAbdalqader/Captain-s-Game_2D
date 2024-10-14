/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2dgame_2;

import entitys.Player;
import java.awt.Graphics;
import levels.LevelManager;

/**
 *
 * @author Omar
 */
public class Game implements Runnable{

    private GameWindow gameWindow;
    private GamePanel gamePanle;
    private Thread gameThread;
    private final int FPS_SET=120;
    private final int UPS_SET=200;
    private Player player;
    private LevelManager levelManager;
    
    
    
    public final static int TILES_DEFAULT_SIZE=32;
     public final static float SCALE = 1.5f;
    public final static int TILES_IN_WIDTH=26;
    public final static int TILES_IN_HEIGHT=14;
    public final static int TILES_SIZE=(int)(TILES_DEFAULT_SIZE*SCALE);
      public final static int GAME_WIDTH=TILES_SIZE*TILES_IN_WIDTH;
    public final static int GAME_HEIGHT=TILES_SIZE*TILES_IN_HEIGHT;
    
    
    
    
    public Game() {
         intClasses();
        gamePanle =new GamePanel(this);
    gameWindow=new GameWindow(gamePanle);
    gamePanle.requestFocus();
       
    
    startGameLoop();

    
    
    }

      private void intClasses() {
            levelManager =new LevelManager(this);
   player =new Player(200, 200);
    player.loadLvlData(levelManager.getCurrentLevel().getLevelData());
   
      }
    
    
    
    
    private void startGameLoop(){
    gameThread=new Thread(this);
    gameThread.start();
    }
    
    public void update(){
    player.update();
    levelManager.update();
    }
    
    public void render(Graphics g){
    levelManager.draw(g);
      player.render(g);
    }
    
    
    @Override
    public void run() {
   double timePerFrame=1000000000.0/FPS_SET;
   double timePerUpdate=1000000000.0/UPS_SET;
   
        long previousTime=System.nanoTime();
        
        
        int frames=0;
        int updates=0;
        long lastCheck=System.currentTimeMillis();
        double deltaU=0;
        double deltaF=0;
        
        
        
        while (true) {
            
     
            long currentTime=System.nanoTime();
            
            deltaU+=(currentTime-previousTime)/timePerUpdate;
             deltaF+=(currentTime-previousTime)/timePerFrame;
            previousTime=currentTime;
             if (deltaU>=1) {
                update();
                updates++;
                deltaU--;
            }
         
             if (deltaF>=1) {
                  gamePanle.repaint();
                 frames++;
                                 deltaF--;
            }
             
             
//            if (now-lastFrame>=timePerFrame) {
//                gamePanle.repaint();
//                lastFrame=now;
//                 frames++;
//            }
//            
            
        if (System.currentTimeMillis()-lastCheck>=1000) {
            lastCheck=System.currentTimeMillis();
            System.out.println("frames : "+frames+"|"+"UPS"+updates);
            frames=0;
            
        }
    
        }

    }

    public void windowFocusLost(){
    player.resetDirBooleans();
    }
    
   public  Player getPlayer(){
  return player;
  }
    
    
}
