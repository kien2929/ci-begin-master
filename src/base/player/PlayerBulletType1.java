package base.player;

import renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBulletType1 extends PlayerBullet {
    public PlayerBulletType1() {
        super.run();
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
}
