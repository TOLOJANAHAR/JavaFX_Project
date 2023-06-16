package application;
import javafx.application.Application;
import javafx.stage.Stage;
import java.sql.*;

public class Connexion extends Application {

	    private static final String DB_URL = "jdbc:mysql://localhost:3306/java_project";
	    private static final String DB_USER = "root";
	    private static final String DB_PASSWORD = "";

	    public static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	    }

		@Override
		public void start(Stage arg0) throws Exception {
			
		}
	
}
