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

    // Constructeur
    public Paiement(double montant, String methode, Date datePaiement)
            throws InvalidDataException {

        setMontant(montant);
        setMethode(methode);
        setDatePaiement(datePaiement != null ? datePaiement : new Date());
        this.statut = STATUT_EN_ATTENTE;
    }


    public void setId(int id) throws InvalidDataException {
        if (id <= 0)
            throw new InvalidDataException("ID paiement invalide");
        this.id = id;
    }

    public int getId() { return id; }

    public double getMontant() { return montant; }
    public void setMontant(double montant) throws InvalidDataException {
        if (montant <= 0)
            throw new InvalidDataException("Montant invalide");
        this.montant = montant;
    }

    public String getMethode() { return methode; }
    public void setMethode(String methode) throws InvalidDataException {
        if (methode == null || methode.trim().isEmpty())
            throw new InvalidDataException("Méthode invalide");
        this.methode = methode.trim();
    }

    public String getStatut() { return statut; }

    public Date getDatePaiement() { return datePaiement; }
    public void setDatePaiement(Date datePaiement) throws InvalidDataException {
        if (datePaiement == null)
            throw new InvalidDataException("Date invalide");
        this.datePaiement = datePaiement;
    }

    public void payer() throws InvalidDataException {
        if (STATUT_PAYE.equals(statut))
            throw new InvalidDataException("Déjà payé");
        this.statut = STATUT_PAYE;
    }

    @Override
    public String toString() {
        return "Paiement " + montant + "$ (" + methode + ") - " + statut;
    }
}