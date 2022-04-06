package Controller;

import Commande.ChargerImageCommande;
import View.VueFenetreAPropos;
import View.VuePanneauImage;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * <p>
 * Cette classe permet de contrôler les actions qui sont demandées par le menu
 * de l'application. Cela inclut, entre autres, l'ouverture d'un fichier,
 * la sauvegarde de paramètres, la possibilité de défaire et refaire une action.
 * </p>
 *
 * @author Thiago Ferreira & autres...
 * @version 1.0
 * @since 2022-03-28 8:33 p.m.
 */
public class MenuOptionsControleur implements ActionListener {

    /**
     * <p>
     * Cette méthode fait appel, à l'aide d'un interrupteur (switch),
     * aux méthodes qui correspondent à l'action de celui qui l'appelle
     * en analysant son nom (événement).
     * </p>
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
        System.exit(1);
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
        File fichierChoisi = ouvrirExplorateurFichier("Choisir un fichier " +
                        "de sauvegarde", "src/Ressources", ".tmp",
                new String[]{"tmp"});
    }

    /**
     * <p>Cette méthode gère les méthodes et les actions à être exécutées
     * lorsque l'option Ouvrir est sélectionnée à partir de son raccourci ou
     * à partir du menu.</p>
     */
    private void actionsOptionOuvrir() {
        File fichierChoisi = ouvrirExplorateurFichier("Choisir une image",
                "src/Images", "PNG, JPG, JPEG",
                new String[]{"png", "jpg", "jpeg"});

        VuePanneauImage panneauImage = new VuePanneauImage();
    }

    /**
     * Cette méthode permet de créer un sélecteur de fichier qui n'accepte que
     * les fichiers de type PNG, JPG et JPEG. Par la suite, elle retourne ce
     * fichier sous le format d'un « File ».
     *
     * @return Le fichier de type « File » choisi par l'usager.
     */
    private File ouvrirExplorateurFichier(String titre, String cheminInitial,
                                          String descriptionExt,
                                          String[] extension) {
        JFileChooser selecteur = new JFileChooser(cheminInitial);

        FileNameExtensionFilter filtrerAvecExtension =
                new FileNameExtensionFilter(descriptionExt, extension);

        selecteur.setDialogTitle(titre);
        selecteur.setAcceptAllFileFilterUsed(true);
        selecteur.addChoosableFileFilter(filtrerAvecExtension);
        selecteur.setFileFilter(filtrerAvecExtension);

        int statut = selecteur.showOpenDialog(null);

        if (statut == JFileChooser.APPROVE_OPTION) {
            System.out.println("le nom et l'extension de l'image choisie : " +
                    selecteur.getSelectedFile().getName());

            File selectedFile = selecteur.getSelectedFile();
            BufferedImage image = null;
            try {
                image = ImageIO.read(selectedFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

            ChargerImageCommande chargerImage = new ChargerImageCommande();
            chargerImage.execute(image,cheminInitial);

            return selecteur.getSelectedFile();
        }

        return null;
    }


}
