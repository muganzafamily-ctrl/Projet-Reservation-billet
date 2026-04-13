package Model;

public class Passager {
    private String numPasseport;
    private String nomComplet;
    private double bagages;

    public Passager(String numPasseport, String nomComplet, double bagages) throws InvalidDataException {
        setNumPasseport(numPasseport);
        setNomComplet(nomComplet);
        setBagages(bagages);
    }

    public String getNumPasseport() {
        return numPasseport;
    }

    public void setNumPasseport(String numPasseport) throws InvalidDataException {
        if (numPasseport == null || numPasseport.trim().isEmpty()) {
            throw new InvalidDataException("Numéro de passeport invalide");
        }
        this.numPasseport = numPasseport.trim();
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) throws InvalidDataException {
        if (nomComplet == null || nomComplet.trim().isEmpty()) {
            throw new InvalidDataException("Nom complet invalide");
        }
        this.nomComplet = nomComplet.trim();
    }

    public double getBagages() {
        return bagages;
    }

    public void setBagages(double bagages) throws InvalidDataException {
        if (bagages < 0) {
            throw new InvalidDataException("Poids de bagages invalide");
        }
        this.bagages = bagages;
    }

    @Override
    public String toString() {
        return "Passager{" +
                "numPasseport='" + numPasseport + '\'' +
                ", nomComplet='" + nomComplet + '\'' +
                ", bagages=" + bagages +
                '}';
    }
}
