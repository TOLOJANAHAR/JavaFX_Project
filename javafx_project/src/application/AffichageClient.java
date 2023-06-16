package application;
import javafx.application.Application;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AffichageClient extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Appel des méthodes 
    	Affichage();
    }
    public void Affichage() {
        try (Connection connection = Connexion.getConnection()) {
            String query = "SELECT nomClient, COUNT(*) as nb_occurrences FROM client GROUP BY nomClient ORDER BY nb_occurrences DESC LIMIT 5";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            List<String> nomsClients = new ArrayList<>();

            while (resultSet.next()) {
                String nomClient = resultSet.getString("nomClient");
                nomsClients.add(nomClient);
            }
            System.out.print(nomsClients);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}