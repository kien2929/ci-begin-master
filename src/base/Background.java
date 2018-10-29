package base;

import tklibs.SpriteUtils;

public class Background extends GameObject {
    public Background(){
        this.image= SpriteUtils.loadImage("assets/images/background/0.png");
        this.y=-2509;
    }
    @Override
    public void run(){
        if(this.y<0){
        this.y++;}


    }
}
