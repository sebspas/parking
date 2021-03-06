package parking.business.facture.Calcul;

/***************************************************************/
/*						Import						   		   */
/***************************************************************/
import parking.business.Place;

/**
 * Interface CalculerTarif, definissant la fonction calculerTarif(),
 * permettant de calculer le tarif d'une place donnee en parametre.
 *
 * @author Chergui, Coadalen, Corfa, Corral
 */
public interface CalculerTarif {
    /**
     * Methode abstraite calculerTarif(), de la classe CalculerTarifHeure, permettant de
     * calculer le tarif d'une place pour un client.
     *
     * @param p
     *          La place sur laquelle on effectue le calcul du tarif a l'heure.
     * @return Le tarif calcule.
     */
    public double calculerTarif(Place p);

} // CalculerTarif interface