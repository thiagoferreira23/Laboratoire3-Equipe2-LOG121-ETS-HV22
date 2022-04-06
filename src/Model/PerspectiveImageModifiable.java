package Model;

import Observers.MyObservable;
import Observers.Observateur;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class PerspectiveImageModifiable implements Serializable, MyObservable {

    private Point pos = new Point(0,0);
    private double zoom=1;
    private ArrayList<Observateur> observateurs=new ArrayList<Observateur>();


    public int getPosX(){return this.pos.x;}

    public int getPosY(){return this.pos.y;}

    public double getZoom(){return this.zoom;}

    public void setPos(Point pos){this.pos=pos;}

    public void setZoom(double zoom){this.zoom=zoom;}

    public void deplacement(Point pos){
        this.pos.translate(pos.x,pos.y);
    }




    @Override
    public void addObservers(Observateur o) {
        observateurs.add(o);
    }

    @Override
    public void deleteObservers(Observateur o) {
        observateurs.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observateur o: observateurs){
            o.update();
        }
    }
}
