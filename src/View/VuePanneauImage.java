package View;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.io.File;

/**
 * <p>
 * Cette classe est responsable de créer et de placer les panneaux d'images
 * et de contenu sous un format spécifique en utilisant les méthodes de
 * placement avec grille disponible avec Java Swing (GridBagLayout). De plus,
 * cette classe contient des sous-classes qui sont respectives à chaque
 * panneau d'affichage (statique et dynamique).
 * </p>
 *
 * @author Thiago Ferreira
 * @version 1.0
 * @since 2022-03-31 9:35 a.m.
 */
public class VuePanneauImage extends JPanel {

    private static final Border border = BorderFactory.
            createEmptyBorder(5, 5, 5, 5);
    private static final int hauteur = VueFenetrePrincipale.HAUTEUR;
    private static final int longueur = VueFenetrePrincipale.LONGUEUR;

    /**
     * <p>
     * Cette méthode agit comme constructeur par défaut et permet d'appeler
     * la méthode qui initialise tous les paramètres de ce panneau et ajoute les
     * sous panneau de cette classe (statique et dynamique).
     * </p>
     */
    public VuePanneauImage() {
        initComposants();
        ajouterPanneauStatique();
        add(ajouterPanneauxDynamiques(), BorderLayout.EAST);
    }

    /**
     * <p>
     * Cette méthode permet de configurer tous les paramètres de ce panneau.
     * Cela inclut les paramètres de couleurs, de disposition, de taille
     * et autres.
     * </p>
     */
    private void initComposants() {
        setBorder(null);
        setBackground(VueFenetrePrincipale.FOND_THEME_CLAIR);
        setForeground(VueFenetrePrincipale.TEXTE_THEME_CLAIR);

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(longueur, hauteur));
    }

    /**
     * <p>
     * Cette méthode permet d'instancier une instance de la classe
     * VueImageStatique est créée. Cette instance ne permet que d'afficher
     * l'image.
     * </p>
     */
    private void ajouterPanneauStatique() {
        JPanel imageStatique = new VueImageStatique();
        imageStatique.setMinimumSize(new Dimension(426, 670));
        add(imageStatique, BorderLayout.WEST);
    }

    /**
     * <p>
     * Cette méthode permet d’instancier les deux instances de la classe
     * VueImageDynamique, chacune de ces classes est positionnée dans le
     * panneau (VuePanneauImage) et ajoutée à celui-ci.
     * </p>
     *
     * @return JPanel — Le panneau contenant les sous-panneaux permettant la
     * modification d'image.
     */
    private JPanel ajouterPanneauxDynamiques() {

        JPanel panneauContientPanneauxDynam = new JPanel();
        panneauContientPanneauxDynam.setLayout(new BorderLayout());
        panneauContientPanneauxDynam.setBackground(
                VueFenetrePrincipale.FOND_THEME_CLAIR);

        panneauContientPanneauxDynam.setMinimumSize(
                new Dimension(852, 670));

        JPanel imageDynamique1 = new VueImageDynamique();
        panneauContientPanneauxDynam.add(imageDynamique1,
                BorderLayout.NORTH);

        imageDynamique1.setMinimumSize(new Dimension(852, 335));

        JPanel imageDynamique2 = new VueImageDynamique();
        panneauContientPanneauxDynam.add(imageDynamique2,
                BorderLayout.SOUTH);

        imageDynamique2.setMinimumSize(new Dimension(852, 335));

        return panneauContientPanneauxDynam;
    }

    /**
     * <p>
     * Cette classe permet d'afficher l'image qui est ouverte par l'usager.
     * Cette image n'est pas modifiable et ne fait que fournir un aperçu
     * avec quelques informations additionnelles.
     * </p>
     *
     * @author Thiago Ferreira
     * @version 1.0
     * @since 2022-03-31 9:35 a.m.
     */
    public class VueImageStatique extends JPanel {

        /**
         * <p>
         * Cette méthode agit comme constructeur par défaut et permet
         * d'appeler la méthode qui initialise tous les paramètres de ce panneau.
         * </p>
         */
        public VueImageStatique() {
            initComposants();
        }

        /**
         * <p>
         * Cette méthode permet de configurer tous les paramètres de ce panneau.
         * Cela inclut les paramètres de couleurs, de taille et autres.
         * </p>
         */
        private void initComposants() {
            setBorder(border);
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            setBorder(new MatteBorder(0, 0, 0, 2,
                    VueFenetrePrincipale.DIVISEUR_THEME_CLAIR));

            setBackground(VueFenetrePrincipale.FOND_THEME_CLAIR);
            setForeground(VueFenetrePrincipale.TEXTE_THEME_CLAIR);

            configPanneau();
        }

        /**
         * <p>
         * Cette méthode permet de configurer le contenu du panneau
         * (VueImageStatique).
         * </p>
         */
        private void configPanneau() {
            JLabel logoPhotoEdit =
                    VuePanneauPrincipal.creerImage("App", 100, 100);
            JLabel titreLaboratoire = new JLabel("Laboratoire 3");
            JLabel sigleDuCours = new JLabel("LOG121");
            JLabel sessionAnnee = new JLabel("Hiver 2022");

            logoPhotoEdit.setAlignmentX(Component.CENTER_ALIGNMENT);
            titreLaboratoire.setAlignmentX(Component.CENTER_ALIGNMENT);
            sigleDuCours.setAlignmentX(Component.CENTER_ALIGNMENT);
            sessionAnnee.setAlignmentX(Component.CENTER_ALIGNMENT);

            add(logoPhotoEdit, BorderLayout.CENTER);
            add(Box.createRigidArea(new Dimension(426, 30)));

            add(titreLaboratoire, BorderLayout.CENTER);
            add(sigleDuCours, BorderLayout.CENTER);
            add(sessionAnnee, BorderLayout.CENTER);
        }
    }

    /**
     * <p>
     * Cette classe permet d'afficher l'image qui est ouverte par l'usager.
     * Par la suite, l'usager peut modifier cette image en utilisant les
     * différentes méthodes établies dans le patron Commande.
     * </p>
     *
     * @author Thiago Ferreira
     * @version 1.0
     * @since 2022-03-31 9:35 a.m.
     */
    public class VueImageDynamique extends JPanel {

        /**
         * <p>
         * Cette méthode agit comme constructeur par défaut et permet
         * d'appeler la méthode qui initialise tous les paramètres de ce panneau.
         * </p>
         */
        public VueImageDynamique() {
            initComposants();
        }

        /**
         * <p>
         * Cette méthode permet de configurer tous les paramètres de ce panneau.
         * Cela inclut les paramètres de couleurs, de taille et autres.
         * </p>
         */
        private void initComposants() {
            setBorder(border);
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            setBorder(new MatteBorder(0, 0, 2, 0,
                    VueFenetrePrincipale.DIVISEUR_THEME_CLAIR));
            setBackground(VueFenetrePrincipale.FOND_THEME_CLAIR);
            setForeground(VueFenetrePrincipale.TEXTE_THEME_CLAIR);
        }

        public void paint(Graphics g) {
            super.paintComponent(g);
            dessinerImage(g, new File("src/Images/mc-laren-red.jpg"));
        }

        public void dessinerImage(Graphics g, File imageChoisie) {

            Image mclaren;
            Graphics2D g2d = (Graphics2D) g;

            mclaren = new ImageIcon("src/Images/r8.jpg")
                    .getImage();

            g2d.drawImage(mclaren, 150, 0, 495, 330, null);
        }
    }
}