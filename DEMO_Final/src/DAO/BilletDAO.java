package DAO;

import Basededonnes.Connexion;
import Model.Billet;

import java.sql.*;

public class BilletDAO {

    public void ajouter(Billet b) throws SQLException {

        Connection con = Connexion.getConnexion();

        String sql = "INSERT INTO billet (numero, prix, siege, classe, statut, numeroReservation, id) VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, b.getNumero());
        ps.setDouble(2, b.getPrix());
        ps.setString(3, b.getSiege());
        ps.setString(4, b.getClasse());
        ps.setString(5, b.getStatut());

        //  RELATIONS
        ps.setInt(6, b.getReservation().getNumero());
        ps.setInt(7, b.getVol().getIdVol());

        ps.executeUpdate();
    }
}