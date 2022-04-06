package Model;

import Observers.MyObservable;
import Observers.Observateur;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class PerspectiveImageFixe implements Serializable, MyObservable {

    private Point pos = new Point(120,50);
    private ArrayList<Observateur> observateurs = new ArrayList<Observateur>();

    public PerspectiveImageFixe(){}

    public PerspectiveImageFixe(Point pos){
        this.pos=pos;
    }

    public Point getPos(){return pos;}

    public void setPos(Point pos){this.pos=pos;}




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
        for(Observateur o:observateurs){
            o.update();
        }
    }
}
