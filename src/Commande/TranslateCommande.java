package Commande;

import Model.PerspectiveImageModifiable;

import java.awt.*;

public class TranslateCommande implements Icommande{

    private PerspectiveImageModifiable perspectiveImageModifiable;
    private int positionX;
    private int positionY;

    public TranslateCommande(PerspectiveImageModifiable perspectiveImageModifiable, int positionX, int positionY) {
        this.perspectiveImageModifiable = perspectiveImageModifiable;
        this.positionX = positionX;
        this.positionY = positionY;
    }
    @Override
    public void execute() {
        this.perspectiveImageModifiable.setPos(new Point(positionX, positionY));
    }
}
