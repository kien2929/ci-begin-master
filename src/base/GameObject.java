package base;

import sun.awt.image.BufferedImageDevice;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameObject {
    //thuoc tinh
    public BufferedImage image;
    public Vector2D position;
    //phuongthuc
    public GameObject(){
        this.position=new Vector2D();

    }
    public void run(){

//        if(this.position.x<350){
//            this.position.x++;
//        }
    }

    public void render(Graphics g){
        g.drawImage(this.image,(int)this.position.x,(int)this.position.y,null);
    }
}
