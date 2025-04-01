package artifacts;

import java.util.Random;

public class Car extends Thread {
    final int MAX_SPEED = 300;
    final int SAFETY_CAR_SPEED = 100;

    Random rd = new Random();
    RaceTrack raceTrack;

    long speed;
    long position;
    long lastUpdate;
    boolean running = true;

    public Car(String name, RaceTrack raceTrack) {
        super(name);
        this.raceTrack = raceTrack;
        this.position = 0;
        this.speed = rd.nextInt(MAX_SPEED / 2);
        this.lastUpdate = System.currentTimeMillis();
    }

    public void updateSpeed() {
        if (!running) return;

        updatePosition();

        if (raceTrack.isSafetyCarActive()) {
            this.speed = Math.min(this.speed, SAFETY_CAR_SPEED);
        } else {
            this.speed = Math.min(this.speed + rd.nextInt(50), MAX_SPEED);
        }
    }

    public void updatePosition() {
        if (!running) return;

        long now = System.currentTimeMillis();
        this.position += this.speed * (now - lastUpdate) / 1000.0;
        this.lastUpdate = now;
    }

    public void requestToGetInTheBox() {
        raceTrack.box.add(this);
    }

    public void penalize() {
        System.out.println("⚠️ Carro " + this.getName() + " penalizado por excesso de velocidade no box!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void addTimeInTheBox() {
        try {
            long boxTime = 1500 + rd.nextInt(3000);
            System.out.println("🛠️ Carro " + this.getName() + " está no box por " + boxTime / 1000 + " segundos.");
            Thread.sleep(boxTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void breakDown() {
        System.out.println("❌ Carro " + this.getName() + " QUEBROU e está FORA da corrida!");
        running = false;
    }

    @Override
    public void run() {
        while (position < raceTrack.getTotalDistance() && running) {
            updateSpeed();

            System.out.println("🏎️ " + this.getName() + " rodando a " + this.speed + " km/h, posição: " + this.position);

            if (rd.nextDouble() < 0.1) {
                System.out.println("🔧 " + this.getName() + " entrou no box!");
                requestToGetInTheBox();
            }

            if (rd.nextDouble() < 0.1) {
                breakDown();
                break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (running) {
            System.out.println("🏁 " + this.getName() + " terminou a corrida!");
        }
    }
}
