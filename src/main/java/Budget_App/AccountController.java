package Budget_App;

import java.util.ArrayList;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.Scene;

public class AccountController {

    //Buttons
    @FXML
    private Button savingsAccountButton;
    @FXML
    private Button checkingAccountButton;
    @FXML
    private Button changeDepositButton;
    @FXML
    private Button changeTransferButton;    
    @FXML
    private Button changeWithdrawButton;
    @FXML 
    private Button newExpenseButton;
    @FXML 
    private Button cancelButton; 
    @FXML 
    private Text headerText;
    @FXML
    private VBox root;
  
    //Main objects
    public Budget budget;
    public BankAccount savingsAccount;  // initialized in fxml init function due to required constructor inputs
    public BankAccount checkingAccount; // initialized in fxml init function due to required constructor inputs

    public BankAccount getSavingsAccount() {
        return this.savingsAccount;
    }
    public BankAccount getCheckingAccount() {
        return this.checkingAccount;
    }

    @FXML
    public void initialize() throws IOException {
        budget = new Budget(new ArrayList<Expense>());
        savingsAccount= new SavingAccount("SavingAccount", 0, 1);
        checkingAccount= new CheckingAccount("CheckingAccount", 0, 1);
        handleRefresh();
    }

    @FXML
    public void handleRefresh() throws IOException {
        budget.LoadState();
        if (budget.getExpenses() != null) {
            try {
                for (Expense ex : budget.getExpenses()) {
                    VBox textbox = new VBox(5);
                    textbox.setId("textbox");
                    textbox.setPadding(new Insets(5, 10, 10, 10));
        
                    Text name = new Text(ex.getExpenseName() + ": ");
                    Text desc = new Text(ex.getDescription());
                    textbox.getChildren().addAll(name, desc);
                    
                    root.getChildren().add(textbox);
                    root.setPadding(new Insets(10, 20, 20, 20)); 
                }  
            } catch(Exception e) {

            }
        }
    }

    @FXML 
    public void savingsAccountView() {
       //TODO: SWAP OUT LABELS AND LIST OF EXPENSES TO THE SAVING ACCOUNT DATA
    }

    @FXML 
    public void checkingAccountView() {
       //TODO: SWAP OUT LABELS AND LIST OF EXPENSES TO THE SAVING ACCOUNT DATA
    }

    @FXML 
    public void changeNewExpenseView() {
        try {
            switchTo("NewExpense");
          } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML 
    public void changeDepositView() {
        try {
            switchTo("Deposit");
          } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML 
    public void changeTransferView() {
        try {
            switchTo("Transfer");
          } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML 
    public void changeWithdrawView() {
        try {
            switchTo("Withdraw");
          } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void switchTo(String fxmlName) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlName + ".fxml"));
        Parent parents = (Parent) fxmlLoader.load();
        Stage stage = (Stage) savingsAccountButton.getScene().getWindow();
        Scene scene = new Scene(parents);
        var controller = fxmlLoader.getController();
        ((Budget_App.performActionController) controller).setAccountController(this);
        stage.setTitle("New " + fxmlName);
        stage.setScene(scene);
        stage.show();
    }
}

