package ultimatePjatkBuilder;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class FloorHBox extends HBox {

    @FXML
    private Label performanceLabel;

    private final Floor floor;

    public FloorHBox(Floor floor) {
        this.floor = floor;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FloorHBox.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }

    @FXML
    public void initialize() {
        for (Person person : floor.getPerson()) {
            getChildren().add(person.getPersonButton());
            person.getPersonButton().setOnAction(e -> person.buy());
        }
    }

    public void setPerformanceLabel(PJCoin value) {
        performanceLabel.setText(value + " / s");
    }
}