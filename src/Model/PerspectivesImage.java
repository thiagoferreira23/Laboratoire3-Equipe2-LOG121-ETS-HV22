package Model;

import Observers.MyObservable;
import Observers.Observateur;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

/**
 * <p>Cette classe utilise le patron Singleton et permet de créer les perspectives nécessaires pour le modèle,
 * elle permet également d'effectuer la sérialisation et désérialisation pour les fichiers. </p>
 *
 * @author Alexandre Bouillon
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


    /**
     * Créateur de l'instance avec le nombre de chaque type de perspective à créer
     * @param nbModifiable Nombre d'instances modifiable à créer
     * @param nbFixe Nombre d'instances fixe à créer
     */
    private PerspectivesImage(int nbModifiable,int nbFixe){

        for(int i=0;i<nbModifiable;i++){
            perspectivesMod.add(new PerspectiveImageModifiable());
        }

        for(int i=0;i<nbFixe;i++){
            perspectiveFixe.add(new PerspectiveImageFixe());
        }

    }


    /**
     * Accesseur de l'instance des perspectives
     * @return l'instance des perspectives
     */
    public static PerspectivesImage getInstance(){ return PImages;}

    /**
     * Accesseur du chemin de l'image
     * @return Le chemin du fichier
     */
    public String getChemin(){return chemin;}

    /**
     * Accesseur de l'image de base des perspectives
     * @return L'image des perspectives
     */
    public BufferedImage getImage(){return image;}

    /**
     * Accesseur de la liste des perspectives modifiable
     * @return La liste des perspectives modifiable
     */
    public ArrayList<PerspectiveImageModifiable> getPerspectivesMod(){return perspectivesMod;}

    /**
     * Accesseur de la liste des perspectives fixe
     * @return La liste des perspectives fixe
     */
    public ArrayList<PerspectiveImageFixe> getPerspectiveFixe(){return perspectiveFixe;}


    /**
     * Mutateur de l'image de l'instance et avertit les observateurs de l'instance
     * @param image La nouvelle image
     */
    public void setImage(BufferedImage image){
        this.image=image;
        for(PerspectiveImageModifiable pim : this.perspectivesMod){
            pim.notifyObservers();
        }
        for(PerspectiveImageFixe pif : this.perspectiveFixe){
            pif.notifyObservers();
        }
    }

    /**
     * Mutateur du chemin du fichier de l'image
     * @param chemin le chemin du fichier
     */
    public void setChemin(String chemin){this.chemin=chemin;}

    /**
     * Mutateur de la liste des perspectives modifiable
     * @param pMod La nouvelle liste des perspectives
     */
    public void setPerspectivesMod(ArrayList<PerspectiveImageModifiable> pMod){
        this.perspectivesMod=pMod;
    }


    public void setPerspectiveFixe(ArrayList<PerspectiveImageFixe> pFixe){
        this.perspectiveFixe=pFixe;
    }



    /**
     * Cette méthode permet d'effectuer la sauvegarde et sérialisation de l'instance.
     *
     * @param chemin Le chemin où sauvegarder le fichier
     */
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


    /**
     * Cette méthode permet d'ouvrir et désérialisé un fichier et récupérer une instance de perspectives
     * @param chemin Le chemin du fichier à ouvrir
     */
    public void deserialize(String chemin){
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
