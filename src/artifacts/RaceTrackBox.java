package artifacts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RaceTrackBox {
    RaceTrack raceTrack;
    List<Car> cars = new ArrayList<Car>();

    int maxSpeed = 80;
    public RaceTrackBox(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void add(Car... newCars) {
        cars.addAll(Arrays.asList(newCars));
        verifyCarsSpeed();
        addBoxTimeToCars();
    }

    public void verifyCarsSpeed() {
        for (Car car : cars) {
            if (car.speed > maxSpeed) {
                car.penalize();
            }
            cars.add(car);
        }
    }

    public void addBoxTimeToCars() {
        for (Car car : cars) {
            if (car.speed > maxSpeed) {
                car.addTimeInTheBox();
            }
            cars.add(car);
        }
    }
}
