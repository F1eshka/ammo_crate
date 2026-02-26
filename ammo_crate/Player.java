package ammo_crate;

import java.util.Random;

public class Player implements Runnable {
    private AmmoCrate crate;
    private String name;
    private Random random;

    public Player(AmmoCrate crate, String name) {
        this.crate = crate;
        this.name = name;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(random.nextInt(501) + 300);
                int amount = random.nextInt(21) + 10;
                crate.takeAmmo(amount, name);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}