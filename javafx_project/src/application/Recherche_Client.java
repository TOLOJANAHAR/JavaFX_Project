package application;

import javafx.application.Application;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Recherche_Client extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Appel des méthodes CRUD
        RechercheClient("ia");
        System.out.print("*****************");
        RechercheClientDansEntretien("at");
    }

    public void RechercheClient(String nomClient) {
        try (Connection connection = Connexion.getConnection()) {
            String query1 = "SELECT * FROM client WHERE nomClient LIKE ?";
            PreparedStatement statement1 = connection.prepareStatement(query1);
            statement1.setString(1, "%" + nomClient + "%");
            ResultSet resultSet = statement1.executeQuery();

            while (resultSet.next()) {
                String nom = resultSet.getString("nomClient");
                String id = resultSet.getString("numClient");
                System.out.println("Nom du Client rechercher : " + nom);
                System.out.println("id du Client rechercher : " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void RechercheClientDansEntretien(String nomClient) {
        try (Connection connection = Connexion.getConnection()) {
            String query1 = "SELECT * FROM entretien WHERE nomClient LIKE ?";
            PreparedStatement statement1 = connection.prepareStatement(query1);
            statement1.setString(1, "%" + nomClient + "%");
            ResultSet resultSet1 = statement1.executeQuery();

            while (resultSet1.next()) {
                String nom = resultSet1.getString("nomClient");
                String numEntr = resultSet1.getString("numEntr");
                String immatriculation_voiture = resultSet1.getString("immatriculation_voiture");
                String dateEntr = resultSet1.getString("dateEntr");
                String numServ = resultSet1.getString("numServ");
                System.out.println("Nom du Client rechercher : " + nom);
                System.out.println("num entretien du Client rechercher : " + numEntr);
                System.out.println("service entretien du Client rechercher : " + numServ);
                System.out.println("immatriculation_voiture du Client rechercher : " + immatriculation_voiture);
                System.out.println("date de l'entretien du Client rechercher : " + dateEntr);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
