package Model;
import java.util.Date;

public class Vol {

        private int idVol;
        private String villeDepartVol;
        private String villeArriveeVol;

        private Date dateDepartVol;
        private Date heureDepartVol;

        private String statutVol;
        private Avion avion;

        private double prix;
        private int placesDisponibles;

        private static int compteurId = 1;

        // Constructeur
        public Vol(String villeDepartVol,
                   String villeArriveeVol,
                   Date dateDepartVol,
                   Date heureDepartVol,
                   String statutVol,
                   Avion avion,
                   double prix,
                   int placesDisponibles) throws InvalidDataException {

            this.idVol = compteurId++;
            setVilleDepartVol(villeDepartVol);
            setVilleArriveeVol(villeArriveeVol);
            setDateDepartVol(dateDepartVol);
            setHeureDepartVol(heureDepartVol);
            setStatutVol(statutVol);
            setAvion(avion);
            setPrix(prix);
            setPlacesDisponibles(placesDisponibles);
        }

        public int getIdVol() {
            return idVol;
        }

        public String getVilleDepartVol() {
            return villeDepartVol;
        }

        public void setVilleDepartVol(String villeDepartVol) throws InvalidDataException {
            if (villeDepartVol == null || villeDepartVol.trim().length() < 2)
                throw new InvalidDataException("Ville de départ invalide");
            this.villeDepartVol = villeDepartVol.trim();
        }

        public String getVilleArriveeVol() {
            return villeArriveeVol;
        }

        public void setVilleArriveeVol(String villeArriveeVol) throws InvalidDataException {
            if (villeArriveeVol == null || villeArriveeVol.trim().length() < 2)
                throw new InvalidDataException("Ville d'arrivée invalide");
            this.villeArriveeVol = villeArriveeVol.trim();
        }


        public Date getDateDepartVol() {
            return dateDepartVol;
        }

        public void setDateDepartVol(Date dateDepartVol) throws InvalidDataException {
            if (dateDepartVol == null)
                throw new InvalidDataException("Date de départ invalide");
            this.dateDepartVol = dateDepartVol;
        }


        public Date getHeureDepartVol() {
            return heureDepartVol;
        }

        public void setHeureDepartVol(Date heureDepartVol) throws InvalidDataException {
            if (heureDepartVol == null)
                throw new InvalidDataException("Heure de départ invalide");
            this.heureDepartVol = heureDepartVol;
        }

        public String getStatutVol() {
            return statutVol;
        }

        public void setStatutVol(String statutVol) throws InvalidDataException {
            if (statutVol == null || statutVol.trim().isEmpty())
                throw new InvalidDataException("Statut du vol invalide");
            this.statutVol = statutVol.trim();
        }

        public Avion getAvion() {
            return avion;
        }

        public void setAvion(Avion avion) throws InvalidDataException {
            if (avion == null)
                throw new InvalidDataException("Un vol doit avoir un avion");
            this.avion = avion;
        }

        public double getPrix() {
            return prix;
        }

        public void setPrix(double prix) throws InvalidDataException {
            if (prix <= 0)
                throw new InvalidDataException("Prix du vol invalide");
            this.prix = prix;
        }

        public int getPlacesDisponibles() {
            return placesDisponibles;
        }

        public void setPlacesDisponibles(int placesDisponibles) throws InvalidDataException {
            if (placesDisponibles < 0)
                throw new InvalidDataException("Places disponibles invalides");
            this.placesDisponibles = placesDisponibles;
        }

        public void diminuerPlaces(int nb) throws InvalidDataException {
            if (nb <= 0)
                throw new InvalidDataException("Nombre de billets invalide");
            if (placesDisponibles < nb)
                throw new InvalidDataException("Pas assez de places disponibles");
            this.placesDisponibles -= nb;
        }

        @Override
        public String toString() {
            return villeDepartVol + " → " + villeArriveeVol +
                    " | Date : " + dateDepartVol +
                    " | Heure : " + heureDepartVol +
                    " | Prix : " + prix + "$" +
                    " | Places : " + placesDisponibles;
        }

    public void setIdVol(int anInt) {
        this.idVol = idVol;
    }
}


