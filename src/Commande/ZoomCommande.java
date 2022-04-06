package Commande;


import Model.PerspectiveImageModifiable;

/**
 * <p>Description de la classe</p>
 *
 * @author Franco Huynh, Gabriel M. Borges & Thiago Ferreira
 * @version 1.0
 * @since 2022-03-17 9:57 a.m.
 */
public class ZoomCommande implements Icommande {

    /*TODO : Voir les parametres pour zoom in,zoom out, c'est parametres vont etre mes attributs */
    private PerspectiveImageModifiable perspectiveImageModifiable;
    private double zoomPourcentage;

    public ZoomCommande(PerspectiveImageModifiable perspectiveImageModifiable, double zoomPourcentage) {
        this.perspectiveImageModifiable = perspectiveImageModifiable;
        this.zoomPourcentage = zoomPourcentage;
    }
    /*TODO: Voir ce que je met dans cette methode*/
    @Override
    public void execute() {

    }


}
