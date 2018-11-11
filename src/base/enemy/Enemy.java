package base.enemy;

import base.FrameCouter;
import base.GameObject;
import base.game.Settings;
import renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject {
    FrameCouter fireCouter;
    public int IMAGE_WIDTH;
    public Enemy(){
        super();

       this.createrenderer();
      this.velocity.set(0,3);
        this.position.set(0,0);
        this.fireCouter=new FrameCouter(20);
    }
    public void createrenderer(){
       ArrayList<BufferedImage> images=SpriteUtils.loadImages(
               "assets/images/enemies/level0/blue/0.png"  ,
               "assets/images/enemies/level0/blue/1.png"  ,
               "assets/images/enemies/level0/blue/2.png"  ,
               "assets/images/enemies/level0/blue/3.png"
               );
       this.renderer=new AnimationRenderer(images);
    }
    @Override
    public void run(){
       super.run();
     if(this.position.x<=0){
         this.velocity.set(3,0);
     }
     if(this.position.x>=(Settings.BACKGROUND_WIDTH-IMAGE_WIDTH-30)){
         this.velocity.set(-3,0);
     }
//     if(check){
//         this.position.addThis(3,0);
//     }
//     if(!check){
//         this.position.addThis(-3,0);

        fire();
    }
    private void fire(){
        if(this.fireCouter.run()) {
            EnemyBullet enemybullet = GameObject.recycle(EnemyBullet.class);
            enemybullet.position.set(this.position);
            this.fireCouter.reset();
        }
    }
}
