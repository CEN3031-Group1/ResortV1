import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

//TODO: Explore difference between preloading ALL fxml files (as here) and loading them as needed. Better performance?
//TODO:     also maybe able to do more with initialize functions to load database info.

public class Main extends Application {
    static AnchorPane root;

    private static List<AnchorPane> grid = new ArrayList<>();

    private static int current = 0;

    @Override
    public void start(Stage primaryStage){
      try {
        root = FXMLLoader.load(Main.class.getResource("anchor.fxml"));
        grid.add(FXMLLoader.load(Main.class.getResource("login.fxml")));
        grid.add(FXMLLoader.load(Main.class.getResource("managerHome.fxml")));
        grid.add(FXMLLoader.load(Main.class.getResource("createNewGuestAccount.fxml")));
        grid.add(FXMLLoader.load(Main.class.getResource("floorChart.fxml")));
        grid.add(FXMLLoader.load(Main.class.getResource("housekeepingView.fxml")));
        grid.add(FXMLLoader.load(Main.class.getResource("maintenanceView.fxml")));
        grid.add(FXMLLoader.load(Main.class.getResource("valetView.fxml")));
        grid.add(FXMLLoader.load(Main.class.getResource("employeeList.fxml")));
        grid.add(FXMLLoader.load(Main.class.getResource("guestHome.fxml")));
        grid.add(FXMLLoader.load(Main.class.getResource("maintenanceRequest.fxml")));
        grid.add(FXMLLoader.load(Main.class.getResource("housekeepingRequest.fxml")));
        grid.add(FXMLLoader.load(Main.class.getResource("foodService.fxml")));
        grid.add(FXMLLoader.load(Main.class.getResource("concierge.fxml")));
        grid.add(FXMLLoader.load(Main.class.getResource("foodServicesView.fxml")));
        grid.add(FXMLLoader.load(Main.class.getResource("valetView.fxml")));
        grid.add(FXMLLoader.load(Main.class.getResource("employeeAccountForm.fxml")));
        grid.add(FXMLLoader.load(Main.class.getResource("guestList.fxml")));

        root.getChildren().add(grid.get(SCREENS.LOGIN.getValue()));

        Scene scene = new Scene(root, 1280,800);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        // Use the line below to skip login screen and jump to another to save time if frequently running
        setPane(SCREENS.LOGIN.getValue());
      }
      catch(Exception e){
        e.printStackTrace();
      }
    }

    public static AnchorPane getPane(int current){
      return grid.get(current);
    }

    public static void setPane(int newCurrent){
      root.getChildren().remove((grid.get(current)));
      root.getChildren().add(grid.get(newCurrent));
      current = newCurrent;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
