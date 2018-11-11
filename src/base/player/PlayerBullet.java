package base.player;

import base.FrameCouter;
import base.GameObject;
import base.game.Settings;
import renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Set;

public class PlayerBullet extends GameObject {
    FrameCouter runcouter;
    public PlayerBullet(){
        super();
        this.position.set(0,0);
        this.velocity.set(0,-5);
    }

    public void destroyIfNeeded() {
        if(this.position.y<20||this.position.y>=Settings.SCREEN_HEIGHT
                ||this.position.x<0||this.position.x>=Settings.SCREEN_WIDTH){

            this.destroy();
        }
    }
    @Override
    public void run(){
        super.run();
        if(this.position.y<-20||this.position.y> Settings.BACKGROUND_HEIGHT
                ||this.position.x<-30||this.position.x> Settings.BACKGROUND_WIDTH){
            this.destroyIfNeeded();
        }
    }
}
