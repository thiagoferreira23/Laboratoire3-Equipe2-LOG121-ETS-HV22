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

    private JMenu appMenu = new JMenu();
    private ArrayList<JMenuItem> itemsMenu = new ArrayList<JMenuItem>();

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
        appMenu.setText("GUILabo3");
        add(appMenu);
    }

}
