package View;

import Model.PerspectiveImageFixe;
import Model.PerspectiveImageModifiable;
import Model.PerspectivesImage;
import Observers.Observateur;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
public class VuePanneauImage extends JPanel implements Observateur {

    private static final Border border = BorderFactory.
            createEmptyBorder(5, 5, 5, 5);
    private static final int hauteur = VueFenetrePrincipale.HAUTEUR;
    private static final int longueur = VueFenetrePrincipale.LONGUEUR;

    PerspectivesImage perspectives = PerspectivesImage.getInstance();

    PerspectiveImageModifiable pim1;
    PerspectiveImageModifiable pim2;
    PerspectiveImageFixe pif1;

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
        pif1 = perspectives.getPerspectiveFixe().get(0);
        pif1.addObservers(this);
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

        pim1 = perspectives.getPerspectivesMod().get(0);
        pim1.addObservers(this);
        pim2 = perspectives.getPerspectivesMod().get(1);
        pim2.addObservers(this);

        return panneauContientPanneauxDynam;
    }

    @Override
    public void update() {
        validate();
        repaint();
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

        private JLabel imageUtilisateur = new JLabel(" ");

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
         *  Cette méthode permet de configurer le contenu du panneau
         *  (VueImageStatique).
         * </p>
         */
        private void configPanneau() {
            JLabel logoPhotoEdit =
                    VuePanneauPrincipal.creerImage("App", 100, 100);
            JLabel titreLaboratoire = new JLabel("Laboratoire 3");
            JLabel sigleDuCours = new JLabel("LOG121");
            JLabel sessionAnnee = new JLabel("Hiver 2022");

            imageUtilisateur.setPreferredSize(new Dimension(300, 200));

            imageUtilisateur.setAlignmentX(Component.CENTER_ALIGNMENT);
            logoPhotoEdit.setAlignmentX(Component.CENTER_ALIGNMENT);
            titreLaboratoire.setAlignmentX(Component.CENTER_ALIGNMENT);
            sigleDuCours.setAlignmentX(Component.CENTER_ALIGNMENT);
            sessionAnnee.setAlignmentX(Component.CENTER_ALIGNMENT);

            add(imageUtilisateur, BorderLayout.CENTER);
            add(Box.createRigidArea(new Dimension(426, 200)));

            add(logoPhotoEdit, BorderLayout.CENTER);
            add(Box.createRigidArea(new Dimension(426, 30)));

            add(titreLaboratoire, BorderLayout.CENTER);
            add(sigleDuCours, BorderLayout.CENTER);
            add(sessionAnnee, BorderLayout.CENTER);
        }

        public void paint(Graphics g) {
            super.paint(g);
            dessinerImage(g);
        }

        public void dessinerImage(Graphics g){

            BufferedImage image = perspectives.getImage();
            Graphics2D g2d = (Graphics2D) g;

            Point pos = perspectives.getPerspectiveFixe().get(0).getPos();
            g2d.drawImage(image, pos.x, pos.y,150,150,this);

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

        private JLabel imageUtilisateur = new JLabel(" ");

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

            configPanneau();
        }

        public void paint(Graphics g) {
            super.paint(g);
            dessinerImage(g);
        }


        public void dessinerImage(Graphics g){

            BufferedImage image = null;
            image = perspectives.getImage();
            Graphics2D g2d = (Graphics2D) g;

            if(image != null){
                Dimension imageSize = new Dimension(image.getWidth(),image.getHeight());
                Dimension nouvelleSize = getScaledDimension(imageSize);

                g2d.scale(perspectives.getPerspectivesMod().get(0).getZoom(),perspectives.getPerspectivesMod().get(0).getZoom());
                g2d.drawImage(image, 0, 0,nouvelleSize.width,nouvelleSize.height,this);


            }


        }

        /**
         * Méthode pour obtenir les nouvelles dimensions d'une image en gardant le ratio de l'image original.
         *
         * Inspiré de "https://stackoverflow.com/questions/10245220/java-image-resize-maintain-aspect-ratio"
         * @param imageSize
         * @return
         */
        public Dimension getScaledDimension(Dimension imageSize){
            int o_largeur = imageSize.width;
            int o_hauteur = imageSize.height;
            int panel_largeur = 852;
            int panel_hauteur = 335;
            int new_largeur = o_largeur;
            int new_hateur = o_hauteur;

            if(o_largeur > panel_largeur){
                new_largeur=panel_largeur;
                new_hateur = (new_largeur * o_hauteur)/o_largeur;
            }

            if(new_hateur > panel_hauteur){
                new_hateur = panel_hauteur;
                new_largeur = (new_hateur * o_largeur)/o_hauteur;
            }
            return new Dimension(new_largeur,new_hateur);
        }


        /**
         * <p>
         *  Cette méthode permet de configurer le contenu du panneau
         *  (VueImageStatique).
         * </p>
         */
        private void configPanneau() {
            imageUtilisateur.setPreferredSize(new Dimension(852, 335));
            imageUtilisateur.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(imageUtilisateur, BorderLayout.CENTER);
        }
    }







}