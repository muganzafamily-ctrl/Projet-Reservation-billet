package Model;

public class Aeroport {

    private String nom;
    private String ville;
    private String pays;

    public Aeroport(String nom, String ville, String pays) throws InvalidDataException {
        setNom(nom);
        setVille(ville);
        setPays(pays);
    }

    public void setNom(String nom) throws InvalidDataException {
        if (nom == null || nom.trim().isEmpty())
            throw new InvalidDataException("Nom aéroport invalide");
        this.nom = nom.trim();
    }

    public void setVille(String ville) throws InvalidDataException {
        if (ville == null || ville.trim().isEmpty())
            throw new InvalidDataException("Ville invalide");
        this.ville = ville.trim();
    }

    public void setPays(String pays) throws InvalidDataException {
        if (pays == null || pays.trim().isEmpty())
            throw new InvalidDataException("Pays invalide");
        this.pays = pays.trim();
    }

    @Override
    public String toString() {
        return nom + " - " + ville + " (" + pays + ")";
    }
}
