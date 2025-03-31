import artifacts.Car;
import artifacts.RaceTrack;
import artifacts.RaceTrackBox;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        RaceTrackBox box = new RaceTrackBox(100);
        RaceTrack raceTrack = new RaceTrack(4000, 10, box);

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            Car car = new Car(String.valueOf(i), raceTrack, 0);
            cars.add(car);
        }
    }
}