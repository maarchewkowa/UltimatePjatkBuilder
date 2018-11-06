package ultimatePjatkBuilder;

import javafx.event.ActionEvent;

public class StartController {

    private Main application;

    public void startGameClick(ActionEvent actionEvent) {
        try {
            application.loadGameScene();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setApplication(Main application) {
        this.application = application;
    }
}