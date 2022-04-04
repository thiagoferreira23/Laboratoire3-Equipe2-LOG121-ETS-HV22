package Model;

import Observers.MyObservable;
import Observers.Observateur;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

/**
 * <p>Description de la classe</p>
 *
 * @author Franco Huynh, Gabriel M. Borges & Thiago Ferreira
 * @version 1.0
 * @since 2022-03-17 9:56 a.m.
 */
public class PerspectivesImage implements Serializable, MyObservable {

    private static int NB_IMAGE_MODIFIABLE = 2;
    private static int NB_IMAGE_FIXE = 1;


    private ArrayList<PerspectiveImageModifiable> perspectiveMod = new ArrayList<>();
    private ArrayList<PerspectiveImageFixe> perspectiveFixe = new ArrayList<>();
    private String chemin;
    private ArrayList<Observateur> observeurs = new ArrayList();
    private transient BufferedImage image;


    private static PerspectivesImage PImages = new PerspectivesImage(NB_IMAGE_MODIFIABLE,NB_IMAGE_FIXE);



    private PerspectivesImage(int nbModifiable,int nbFixe){

        for(int i=0;i<nbModifiable;i++){
            perspectiveMod.add(new PerspectiveImageModifiable());
        }

        for(int i=0;i<nbFixe;i++){
            perspectiveFixe.add(new PerspectiveImageFixe());
        }

    }



    public PerspectivesImage getInstance(){ return PImages;}


    public BufferedImage getImage(){return image;}

    public void setImage(BufferedImage image){this.image=image;}





    @Override
    public void addObservers(Observateur o) {
        observeurs.add(o);
    }

    @Override
    public void deleteObservers(Observateur o) {
        observeurs.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observateur o : observeurs){
            o.update();
        }
    }
}
