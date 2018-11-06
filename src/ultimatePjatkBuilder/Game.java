package ultimatePjatkBuilder;

import javafx.application.Platform;

import java.util.*;

public class Game {
    private static Game instance;
    private int gameTime = 0;
    private GameController gameController;
    private PJCoin balance = PJCoin.valueOf(12);
    private PJCoin performance = PJCoin.valueOf(0);
    private final ArrayList<City> cities = new ArrayList<>();

    private Game() {
        cities.add(new City("Warsaw"));
        cities.add(new City("Gdansk"));
        cities.add(new City("Bytom"));
    }

    public static Game getInstance() {
        if (instance == null)
            instance = new Game();
        return instance;
    }

    public void start(GameController gameController) {
        this.gameController = gameController;

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    balance = balance.add(performance);
                    gameController.setTime(gameTime++);
                    gameController.setBalance(balance);
                });
            }
        }, 0, 1000);

        gameController.setTotalPerformance(performance);
    }

    public boolean pay(PJCoin price) {
        if (price.compareTo(balance) > 0) {
            gameController.showNotEnoughMoneyAlert();
            return false;
        }

        balance = balance.subtract(price);
        gameController.setBalance(balance);
        return true;
    }

    public void increasePerformance(PJCoin value) {
        performance = performance.add(value);
        gameController.setTotalPerformance(performance);
    }

    public ArrayList<City> getCities() {
        return cities;
    }
}