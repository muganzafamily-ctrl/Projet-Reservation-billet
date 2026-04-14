package Model;

import java.util.Date;

public class Paiement {

    private int id;
    private double montant;
    private String methode;
    private String statut;
    private Date datePaiement;

    public static final String STATUT_EN_ATTENTE = "En attente";
    public static final String STATUT_PAYE = "Payé";
    public static final String STATUT_REMBOURSE = "Remboursé";
    public static final String STATUT_ANNULE = "Annulé";

    private static int compteurId = 1;

    public Paiement(double montant, String methode, Date datePaiement) throws InvalidDataException {
        this.id = compteurId++;
        setMontant(montant);
        setMethode(methode);
        setDatePaiement(datePaiement != null ? datePaiement : new Date());
        this.statut = STATUT_EN_ATTENTE;
    }

    public int getId() { return id; }

    public double getMontant() { return montant; }
    public void setMontant(double montant) throws InvalidDataException {
        if (montant <= 0)
            throw new InvalidDataException("Montant de paiement invalide");
        this.montant = montant;
    }

    public String getMethode() { return methode; }
    public void setMethode(String methode) throws InvalidDataException {
        if (methode == null || methode.trim().isEmpty())
            throw new InvalidDataException("Méthode de paiement invalide");
        this.methode = methode.trim();
    }

    public String getStatut() { return statut; }

    public Date getDatePaiement() { return datePaiement; }
    public void setDatePaiement(Date datePaiement) throws InvalidDataException {
        if (datePaiement == null)
            throw new InvalidDataException("Date de paiement invalide");
        this.datePaiement = datePaiement;
    }

    public void payer() throws InvalidDataException {
        if (STATUT_PAYE.equals(statut))
            throw new InvalidDataException("Le paiement est déjà effectué");
        this.statut = STATUT_PAYE;
    }

    public void rembourser() throws InvalidDataException {
        if (!STATUT_PAYE.equals(statut))
            throw new InvalidDataException("Remboursement impossible : paiement non payé");
        this.statut = STATUT_REMBOURSE;
    }

    public void annuler() throws InvalidDataException {
        if (!STATUT_EN_ATTENTE.equals(statut))
            throw new InvalidDataException("Annulation impossible");
        this.statut = STATUT_ANNULE;
    }

    @Override
    public String toString() {
        return "Paiement " + montant + "$ (" + methode + ") - " + statut;
    }
}
