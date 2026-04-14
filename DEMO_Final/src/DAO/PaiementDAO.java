package DAO;

import Basededonnes.Connexion;
import Model.InvalidDataException;
import Model.Paiement;

import java.sql.*;

public class PaiementDAO {

    public void ajouter(Paiement p, int numReservation) throws SQLException, InvalidDataException {

        String sql = "INSERT INTO paiement " +
                "(montant, methode, statut, numeroReservation) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection con = Connexion.getConnexion();
             PreparedStatement ps =
                     con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setDouble(1, p.getMontant());
            ps.setString(2, p.getMethode());
            ps.setString(3, p.getStatut());
            ps.setInt(4, numReservation);

            ps.executeUpdate();

            // Récupérer l'id AUTO_INCREMENT
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                p.setId(rs.getInt(1));
            }
        }
    }
}