package base;

import tklibs.SpriteUtils;

public class Player extends GameObject {
    public Player(){
        this.image= SpriteUtils.loadImage("assets/images/players/straight/0.png");
        this.x=192;
        this.y=300;
    }
}
