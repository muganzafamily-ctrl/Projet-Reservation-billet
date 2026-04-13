package DAO;

import Basededonnes.Connexion;
import Model.Passager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PassagerDAO {

    public void ajouterPassager(Passager p) throws SQLException {

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
}