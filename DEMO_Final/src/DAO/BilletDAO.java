package DAO;

import Basededonnes.Connexion;
import Model.Billet;
import Model.InvalidDataException;

import java.sql.*;

public class BilletDAO {

    public void ajouter(Billet b) throws SQLException, InvalidDataException {

        String sql =
                "INSERT INTO billet (numero, prix, siege, classe, statut, numeroReservation) " +
                        "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = Connexion.getConnexion();
             PreparedStatement ps =
                     con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, b.getNumero());
            ps.setDouble(2, b.getPrix());
            ps.setString(3, b.getSiege());
            ps.setString(4, b.getClasse());
            ps.setString(5, b.getStatut());
            ps.setInt(6, b.getReservation().getNumero());

            ps.executeUpdate();

            // récupérer l'id AUTO_INCREMENT
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                b.setId(rs.getInt(1));
            }
        }
    }
}