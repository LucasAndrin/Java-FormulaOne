package artifacts;

import java.util.ArrayList;
import java.util.List;

public class RaceTrackBox {
    List<Car> cars = new ArrayList<>();
    int maxSpeed;

    public RaceTrackBox(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public synchronized void add(Car car) {
        cars.add(car);

        if (car.speed > maxSpeed) {
            car.penalize();
        }

        car.addTimeInTheBox();
        car.speed = 60;
        System.out.println("Carro " + car.getName() + " saiu do box!");
        cars.remove(car);
    }
}
