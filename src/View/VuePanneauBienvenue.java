package View;

import javax.swing.*;
import java.awt.*;

/**
 * <p>Cette classe créé et configure un panneau de bienvenue qui sert comme
 * écran d'accueil et qui introduit l'application
 * à l'usager.</p>
 *
 * @author Thiago Ferreira
 * @version 1.0
 * @since 2022-03-31 9:36 a.m.
 */
public class VuePanneauBienvenue extends JPanel {


    private String messageBienvenue = "Bienvenue sur l'application " +
            "d'édition de photos";
    private String messageInstructions = "Pour débuter, veuillez ouvrir un " +
            "fichier à partir du menu";

    /**
     * <p>Cette méthode agit comme constructeur par défaut et permet d'appeler
     * la méthode qui initialise tous les paramètres de ce panneau de bienvenue.
     * </p>
     */
    public VuePanneauBienvenue() {
        initComposants();
    }

    /**
     * <p>
     * Cette méthode permet de configurer tous les paramètres de ce panneau de
     * bienvenue. Cela inclut, un bref texte d'introduction et d'explication
     * du fonctionnement initial de l'application.
     * </p>
     */
    private void initComposants() {

        setBackground(VueFenetrePrincipale.FOND_THEME_CLAIR);
        setForeground(VueFenetrePrincipale.TEXTE_THEME_CLAIR);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel mBienvenue = new JLabel(messageBienvenue);
        JLabel mInstructions = new JLabel(messageInstructions);
        JLabel logo = VuePanneauPrincipal.creerImage("App", 200, 200);

        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        mBienvenue.setAlignmentX(Component.CENTER_ALIGNMENT);
        mInstructions.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(logo, BorderLayout.CENTER);
        add(mBienvenue, BorderLayout.CENTER);
        add(mInstructions, BorderLayout.CENTER);
    }
}
