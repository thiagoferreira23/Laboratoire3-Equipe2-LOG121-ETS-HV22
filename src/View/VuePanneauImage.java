package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * <p>Description de la classe</p>
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

    public VuePanneauImage() {
        initComposants();
        ajouterPanneaux();
    }

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

    private void ajouterPanneaux() {
        JPanel imageStatique = new VueImageStatique();
        contraintesDisposition.gridx = 0;

        add(imageStatique, contraintesDisposition);

        JPanel imageDynamique1 = new VueImageChangements();
        contraintesDisposition.gridx = 2;
        contraintesDisposition.gridy = 1;

        add(imageDynamique1, contraintesDisposition);

        JPanel imageDynamique2 = new VueImageChangements();
        contraintesDisposition.gridx = 2;
        contraintesDisposition.gridy = 2;

        imageDynamique2.setBackground(Color.ORANGE);
        add(imageDynamique2, contraintesDisposition);
    }

    /**
     * <p>Description de la classe</p>
     *
     * @author Thiago Ferreira
     * @version 1.0
     * @since 2022-03-31 9:35 a.m.
     */
    public class VueImageStatique extends JPanel {
        public VueImageStatique() {
            initComposants();
        }

        private void initComposants() {
            setBorder(BORDURE_FENETRE);
            //setBackground(VueFenetrePrincipale.FOND_THEME_CLAIR);
            setBackground(Color.BLUE);
            setForeground(VueFenetrePrincipale.TEXTE_THEME_CLAIR);
            setSize(50, 720);
        }
    }

    /**
     * <p>Description de la classe</p>
     *
     * @author Thiago Ferreira
     * @version 1.0
     * @since 2022-03-31 9:35 a.m.
     */
    public class VueImageChangements extends JPanel {
        public VueImageChangements() {
            initComposants();
        }

        private void initComposants() {
            setBorder(BORDURE_FENETRE);
            setBackground(Color.GREEN);
            setForeground(VueFenetrePrincipale.TEXTE_THEME_CLAIR);
        }
    }
}
