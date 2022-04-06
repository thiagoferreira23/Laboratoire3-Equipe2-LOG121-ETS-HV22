package Commande;

import Model.PerspectivesImage;

import java.awt.image.BufferedImage;

public class ChargerImageCommande implements Icommande{


    public void execute(BufferedImage img,String chemin) {
        PerspectivesImage pi = PerspectivesImage.getInstance();
        pi.setImage(img);
        pi.setChemin(chemin);
    }


    @Override
    public void execute() {

    }
}
