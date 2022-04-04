package Model;

import java.awt.*;
import java.io.Serializable;

public class PerspectiveImageFixe implements Serializable {

    private Point pos;

    public PerspectiveImageFixe(){}

    public PerspectiveImageFixe(Point pos){
        this.pos=pos;
    }

    public Point getPos(){return pos;}

    public void setPos(Point pos){this.pos=pos;}



}
