package Controller;

import Commande.ZoomCommande;
import Model.PerspectiveImageModifiable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <p>Description de la classe</p>
 *
 * @author Franco Huynh, Gabriel M. Borges & Thiago Ferreira
 * @version 1.0
 * @since 2022-03-17 9:57 a.m.
 */
public class PanneauImageModifiableControleur implements ActionListener {

    private PerspectiveImageModifiable perspectiveImageModifiable;

    public void zoomIn(){
        ZoomCommande zoomCommande = new ZoomCommande(perspectiveImageModifiable,2);

        zoomCommande.execute();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
