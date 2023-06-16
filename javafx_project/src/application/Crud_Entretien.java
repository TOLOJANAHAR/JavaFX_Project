package application;
import javafx.application.Application;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Crud_Entretien extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Appel des méthodes CRUD
        //creatEntretien("01", 1122, "lala",0);
    	//readEntretien();
        /*System.out.print("************");
        updateEntretien("03", 6666, "aaa", 0, "3");
        readEntretien();
        deleteEntretien("3");
        System.out.print("************");
        readEntretien();*/
    }
    
    //Creation
    public void creatEntretien (String numServ, int immatriculation_voiture, String nomClient, int dateEntr) {
        try (Connection connection = Connexion.getConnection()) {
            String query = "INSERT INTO entretien ( numServ, immatriculation_voiture ,nomClient, dateEntr) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString( 1, numServ);
            statement.setInt(2, immatriculation_voiture);
            statement.setString(3, nomClient);
            statement.setInt(4, dateEntr);
            //verification si le service est dans la BD Service
            //liaison avec le client
            String query1 = "INSERT INTO client (nomClient) VALUES (?)";
            PreparedStatement statement1 = connection.prepareStatement(query1);
            statement1.setString(1, nomClient);
            statement.executeUpdate();
            statement1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Lire
    public void readEntretien() {
        try (Connection connection = Connexion.getConnection()) {
            String query = "SELECT numEntr, numServ, immatriculation_voiture, nomClient, dateEntr FROM entretien";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String numEntr = resultSet.getString("numEntr");
                String numServ = resultSet.getString("numServ");
                String immatriculation_voiture = resultSet.getString("immatriculation_voiture");
                String nomClient = resultSet.getString("nomClient");
                String dateEntr = resultSet.getString("dateEntr");
                System.out.println("numEntr : " + numEntr);
                /*
                 	for (String num : numServ) {
                    System.out.print(num + " ");
                }
                */
                System.out.println("numServ : " + numServ);
                System.out.println("immatriculation_voiture : " + immatriculation_voiture);
                System.out.println("nomClient : " + nomClient);
                System.out.println("dateEntr : " + dateEntr);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Mise à jour
    public void updateEntretien(String numServ, int immatriculation_voiture, String nomClient, int dateEntr, String numEntr) {
        try (Connection connection = Connexion.getConnection()) {
            String query = "UPDATE entretien SET numServ = ?, immatriculation_voiture = ?, nomClient = ?, dateEntr=? WHERE numEntr = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, numServ);
            statement.setInt(2, immatriculation_voiture);
            statement.setString(3, nomClient);
            statement.setInt(4, dateEntr);
            statement.setString(5, numEntr);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Suppression
    public void deleteEntretien(String numEntr) {
        try (Connection connection = Connexion.getConnection()) {
            String query = "DELETE FROM entretien WHERE numEntr = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, numEntr);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}

 
    
    
 
	


