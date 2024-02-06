import java.util.Scanner;


public class Main {
@SuppressWarnings("static-access")
public static void main(String[] args) throws InterruptedException {
       Scanner s = new Scanner(System.in);


       // player starts at 3, 5
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
                   System.out.print("\n\nYou called for help");
                   for(int i = 1; i <= 6; i++){
                    System.out.print(" . ");
                    Thread.sleep(500);
                   }
                   System.out.print(" But nobody came");
                   Thread.sleep(500);
                   break;
               case "dodge":
                   System.out.println("\n\nYou dive headfirst into a nearby wall, instantly killing you.");
                   Thread.sleep(1000);
                   b.hasWon = true;
                   break;
               case "turn back":
                   System.out.println("\n\nYou call out to the universe, begging to be sent back to the start of your adventure.");
                   Thread.sleep(750);
                   System.out.println("\nThe universe answers, and in a flash of light you are transported to the room you started in.");
                   Thread.sleep(400);
                   p.setPos(4, 2);
           }
       }
       s.close();
   }
}