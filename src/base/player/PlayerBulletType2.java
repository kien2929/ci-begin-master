package base.player;

import base.FrameCouter;
import base.GameObject;
import base.Vector2D;
import base.enemy.Enemy;
import base.game.Settings;
import renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBulletType2 extends PlayerBullet {
    FrameCouter runcouter;
    public PlayerBulletType2(){
        super();
        this.position.set(0,0);
        this.createrenderer();
        this.velocity.set(0,-5);



    }
    public void createrenderer(){
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "assets/images/enemies/bullets/blue.png ",
                "assets/images/enemies/bullets/green.png ",
                "assets/images/enemies/bullets/pink.png ",
                "assets/images/enemies/bullets/white.png "
        );
        this.renderer=new AnimationRenderer(images);


    }
    @Override
    public void run(){
        super.run();
        this.moveToEnemy();
        this.destroyIfNeeded();
        if(this.position.y<-20||this.position.y> Settings.BACKGROUND_HEIGHT
                ||this.position.x<-20||this.position.x> Settings.BACKGROUND_WIDTH){
            this.destroy();
        }
    }



    private void moveToEnemy() {
        //enemy
        Enemy enemy=null;
        for(GameObject gameObject: GameObject.gameObjects){
            if(gameObject.isActive && gameObject instanceof Enemy){
                enemy = (Enemy) gameObject;
                break;
            }
        }
        //enemy pothission
        if(enemy!=null){
            Vector2D enemyPosition=enemy.position;
            Vector2D result =enemyPosition.substract(this.position);
            result.addThis(this.velocity);
            result.setLength(5);
            this.velocity.set(result);
        }
        //set this.velocity>> enemy.position
    }

}
