package ultimatePjatkBuilder;

import javafx.scene.control.Button;

public class Person {
    private final Button personButton = new Button();
    private final PJCoin price;
    private final PJCoin performance;
    private final Floor floor;

    public Person(int number, Floor floor) {
        this.floor = floor;
        price = PJCoin.valueOf(2).pow(number);
        performance = PJCoin.valueOf(1 + number * number);
        personButton.setText(price + "\n" + performance + " / s");

        if ((number + 1) % floor.numberOfPeopleOnFloor == 0) {
            personButton.getStyleClass().add("special");
        }
    }

    public Button getPersonButton() {
        return personButton;
    }

    public void buy() {
        if (Game.getInstance().pay(price) == false) {
            return;
        }

        personButton.setText(performance + " / s");
        personButton.setDisable(true);
        floor.increasePerformance(performance);
    }
}