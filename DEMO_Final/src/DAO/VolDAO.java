package DAO;

import Basededonnes.Connexion;
import Model.Vol;

import java.sql.*;

public class VolDAO {
    public void ajouter(Vol v) throws SQLException {

        Connection con = Connexion.getConnexion();

        String sql = "INSERT INTO vol " +
                "(villeDepart, villeArrivee, dateDepart, heureDepart, prix, places) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement ps =
                con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, v.getVilleDepartVol());
        ps.setString(2, v.getVilleArriveeVol());

        java.sql.Date sqlDate =
                new java.sql.Date(v.getDateDepartVol().getTime());
        ps.setDate(3, sqlDate);

        java.sql.Time sqlTime =
                new java.sql.Time(v.getHeureDepartVol().getTime());
        ps.setTime(4, sqlTime);

        ps.setDouble(5, v.getPrix());
        ps.setInt(6, v.getPlacesDisponibles());

        ps.executeUpdate();

        //  RÉCUPÉRATION DE L'ID GÉNÉRÉ
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            v.setIdVol(rs.getInt(1));
        }

        System.out.println("Vol ajouté avec succès (idVol = " + v.getIdVol() + ")");
    }
    }
