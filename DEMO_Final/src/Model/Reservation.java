package Model;

import java.util.Date;

public class Reservation {

    private int numero; // AUTO_INCREMENT (NE PAS toucher au constructeur)
    private Date dateReservation;
    private String statut;
    private Passager passager;
    private Vol vol;

    public static final String STATUT_CONFIRME = "CONFIRMEE";

    // ✅ CONSTRUCTEUR SANS NUMÉRO
    public Reservation(Date dateReservation,
                       Passager passager,
                       Vol vol) throws InvalidDataException {

        setDateReservation(dateReservation);
        setPassager(passager);
        setVol(vol);
        this.statut = STATUT_CONFIRME;
    }

    // ✅ LE NUMÉRO EST FOURNI UNIQUEMENT PAR LE DAO
    public void setNumero(int numero) throws InvalidDataException {
        if (numero <= 0) {
            throw new InvalidDataException("Numéro de réservation invalide");
        }
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) throws InvalidDataException {
        if (dateReservation == null)
            throw new InvalidDataException("Date de réservation invalide");
        this.dateReservation = dateReservation;
    }

    public Passager getPassager() {
        return passager;
    }

    public void setPassager(Passager passager) throws InvalidDataException {
        if (passager == null)
            throw new InvalidDataException("Passager invalide");
        this.passager = passager;
    }

    public Vol getVol() {
        return vol;
    }

    public void setVol(Vol vol) throws InvalidDataException {
        if (vol == null)
            throw new InvalidDataException("Vol invalide");
        this.vol = vol;
    }

    public String getStatut() {
        return statut;
    }
}