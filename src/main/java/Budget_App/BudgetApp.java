package Budget_App;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BudgetApp extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Budget App");
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("BankAccount.fxml"))));
        primaryStage.show();
    }
}