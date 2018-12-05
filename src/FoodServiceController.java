import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Class FoodServiceController allows guests to submit a personalized food service request.
 */
public class FoodServiceController {

    @FXML
    public TextField totalAmount;

    @FXML
    public Button buttonSubmitOrder;

    @FXML
    public TextField quantityCalmari;

    @FXML
    public TextField quantityCaprese;

    @FXML
    public TextField quantityZucchini;

    @FXML
    public TextField quantityVegetables;

    @FXML
    public TextField quantityPotato;

    @FXML
    public TextField quantitySalad;

    @FXML
    public TextField quantityChicken;

    @FXML
    public TextField quantityShrimp;

    @FXML
    public TextField quantityBeef;

    @FXML
    public TextField quantityMushroom;

    @FXML
    public TextField quantityTiramisu;

    @FXML
    public TextField quantityPannaCotta;

    @FXML
    public TextField quantityZeppole;

    @FXML
    public TextField roomNumber;

    public Text calmariPrice;
    public Text capresePrice;
    public Text zucchiniPrice;
    public Text chickenPrice;
    public Text shrimpPrice;
    public Text beefPrize;
    public Text mushroomPrice;
    public Text mixedVegetablesPrice;
    public Text potatoPrice;
    public Text saladPrice;
    public Text tiramisuPrice;
    public Text pannaCottaPrice;
    public Text zeppolePrice;


    private String requestDetail;
    private float valueTotalPrice;


    /**
     * Brings guest back to the home screen.
     *
     * @param mouseEvent - Mouse click
     */
    public void getBackHome(MouseEvent mouseEvent) {
        Main.setPane(SCREENS.GUESTHOME.getValue());

    }

    private void requestDetailAdd(String value) {
        if(requestDetail.isEmpty())
            requestDetail = value.trim();
        else
            requestDetail += ", \r\n" + value.trim();
    }
    public void onEnterOnExitMouse(MouseEvent event) {
        updateTotalPrice();
    }

    public void onChangeInput(KeyEvent event) {
        System.out.println(event.getText());
        updateTotalPrice();
    }

    private void updateTotalPrice() {
        valueTotalPrice = 0;

        if(getIntValue(quantityCalmari) > 0) valueTotalPrice += Math.abs(getIntValue(quantityCalmari)) * getFloatValue(calmariPrice);
        if(getIntValue(quantityCaprese) > 0) valueTotalPrice += Math.abs(getIntValue(quantityCaprese)) * getFloatValue(capresePrice);
        if(getIntValue(quantityZucchini) > 0) valueTotalPrice += Math.abs(getIntValue(quantityZucchini)) * getFloatValue(zucchiniPrice);

        if(getIntValue(quantityChicken) > 0) valueTotalPrice += Math.abs(getIntValue(quantityChicken)) * getFloatValue(chickenPrice);
        if(getIntValue(quantityShrimp) > 0) valueTotalPrice += Math.abs(getIntValue(quantityShrimp)) * getFloatValue(shrimpPrice);
        if(getIntValue(quantityBeef) > 0) valueTotalPrice += Math.abs(getIntValue(quantityBeef)) * getFloatValue(beefPrize);
        if(getIntValue(quantityMushroom) > 0) valueTotalPrice += Math.abs(getIntValue(quantityMushroom)) * getFloatValue(mushroomPrice);

        if(getIntValue(quantityVegetables) > 0) valueTotalPrice += Math.abs(getIntValue(quantityVegetables)) * getFloatValue(mixedVegetablesPrice);
        if(getIntValue(quantityPotato) > 0) valueTotalPrice += Math.abs(getIntValue(quantityPotato)) * getFloatValue(potatoPrice);
        if(getIntValue(quantitySalad) > 0) valueTotalPrice += Math.abs(getIntValue(quantitySalad)) * getFloatValue(saladPrice);

        if(getIntValue(quantityTiramisu) > 0) valueTotalPrice += Math.abs(getIntValue(quantityTiramisu)) * getFloatValue(tiramisuPrice);
        if(getIntValue(quantityPannaCotta) > 0) valueTotalPrice += Math.abs(getIntValue(quantityPannaCotta)) * getFloatValue(pannaCottaPrice);
        if(getIntValue(quantityZeppole) > 0) valueTotalPrice += Math.abs(getIntValue(quantityZeppole)) * getFloatValue(zeppolePrice);

        totalAmount.setText("$ "+valueTotalPrice);
    }

