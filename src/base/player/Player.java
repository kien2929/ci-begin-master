package base.player;

import base.FrameCouter;
import base.GameObject;
import base.KeyEventPress;
import renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject {
    FrameCouter fireCouter;

    public Player() {
        super();
//        BufferedImage image=SpriteUtils.loadImage("assets/images/players/straight/0.png");
//        this.renderer=new SingleImageRenderer(image);
        this.createrender();
        this.position.set(192, 300);
        this.fireCouter = new FrameCouter(15);
    }

    public void createrender() {
        //Array
        ArrayList<BufferedImage> images = new ArrayList<>();
        //Animation
        images.add(SpriteUtils.loadImage("assets/images/players/straight/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/3.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/4.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/5.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/6.png"));
        this.renderer = new AnimationRenderer(images);
    }

    @Override
    public void run() {
        this.move();

        if (this.fireCouter.run() && KeyEventPress.isFirePress) {
            this.fire();
        }
    }   public void move(){
        //TODO upgrade
        int vx=0;
        int vy=0;
        if (KeyEventPress.isUpPress) {
//            this.velocity.set(0,-1);
            vy-=1;
        }
        if (KeyEventPress.isDownPress) {
//            this.velocity.set(0,1);
            vy+=1;
        }
        if (KeyEventPress.isLeftPress) {
//            this.velocity.set(-1,0);
            vx-=1;
        }
        if (KeyEventPress.isRightPress) {
//            this.velocity.set(1,0);
            vx+=1;
        }
            this.velocity.set(vx,vy);


    }

    //TODO
    private void fire() {

            PlayerBulletType1 bullett1 = GameObject.recycle(PlayerBulletType1.class);
            bullett1.position.set(this.position);

            PlayerBulletType2 bullett2 = GameObject.recycle(PlayerBulletType2.class);
            bullett2.position.set(this.position.add(-25,0));
            bullett2.velocity.set(-2,-5);

            PlayerBulletType2 bullett3 = GameObject.recycle(PlayerBulletType2.class);
            bullett3.position.set(this.position.add(25,0));
            bullett3.velocity.set(2,-5);
            this.fireCouter.reset();


    }
}
