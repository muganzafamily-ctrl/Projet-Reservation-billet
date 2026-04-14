package DAO;

import Basededonnes.Connexion;
import Model.Reservation;

import java.sql.*;

public class ReservationDAO {

    public void ajouter(Reservation r) throws SQLException {

        Connection con = Connexion.getConnexion();

        String sql = "INSERT INTO reservation (numero, dateReservation, statut, numPasseport, idVol) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, r.getNumero());
        ps.setString(2, r.getDateReservation());
        ps.setString(3, r.getStatut());

        //  relation
        ps.setString(4, r.getPassager().getNumPasseport());
        ps.setInt(5, r.getVol().getIdVol());

        ps.executeUpdate();
    }
}