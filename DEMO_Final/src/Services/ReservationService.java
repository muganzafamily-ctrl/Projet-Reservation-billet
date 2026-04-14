package Services;

import DAO.ReservationDAO;
import Model.*;

import java.sql.SQLException;

public class ReservationService {

    private ReservationDAO dao = new ReservationDAO();

    public void ajouterReservation(Reservation r)
            throws InvalidDataException, SQLException {

        if (r == null) {
            throw new InvalidDataException("Réservation invalide");
        }

        if (r.getVol().getPlacesDisponibles() <= 0) {
            throw new InvalidDataException("Pas de places disponibles");
        }

        // ✅ 1️⃣ Insérer d'abord la réservation
        dao.ajouter(r);

        // ✅ 2️⃣ PUIS diminuer les places (cohérence métier)
        r.getVol().diminuerPlaces(1);

        System.out.println("✅ Réservation ajoutée !");
    }
}