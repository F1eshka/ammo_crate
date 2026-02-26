package ammo_crate;

public class Main {
    public static void main(String[] args) {
        AmmoCrate crate = new AmmoCrate();

        Thread supplier = new Thread(new Supplier(crate));
        Thread player1 = new Thread(new Player(crate, "Player-1"));
        Thread player2 = new Thread(new Player(crate, "Player-2"));
        Thread player3 = new Thread(new Player(crate, "Player-3"));

        supplier.start();
        player1.start();
        player2.start();
        player3.start();
    }
}