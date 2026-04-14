package Model;

import Services.*;

public class Program {
    public static void main(String[] args) {

        try {

            //  SERVICES
            PassagerService passagerService = new PassagerService();
            VolService volService = new VolService();
            ReservationService reservationService = new ReservationService();
            BilletService billetService = new BilletService();
            PaiementService paiementService = new PaiementService();

            //  PASSAGER
            Passager p = new Passager("P12345", "Amine Akdim", 20);
            passagerService.ajouterPassager(p);

            //  COMPAGNIE + AVION
            CompagnieAerienne comp = new CompagnieAerienne("AC", "Canada");
            Avion avion = new Avion("Boeing 737", 100, comp);

            //  VOL
            Vol v = new Vol(
                    "Montreal",
                    "Paris",
                    "2026-05-01",
                    "10:00",
                    "PREVU",
                    avion,
                    800,
                    5
            );

            volService.ajouterVol(v);

            //  RESERVATION
            Reservation r = new Reservation(
                    1,
                    "2026-04-13",
                    p,
                    v
            );

            reservationService.ajouterReservation(r);

            // BILLET
            Billet b = new Billet(
                    "B123",
                    800.0,
                    "A1",
                    "Eco",
                    "Confirmé",
                    r,
                    p,
                    v
            );

            billetService.ajouterBillet(b);

            //PAIEMENT
            Paiement pay = new Paiement(800, "Carte", new java.util.Date());

            paiementService.payer(pay, r.getNumero());

            System.out.println("PROJET TERMINÉ AVEC SUCCÈS ");

        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
