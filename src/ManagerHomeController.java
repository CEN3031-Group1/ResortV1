import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class ManagerHomeController {

  public Button buttonNewGuestAccount;
  public Button buttonFloorChart;
  public Button buttonAllRequests;
  public Button buttonEmployees;

  //these are request radio buttons - they suppose to disappear when req is done
  public CheckBox radio1;
  public CheckBox radio2;
  public CheckBox radio3;
  public CheckBox radio4;
  //when this button is clicked - radio disappears
  public Button buttonDone;


  //brings to create new guest account screen
  public void buttonNewGuestAccount(ActionEvent actionEvent) {
    Main.setPane(SCREENS.CREATENEWGUEST.getValue());
  }

  //brings to view floor chart screen
  public void viewFloorChart(ActionEvent actionEvent) {
    Main.setPane(SCREENS.FLOORCHART.getValue());
  }

  public void viewAllRequests(ActionEvent actionEvent) {
    Main.setPane(SCREENS.ALLREQUESTS.getValue());
  }

  public void viewAllEmployees(ActionEvent actionEvent) {
    Main.setPane(SCREENS.EMPLOYEELIST.getValue());
  }

  public void RequestIsDone(ActionEvent actionEvent) {
  }
}
