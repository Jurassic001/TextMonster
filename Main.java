import java.util.Scanner;


public class Main {
    @SuppressWarnings("static-access")
    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);

        // The player starts at the very right of the first floor
        Player p = new Player(4, 2);
        Board b = new Board(p);

        while (!b.hasWon) {
            b.printCastle();
            b.printCurRoom();
            System.out.print("What would you like to do? ");
            String input = s.nextLine();
            switch (input) {
                case "r":
                case "right":
                    p.updatePos(1);
                    break;
                case "l":
                case "left":
                    p.updatePos(2);
                    break;
                case "u":
                case "up":
                    p.updatePos(3);
                    break;
                case "d":
                case "down":
                    p.updatePos(4);
                    break;
                case "g":
                case "grab":
                    p.updateInv();
                    break;
                case "a":
                case "attack":
                    p.attack();
                    break;
                case "help":
                    p.help();
                    s.nextLine();
                    break;
                case "dodge":
                    System.out.println("\n\nYou dive headfirst into a nearby wall, instantly killing you");
                    Thread.sleep(1000);
                    b.hasWon = true;
                    break;
                case "turn back":
                    System.out.println("\n\nYou call out to the universe, begging to be sent back to the start of your adventure");
                    Thread.sleep(750);
                    System.out.println("\nThe universe answers, and in a flash of light you are transported to the room you started in");
                    Thread.sleep(600);
                    p.setPos(4, 2);
                    break;
                default: // Invalid commands are recognized by the main character and a hint is given
                    System.out.println("\n\nYou feel confused and forgetful, as if you can't understand what you wanted to do before");
                    Thread.sleep(600);
                    System.out.println("\nThrough the fog of confusion, you feel the urge to ask for help");
                    Thread.sleep(600);
                    break;
            }
            if(b.hasWon) {
                System.out.println("\n\nWould you like to play again? ");
                String restart = s.nextLine();
                switch (restart) {
                    case "yes":
                    case "y":
                        p.setPos(4, 2);
                        b.reset();
                }
            }
        }
        s.close();
    }
}