package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

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

    public static final Border BORDURE_FENETRE = BorderFactory.
            createEmptyBorder(20, 20, 20, 20);

    private GridBagLayout dispositionGrille = new GridBagLayout();
    private GridBagConstraints contraintesDisposition = new GridBagConstraints();

    /**
     * <p>
     * Cette méthode agit comme constructeur par défaut et permet d'appeler
     * la méthode qui initialise tous les paramètres de ce panneau et ajoute les
     * sous panneau de cette classe (statique et dynamique).
     * </p>
     */
    public VuePanneauImage() {
        initComposants();
        ajouterPanneaux();
    }

    /**
     * <p>
     * Cette méthode permet de configurer tous les paramètres de ce panneau.
     * Cela inclut les paramètres de couleurs, de disposition, de taille
     * et autres.
     * </p>
     */
    private void initComposants() {
        setBorder(BORDURE_FENETRE);
        setBackground(VueFenetrePrincipale.FOND_THEME_CLAIR);
        setForeground(VueFenetrePrincipale.TEXTE_THEME_CLAIR);

        setSize(VueFenetrePrincipale.LONGUEUR, VueFenetrePrincipale.HAUTEUR);

        contraintesDisposition.gridwidth = 2;
        contraintesDisposition.gridheight = 2;

        dispositionGrille.setConstraints(this, contraintesDisposition);

        setLayout(dispositionGrille);
    }

    /**
     * <p>
     * Cette méthode permet d'instancier les trois vues de cette application.
     * Une instance de la classe VueImageStatique est créée et deux instances
     * de la classe VueImageDynamique sont créées. Par la suite, chacune de ces
     * classes est positionnée dans la grille et ajoutée au panneau
     * VuePanneauImage.
     * </p>
     */
    private void ajouterPanneaux() {
        JPanel imageStatique = new VueImageStatique();
        contraintesDisposition.gridx = 0;

        add(imageStatique, contraintesDisposition);

        JPanel imageDynamique1 = new VueImageDynamique();
        contraintesDisposition.gridx = 2;
        contraintesDisposition.gridy = 1;

        add(imageDynamique1, contraintesDisposition);

        JPanel imageDynamique2 = new VueImageDynamique();
        contraintesDisposition.gridx = 2;
        contraintesDisposition.gridy = 2;

        imageDynamique2.setBackground(Color.ORANGE);
        add(imageDynamique2, contraintesDisposition);
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
            setBorder(BORDURE_FENETRE);
            //setBackground(VueFenetrePrincipale.FOND_THEME_CLAIR);
            setBackground(Color.BLUE);
            setForeground(VueFenetrePrincipale.TEXTE_THEME_CLAIR);
            setSize(50, 720);
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
            setBorder(BORDURE_FENETRE);
            setBackground(Color.GREEN);
            setForeground(VueFenetrePrincipale.TEXTE_THEME_CLAIR);
        }
    }
}
