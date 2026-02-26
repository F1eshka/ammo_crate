package ammo_crate;

import java.util.Random;

public class Supplier implements Runnable {
    private AmmoCrate crate;
    private Random random;

    public Supplier(AmmoCrate crate) {
        this.crate = crate;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(random.nextInt(501) + 500);
                int amount = random.nextInt(31) + 20;
                crate.reload(amount);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}