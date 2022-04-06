package Commande;

import Model.PerspectivesImage;

public class DeserializeCommande implements Icommande{


    @Override
    public void execute() {
        PerspectivesImage.getInstance().deserialize("sauvegarde.ser");
    }
}
