package Controller;

import View.VueFenetreAPropos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <p>
 * TODO : Description de classe
 * </p>
 *
 * @author Thiago Ferreira
 * @version 1.0
 * @since 2022-03-28 8:33 p.m.
 */
public class MenuOptionsControleur implements ActionListener {

    public boolean aProposActif = false;

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(((JMenuItem) e.getSource()).getText()){
            case "Ouvrir" -> actionsOptionOuvrir();
            case "Sauvegarder" -> actionsOptionSauvegarder();
            case "Restaurer" -> actionsOptionRestaurer();
            case "Quitter" -> actionsOptionQuitter();
            case "Retour" -> actionsOptionRetour();
            case "Revenir" -> actionsOptionRevenir();
            case "À propos" -> actionsOptionAPropos();
        }
    }

    private void actionsOptionAPropos() {
        VueFenetreAPropos fenetreAPropos = new VueFenetreAPropos();
    }

    private void actionsOptionRevenir() {
    }

    private void actionsOptionRetour() {
    }

    private void actionsOptionQuitter() {
    }

    private void actionsOptionSauvegarder() {
    }

    private void actionsOptionRestaurer() {
    }

    private void actionsOptionOuvrir() {
    }
}
