package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

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
     * <p>
     * Cette méthode permet de configurer tous les paramètres de ce panneau
     * principal contenant le contenu de l'application. Cela inclut,
     * l'instanciation de la vue bienvenue, ainsi que les paramètres de ce
     * panneau.
     * </p>
     */
    private void initComposants() {
        setBorder(BorderFactory.
                createEmptyBorder(20, 20, 20, 20));
        setBackground(VueFenetrePrincipale.FOND_THEME_CLAIR);
        setForeground(VueFenetrePrincipale.TEXTE_THEME_CLAIR);

        setPreferredSize(new Dimension(VueFenetrePrincipale.LONGUEUR,
                VueFenetrePrincipale.HAUTEUR));

        GridBagLayout dispositionGrille = new GridBagLayout();
        GridBagConstraints contraintesDisposition = new GridBagConstraints();

        contraintesDisposition.gridwidth = 3;
        contraintesDisposition.gridheight = 2;

        dispositionGrille.setConstraints(this, contraintesDisposition);

        setLayout(dispositionGrille);
       // creerVueBienvenue();
        creerVuesImages();
    }

    /**
     * <p>
     * Cette méthode permet de créer une instance du panneau de bienvenue
     * qui sert comme écran d'accueil et qui introduit l'application à
     * l'usager.
     * </p>
     */
    private void creerVueBienvenue() {
        VuePanneauBienvenue bienvenue = new VuePanneauBienvenue();
        add(bienvenue);
    }

    /**
     * <p>
     * Cette méthode permet de créer une instance des panneaux contenant le
     * fichier d'image dont l'utilisateur pourra interagir, ainsi qu'un panneau
     * statique qui ne fait que présenter l'image à l'usager.
     * </p>
     */
    private void creerVuesImages() {
        VuePanneauImage contenuImage = new VuePanneauImage();
        add(contenuImage);
    }

    /**
     * <p>
     * Cette méthode publique accessible par l'entièreté du programme permet
     * de créer un libellé contenant une image désirée qui se retrouve dans le
     * dossier Images de ce projet.
     * </p>
     *
     * @param nomFichier Le nom exact du fichier de l'image
     * @param longueur   La longueur de l'image
     * @param hauteur    La hauteur de l'image
     */
    public static JLabel creerImage(String nomFichier, int longueur, int hauteur) {
        try {
            String typeFichierPNG = ".png"; //TODO : Changer pour variable
            String cheminDeBaseImages = "/Images/";

            BufferedImage typeImage;
            ImageIcon image;
            JLabel libelleImage;

            String chemin = cheminDeBaseImages + nomFichier + typeFichierPNG;

            typeImage = ImageIO.read(VuePanneauPrincipal.class.getResource(chemin));
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
