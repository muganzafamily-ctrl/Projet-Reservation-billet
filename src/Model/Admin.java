package Model;

public class Admin extends Utilisateur {

    private String poste;

    public Admin(String nom, String email, String motDePasse, String poste) throws InvalidDataException {
        super(nom, email, motDePasse);
        setPoste(poste);
    }

    public void setPoste(String poste) throws InvalidDataException {
        if (poste == null || poste.trim().isEmpty())
            throw new InvalidDataException("Poste invalide");
        this.poste = poste.trim();
    }
}
