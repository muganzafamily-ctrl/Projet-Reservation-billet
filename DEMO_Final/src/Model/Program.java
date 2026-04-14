package Model;

import Services.*;

import java.util.Date;

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

            Date dateDepart = new Date();   // date actuelle
            Date heureDepart = new Date();  // heure actuelle

            Vol v = new Vol(
                    "Montreal",
                    "Paris",
                    dateDepart,
                    heureDepart,
                    "PREVU",
                    avion,
                    800,
                    5
            );


            volService.ajouterVol(v);

            //  RESERVATION

            Date dateReservation = new Date(); // date actuelle

            Reservation r = new Reservation(
                    dateReservation,
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
