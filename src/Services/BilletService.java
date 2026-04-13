package Services;

import DAO.BilletDAO;
import Model.Billet;
import Model.InvalidDataException;

public class BilletService {

    private BilletDAO dao = new BilletDAO();

    public void ajouterBillet(Billet billet) throws InvalidDataException {

        if (billet == null) {
            throw new InvalidDataException("Billet invalide");
        }

        try {
            dao.ajouter(billet);
            System.out.println("Billet ajouté !");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}