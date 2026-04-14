package Services;

import DAO.ReservationDAO;
import Model.*;

public class ReservationService {

    private ReservationDAO dao = new ReservationDAO();

    public void ajouterReservation(Reservation r) throws InvalidDataException {

        if (r == null) {
            throw new InvalidDataException("Réservation invalide");
        }

        try {


            if (r.getVol().getPlacesDisponibles() <= 0) {
                throw new InvalidDataException("Pas de places disponibles");
            }

            // diminuer places
            r.getVol().diminuerPlaces(1);

            dao.ajouter(r);

            System.out.println("Réservation ajoutée !");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
