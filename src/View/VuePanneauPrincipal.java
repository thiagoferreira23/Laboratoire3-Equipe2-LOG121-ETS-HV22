package View;

import javax.swing.*;

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

    }

    /**
     * <p></p>
     */
    private void initComposants() {

    }

    /**
     * <p></p>
     */
    private void creerMenu() {
        VueMenuOptions menu = new VueMenuOptions();
        add(menu);
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
