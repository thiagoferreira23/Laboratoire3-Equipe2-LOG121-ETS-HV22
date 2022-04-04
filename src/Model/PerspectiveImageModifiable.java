package Model;

import java.awt.*;
import java.io.Serializable;

public class PerspectiveImageModifiable implements Serializable {

    private Point pos;
    private double zoom=1;


    public int getPosX(){return this.pos.x;}

    public int getPosY(){return this.pos.y;}

    public void setPos(Point pos){this.pos=pos;}

    public double getZoom(){return this.zoom;}

    public void setZoom(double zoom){this.zoom=zoom;}


}
