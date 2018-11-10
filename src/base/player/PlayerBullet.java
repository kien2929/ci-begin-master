package base.player;

import base.FrameCouter;
import base.GameObject;
import renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBullet extends GameObject {
    FrameCouter runcouter;
    public PlayerBullet(){
        super();
        this.position.set(0,0);
        this.createrenderer();



    }
    public void createrenderer(){
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "assets/images/player-bullets/a/0.png ",
                "assets/images/player-bullets/a/1.png ",
                "assets/images/player-bullets/a/2.png ",
                "assets/images/player-bullets/a/3.png "
                );
        this.renderer=new AnimationRenderer(images);


    }
    @Override
    public void run(){
        this.position.y-=5;
        if(this.position.y<-20){
            this.destroy();
        }
    }
}
