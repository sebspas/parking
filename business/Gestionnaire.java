package parking.business;

/***************************************************************/
/*						Import						   		   */
/***************************************************************/
import java.io.*;

/**
 * Classe Gestionnaire permettant de sauvegarder ou de charger(lire) un parking.
 *
 * @author Chergui, Coadalen, Corfa, Corral
 */
public class Gestionnaire {
    /***************************************************************/
	/*						Methodes							   */
    /***************************************************************/
    /**
     * Methode sauvegarder(), permet de sauvegarder le parking dans un
     * fichier .ser et cree le repertoire saves si il n'existe pas.
     */
    public void sauvegarder(){
        new File("saves").mkdir();
        new File("saves/" + Parking.getInstance().getNom() + ".ser");
        ObjectOutputStream oos = null;

        try {
            oos =  new ObjectOutputStream(new FileOutputStream("saves/" + Parking.getInstance().getNom() + ".ser")) ;
            oos.writeObject(Parking.getInstance());
        }
        catch(EOFException e){
            e.printStackTrace();
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    } // sauvegarder()

    /**
     * Methode lire() permet de lire et charger le fichier passe en parametre.
     * @param fichier
     *          Nom du fichier de save du parking.
     */
    public void lire(String fichier){
        new File(fichier);
        ObjectInputStream ois = null;
        try {
            ois =  new ObjectInputStream(new FileInputStream(fichier)) ;
            Parking parking = (Parking)ois.readObject();
            Parking.getInstance().setNom(parking.getNom());
            Parking.getInstance().setNumeroFacture(parking.getNumeroFacture());
            
            Parking.getInstance().setListePlaces(parking.getListePlaces());
            
            Parking.getInstance().setListeFacture(parking.getListeFacture());
            
            Parking.getInstance().setListeClients(parking.getListeClients());
            
            Parking.getInstance().setNbPlacesMax(parking.getNbPlacesMax());
            
            Parking.getInstance().setTarifParticulier(parking.getTarifParticulier());
            Parking.getInstance().setTarifTransporteur(parking.getTarifTransporteur());

            Parking.getInstance().setNbPlaceOccupees(parking.getNbPlaceOccupees());
            Parking.getInstance().notifier();
        }
        catch(EOFException e){
            e.printStackTrace();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    } // lire()

} // Gestionnaire class
