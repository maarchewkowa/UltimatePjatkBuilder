package ultimatePjatkBuilder;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class GameController {
    @FXML
    private HBox citiesButtons;
    @FXML
    private Label timeLabel;
    @FXML
    private Label balanceLabel;
    @FXML
    private Label performanceLabel;
    @FXML
    private VBox cityContainer;

    @FXML
    public void initialize() {
        Game.getInstance().start(this);
        cityContainer.getChildren().add(Game.getInstance().getCities().get(0).getCityVBox());
        for (City city : Game.getInstance().getCities()){
            Button cityButton = new Button(city.getName());
            cityButton.setOnAction(e -> {
                cityContainer.getChildren().clear();
                cityContainer.getChildren().add(city.getCityVBox());
            });
            citiesButtons.getChildren().add(cityButton);
        }
    }

    public void setTime(int seconds) {
        timeLabel.setText(String.format("%02d : %02d", seconds/60, seconds%60));
    }

    public void setBalance(PJCoin balance){
        balanceLabel.setText(balance.toString());
    }

    public void setTotalPerformance(PJCoin performance){
        performanceLabel.setText(performance + " / s");
    }

    public void showNotEnoughMoneyAlert(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Not Enough PJ Coins!");
        alert.setHeaderText(null);
        alert.setContentText("You don't have enough PJC to buy this item!");

        alert.showAndWait();
    }
}