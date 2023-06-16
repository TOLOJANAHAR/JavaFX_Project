package application;
import javafx.application.Application;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Crud_Entree extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Appel des méthodes CRUD
        creatEntree("20", 17000,0);
        readEntree();
        System.out.print("************");
        updateEntree("33", 22000, 0, "2");
        readEntree();
        deleteEntree("1");
        System.out.print("************");
        readEntree();
    }
    
    //Creation
    public void creatEntree( String numProd, int stockEntree, int dateEntree) {
        try (Connection connection = Connexion.getConnection()) {
            String query1 = "INSERT INTO entree ( numProd, stockEntree,dateEntree) VALUES ( ?, ?, ?)";
            PreparedStatement statement1 = connection.prepareStatement(query1);
            statement1.setString(1, numProd);
            statement1.setInt(2, stockEntree);
            statement1.setInt(3, dateEntree);
            statement1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Lire
    public void readEntree() {
        try (Connection connection = Connexion.getConnection()) {
            String query = "SELECT numEntree, numProd, stockEntree, dateEntree FROM entree";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String numEntree = resultSet.getString("numEntree");
                String numProd = resultSet.getString("numProd");
                String stockEntree = resultSet.getString("stockEntree");
                String dateEntree = resultSet.getString("dateEntree");
                System.out.println("numEntree : " + numEntree);
                System.out.println("numProd : " + numProd);
                System.out.println("dateEntree : " + dateEntree);
                System.out.println("stockEntree : " + stockEntree);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Mise à jour
    public void updateEntree(String numProd, int stockEntree, int dateEntree, String numEntree) {
        try (Connection connection = Connexion.getConnection()) {
            String query = "UPDATE entree SET numProd = ?, stockEntree = ?, dateEntree = ? WHERE numEntree = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, numProd);
            statement.setInt(2, stockEntree);
            statement.setInt(3, dateEntree);
            statement.setString(4, numEntree);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Suppression
    public void deleteEntree(String numEntree) {
        try (Connection connection = Connexion.getConnection()) {
            String query = "DELETE FROM entree WHERE numEntree = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, numEntree);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}

 
    
    
 
	

