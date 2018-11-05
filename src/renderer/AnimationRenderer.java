package renderer;

import base.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AnimationRenderer extends Renderer {
    ArrayList<BufferedImage> images;
    int currentimageindex;

    public AnimationRenderer(ArrayList<BufferedImage> images) {
        this.images = images;
        this.currentimageindex = 0;
    }

    int count = 0;
    @Override
    public void render(Graphics g, GameObject master) {
        g.drawImage(this.images.get(currentimageindex), (int) master.position.x, (int) master.position.y, null);
        this.currentimageindex++;

        if (count >= 10) {
            this.currentimageindex++;
            if (this.currentimageindex >= this.images.size()) {
                this.currentimageindex = 0;
            }
            count = 0;
        } else {
            count++;
        }
    }
}
