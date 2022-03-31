package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

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
     *
     */
    public VuePanneauBienvenue() {
        initComposants();
    }

    /**
     *
     */
    private void initComposants() {

        setBackground(VueFenetrePrincipale.BACKGROUND_THEME_CLAIR);
        setForeground(VueFenetrePrincipale.TEXT_THEME_CLAIR);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel mBienvenue = new JLabel(messageBienvenue);
        JLabel mInstructions = new JLabel(messageInstructions);
        JLabel logo = ajouterImage("App", 200, 200);

        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        mBienvenue.setAlignmentX(Component.CENTER_ALIGNMENT);
        mInstructions.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(logo, BorderLayout.CENTER);
        add(mBienvenue, BorderLayout.CENTER);
        add(mInstructions, BorderLayout.CENTER);
    }

    /**
     * <p>Permet d'ajouter une image au panneau.</p>
     *
     * @param nomFichier Le nom exact du fichier de l'image
     * @param longueur   La longueur de l'image
     * @param hauteur    La hauteur de l'image
     */
    private JLabel ajouterImage(String nomFichier, int longueur, int hauteur) {
        try {
            String typeFichierPNG = ".png";
            String cheminDeBaseImages = "/Images/";

            BufferedImage typeImage;
            ImageIcon image;
            JLabel libelleImage;

            String chemin = cheminDeBaseImages + nomFichier + typeFichierPNG;

            typeImage = ImageIO.read(this.getClass().getResource(chemin));
            image = new ImageIcon(typeImage);
            Image img = image.getImage();
            Image nouvImage = img.getScaledInstance(longueur,
                    hauteur, Image.SCALE_SMOOTH);
            image = new ImageIcon(nouvImage);
            libelleImage = new JLabel(image);

            return libelleImage;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
