package Services;

import DAO.PaiementDAO;
import Model.InvalidDataException;
import Model.Paiement;

public class PaiementService {

    private PaiementDAO dao = new PaiementDAO();

    public void payer(Paiement p, int numReservation) throws InvalidDataException {

        if (p == null) {
            throw new InvalidDataException("Paiement invalide");
        }

        try {

            p.payer(); // logique métier

            dao.ajouter(p, numReservation);

            System.out.println("Paiement effectué !");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}