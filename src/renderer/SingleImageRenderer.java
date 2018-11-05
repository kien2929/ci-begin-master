package renderer;

import base.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class SingleImageRenderer extends Renderer {
    BufferedImage image;
    public SingleImageRenderer(BufferedImage image){
        this.image=image;
    }
    @Override
    public void render(Graphics g, GameObject master){
        System.out.println(g);
        System.out.println(master);
        System.out.println(this.image);
        g.drawImage(this.image,(int)master.position.x,(int)master.position.y,null);
    }
}
