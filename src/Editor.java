
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;





public class Editor extends BaseComponent{

/* ----------------------------- EXTERNAL ACCESS ---------------------------- */
/* ----------------------------- INTERNAL ACCESS ---------------------------- */
    private Rectangle myRect;
    private LayerManager layerManager;


    Editor(int x, int y, int w, int h){
        setBounds(x, y, w, h);
        myRect = new Rectangle(w, h);
        init();
    }

    void init(){
        setLayout(null);
        layerManager = new LayerManager();
        layerManager.addLayer(new Layer(myRect.width, myRect.height));
        layerManager.addLayer(new Layer(myRect.width, myRect.height));
        setIsHoverable(false);
        setIsRised(true);
        setIsBorderVisible(false);
        setShowImg(true);
        setIsInteractive(false);
        addMouseMotionListener(this);
        addMouseListener(this);        
    }

    
    
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(layerManager.getImage(), 0, 0, null);
    }

    public void saveEditor(){
        try {
            BufferedImage bi = layerManager.getImage();  // retrieve image
            File outputfile = new File("pippo.png");
            ImageIO.write(bi, "png", outputfile);
        } catch (IOException e) {
            // handle exception
        }
    }
    



    /* ---------------------------- SETTERS & GETTERS --------------------------- */

    
    
    /* -------------------------- END SETTERS & GETTERS ------------------------- */

    @Override
    public void mouseDragged(MouseEvent e){
        layerManager.dragging(e.getX(), e.getY());
        repaint();   
    }

    
}