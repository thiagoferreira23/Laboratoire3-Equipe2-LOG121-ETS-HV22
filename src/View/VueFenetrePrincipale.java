package View;

import javax.swing.*;
import java.awt.*;

/**
 * <p>Cette classe est le conteneur graphique (JFrame) qui est responsable de
 * contenir tous les éléments graphiques de cette application. Elle permet aussi
 * d'agir comme élément exécutable de l'application en implémentant
 * la classe Runnable.</p>
 *
 * @author Thiago Ferreira
 * @version 1.0
 * @since 2022-03-28 8:33 p.m.
 */
public class VueFenetrePrincipale extends JFrame implements Runnable {
 
    //Titre de la fenêtre de l'application.
    public static final String TITRE = "PhotoEdit";

    //Dimensions de la fenêtre d'accueil séparer en longueur et hauteur.
    public static final int LONGUEUR = 1280;
    public static final int HAUTEUR = 720;

    //Dimensions minimum de la fenêtre d'accueil séparer en longueur et hauteur.
    public static final int MIN_LONGUEUR = 630;
    public static final int MIN_HAUTEUR = 500;

    //Couleur de fond et couleur de texte pour un thème sombre
    public static final Color FOND_THEME_CLAIR = Color.decode("#FFFFFF");
    public static final Color DIVISEUR_THEME_CLAIR = Color.decode("#454545");
    public static final Color TEXTE_THEME_CLAIR = Color.BLACK;

    /**
     * <p>Cette méthode agit comme constructeur par défaut et permet d'appeler
     * la méthode qui initialise tout les paramètres de
     * cette fenêtre d'affichage.</p>
     */
    public VueFenetrePrincipale(){
        initComposants();
    }

    /**
     * <p>Cette méthode permet de configurer tous les paramètres de cette
     * fenêtre d'affichage. Cela inclut, entre autres, le titre de
     * l'application, sa taille initiale et ses paramètres de fenêtre.</p>
     */
    private void initComposants(){
        setTitle(TITRE);
        setSize(LONGUEUR, HAUTEUR);
        setMinimumSize(new Dimension(MIN_LONGUEUR, MIN_HAUTEUR));
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setBackground(FOND_THEME_CLAIR);
        getContentPane().setForeground(TEXTE_THEME_CLAIR);

        creerPanneauPrincipal();
        creerMenu();
        setVisible(true);
    }

    /**
     * <p>Cette méthode permet de créer une instance du panneau principal qui
     * contient le menu et les différents affichages de cette application.
     * Ce panneau sert comme le cœur du contenu de cette application. </p>
     */
    private void creerPanneauPrincipal() {
        VuePanneauPrincipal principal = new VuePanneauPrincipal();
        add(principal);
    }

    private void creerMenu() {
        VueMenuOptions menu = new VueMenuOptions();
        setJMenuBar(menu);
    }

    /**
     * <p>Cette méthode permet d'exécuter tout les components graphique de
     * l'application.</p>
     */
    @Override
    public void run() {

    }
}
