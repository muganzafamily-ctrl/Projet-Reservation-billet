package Model;

public class Avion {

    private String modele;
    private int capacite;
    private CompagnieAerienne compagnie;

    public Avion(String modele, int capacite, CompagnieAerienne compagnie) throws InvalidDataException {
        setModele(modele);
        setCapacite(capacite);
        setCompagnie(compagnie);
    }

    public void setModele(String modele) throws InvalidDataException {
        if (modele == null || modele.trim().isEmpty())
            throw new InvalidDataException("Modèle avion invalide");
        this.modele = modele.trim();
    }

    public void setCapacite(int capacite) throws InvalidDataException {
        if (capacite <= 0)
            throw new InvalidDataException("Capacité invalide");
        this.capacite = capacite;
    }

    public void setCompagnie(CompagnieAerienne compagnie) throws InvalidDataException {
        if (compagnie == null)
            throw new InvalidDataException("Compagnie requise");
        this.compagnie = compagnie;
    }

    @Override
    public String toString() {
        return modele + " (" + capacite + " places) - " + compagnie;
    }
}
