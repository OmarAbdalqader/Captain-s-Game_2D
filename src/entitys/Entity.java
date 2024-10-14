/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitys;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Omar
 */
public abstract class Entity {
 protected Rectangle hitbox;
    protected float x,y;
    protected int width,height;
   
    public Entity(float x,float y) {
    this.x=x;
    this.y=y;
    this.width=width;
    this.height=height;
    initHitbox();
    }

    public void drawHitbox(Graphics g){
    g.setColor(Color.pink);
    g.drawRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height);
    }
    
    private void initHitbox() {
          hitbox=new Rectangle((int)x,(int)y,width,height);
    }
    
    protected void updateHitbox(){
    hitbox.x=(int)x;
    hitbox.y=(int)y;
    }
    
    public Rectangle getHitbox(){
    return hitbox;
    }
    
    
    
}
