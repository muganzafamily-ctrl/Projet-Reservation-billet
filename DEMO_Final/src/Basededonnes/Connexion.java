package Basededonnes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {

    private static final String serveur = "localhost:3306/";
    private static final String utilisateur = "root";
    private static final String motDePasse = "";
    private static final String nomDB = "airline_db";

    private static final String URL = "jdbc:mysql://" + serveur + nomDB;

    private static Connection connection;

    public static Connection getConnexion() throws SQLException {

        try {

            //  réutilisation connexion
            if (connection == null || connection.isClosed()) {

                connection = DriverManager.getConnection(URL, utilisateur, motDePasse);

                System.out.println("Connexion réussie à airline_db");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}