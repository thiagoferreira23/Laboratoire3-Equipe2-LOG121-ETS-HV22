package Controller;

import Commande.ZoomCommande;
import Model.PerspectiveImageModifiable;
import View.VuePanneauImage;

import java.awt.*;
import java.awt.event.*;

/**
 * <p>Description de la classe</p>
 *
 * @author Franco Huynh, Gabriel M. Borges & Thiago Ferreira
 * @version 1.0
 * @since 2022-03-17 9:57 a.m.
 */
public class PanneauImageModifiableControleur implements MouseListener {
    private VuePanneauImage vueImage;
    private PerspectiveImageModifiable perspective;

    public void PanneauImageAvecChangementsControleur(VuePanneauImage vuePanneau, PerspectiveImageModifiable perspective) {
        this.vueImage = vuePanneau;
        this.perspective = perspective;
    }
    /**
     * <p>Cette méthode gère les méthodes et les actions à être exécutées
     * lorsque le mouse  est cliqué.</p>
     */
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    /**
     * <p>Cette méthode gère les méthodes et les actions à être exécutées
     * lorsque le mouse  est séléctionné.</p>
     */
    @Override
    public void mousePressed(MouseEvent e) {
        Point imagePosition = vueImage.getGraphics().getClipBounds().getLocation(); //GET IMAGE POSITION
        Point mousePosition = e.getPoint();
        int nvPositionX = (int) (imagePosition.getX() + mousePosition.getX());
        int nvPositionY = (int) (imagePosition.getY() + mousePosition.getY());
        //this.vueImage.getGraphics().set()... //SET NEW POSITION
    }
    /**
     * <p>Cette méthode gère les méthodes et les actions à être exécutées
     * lorsque le mouse  est déselectionnéé.</p>
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }
    /**
     * <p>Cette méthode gère les méthodes et les actions à être exécutées
     * lorsque la souris rentre dans l'espace de l'image.</p>
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    /**
     * <p>Cette méthode gère les méthodes et les actions à être exécutées
     * lorsque la souris sort de l'espace de l'image.</p>
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }
    /**
     * <p>Cette méthode permet de gérer lorsque on zoom in l'image.
     * Elle exectue la commande zoom de la classe zoomCommande.</p>
     */
    public void zoomIn(){
        ZoomCommande zoomCommande = new ZoomCommande(perspective,2);

        zoomCommande.execute();
    }
    /**
     * <p>Cette méthode permet de gérer lorsque on zoom out l'image.
     * Elle exectue la commande zoom de la classe zoomCommande.</p>
     */
    public void zoomOut(){
        ZoomCommande zoomCommande = new ZoomCommande(perspective,2);

        zoomCommande.execute();
    }
    /**
     * <p>Cette méthode gère les méthodes et les actions à être exécutées
     * lorsque la roue de la souris bouge.</p>
     */
    public void mouseWheelMoved(MouseWheelEvent e) {

        int notches = e.getWheelRotation();
        double temp = perspective.getZoom() - (notches * 0.2);

        temp = Math.max(temp, 1.0);
        if (temp != perspective.getZoom()) {
            perspective.setZoom(temp);
            //resizeImage();
        }
        //double factor = Math.pow(perspective.getZoom(), 0);
        //perspective.setSize((int) (vueImage.getWidth() * factor), (int) (vueImage.getHeight() * factor));

    }

}
