import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;

public class ManagerHomeController {

  public Button buttonNewAccount;
  public Button buttonFloorChart;
  public Button buttonAllRequests;
  public Button buttonEmployees;
  public Button viewFoodServices;
  @FXML
  private Button viewFoodServicesEmp;

  //these are request radio buttons - they suppose to disappear when req is done
  public CheckBox radio1;
  public CheckBox radio2;
  public CheckBox radio3;
  public CheckBox radio4;
  //when this button is clicked - radio disappears
  public Button buttonDone;

  @FXML
  public TableView<Request> allRequestsTable;


  public void initialize(){
    viewAllRequests();
  }

  //brings to create new guest account screen
  public void buttonNewAccount(ActionEvent actionEvent) {
    Main.setPane(SCREENS.CREATENEWGUEST.getValue());
  }

  //brings to view floor chart screen
  public void viewFloorChart(ActionEvent actionEvent) {
    Main.setPane(SCREENS.FLOORCHART.getValue());
  }

  public void viewAllRequests() {
    ObservableList<Request> allRequests = Request.getAllRequestList();

    TableColumn requestIDCol = new TableColumn("RequestID");
    requestIDCol.setMinWidth(60.0);
    requestIDCol.setCellValueFactory(
            new PropertyValueFactory<Request, Integer>("requestID"));

    TableColumn assignedEmployeeCol = new TableColumn("Assigned Employee");
    assignedEmployeeCol.setMinWidth(70.0);
    assignedEmployeeCol.setCellValueFactory(
            new PropertyValueFactory<Request, String>("empTypeText"));

    TableColumn requestEnteredTimestampCol = new TableColumn("Request Submitted On");
    requestEnteredTimestampCol.setMinWidth(70.0);
    requestEnteredTimestampCol.setCellValueFactory(
            new PropertyValueFactory<Request, String>("requestEnteredTimestampReadable"));

    TableColumn roomNumCol = new TableColumn("Room Number");
    roomNumCol.setMinWidth(60.0);
    roomNumCol.setCellValueFactory(
            new PropertyValueFactory<Request, Integer>("requestRoomNum"));

    TableColumn detailsCol = new TableColumn("Details");
    detailsCol.setMinWidth(360.0);
    detailsCol.setCellValueFactory(
            new PropertyValueFactory<Request, String>("requestDetail"));

    allRequestsTable.setItems(allRequests);
    allRequestsTable.getColumns().clear();
    allRequestsTable.getColumns().addAll(requestIDCol, assignedEmployeeCol, roomNumCol, requestEnteredTimestampCol, detailsCol);
  }

  public void viewAllEmployees(ActionEvent actionEvent) {
    Main.setPane(SCREENS.EMPLOYEELIST.getValue());
  }

  public void RequestIsDone(ActionEvent actionEvent) {
    Request selectedRequest;
    selectedRequest = allRequestsTable.getSelectionModel().getSelectedItem();
    if (selectedRequest != null) {
      System.out.println("Mark request " + selectedRequest.getRequestID());
      selectedRequest.completeRequest("no notes");
      viewAllRequests();
    } else {
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Error");
      alert.setHeaderText("Request not selected.");
      alert.setContentText("Select a request and then click Mark as Done button.");
      alert.showAndWait();
    }

  }

  public void logOut(){
    Main.setPane(SCREENS.LOGIN.getValue());
  }

  public void createReport(){
    PDDocument document = new PDDocument();
    PDPage page = new PDPage();
    document.addPage(page);
    try {
      PDPageContentStream contentStream = new PDPageContentStream(document, page);

      contentStream.setFont(PDType1Font.HELVETICA_BOLD, 24);
      contentStream.beginText();
      contentStream.moveTextPositionByAmount(100,750);
      contentStream.showText("FGCU Resort - Manager Report");
      contentStream.endText();

      contentStream.setFont(PDType1Font.HELVETICA_BOLD, 18);
      contentStream.beginText();
      contentStream.moveTextPositionByAmount(20,700);
      contentStream.showText("# STAFF");
      contentStream.endText();

      contentStream.setFont(PDType1Font.HELVETICA, 12);
      contentStream.beginText();
      contentStream.moveTextPositionByAmount(25,680);

      //has to load from query
      contentStream.showText("Maintenance: 5");
      contentStream.endText();

      contentStream.setFont(PDType1Font.HELVETICA, 12);
      contentStream.beginText();
      contentStream.moveTextPositionByAmount(25,660);
      //has to load from query
      contentStream.showText("Valet: 1");
      contentStream.endText();

      contentStream.setFont(PDType1Font.HELVETICA, 12);
      contentStream.beginText();
      contentStream.moveTextPositionByAmount(25,640);
      //has to load from query
      contentStream.showText("Housekeeping: 3");
      contentStream.endText();

      contentStream.setFont(PDType1Font.HELVETICA, 12);
      contentStream.beginText();
      contentStream.moveTextPositionByAmount(25,620);
      //has to load from query
      contentStream.showText("Managers: 2");
      contentStream.endText();

      contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
      contentStream.beginText();
      contentStream.moveTextPositionByAmount(20,580);
      //has to load from query
      contentStream.showText("Reserved Rooms: 10");
      contentStream.endText();


      contentStream.close();

      document.save("./reports/managerReport.pdf");
      document.close();

      System.out.println("Report created");
    } catch(IOException e){
      System.out.println(e.toString());
    }

  }

  public void viewGuests(ActionEvent actionEvent) {
    Main.setPane(SCREENS.GUESTLIST.getValue());
  }
}
