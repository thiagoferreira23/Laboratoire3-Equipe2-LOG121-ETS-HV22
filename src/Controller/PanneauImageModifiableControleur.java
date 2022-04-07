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

    @Override
    public void mouseClicked(MouseEvent e) {
        Point imagePosition = vueImage.getGraphics().getClipBounds().getLocation(); //GET IMAGE POSITION
        Point mousePosition = e.getPoint();
        int nvPositionX = (int) (imagePosition.getX() + mousePosition.getX());
        int nvPositionY = (int) (imagePosition.getY() + mousePosition.getY());
        //this.vueImage.getGraphics().set()... //SET NEW POSITION
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void zoomIn(){
        ZoomCommande zoomCommande = new ZoomCommande(perspective,2);

        zoomCommande.execute();
    }
    public void mouseWheelMoved(MouseWheelEvent e) {

        int notches = e.getWheelRotation();
        double temp = perspective.getZoom() - (notches * 0.2);

        temp = Math.max(temp, 1.0);
        if (temp != perspective.getZoom()) {
            perspective.setZoom(temp);
            //resizeImage();
        }
        // double factor = Math.pow(perspective.getZoom(), 0);
        //perspective.setSize((int) (vueImage.getWidth() * factor), (int) (vueImage.getHeight() * factor));

    }

}
