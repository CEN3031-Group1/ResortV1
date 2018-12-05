import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Class ConciergeController allows Guests to submit a concierge requests.
 *
 */
public class ConciergeController {
  @FXML
  public TextField quantityUniLandTickets;

  @FXML
  public TextField quantityAdvTickets;

  @FXML
  public TextField quantityKBBQ;

  private String requestDetail;

  /**
   * Function requestDetailAdd is used to assemble the detail text that goes with a request.
   *
   * @param value - String containing the info to be included in the request
   */
  private void requestDetailAdd(String value) {
    if(requestDetail.isEmpty())
      requestDetail = value.trim();
    else
      requestDetail += ", \r\n" + value.trim();
  }



  /**
   * Function getBackHome brings the user back to the main menu once the back arrow icon is clicked.
   *
   * @param mouseEvent - Click of the mouse
   */
  public void getBackHome(MouseEvent mouseEvent) {

    //Set current pane in Main to GUESTHOME
    Main.setPane(SCREENS.GUESTHOME.getValue());
  }

  /**
   * Function submitReservation calculates the total amount that the guest owes, adds it to a field in the DB,
   * and creates a maintenance request for managers that contains the type of concierge service the guest has
   * selected.
   *
   * @param actionEvent - Click of the mouse onto button
   */
  public void submitReservation(ActionEvent actionEvent) {
    //
    requestDetail = "";

    if(getIntValue(quantityUniLandTickets) > 0) requestDetailAdd( "Reserve Universe Land Tickets: " + getIntValue(quantityUniLandTickets));
    if(getIntValue(quantityAdvTickets) > 0) requestDetailAdd( "Reserve Archipelagos of Adventure Tickets: " + getIntValue(quantityAdvTickets));
    if(getIntValue(quantityKBBQ) > 0) requestDetailAdd( "Reserve Seats at Korean BBQ: " + getIntValue(quantityKBBQ));

    Request thisRequest = new Request(User.globalCurrentUser.getUserID(), 6, requestDetail,
            User.globalCurrentUser.getGuestRoomNumber());
    thisRequest.insertRequestInDB();

    //After DB method returns true
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Success!");
    alert.setHeaderText(null);
    alert.setContentText("Reservation successfully submitted!");

    alert.showAndWait();

    //Bring guest back to main menu
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



}
