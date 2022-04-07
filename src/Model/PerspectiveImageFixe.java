package Model;

import Observers.MyObservable;
import Observers.Observateur;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Cette classe utilise le patron Singleton pour instancier une perspective d'une image Fixe qui as seulement une
 * position comme attribut. Sa liste d'observateurs est averti lorsqu'il y a un changement.
 *
 * @author Alexandre Bouillon
 * @révision Hiver 2022
 */
public class PerspectiveImageFixe implements Serializable, MyObservable {

    private Point pos = new Point(120,50);
    private ArrayList<Observateur> observateurs = new ArrayList<Observateur>();

    public PerspectiveImageFixe(){}


    /**
     * Accesseur de la position de la perspective
     * @return La position
     */
    public Point getPos(){return pos;}





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
