package ammo_crate;

public class AmmoCrate {
    private int totalAmmo = 0;

    public synchronized void reload(int amount) {
        totalAmmo += amount;
        System.out.println("[Supplier] Поповнив на +" + amount + ". Всього на складі: " + totalAmmo);
        notifyAll();
    }

    public synchronized void takeAmmo(int amount, String playerName) {
        while (totalAmmo < amount) {
            System.out.println("[" + playerName + "] Невдача! Не вистачає патронів (хотів " + amount + ", є "
                    + totalAmmo + "). Очікує...");
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        totalAmmo -= amount;
        System.out.println("[" + playerName + "] Перезарядився на -" + amount + ". Залишилось: " + totalAmmo);
    }
}