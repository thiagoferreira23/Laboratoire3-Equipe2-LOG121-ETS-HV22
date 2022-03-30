package View;

import javax.swing.*;
import java.awt.*;

/**
 * <p>Panneau principal qui contiendra le menu et les différents affichages
 * de cette application. Ce panneau sert comme le cœur du contenu
 * de cette application.</p>
 *
 * @author Alexandre Bouillon, Franco Huynh, Gabriel M. Borges & Thiago Ferreira
 * @version 1.0
 * @since 2022-03-28 8:33 p.m.
 */
public class VuePanneauPrincipal extends JPanel {

    /**
     * <p></p>
     */
    public VuePanneauPrincipal() {
        initComposants();
    }

    /**
     * <p></p>
     */
    private void initComposants() {
        this.setBorder(BorderFactory.
                createEmptyBorder(20,20,20,20));
        this.setBackground(Color.decode("#222222"));
    }

    /**
     * <p></p>
     */
    private void creerVuesImages() {
        VuePanneauImageSansChangement sansChangement =
                new VuePanneauImageSansChangement();
        VuePanneauImageAvecChangements avecChangements =
                new VuePanneauImageAvecChangements();

        add(sansChangement);
        add(avecChangements);
    }
}
