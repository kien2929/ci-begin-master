package base;

import renderer.Renderer;
import sun.awt.image.BufferedImageDevice;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameObject {
    //thuoc tinh

    public Vector2D position;
    public Renderer renderer;
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
        if(this.renderer !=null){
            this.renderer.render(g,this);
        }

    }
}
