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

    }
    @Override
    public void run(){
        this.position.y+=5;
        if(this.position.y> Settings.SCREEN_HEIGHT){
            this.destroy();
        }
    }
}
