package application;
import javafx.application.Application;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Crud_Achat extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Appel des méthodes CRUD
        //creatAchat("05", "nata", 15,0);
        //creatAchat("06", "lala", 100 ,0);
        readAchat();
        System.out.print("************");
        updateAchat("33", "kevin", 45, 0, "2");
        readAchat();
        deleteAchat("2");
        System.out.print("************");
        readAchat();
    }
    
    //Creation
    public void creatAchat ( String numProd, String nomClient, int nbrLitre, int dateAchat) {
        try (Connection connection = Connexion.getConnection()) {
            String query = "INSERT INTO achat ( numProd, nomClient ,nbrLitre, dateAchat) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, numProd);
            statement.setString(2, nomClient);
            statement.setInt(3, nbrLitre);
            statement.setInt(4, dateAchat);
            System.out.print("ok");
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Lire
    public void readAchat() {
        try (Connection connection = Connexion.getConnection()) {
            String query = "SELECT numAchat, numProd, nomClient, nbrLitre, dateAchat FROM achat";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String numAchat = resultSet.getString("numAchat");
                String numProd = resultSet.getString("numProd");
                String nomClient = resultSet.getString("nomClient");
                String nbrLitre = resultSet.getString("nbrLitre");
                String dateAchat = resultSet.getString("dateAchat");
                System.out.println("numAchat : " + numAchat);
                System.out.println("numProd : " + numProd);
                System.out.println("nomClient : " + nomClient);
                System.out.println("nbrLitre : " + nbrLitre);
                System.out.println("dateAchat : " + dateAchat);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Mise à jour
    public void updateAchat(String numProd, String nomClient, int nbrLitre, int dateAchat, String numAchat) {
        try (Connection connection = Connexion.getConnection()) {
            String query = "UPDATE achat SET numProd = ?, nomClient = ?, nbrLitre = ?, dateAchat=? WHERE numAchat = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, numProd);
            statement.setString(2, nomClient);
            statement.setInt(3, nbrLitre);
            statement.setInt(4, dateAchat);
            statement.setString(5, numAchat);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Suppression
    public void deleteAchat(String numAchat) {
        try (Connection connection = Connexion.getConnection()) {
            String query = "DELETE FROM achat WHERE numAchat = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, numAchat);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}

 
    
    
 
	


