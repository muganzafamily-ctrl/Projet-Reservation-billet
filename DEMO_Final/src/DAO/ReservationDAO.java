package DAO;

import Basededonnes.Connexion;
import Model.InvalidDataException;
import Model.Reservation;

import java.sql.*;

public class ReservationDAO {

    public void ajouter(Reservation r) throws SQLException, InvalidDataException {

        String sql = "INSERT INTO reservation " +
                "(dateReservation, statut, numPasseport, idVol) " +
                "VALUES (?, ?, ?, ?)";

        try (
                Connection con = Connexion.getConnexion();
                PreparedStatement ps =
                        con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            // Date de réservation
            java.sql.Date sqlDate =
                    new java.sql.Date(r.getDateReservation().getTime());
            ps.setDate(1, sqlDate);

            ps.setString(2, r.getStatut());

            // Relations
            ps.setString(3, r.getPassager().getNumPasseport());
            ps.setInt(4, r.getVol().getIdVol());

            ps.executeUpdate();

            // Récupération du numéro AUTO_INCREMENT
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                r.setNumero(rs.getInt(1));
            }
        }

        System.out.println("Réservation ajoutée (numero = " + r.getNumero() + ")");
    }
}
