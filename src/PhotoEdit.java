import View.VueFenetrePrincipale;

import javax.swing.*;

/**
 * <p>Cette classe contient la méthode permettant d'exécuter le programme et
 * son interface graphique.</p>
 *
 * @author Alexandre Bouillon, Franco Huynh, Gabriel M. Borges & Thiago Ferreira
 * @version 1.0
 * @since 2022-03-28 8:33 p.m.
 */

public class PhotoEdit {
    public static void main(String[] args) {

        VueFenetrePrincipale principal = new VueFenetrePrincipale();
        SwingUtilities.invokeLater(principal);
        
    }
}
