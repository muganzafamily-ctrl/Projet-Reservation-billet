package DAO;

import Basededonnes.Connexion;
import Model.Paiement;

import java.sql.*;

public class PaiementDAO {

    public void ajouter(Paiement p, int numReservation) throws SQLException {

        Connection con = Connexion.getConnexion();

        String sql = "INSERT INTO paiement (montant, methode, statut, numeroReservation) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setDouble(1, p.getMontant());
        ps.setString(2, p.getMethode());
        ps.setString(3, p.getStatut());
        ps.setInt(4, numReservation);

        ps.executeUpdate();
    }
}