package base.enemy;

import base.GameObject;
import base.game.Settings;
import renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class EnemyBullet extends GameObject {
    public EnemyBullet(){
        super();
        BufferedImage image =SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png");
        this.renderer=new SingleImageRenderer(image);
        this.position.set(0,0);
        this.velocity.set(0,5);

    }
    private void destroyIfNeeded() {
        if(this.position.y<20||this.position.y>=Settings.SCREEN_HEIGHT
                ||this.position.x<0||this.position.x>=Settings.SCREEN_WIDTH){

            this.destroy();
        }
    }
    @Override
    public void run(){
        super.run();
        if(this.position.y<-20||this.position.y> Settings.BACKGROUND_HEIGHT
                ||this.position.x<-20||this.position.x> Settings.BACKGROUND_WIDTH){
            this.destroyIfNeeded();
        }
    }
}
