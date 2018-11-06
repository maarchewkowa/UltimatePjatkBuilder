package ultimatePjatkBuilder;

import java.util.ArrayList;

public class City {
    private final String name;
    private final ArrayList<Floor> floors = new ArrayList<>();
    private PJCoin performance = PJCoin.valueOf(0);
    private final CityVBox cityVBox = new CityVBox(this);

    public City(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public CityVBox getCityVBox() {
        return cityVBox;
    }

    public ArrayList<Floor> getFloors(){
        return floors;
    }

    public void increasePerformance(PJCoin value){
        performance = performance.add(value);
        Game.getInstance().increasePerformance(value);
        cityVBox.setPerformanceLabel(performance);
    }
}