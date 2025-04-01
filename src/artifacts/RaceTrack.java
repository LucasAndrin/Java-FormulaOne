package artifacts;

import java.util.ArrayList;
import java.util.List;

public class RaceTrack extends Thread {
    long distance;
    int laps;
    List<Car> cars = new ArrayList<>();
    RaceTrackBox box;
    private boolean safetyCarActive = false;

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
            if (car.isAlive()) return true;
        }
        return false;
    }

    public void addCar(Car... newCars) {
        cars.addAll(List.of(newCars));
    }

    public boolean isSafetyCarActive() {
        return safetyCarActive;
    }

    public void activateSafetyCar() {
        safetyCarActive = true;
        System.out.println("🚨 SAFETY CAR ATIVADO! Todos os carros devem reduzir a velocidade!");
    }

    public void deactivateSafetyCar() {
        safetyCarActive = false;
        System.out.println("✅ SAFETY CAR DESATIVADO! Corrida normalizada.");
    }

    @Override
    public void run() {
        System.out.println("🏁 Corrida iniciada!");
        for (Car car : cars) {
            car.start();
        }

        while (carsAreRunning()) {
            try {
                Thread.sleep(10000);

                if (Math.random() < 0.2) {
                    activateSafetyCar();
                    Thread.sleep(8000);
                    deactivateSafetyCar();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("🏁 Corrida finalizada!");
    }
}
