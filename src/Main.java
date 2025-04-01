import artifacts.Car;
import artifacts.RaceTrack;
import artifacts.RaceTrackBox;

public class Main {
    public static void main(String[] args) {
        RaceTrackBox box = new RaceTrackBox(80);
        RaceTrack raceTrack = new RaceTrack(500, 10, box);

        var car1 = new Car("Carro 1", raceTrack);
        var car2 = new Car("Carro 2", raceTrack);
        var car3 = new Car("Carro 3", raceTrack);

        raceTrack.addCar(car1, car2, car3);

        raceTrack.start();
    }
}
