package ultimatePjatkBuilder;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;

import java.io.IOException;

public class CityVBox extends VBox {
    private final City city;
    @FXML
    private VBox floorsVBox;
    @FXML
    private Button buyFloorButton;
    @FXML
    private Label performanceLabel;

    public CityVBox(City city) {
        this.city = city;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CityVBox.fxml"));
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
        setNextFloorPrice();
    }

    public void buyFloorClick(ActionEvent actionEvent) {
        if (Game.getInstance().pay(Floor.price(city.getFloors().size() + 1)) == false)
            return;

        Floor floor = new Floor(city.getFloors().size() + 1, city);
        floorsVBox.getChildren().add(0, floor.getFloorHBox());
        city.getFloors().add(floor);
        setNextFloorPrice();
    }

    private void setNextFloorPrice() {
        buyFloorButton.setText("Buy New Floor for " + Floor.price(city.getFloors().size() + 1));
    }

    public void setPerformanceLabel(PJCoin value) {
        performanceLabel.setText(value + " / s");
    }
}