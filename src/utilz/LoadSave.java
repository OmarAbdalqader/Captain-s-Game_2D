/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilz;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import pkg2dgame_2.Game;

/**
 *
 * @author Omar
 */
public class LoadSave {

     public static final String PLAYER_ATLAS="/res/player_sprites.png";
      public static final String LEVEL_ATLAS="/res/outside_sprites.png";
      public static final String LEVEL_ONE_DATA="/res/level_one_data.png";
      
    public static BufferedImage GetSpriteAtlas(String fileName){
         BufferedImage img=null;
        InputStream is = LoadSave.class.getResourceAsStream(fileName);
    
    if (is == null) {
        System.out.println("الصورة لم يتم العثور عليها. تحقق من المسار.");

    }
    
    try {
         img = ImageIO.read(is);
  
     
    } catch (IOException ex) {
        ex.printStackTrace();
    }
            
return img;

    
    }
    
    
    public static int[][ ]GetLevelData(){
    int[][] lvlData=new int[Game.TILES_IN_HEIGHT][Game.TILES_IN_WIDTH];
        BufferedImage img =GetSpriteAtlas(LEVEL_ONE_DATA);
        
        for (int j = 0; j < img.getHeight(); j++) 
            for(int i = 0; i < img.getWidth(); i++) 
            {
            Color color=new Color(img.getRGB(i, j));
            int value=color.getRed();
                if (value>=48) 
                    value=0;
                lvlData[j][i]=value;
            }
        return lvlData;
    }
    
}
