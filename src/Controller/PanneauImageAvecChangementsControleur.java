package Controller;

import Model.PerspectiveImageModifiable;
import View.VuePanneauImage;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * <p>Description de la classe</p>
 *
 * @author Franco Huynh, Gabriel M. Borges & Thiago Ferreira
 * @version 1.0
 * @since 2022-03-17 9:57 a.m.
 */
public class PanneauImageAvecChangementsControleur implements MouseListener {
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
}
