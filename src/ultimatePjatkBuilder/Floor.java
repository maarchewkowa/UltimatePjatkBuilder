package ultimatePjatkBuilder;

import java.util.ArrayList;

public class Floor {
    private PJCoin performance = PJCoin.valueOf(0);
    private final ArrayList<Person> people = new ArrayList<>();
    private final FloorHBox floorHBox;
    private final City city;
    public final int numberOfPeopleOnFloor = 4;

    public Floor(int number, City city) {
        this.city = city;

        for (int i = 0; i < numberOfPeopleOnFloor; i++) {
            people.add(new Person(numberOfPeopleOnFloor * (number - 1) + i, this));
        }
        floorHBox = new FloorHBox(this);
    }

    public void increasePerformance(PJCoin value) {
        performance = performance.add(value);
        city.increasePerformance(value);
        floorHBox.setPerformanceLabel(performance);
    }

    public static PJCoin price(int number) {
        return PJCoin.valueOf(10).pow(number);
    }

    public FloorHBox getFloorHBox() {
        return floorHBox;
    }

    public ArrayList<Person> getPerson() {
        return people;
    }
}