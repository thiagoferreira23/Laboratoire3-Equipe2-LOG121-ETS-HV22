package View;

import javax.swing.*;
import java.util.ArrayList;

/**
 * <p>Description de la classe</p>
 *
 * @author Franco Huynh, Gabriel M. Borges & Thiago Ferreira
 * @version 1.0
 * @since 2022-03-17 9:57 a.m.
 */
public class VueMenuOptions extends JMenuBar {

    private ArrayList<JMenu> optionsMenu = new ArrayList<JMenu>();

    /**
     * <p></p>
     */
    public VueMenuOptions() {
        initComposants();
    }

    /**
     * <p></p>
     */
    private void initComposants() {
        creerOptionsMenu();
    }

    private void creerOptionsMenu() {
        JMenu optionFichier = new JMenu("Fichier");
        JMenu optionEdition = new JMenu("Édition");
        JMenu optionAide = new JMenu("Aide");

        optionsMenu.add(optionFichier);
        optionsMenu.add(optionEdition);
        optionsMenu.add(optionAide);

        for (JMenu m : optionsMenu) {
            ajouterOptionsMenu(m);
            add(m);
        }
    }

    private void ajouterOptionsMenu(JMenu menu) {
        switch (menu.getText()) {
            case "Fichier" -> ajouterOptionsFichier(menu);
            case "Édition" -> ajouterOptionsEdition(menu);
            case "Aide" -> ajouterOptionsAide(menu);
            default -> System.out.println("Ce menu n'existe pas");
        }
    }

    private void ajouterOptionsFichier(JMenu menu) {
        JMenuItem optionOuvrir = new JMenuItem("Ouvrir");
        JMenuItem optionSauvegarder = new JMenuItem("Sauvegarder");
        JMenuItem optionQuitter = new JMenuItem("Quitter");

        menu.add(optionOuvrir);
        menu.add(optionSauvegarder);
        menu.add(optionQuitter);
    }

    private void ajouterOptionsEdition(JMenu menu) {
        JMenuItem optionRetour = new JMenuItem("Retour");
        JMenuItem optionRevenir = new JMenuItem("Revenir");
        JMenuItem optionZoomAvant = new JMenuItem("Zoom avant");
        JMenuItem optionZoomArriere = new JMenuItem("Zoom arrière");

        menu.add(optionRetour);
        menu.add(optionRevenir);
        menu.add(optionZoomAvant);
        menu.add(optionZoomArriere);
    }

    private void ajouterOptionsAide(JMenu menu) {
        JMenuItem optionAPropos = new JMenuItem("À propos");
        menu.add(optionAPropos);
    }
}
