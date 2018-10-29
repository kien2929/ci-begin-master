package base;

import sun.awt.image.BufferedImageDevice;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameObject {
    //thuoc tinh
    BufferedImage image;
    int x;
    int y;
    //phuongthuc
    public GameObject(){

    }
    public void run(){

        if(this.x<350){
            this.x++;
        }
    }

    public void render(Graphics g){
        g.drawImage(this.image,this.x,this.y,null);
    }
}
