package Model;

import java.util.ArrayList;
import java.util.List;

public class Reservation {

    private int numero;
    private String statut;
    private String dateReservation;

    private Passager passager;
    private Vol vol;
    private Paiement paiement;
    private Billet billet;

    private List<Integer> bagagesSupplementaires = new ArrayList<>();

    public static final String STATUT_CONFIRME = "CONFIRMEE";
    public static final String STATUT_ANNULE = "ANNULEE";

    public Reservation(int numero,
                       String dateReservation,
                       Passager passager,
                       Vol vol) throws InvalidDataException {

        setNumero(numero);
        setDateReservation(dateReservation);
        setPassager(passager);
        setVol(vol);
        this.statut = STATUT_CONFIRME;
    }

    public int getNumero() { return numero; }
    public void setNumero(int numero) throws InvalidDataException {
        if (numero <= 0)
            throw new InvalidDataException("Numéro de réservation invalide");
        this.numero = numero;
    }

    public String getStatut() { return statut; }

    public String getDateReservation() { return dateReservation; }
    public void setDateReservation(String dateReservation) throws InvalidDataException {
        if (dateReservation == null || dateReservation.trim().isEmpty())
            throw new InvalidDataException("Date de réservation invalide");
        this.dateReservation = dateReservation.trim();
    }

    public Passager getPassager() { return passager; }
    public void setPassager(Passager passager) throws InvalidDataException {
        if (passager == null)
            throw new InvalidDataException("Passager obligatoire pour une réservation");
        this.passager = passager;
    }

    public Vol getVol() { return vol; }
    public void setVol(Vol vol) throws InvalidDataException {
        if (vol == null)
            throw new InvalidDataException("Vol obligatoire pour une réservation");
        this.vol = vol;
    }

    public Paiement getPaiement() { return paiement; }
    public void setPaiement(Paiement paiement) throws InvalidDataException {
        if (paiement == null)
            throw new InvalidDataException("Paiement obligatoire");
        this.paiement = paiement;
    }

    public Billet getBillet() { return billet; }
    public void setBillet(Billet billet) throws InvalidDataException {
        if (billet == null)
            throw new InvalidDataException("Billet obligatoire");
        this.billet = billet;
    }

    public void confirmer() { this.statut = STATUT_CONFIRME; }
    public void annuler() { this.statut = STATUT_ANNULE; }

    public void ajouterBagageSupplementaire(int poids) throws InvalidDataException {
        if (bagagesSupplementaires.size() >= 3)
            throw new InvalidDataException("Maximum 3 bagages supplémentaires");
        if (poids <= 0 || poids > 23)
            throw new InvalidDataException("Poids de bagage invalide (1–23kg)");
        bagagesSupplementaires.add(poids);
    }

    @Override
    public String toString() {
        return "Reservation #" + numero +
                " | " + statut +
                " | Vol : " + (vol != null ? vol.toString() : "N/A") +
                " | Passager : " + (passager != null ? passager.toString() : "N/A");
    }
}
