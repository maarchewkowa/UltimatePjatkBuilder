package ultimatePjatkBuilder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        FXMLLoader startLoader = new FXMLLoader(getClass().getResource("StartWindow.fxml"));
        Parent startScene = startLoader.load();
        primaryStage.setTitle("Ultimate PJATK Builder");
        StartController startController = startLoader.getController();
        startController.setApplication(this);
        primaryStage.setScene(new Scene(startScene));
        primaryStage.show();
    }

    public void loadGameScene() throws Exception {
        FXMLLoader startLoader = new FXMLLoader(getClass().getResource("GameWindow.fxml"));
        Parent startScene = startLoader.load();
        startLoader.getController();
        primaryStage.setScene(new Scene(startScene));
        primaryStage.show();
        primaryStage.setOnCloseRequest(e ->
                System.exit(0)
        );
    }

    public static void main(String[] args) {
        launch(args);
    }
}