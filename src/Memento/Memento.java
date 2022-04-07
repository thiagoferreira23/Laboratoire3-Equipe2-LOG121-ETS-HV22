package Memento;
/**
 * Cette classe permet de faire un Memento d'une perspective avec ses attributs pour la récupérer avec les commandes
 * défaire, refaire.
 *
 * @author Alexandre Bouillon
 * @révision Hiver 2022
 */

import Model.PerspectiveImageModifiable;

import java.awt.*;

public class Memento {

    private double zoomMemorise;
    private Point translationMemorise;

    public Memento(PerspectiveImageModifiable p){
        this.zoomMemorise=p.getZoom();
        this.translationMemorise=p.getPos();
    }

    /**
     * Accesseur du zoom garder en mémoire
     * @return le zoom
     */
    public double getZoomMemorise(){return this.zoomMemorise;}

    /**
     * Accesseur du Point (position) de l'image garder en mémoire
     * @return Le Point (position)
     */
    public Point getTranslationMemorise(){return this.translationMemorise;}



}
