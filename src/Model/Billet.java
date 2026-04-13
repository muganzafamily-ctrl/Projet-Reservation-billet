package Model;

public class Billet {
    private int id;
    private String numero;
    private Double prix;
    private String siege;
    private String classe;
    private String statut;
    private Reservation reservation;
    private Passager passager;
    private Vol vol;

    public Billet() {
    }

    public Billet(String numero,
                  Double prix,
                  String siege,
                  String classe,
                  String statut,
                  Reservation reservation,
                  Passager passager,
                  Vol vol) throws InvalidDataException {
        setNumero(numero);
        setPrix(prix);
        setSiege(siege);
        setClasse(classe);
        setStatut(statut);
        setReservation(reservation);
        setPassager(passager);
        setVol(vol);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws InvalidDataException {
        if (id < 0) {
            throw new InvalidDataException("ID billet invalide");
        }
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) throws InvalidDataException {
        if (numero == null || numero.trim().isEmpty()) {
            throw new InvalidDataException("Numéro de billet invalide");
        }
        this.numero = numero.trim();
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) throws InvalidDataException {
        if (prix == null || prix <= 0) {
            throw new InvalidDataException("Le prix doit être supérieur à 0");
        }
        this.prix = prix;
    }

    public String getSiege() {
        return siege;
    }

    public void setSiege(String siege) throws InvalidDataException {
        if (siege == null || siege.trim().isEmpty()) {
            throw new InvalidDataException("Le siège ne peut pas être vide");
        }
        this.siege = siege.trim();
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) throws InvalidDataException {
        if (classe == null || classe.trim().isEmpty()) {
            throw new InvalidDataException("Classe invalide");
        }
        this.classe = classe.trim();
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) throws InvalidDataException {
        if (statut == null ||
                (!"Confirmé".equalsIgnoreCase(statut.trim()) &&
                        !"Reservé".equalsIgnoreCase(statut.trim()) &&
                        !"Annulé".equalsIgnoreCase(statut.trim()))) {
            throw new InvalidDataException("Statut invalide");
        }
        this.statut = statut.trim();
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) throws InvalidDataException {
        if (reservation == null) {
            throw new InvalidDataException("La réservation doit exister");
        }
        this.reservation = reservation;
    }

    public Passager getPassager() {
        return passager;
    }

    public void setPassager(Passager passager) throws InvalidDataException {
        if (passager == null) {
            throw new InvalidDataException("Le passager doit exister");
        }
        this.passager = passager;
    }

    public Vol getVol() {
        return vol;
    }

    public void setVol(Vol vol) throws InvalidDataException {
        if (vol == null) {
            throw new InvalidDataException("Le vol doit exister");
        }
        this.vol = vol;
    }

    @Override
    public String toString() {
        return "Billet{" +
                "numero='" + numero + '\'' +
                ", prix=" + prix +
                ", siege='" + siege + '\'' +
                ", classe='" + classe + '\'' +
                ", statut='" + statut + '\'' +
                ", reservation=" + reservation.getNumero() +
                ", passager=" + passager.getNomComplet() +
                ", vol=" + vol.getVilleDepartVol() + " -> " + vol.getVilleArriveeVol() +
                '}';
    }
}