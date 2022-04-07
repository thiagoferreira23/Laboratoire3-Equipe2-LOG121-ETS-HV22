package Model;

import Memento.Memento;
import Observers.MyObservable;
import Observers.Observateur;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Cette classe permet d'instancier une perspective d'une image modifiable avec ses attributs et de les modifiers
 * si un déplacement ou un zoom est fait sur l'image.
 *
 * @author Alexandre Bouillon
 * @révision Hiver 2022
 */
public class PerspectiveImageModifiable implements Serializable, MyObservable {

    private Point pos = new Point(0,0);
    private double zoom=1;
    private ArrayList<Observateur> observateurs=new ArrayList<Observateur>();

    /**
     * Accesseurs de la position
     * @return La position
     */
    public Point getPos(){return this.pos;}

    /**
     * Accesseur du zoom appliqué sur l'image.
     * @return Le zoom
     */
    public double getZoom(){return this.zoom;}

    /**
     * Méthode qui permet de créer un Memento de la perspective actuelle
     * @return Le Memento de la perspective
     */
    public Memento getMemento(){
        return new Memento(this);
    }

    /**
     * Mutateur qui permet de modifier la position de la perspective et avertit les observateurs
     * @param pos La nouvelle position
     */
    public void setPos(Point pos){
        this.pos=pos;
        notifyObservers();
    }

    /**
     * Mutateur qui permet de changer le zoom effectuer sur l'image et avertit les observateurs
     * @param zoom Le nouveau zoom
     */
    public void setZoom(double zoom){
        this.zoom=zoom;
        notifyObservers();
    }

    /**
     * Méthode qui permet d'effectuer le déplacement de la perspective et avertit les observateurs
     * @param pos La nouvelle position de l'image
     */
    public void deplacement(Point pos){
        this.pos.translate(pos.x,pos.y);
        notifyObservers();
    }

    /**
     * Méthode qui permet de récupérer les paramètres d'un Memento et de les appliquer à la perspective
     * et avertit les observateurs par la suite
     * @param m Le Memento à appliquer
     */
    public void setMemento(Memento m){
        this.zoom = m.getZoomMemorise();
        this.pos=m.getTranslationMemorise();
        notifyObservers();
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
