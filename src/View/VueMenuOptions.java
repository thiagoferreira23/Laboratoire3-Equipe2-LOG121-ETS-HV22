package View;

import Controller.MenuOptionsControleur;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.InputEvent;
import java.util.ArrayList;

/**
 * <p>Cette classe contient le menu d’options de l’application.
 * Elle permet d’ouvrir un fichier d’image, de sauvegarder des paramètres,
 * de charger des paramètres et d’accéder à un menu d’aide.</p>
 *
 * @author Thiago Ferreira
 * @version 1.0
 * @since 2022-03-17 9:57 a.m.
 */
public class VueMenuOptions extends JMenuBar {

    private ArrayList<JMenu> optionsMenu = new ArrayList<JMenu>();

    /**
     * <p>Cette méthode agit comme constructeur par défaut et permet d'appeler
     * la méthode qui initialise tout les paramètres du menu
     * de cette application.</p>
     */
    public VueMenuOptions() {
        initComposants();
    }

    /**
     * <p>Cette méthode permet de configurer tous les paramètres de ce menu.
     * Cela inclut, les trois options du menu (Fichier, édition et aide),
     * ainsi que les sous options de chacun de ces options.</p>
     */
    private void initComposants() {
        setBackground(VueFenetrePrincipale.BACKGROUND_THEME_CLAIR);
        setForeground(VueFenetrePrincipale.TEXT_THEME_CLAIR);
        setBorder(new MatteBorder(0, 0, 2, 0, Color.decode("#454545")));

        creerOptionsMenu();
    }

    /**
     * <p>Cette méthode permet d'instancier et d'ajouter au menu les options
     * principales de cette application.</p>
     */
    private void creerOptionsMenu() {
        JMenu optionFichier = new JMenu("Fichier");
        JMenu optionEdition = new JMenu("Édition");
        JMenu optionAide = new JMenu("Aide");

        optionsMenu.add(optionFichier);
        optionsMenu.add(optionEdition);
        optionsMenu.add(optionAide);

        for (JMenu m : optionsMenu) {
            m.setForeground(VueFenetrePrincipale.TEXT_THEME_CLAIR);
            ajouterOptionsMenu(m);
            add(m);
        }
    }

    /**
     * <p>Cette méthode permet d'ajouter à chacune des options principale du
     * menu leurs sous actions (par exemple, ouvrir, sauvegarder, etc.).</p>
     *
     * @param menu Le menu auquel les options doivent être ajoutées.
     */
    private void ajouterOptionsMenu(JMenu menu) {
        switch (menu.getText()) {
            case "Fichier" -> ajouterOptionsFichier(menu);
            case "Édition" -> ajouterOptionsEdition(menu);
            case "Aide" -> ajouterOptionsAide(menu);
            default -> System.out.println("Ce menu n'existe pas");
        }
    }

    /**
     * <p>Cette méthode ajoute les options du l'option Fichier menu.</p>
     *
     * @param menu Le menu auquel les options doivent être ajoutées.
     */
    private void ajouterOptionsFichier(JMenu menu) {
        JMenuItem optionOuvrir = new JMenuItem("Ouvrir");
        JMenuItem optionSauvegarder = new JMenuItem("Sauvegarder");
        JMenuItem optionRestaurer = new JMenuItem("Restaurer");
        JMenuItem optionQuitter = new JMenuItem("Quitter");

        configItemMenu(menu, 'O', optionOuvrir);
        configItemMenu(menu, 'S', optionSauvegarder);
        configItemMenu(menu, 'R', optionRestaurer);
        configItemMenu(menu, 'Q', optionQuitter);
    }

    /**
     * <p>Cette méthode ajoute les options du l'option Édition menu.</p>
     *
     * @param menu Le menu auquel les options doivent être ajoutées.
     */
    private void ajouterOptionsEdition(JMenu menu) {
        JMenuItem optionRetour = new JMenuItem("Retour");
        JMenuItem optionRevenir = new JMenuItem("Revenir");

        configItemMenu(menu, 'Z', optionRetour);
        configItemMenu(menu, 'Y', optionRevenir);
    }

    /**
     * <p>Cette méthode ajoute les options du l'option Aide menu.</p>
     *
     * @param menu Le menu auquel les options doivent être ajoutées.
     */
    private void ajouterOptionsAide(JMenu menu) {
        JMenuItem optionAPropos = new JMenuItem("À propos");
        configItemMenu(menu, '1', optionAPropos);
    }

    /**
     * <p>Cette méthode permet de configurer les paramètres des items du menu.</p>
     *
     * @param menu       Le menu auquel les options doivent être ajoutées.
     * @param sousOption La sous-option du menu.
     */
    private void configItemMenu(JMenu menu, char touche, JMenuItem sousOption) {
        sousOption.setBackground(VueFenetrePrincipale.BACKGROUND_THEME_CLAIR);
        sousOption.setForeground(VueFenetrePrincipale.TEXT_THEME_CLAIR);

        /*
         * Cet IF-ELSE permet de détecter le type de système d'exploitation sur
         * lequel l'application est exécutée et d'assigner les bonnes touches de
         * raccourcis correspondants.
         */
        if (System.getProperty("os.name").equals("Mac OS X")) {
            sousOption.setAccelerator(KeyStroke.getKeyStroke(touche,
                    InputEvent.META_DOWN_MASK));
        } else {
            sousOption.setAccelerator(KeyStroke.getKeyStroke(touche,
                    InputEvent.CTRL_DOWN_MASK));
        }

        sousOption.addActionListener(new MenuOptionsControleur());
        menu.add(sousOption);
    }
}
