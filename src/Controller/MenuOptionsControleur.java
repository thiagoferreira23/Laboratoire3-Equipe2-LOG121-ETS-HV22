package Controller;

import View.VueFenetreAPropos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <p> Cette classe permet de controller les actions qui sont demander par
 * le menu de l"application. Cela inclus, entres autres, l'ouverture d'un
 * fichier, la sauvegarde de paramètres, la commande défaire et
 * la commande refaire.
 * </p>
 *
 * @author Thiago Ferreira & autres...
 * @version 1.0
 * @since 2022-03-28 8:33 p.m.
 */
public class MenuOptionsControleur implements ActionListener {

    /**
     * <p>Cette méthode fait appel, à l'aide d'un switch, aux méthodes qui
     * correspondent à l'action de celui qui l'appelle en analysant son
     * nom (événement).</p>
     *
     * @param e L'événement déclencheur de l'action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (((JMenuItem) e.getSource()).getText()) {
            case "Ouvrir" -> actionsOptionOuvrir();
            case "Sauvegarder" -> actionsOptionSauvegarder();
            case "Restaurer" -> actionsOptionRestaurer();
            case "Quitter" -> actionsOptionQuitter();
            case "Retour" -> actionsOptionRetour();
            case "Revenir" -> actionsOptionRevenir();
            case "À propos" -> actionsOptionAPropos();
        }
    }

    /**
     * <p>Cette méthode gère les méthodes et les actions à être exécutées
     * lorsque l'option À Propos est sélectionnée à partir de son raccourci ou
     * à partir du menu.</p>
     */
    private void actionsOptionAPropos() {
        VueFenetreAPropos fenetreAPropos = new VueFenetreAPropos();
    }

    /**
     * <p>Cette méthode gère les méthodes et les actions à être exécutées
     * lorsque l'option Revenir est sélectionnée à partir de son raccourci ou
     * à partir du menu.</p>
     */
    private void actionsOptionRevenir() {
    }

    /**
     * <p>Cette méthode gère les méthodes et les actions à être exécutées
     * lorsque l'option Retour est sélectionnée à partir de son raccourci ou
     * à partir du menu.</p>
     */
    private void actionsOptionRetour() {
    }

    /**
     * <p>Cette méthode gère les méthodes et les actions à être exécutées
     * lorsque l'option Quitter est sélectionnée à partir de son raccourci ou
     * à partir du menu.</p>
     */
    private void actionsOptionQuitter() {
    }

    /**
     * <p>Cette méthode gère les méthodes et les actions à être exécutées
     * lorsque l'option Sauvegarder est sélectionnée à partir de son raccourci
     * ou à partir du menu.</p>
     */
    private void actionsOptionSauvegarder() {
    }

    /**
     * <p>Cette méthode gère les méthodes et les actions à être exécutées
     * lorsque l'option Restaurer est sélectionnée à partir de son raccourci ou
     * à partir du menu.</p>
     */
    private void actionsOptionRestaurer() {
    }

    /**
     * <p>Cette méthode gère les méthodes et les actions à être exécutées
     * lorsque l'option Ouvrir est sélectionnée à partir de son raccourci ou
     * à partir du menu.</p>
     */
    private void actionsOptionOuvrir() {
    }
}
