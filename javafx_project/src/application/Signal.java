package application;
import javafx.application.Application;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Signal extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Appel des méthodes 
    	Signall();
    }
    public void Signall() {
        try (Connection connection = Connexion.getConnection()) {
            String query = "SELECT * FROM produit WHERE stock < 10";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String nomProduit = resultSet.getString("design");
                int stock = resultSet.getInt("stock");
                System.out.println("Produit à signaler : " + nomProduit + " = " + stock);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}