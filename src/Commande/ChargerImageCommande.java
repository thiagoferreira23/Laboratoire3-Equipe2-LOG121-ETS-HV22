package Commande;

import Model.PerspectivesImage;

import java.awt.image.BufferedImage;

/**
 * Cette classe permet d'effectuer l'importation des paramètres de l'image et du chemin dans l'instance
 * des perspectives.
 */


public class ChargerImageCommande implements Icommande{

    /**
     * Méthode qui permet de passer les paramètres de l'image et des muter
     * @param img la nouvelle image
     * @param chemin le chemin du fichier de l'image
     */
    public void execute(BufferedImage img,String chemin) {
        PerspectivesImage pi = PerspectivesImage.getInstance();
        pi.setImage(img);
        pi.setChemin(chemin);
    }


    @Override
    public void execute() {

    }
}
