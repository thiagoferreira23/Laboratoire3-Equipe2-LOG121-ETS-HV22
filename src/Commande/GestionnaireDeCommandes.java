package Commande;

import java.util.ArrayList;

/**
 * <p>Description de la classe Singleton</p>
 *
 * @author Franco Huynh, Gabriel M. Borges & Thiago Ferreira
 * @version 1.0
 * @since 2022-03-17 9:57 a.m.
 */
public class GestionnaireDeCommandes {

    private ArrayList<Icommande> lstCommandes;
    private static GestionnaireDeCommandes single_instance = null;

    private GestionnaireDeCommandes() {
    }

    public static GestionnaireDeCommandes getInstance() {
        if (single_instance == null)
            single_instance = new GestionnaireDeCommandes();

        return single_instance;
    }


    public void execute(Icommande cmd) {

        cmd.execute();
        lstCommandes.add(cmd);

    }


}
