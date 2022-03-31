package View;

import javax.swing.*;

/**
 * <p>Panneau principal qui contiendra les différents affichages
 * de cette application. Ce panneau sert comme le cœur du contenu
 * de cette application.</p>
 *
 * @author Thiago Ferreira
 * @version 1.0
 * @since 2022-03-28 8:33 p.m.
 */
public class VuePanneauPrincipal extends JPanel {

    /**
     * <p>Cette méthode agit comme constructeur par défaut et permet
     * d'appeler la méthode qui initialise tout les paramètres de ce
     * panneau principal contenant le contenu de l'application.</p>
     */
    public VuePanneauPrincipal() {
        initComposants();
    }

    /**
     * <p>Cette méthode permet de configurer tous les paramètres de ce panneau
     * principal contenant le contenu de l'application. Cela inclut, les trois
     * vues de l'application, ainsi que les paramètres de ce panneau
     * spécifique.</p>
     */
    private void initComposants() {
        setBorder(BorderFactory.
                createEmptyBorder(20,20,20,20));
        setBackground(VueFenetrePrincipale.BACKGROUND_THEME_CLAIR);
        setForeground(VueFenetrePrincipale.TEXT_THEME_CLAIR);
    }

    /**
     * <p>Cette méthode permet de créer une instance des panneaux contenant le
     * fichier d'image dont l'utilisateur pourra interagir, ainsi qu'un panneau
     * statique qui ne fait que présenter image à l'usager.</p>
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