    /**
     * Fetches data from textFields and calculates total of the order. Assigns this total to field in user table,
     * then creates a foodService request with the value that the user provided.
     *
     * @param actionEvent - Mouse click
     */
    public void submitOrder(ActionEvent actionEvent) {

        requestDetail = "";

        if(getIntValue(quantityCalmari) > 0) requestDetailAdd( "Appetizers - Calamari: " + getIntValue(quantityCalmari));
        if(getIntValue(quantityCaprese) > 0) requestDetailAdd( "Appetizers - Tomato caprese: " + getIntValue(quantityCaprese));
        if(getIntValue(quantityZucchini) > 0) requestDetailAdd( "Appetizers - Zucchini Fritte: " + getIntValue(quantityZucchini));

        if(getIntValue(quantityChicken) > 0) requestDetailAdd( "Entrées - Parmesean Chicken: " + getIntValue(quantityChicken));
        if(getIntValue(quantityShrimp) > 0) requestDetailAdd( "Entrées - Shrimp Scapi: " + getIntValue(quantityShrimp));
        if(getIntValue(quantityBeef) > 0) requestDetailAdd( "Entrées - Beef Tenderloin: " + getIntValue(quantityBeef));
        if(getIntValue(quantityMushroom) > 0) requestDetailAdd( "Entrées - Mushroom Rissotto: " + getIntValue(quantityMushroom));

        if(getIntValue(quantityVegetables) > 0) requestDetailAdd( "Sides - Mixed Vegetables: " + getIntValue(quantityVegetables));
        if(getIntValue(quantityPotato) > 0) requestDetailAdd( "Sides - Mashed Potatos: " + getIntValue(quantityPotato));
        if(getIntValue(quantitySalad) > 0) requestDetailAdd( "Sides - Ceasar salad: " + getIntValue(quantitySalad));

        if(getIntValue(quantityTiramisu) > 0) requestDetailAdd( "Desserts - Tiramisu: " + getIntValue(quantityTiramisu));
        if(getIntValue(quantityPannaCotta) > 0) requestDetailAdd( "Desserts - Panna Cotta: " + getIntValue(quantityPannaCotta));
        if(getIntValue(quantityZeppole) > 0) requestDetailAdd( "Desserts - Zeppole: " + getIntValue(quantityZeppole));

        requestDetailAdd("Total amount: " + totalAmount.getText().trim() );

        Request thisRequest = new Request(User.globalCurrentUser.getUserID(), 5, requestDetail,
                User.globalCurrentUser.getGuestRoomNumber());
        thisRequest.insertRequestInDB();

        //After DB method returns true
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Success!");
        alert.setHeaderText(null);
        alert.setContentText("Food request successfully submitted!");

        alert.showAndWait();

        Main.setPane(SCREENS.GUESTHOME.getValue());
    }

    public int getIntValue(TextField textField) {
        int value = 0;
        if(textField.getText() != null && textField.getText().trim().length() > 0)
        {
            try {
                value = Integer.parseInt(textField.getText().trim());
            } catch (NumberFormatException ex) {
                //
            }
        }
        return value;
    }

    public float getFloatValue(Text textField) {
        float value = 0;
        if(textField.getText() != null && textField.getText().trim().length() > 0)
        {
            try {
                value = Float.parseFloat(textField.getText().trim());
            } catch (NumberFormatException ex) {
                //
            }
        }
        return value;
    }

}
