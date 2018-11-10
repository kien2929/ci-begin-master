package renderer;

import base.FrameCouter;
import base.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AnimationRenderer extends Renderer {
    FrameCouter nextImageCouter;
    ArrayList<BufferedImage> images;
    int currentimageindex;

    public AnimationRenderer(ArrayList<BufferedImage> images) {
        this.images = images;
        this.currentimageindex = 0;
        this.nextImageCouter=new FrameCouter(10);
    }

    int count = 0;
    @Override
    public void render(Graphics g, GameObject master) {
        g.drawImage(this.images.get(currentimageindex), (int) master.position.x, (int) master.position.y, null);


        if (this.nextImageCouter.run()) {
            this.currentimageindex++;
            if (this.currentimageindex >= this.images.size()) {
                this.currentimageindex = 0;
            }
            this.nextImageCouter.reset();
        }
    }
}
