package base.enemy;

import base.Background;
import base.GameObject;
import base.game.GameCanvas;
import base.game.Settings;
import renderer.AnimationRenderer;
import renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Set;

public class Enemy extends GameObject {
    public int IMAGE_WIDTH;
    public Enemy(){
        super();

       this.createrenderer();
        this.position.set(0,0);
    }
    public void createrenderer(){
        ArrayList<BufferedImage> images= new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/blue/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/blue/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/blue/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/blue/3.png"));
        this.renderer=new AnimationRenderer(images);
    }
    boolean check=true;
    @Override
    public void run(){
     if(this.position.x<=0){
         check=true;
     }
     if(this.position.x>=(Settings.BACKGROUND_WIDTH-IMAGE_WIDTH-30)){
         check=false;
     }
     if(check){
         this.position.addThis(3,0);
     }
     if(!check){
         this.position.addThis(-3,0);
     }
        fire();
    }
    int count=0;
    private void fire(){
        if(count>20) {
            EnemyBullet enemybullet = new EnemyBullet();
            enemybullet.position.set(this.position.x, this.position.y);
            GameCanvas.enemyBullets.add(enemybullet);
            count =0;
        }else{
            count++;
        }
    }
}
