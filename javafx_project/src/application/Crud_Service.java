package application;
import javafx.application.Application;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Crud_Service extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Appel des méthodes CRUD
        //creatService("20", 17000);
        //creatService("45", 17000);
        readService();
        System.out.print("************");
        updateService("55", 22000, "2");
        readService();
        deleteService("1");
        System.out.print("************");
        readService();
    }
    
    //Creation
    public void creatService( String service, int prix) {
        try (Connection connection = Connexion.getConnection()) {
            String query = "INSERT INTO service ( service, prix) VALUES ( ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, service);
            statement.setInt(2, prix);
            System.out.print("ok");
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Lire
    public void readService() {
        try (Connection connection = Connexion.getConnection()) {
            String query = "SELECT numServ, service, prix FROM service ";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String numServ = resultSet.getString("numServ");
                String service = resultSet.getString("service");
                String prix = resultSet.getString("prix");
                
                System.out.println("numService : " + numServ);
                System.out.println("service : " + service);
                System.out.println("prix : " + prix);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Mise à jour
    public void updateService( String service, int prix, String numServ) {
        try (Connection connection = Connexion.getConnection()) {
            String query = "UPDATE service SET service = ?, prix = ? WHERE numServ = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, service);
            statement.setInt(2, prix);
            statement.setString(3, numServ);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Suppression
    public void deleteService(String numServ) {
        try (Connection connection = Connexion.getConnection()) {
            String query = "DELETE FROM service WHERE numServ = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, numServ);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}

 
    
    
 
	

