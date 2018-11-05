package base.player;

import base.GameObject;
import renderer.AnimationRenderer;
import renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBullet extends GameObject {
    public PlayerBullet(){
        super();
        this.position.set(0,0);
        this.createrenderer();

        BufferedImage image=SpriteUtils.loadImage("assets/images/player-bullets/a/0.png");
        this.renderer= new SingleImageRenderer(image);

    }
    public void createrenderer(){
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/3.png"));
        this.renderer=new AnimationRenderer(images);

    }
    @Override
    public void run(){
        this.position.y-=5;
    }
}
