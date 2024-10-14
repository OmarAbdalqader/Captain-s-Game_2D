/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilz;

import pkg2dgame_2.Game;

/**
 *
 * @author Omar
 */
public class HelpMethods {
    
    public static boolean CanMoveHere(float x,float y,int width,int height,int[][] lvlData){
        if (!IsSolid(x,y,lvlData))
             if (!IsSolid(x+width,y+height,lvlData))
                  if (!IsSolid(x+width,y,lvlData))
                       if (!IsSolid(x,y+height,lvlData))
                                return true;
        return false;
    }

    private static boolean IsSolid(float x, float y, int[][] lvlData) {
        if (x<0 || x>=Game.GAME_WIDTH)
            return true;
         if (y<0 || y>=Game.GAME_HEIGHT)
            return true;
         
         float xIndex=x/Game.TILES_SIZE;
           float yIndex=y/Game.TILES_SIZE;

           int value=lvlData[(int)yIndex][(int)xIndex];
           
           if (value>=48 || value<0 || value!=11)
               return true;
           
        return false; }

    public static boolean IsOnGround(float x, float y, int WIDTH, int HEIGHT, int[][] lvlData) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
}
