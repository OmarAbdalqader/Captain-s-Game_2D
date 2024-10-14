/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import pkg2dgame_2.Game;
import utilz.LoadSave;

/**
 *
 * @author Omar
 */
public class LevelManager {
  
    private Game game;
    private BufferedImage[] levelSprite;
    private Level levelOne;
    
    
    public LevelManager(Game game) {
    this.game=game;
//    levelSprite=LoadSave.GetSpriteAtlas(LoadSave.LEVEL_ATLAS);
    importOutsiceSprites();
    levelOne=new Level(LoadSave.GetLevelData());
        }
 
    private void importOutsiceSprites() {
  BufferedImage img =LoadSave.GetSpriteAtlas(LoadSave.LEVEL_ATLAS);
levelSprite=new BufferedImage[48];
        for (int j = 0; j < 4; j++) 
            for(int i=0;i<12;i++){
            int index=j*12+i;
            levelSprite[index]=img.getSubimage(i*32, j*32, 32, 32);
            }
        

    }
    
    
    
    public void draw(Graphics g){
        for (int j = 0; j < Game.TILES_IN_HEIGHT; j++)
              for (int i = 0; i < Game.TILES_IN_WIDTH; i++){
              int index=levelOne.getSpriteIndex(i, j);
               g.drawImage(levelSprite[index],Game.TILES_SIZE*i,Game.TILES_SIZE*j,Game.TILES_SIZE,Game.TILES_SIZE, null);
              
              }
         
  
    
    }
    
    public void update(){
    
    
    
    }

    /**
     *
     * @return
     */
    public Level getCurrentLevel(){
    return levelOne;
    }

  
    
}
