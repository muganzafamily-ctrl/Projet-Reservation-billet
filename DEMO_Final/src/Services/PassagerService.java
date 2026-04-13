package Services;

import DAO.PassagerDAO;
import Model.InvalidDataException;
import Model.Passager;

public class PassagerService {

    private PassagerDAO dao = new PassagerDAO();

    public void ajouterPassager(Passager passager) throws InvalidDataException {

        if (passager == null) {
            throw new InvalidDataException("Passager invalide");
        }

        try {
            dao.ajouterPassager(passager);
            System.out.println("Passager ajouté !");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
