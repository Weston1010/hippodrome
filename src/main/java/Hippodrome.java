import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    static class AnsiColors {
        public static final String RESET = "\u001B[0m";
        public static final String RED = "\u001B[31m";
        public static final String PURPLE = "\u001B[35m";
        public static final String TURQUOISE = "\u001B[36m";
    }
    static Hippodrome game;
    private List<Horse> horses;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse winHorse = horses.get(0);
        for (Horse horse : horses) {
            if (winHorse.getDistance() < horse.getDistance()) {
                winHorse = horse;
            }
        }
        return winHorse;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) {
        ArrayList<Horse> horses = new ArrayList<>();
        horses.add(new Horse(AnsiColors.PURPLE + "Midnight" + "\uD83D\uDC0E" + AnsiColors.RESET, 3, 0));
        horses.add(new Horse(AnsiColors.RED + "Wildfire" + "\uD83D\uDC0E" + AnsiColors.RESET, 3, 0));
        horses.add(new Horse(AnsiColors.TURQUOISE + "Kingston" + "\uD83D\uDC0E" + AnsiColors.RESET, 3, 0));
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }
}