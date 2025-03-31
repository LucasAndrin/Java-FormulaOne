package artifacts;

import java.util.Random;

public class Car extends Thread {
    final int MAX_SPEED = 300;

    Random rd = new Random();
    RaceTrack raceTrack;

    long speed;
    long position;
    long lastUpdate;
    int currentLap;
    long endTime;

    public Car(String name, RaceTrack raceTrack) {
        super(name);
        this.raceTrack = raceTrack;
        this.position = 0;
        this.speed = 0;
    }

    public int getCurrentLap() {
        return (int) (position / raceTrack.getTotalDistance());
    }

    public void updateSpeed() {
        updatePosition();
        this.speed += rd.nextInt(MAX_SPEED);
    }

    public void updatePosition() {
        this.position += this.speed * (lastUpdate - System.currentTimeMillis());
    }

    public void requestToGetInTheBox() {
        raceTrack.box.add(this);
    }

    public void penalize() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void addTimeInTheBox() {
        var random = new Random();

        try {
            Thread.sleep(random.nextLong(1500,4500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        do {

        } while (position < raceTrack.getTotalDistance());
        System.out.println();
        System.out.println("Car " + this.getName() + " is running with speed: " + this.speed);
    }
}
