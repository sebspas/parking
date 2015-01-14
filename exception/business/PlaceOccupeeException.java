package parking.exception.business;

/**
 * Exception se propageant lorsque l'on souhaite parker un vehicule sur une
 * place est déjà occupée (aussi lorqu'elle n'est pas adaptée au véhicule).
 */
public class PlaceOccupeeException extends Exception{

	private static final long serialVersionUID = -6835512499961475382L;

}