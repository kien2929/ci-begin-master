package base.player;

import base.game.GameCanvas;
import base.GameObject;
import base.KeyEventPress;
import renderer.AnimationRenderer;
import renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject {


    public Player(){
        super();
//        BufferedImage image=SpriteUtils.loadImage("assets/images/players/straight/0.png");
//        this.renderer=new SingleImageRenderer(image);
        this.createrender();
        this.position.set(192,300);
    }
    public void  createrender(){
        //Array
        ArrayList<BufferedImage> images= new ArrayList<>();
        //Animation
        images.add(SpriteUtils.loadImage("assets/images/players/straight/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/3.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/4.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/5.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/6.png"));
        this.renderer=new AnimationRenderer(images);
    }
    @Override
    public void run(){
        if(KeyEventPress.isUpPress){
            this.position.y--;
        }
        if(KeyEventPress.isDownPress){
            this.position.y++;
        }
        if(KeyEventPress.isLeftPress){
            this.position.x--;
        }
        if(KeyEventPress.isRightPress){
            this.position.x++;
        }
        if(KeyEventPress.isFirePress){
            this.fire();
        }
    }
    int count=0;
    private void fire(){
        if(count>20) {
            PlayerBullet bullett = new PlayerBullet();
            bullett.position.set(this.position.x, this.position.y);
            GameCanvas.bullets.add(bullett);
            count = 0;
        }
        else {
            count++;
        }

    }
}
