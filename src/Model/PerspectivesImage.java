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


    private ArrayList<PerspectiveImageModifiable> perspectivesMod = new ArrayList<>();
    private ArrayList<PerspectiveImageFixe> perspectiveFixe = new ArrayList<>();
    private String chemin;
    private ArrayList<Observateur> observeurs = new ArrayList();
    private transient BufferedImage image;


    private static PerspectivesImage PImages = new PerspectivesImage(NB_IMAGE_MODIFIABLE,NB_IMAGE_FIXE);



    private PerspectivesImage(int nbModifiable,int nbFixe){

        for(int i=0;i<nbModifiable;i++){
            perspectivesMod.add(new PerspectiveImageModifiable());
        }

        for(int i=0;i<nbFixe;i++){
            perspectiveFixe.add(new PerspectiveImageFixe());
        }

    }


    //Getter
    public PerspectivesImage getInstance(){ return PImages;}

    public String getChemin(){return chemin;}

    public BufferedImage getImage(){return image;}

    public ArrayList<PerspectiveImageModifiable> getPerspectivesMod(){return perspectivesMod;}

    public ArrayList<PerspectiveImageFixe> getPerspectiveFixe(){return perspectiveFixe;}


    //Setter
    public void setImage(BufferedImage image){this.image=image;}

    public void setChemin(String chemin){this.chemin=chemin;}

    public void setPerspectivesMod(ArrayList<PerspectiveImageModifiable> pMod){
        this.perspectivesMod=pMod;
    }

    public void setPerspectiveFixe(ArrayList<PerspectiveImageFixe> pFixe){
        this.perspectiveFixe=pFixe;
    }


    public void serialize(String chemin){
        try {
            FileOutputStream fileOut =
                    new FileOutputStream(chemin);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.getInstance());
            out.close();
            fileOut.close();
            System.out.printf("Les données de sérialisation sont enregistré dans " + chemin);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }



    public void deserialize(){
        PerspectivesImage pi = null;
        try {
            FileInputStream fileIn = new FileInputStream(chemin);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            pi = (PerspectivesImage) in.readObject();
            in.close();
            fileIn.close();

            this.setChemin(pi.getChemin());

            this.setPerspectivesMod(pi.getPerspectivesMod());
            this.setPerspectiveFixe(pi.getPerspectiveFixe());
            this.setImage(pi.getImage());


        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("PerspectivesImage class not found");
            c.printStackTrace();
            return;
        }

    }











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
