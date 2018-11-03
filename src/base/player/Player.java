package base.player;

import base.game.GameCanvas;
import base.GameObject;
import base.KeyEventPress;
import tklibs.SpriteUtils;

public class Player extends GameObject {


    public Player(){
        super();
        this.image= SpriteUtils.loadImage("assets/images/players/straight/0.png");
        this.position.set(192,300);
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
