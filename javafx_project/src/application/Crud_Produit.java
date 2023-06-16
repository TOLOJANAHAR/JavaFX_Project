package application;
import javafx.application.Application;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Crud_Produit extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Appel des méthodes CRUD
        createProduit( "vero", 655);
        createProduit( "sitraka", 655);
        readProduit();
        System.out.print("********");
        updateProduit("sandratra", 22, "3");
        readProduit();
        System.out.print("********");
        deleteProduit("2");
        readProduit();
    }
    
    //Creation
    public void createProduit( String design, int stock) {
        try (Connection connection = Connexion.getConnection()) {
            String query = "INSERT INTO produit ( design, stock) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, design);
            statement.setInt(2, stock);
            System.out.print(0);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Lire
    public void readProduit() {
        try (Connection connection = Connexion.getConnection()) {
            String query = "SELECT  design, stock FROM produit";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String design = resultSet.getString("design");
                int stock = resultSet.getInt("stock");
                System.out.println("design : " + design);
                System.out.println("stock : " + stock);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Mise à jour
    public void updateProduit(String design, int stock, String numProd) {
        try (Connection connection = Connexion.getConnection()) {
            String query = "UPDATE produit SET design = ?, stock = ? WHERE numProd = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, design);
            statement.setInt(2, stock);
            statement.setString(3, numProd);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Suppression
    public void deleteProduit(String numProd) {
        try (Connection connection = Connexion.getConnection()) {
            String query = "DELETE FROM produit WHERE numProd = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, numProd);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}

 
    
    
 
	

