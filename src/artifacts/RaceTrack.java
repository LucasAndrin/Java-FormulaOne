package artifacts;

import java.util.ArrayList;
import java.util.List;

public class RaceTrack extends Thread {
    long distance;
    int laps;

    List<Car> cars = new ArrayList<Car>();
    RaceTrackBox box;

    boolean safetyCarActive = false;

    public RaceTrack(long distance, int laps, RaceTrackBox box) {
        this.distance = distance;
        this.laps = laps;
        this.box = box;
    }

    public long getTotalDistance() {
        return distance * laps;
    }

    public boolean carsAreRunning() {
        for (Car car : cars) {
            if (car.isAlive())
                return true;
        }
        return false;
    }

    @Override
    public void run() {


        for (Car car : cars) {

        }
    }


}