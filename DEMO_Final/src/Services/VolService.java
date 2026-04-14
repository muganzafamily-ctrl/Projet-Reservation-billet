package Services;

import DAO.VolDAO;
import Model.InvalidDataException;
import Model.Vol;

public class VolService {

    private VolDAO dao = new VolDAO();

    public void ajouterVol(Vol vol) throws InvalidDataException {

        if (vol == null) {
            throw new InvalidDataException("Vol invalide");
        }

        try {
            dao.ajouter(vol);
            System.out.println("Vol ajouté !");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}