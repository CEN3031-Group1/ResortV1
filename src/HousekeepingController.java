import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

/**
 * Class HousekeepingController allows housekeeping employees to check requests sent from guests.
 */
public class HousekeepingController {

  public ImageView logoHome;
  public Rectangle room101;
  public Rectangle room102;
  public Rectangle room100;
  public Rectangle room103;

  @FXML
  public Button refreshRequestButton;

  @FXML
  public Button requestDoneButton;

  @FXML
  public TableView<Request> requestsTable;

  /**
   * When the screen loads, initaliaze requests table.
   */
  public void initialize(){
    loadRequests();
  }

  /**
   * Logs out user. Brings them to the login page.
   *
   */
  public void logOut(){
    Main.setPane(SCREENS.LOGIN.getValue());
  }

  /**
   * Populate table of requests.
   */
  public void loadRequests() {
    ObservableList<Request> selectedRequests = Request.getSelectedRequestList(2);

    TableColumn requestIDCol = new TableColumn("RequestID");
    requestIDCol.setMinWidth(20);
    requestIDCol.setCellValueFactory(
            new PropertyValueFactory<Request, Integer>("requestID"));

    TableColumn assignedEmployeeCol = new TableColumn("Assigned Employee");
    assignedEmployeeCol.setMinWidth(10);
    assignedEmployeeCol.setCellValueFactory(
            new PropertyValueFactory<Request, Integer>("empType"));

    TableColumn requestEnteredTimestampCol = new TableColumn("Request submitted on");
    requestEnteredTimestampCol.setMinWidth(60);
    requestEnteredTimestampCol.setCellValueFactory(
            new PropertyValueFactory<Request, String>("requestEnteredTimestamp"));

    TableColumn detailsCol = new TableColumn("Details");
    detailsCol.setMinWidth(60);
    detailsCol.setCellValueFactory(
            new PropertyValueFactory<Request, String>("requestDetail"));

    TableColumn requestStatusCol = new TableColumn("Status");
    requestStatusCol.setMinWidth(20);
    requestStatusCol.setCellValueFactory(
            new PropertyValueFactory<Request, String>("requestStatus"));

    TableColumn requestedCompletedTimeStampCol = new TableColumn("Completed on");
    requestedCompletedTimeStampCol.setMinWidth(60);
    requestedCompletedTimeStampCol.setCellValueFactory(
            new PropertyValueFactory<Request, String>("requestCompletedTimestamp"));

    TableColumn requestEmpNotesCol = new TableColumn("Employee Notes");
    requestEmpNotesCol.setMinWidth(60);
    requestEmpNotesCol.setCellValueFactory(
            new PropertyValueFactory<Request, String>("requestEmpNotes"));

    requestsTable.setItems(selectedRequests);
    requestsTable.getColumns().clear();
    requestsTable.getColumns().addAll(requestIDCol, assignedEmployeeCol, requestEnteredTimestampCol, detailsCol, requestStatusCol,
            requestedCompletedTimeStampCol, requestEmpNotesCol);
  }

  /**
   * Mark selected request in the tableView as done.
   *
   * TODO: IMPLEMENT THIS
   *
   * @param actionEvent - Mouse click
   */
  public void markRequestDone(ActionEvent actionEvent) {
    Request selectedRequest;
    selectedRequest = requestsTable.getSelectionModel().getSelectedItem();
    if (selectedRequest != null) {
      System.out.println("Mark request " + selectedRequest.getRequestID());
      selectedRequest.completeRequest("no notes");
      loadRequests();
    } else {
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Error");
      alert.setHeaderText("Request not selected.");
      alert.setContentText("Select a request and then click Mark as Done button.");
      alert.showAndWait();
    }


  }
}