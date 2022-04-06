package Commande;

import Model.PerspectivesImage;

public class SerializeCommande implements Icommande {


    @Override
    public void execute() {
        PerspectivesImage.getInstance().serialize("sauvegarde.ser");
    }
}
