package DAO;

import Basededonnes.Connexion;
import Model.Passager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PassagerDAO {

    public void ajouterPassager(Passager p) throws SQLException {


        if (passagerExiste(p.getNumPasseport())) {
            System.out.println("Passager déjà existant");
            return;
        }

        Connection con = Connexion.getConnexion();

        if (con != null) {

            String sql = "INSERT INTO passager (numPasseport, nomComplet, bagages) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, p.getNumPasseport());
            ps.setString(2, p.getNomComplet());
            ps.setDouble(3, p.getBagages());

            ps.executeUpdate();

            System.out.println("Passager ajouté !");
        }


    }
    public boolean passagerExiste(String numPasseport) throws SQLException {
        String sql = "SELECT 1 FROM passager WHERE numPasseport = ?";
        try (Connection con = Connexion.getConnexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, numPasseport);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }

}