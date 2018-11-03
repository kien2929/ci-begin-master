package base.enemy;

import base.Background;
import base.GameObject;
import base.game.GameCanvas;
import base.game.Settings;
import tklibs.SpriteUtils;

public class Enemy extends GameObject {
    public Enemy(){
        super();
        this.image= SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png");
        this.position.set(0,0);
    }
    boolean check = true;
    @Override

    public void run() {
        fire();
    }
    int count=0;
    public void fire(){
        if(count>20) {
            EnemyBullet enemybullet = new EnemyBullet();
            enemybullet.position.set(this.position.x, this.position.y);
            GameCanvas.enemyBullets.add(enemybullet);
            count =0;
        }else{
            count++;
        }
    }
}
