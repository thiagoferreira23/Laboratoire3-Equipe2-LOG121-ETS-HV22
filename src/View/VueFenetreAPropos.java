package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * <p>Cette classe contient le menu d’options de l’application.
 * Elle permet d’ouvrir un fichier d’image, de sauvegarder des paramètres,
 * de charger des paramètres et d’accéder à un menu d’aide.</p>
 *
 * @author Thiago Ferreira
 * @version 1.0
 * @since 2022-03-31 8:29 p.m.
 */
public class VueFenetreAPropos extends JFrame {

    //Titre de la fenêtre
    public static final String TITRE = "À propos";

    //Dimensions de la fenêtre d'accueil séparer en longueur et hauteur.
    public static final int LONGUEUR = 350;
    public static final int HAUTEUR = 350;

    /**
     * <p>Cette méthode agit comme constructeur par défaut et permet d'appeler
     * la méthode qui initialise tout les paramètres de
     * cette fenêtre d'affichage.</p>
     */
    public VueFenetreAPropos() {
        initComposants();
    }

    /**
     * <p>Cette méthode permet de configurer tous les paramètres de cette
     * fenêtre d'affichage. Cela inclut, entre autres, le titre de
     * l'application, sa taille initiale et ses paramètres de fenêtre.</p>
     */
    private void initComposants() {
        setTitle(TITRE);
        setSize(LONGUEUR, HAUTEUR);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        getContentPane().setBackground(
                VueFenetrePrincipale.BACKGROUND_THEME_CLAIR);
        getContentPane().setForeground(
                VueFenetrePrincipale.TEXT_THEME_CLAIR);

        creerPanneau();
        setVisible(true);
    }

    /**
     * <p>Cette méthode permet de créer une instance du panneau principal qui
     * contient le menu et les différents affichages de cette application.
     * Ce panneau sert comme le cœur du contenu de cette application. </p>
     */
    private void creerPanneau() {
        JPanel panneauAPropos = new JPanel();
        configPanneau(panneauAPropos);
        add(panneauAPropos);
    }

    /**
     * <p>Cette méthode permet de configurer le panneau À Propos avec
     * ses paramètres et son contenu unique.</p>
     *
     * @param panneau Le panneau qui recevra les paramètres et
     *                qui contiendra le contenu.
     */
    private void configPanneau(JPanel panneau) {

        panneau.setBackground(VueFenetrePrincipale.BACKGROUND_THEME_CLAIR);
        panneau.setForeground(VueFenetrePrincipale.TEXT_THEME_CLAIR);

        panneau.setLayout(new BoxLayout(panneau, BoxLayout.Y_AXIS));

        JLabel messageCreateurs = new JLabel("<html><body style=\"text-align: center\">Application créer par :<br>" +
                "Bouillon, Alexandre<br>Borges, Gabriel M.<br>" +
                "Ferreira, Thiago<br>Huynh, Franco</body></html>/n", SwingConstants.CENTER);
        JLabel messageDroitsAuteur = new JLabel("© Tous droits réservés.");

        JLabel logo = VuePanneauPrincipal.creerImage("App", 180, 180);

        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        messageCreateurs.setAlignmentX(Component.CENTER_ALIGNMENT);
        messageDroitsAuteur.setAlignmentX(Component.CENTER_ALIGNMENT);

        panneau.add(logo, BorderLayout.CENTER);
        panneau.add(messageCreateurs, BorderLayout.CENTER);
        panneau.add(Box.createRigidArea(new Dimension(0, 10)));
        panneau.add(messageDroitsAuteur, BorderLayout.CENTER);
    }
}
