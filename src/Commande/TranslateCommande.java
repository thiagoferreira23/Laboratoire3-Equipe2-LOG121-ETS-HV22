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
    /**
     * <p>Cette méthode gère l'execution de la commande undo</p>
     */
    public void undo(){}
    /**
     * <p>Cette méthode gère l'execution de la commande translate</p>
     */
    @Override
    public void execute() {
        this.perspectiveImageModifiable.setPos(new Point(positionX, positionY));
    }
}