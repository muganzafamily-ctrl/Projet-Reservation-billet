package DAO;

import Basededonnes.Connexion;
import Model.Vol;

import java.sql.*;

public class VolDAO {

    public void ajouter(Vol v) throws SQLException {

        Connection con = Connexion.getConnexion();

        String sql = "INSERT INTO vol (villeDepart, villeArrivee, dateDepart, prix, places) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, v.getVilleDepartVol());
        ps.setString(2, v.getVilleArriveeVol());
        ps.setString(3, v.getDateDepartVol());
        ps.setDouble(4, v.getPrix());
        ps.setInt(5, v.getPlacesDisponibles());

        ps.executeUpdate();
    }
}