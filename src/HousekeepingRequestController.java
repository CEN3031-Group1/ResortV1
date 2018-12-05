import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.Action;

/**
 * Class HousekeepingRequestController allows guests to submit a personalized housekeeping request.
 */
public class HousekeepingRequestController {
    public Button buttonSubmitRequestHouskeeping;
    public TextField towelAmount;
    public TextField toiletPaperAmount;
    public TextField shampooAmount;
    public TextField conditionerAmount;
    public TextField soapAmount;
    public CheckBox changeSheets;
    public CheckBox restockFridge;
    public CheckBox cleanRoom;
    public CheckBox makeBed;
    public TextField textOtherReqs;

    private String requestDetail = "";


    /**
     * Brings guest back to the home screen.
     *
     * @param mouseEvent - Mouse click
     */
    public void getBackHome(MouseEvent mouseEvent) {
        Main.setPane(SCREENS.GUESTHOME.getValue());
    }

  /**
   * Adds text to requestDetail String
   *
   * @param value - String containing text o add to detail
   */
    private void requestDetailAdd(String value) {
      if(requestDetail.isEmpty())
        requestDetail = value.trim();
      else
        requestDetail += ", \r\n" + value.trim();
    }


  /**
     * Creates a request by fetching data from user. Request is inserted into DB through query.
     *
     * @param event - Mouse click
     */
    public void submitRequest(ActionEvent event){
      requestDetail = "";

      if (changeSheets.isSelected()) requestDetailAdd( "Change the sheets" );
      if (restockFridge.isSelected()) requestDetailAdd( "Restock fridge" );
      if (cleanRoom.isSelected()) requestDetailAdd( "Clean the room" );
      if (makeBed.isSelected()) requestDetailAdd( "Make the bed" );

      if(getIntValue(towelAmount) > 0) requestDetailAdd( "Towlels: " + getIntValue(towelAmount));

      if(getIntValue(toiletPaperAmount) > 0) requestDetailAdd( "Toilet paper: " + getIntValue(toiletPaperAmount));

      if(getIntValue(shampooAmount) > 0) requestDetailAdd( "Shampoo: " + getIntValue(shampooAmount));

      if(getIntValue(conditionerAmount) > 0) requestDetailAdd( "Conditioner: " + getIntValue(conditionerAmount));

      if(getIntValue(soapAmount) > 0) requestDetailAdd( "Soap: " + getIntValue(soapAmount));

      requestDetail += textOtherReqs.getText().trim();

      Request thisRequest = new Request(User.globalCurrentUser.getUserID(), 2, requestDetail,
              User.globalCurrentUser.getGuestRoomNumber());
      thisRequest.insertRequestInDB();

      //After DB method returns true
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setTitle("Success!");
      alert.setHeaderText(null);
      alert.setContentText("Housekeeping request successfully submitted!");
      alert.showAndWait();

      //Once the request is submitted bring guests home
      Main.setPane(SCREENS.GUESTHOME.getValue());
    }


  /**
   * Extracts integer value from contents of a text entry
   *
   * @param textField - TextField to extract int value from
   */

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

}
