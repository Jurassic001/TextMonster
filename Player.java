import java.util.ArrayList;


public class Player {
    private static int[] pos = new int[2];
    private ArrayList<String> weapons;


    public Player(int x, int y) {
        pos[0] = y; // floor
        pos[1] = x; // room
        weapons = new ArrayList<String>();
    }


    public static int[]getPos() {
        return pos; 
    }


    public void setPos(int x, int y) {
        pos[0] = y; // floor
        pos[1] = x; // room
    }


    public void updatePos(int direction) throws InterruptedException {
        switch (direction) {
            case 1:
                if (pos[1] < Board.board[pos[0]].length - 1) {
                    if (Board.getCurRoom().equals("monster") && pos[0] == 1) {
                        System.out.println("\n\nTrying to move past the monster, he roars in anger!");
                        Thread.sleep(500);
                        System.out.println("\nHe brings his club down on your head, instantly killing you.");
                        Thread.sleep(500);
                        Board.hasWon = true;
                        return;
                    }
                    pos[1] += 1;
                    System.out.println("\n\n\n\n\n");
                    Thread.sleep(100);
                } 
                else {
                    System.out.println("\n\nYou cannot move right");
                    Thread.sleep(500);
                }
                break;
            case 2:
                if (pos[1] > 0) {
                    if (Board.getCurRoom().equals("monster") && (pos[0] == 0 || pos[0] == 2)) {
                        System.out.println("\n\nTrying to move past the monster, he roars in anger!");
                        Thread.sleep(500);
                        System.out.println("\nHe brings his club down on your head, instantly killing you.");
                        Thread.sleep(500);
                        Board.hasWon = true;
                        return;
                    } 
                    else if (Board.getCurRoom().equals("boss")) {
                        System.out.println("\n\nTrying to move past the boss, he roars in anger!");
                        Thread.sleep(500);
                        System.out.println("\nHe brings his club down on your head, instantly killing you.");
                        Thread.sleep(500);
                        Board.hasWon = true;
                        return;
                    }
                    pos[1] -= 1;
                    System.out.println("\n\n\n\n\n");
                    Thread.sleep(100);
                } 
                else {
                    System.out.println("\n\nYou cannot move left");
                    Thread.sleep(500);
                }
                break;
            case 3:
                if (Board.getCurRoom().equals("stair up")) {
                    pos[0] -= 1;
                    System.out.println("\n\n\n\n\n");
                    Thread.sleep(100);
                } 
                else {
                    System.out.println("\n\nYou cannot go up");
                    Thread.sleep(500);
                }
                break;
            case 4:
                if (Board.getCurRoom().equals("stair down")) {
                    pos[0] += 1;
                    System.out.println("\n\n\n\n\n");
                    Thread.sleep(100);
                } 
                else {
                    System.out.println("\n\nYou cannot go down");
                    Thread.sleep(500);
                }
                break;
        }
    }


    public void updateInv() throws InterruptedException {
        String cur = Board.getCurRoom();
        switch(cur){
            case "sword":
            case "magic rocks":
            case "prize":
            case "stick":
                if (weapons.size() >= 3) {
                    System.out.println("\n\ninventory full");
                    Thread.sleep(500);
                    return;
                }
                weapons.add(cur);
                Board.setCurRoom("");
                System.out.println("\n\nYou picked up the " + cur);
                Thread.sleep(500);
                System.out.println("\nInventory: ");
                Thread.sleep(200);
                for (String s : weapons) {
                    System.out.println(s + " ");
                    Thread.sleep(200);
                }
                Thread.sleep(750);
                return;
            case "boss":
            case "monster":
                System.out.println("\n\nYou can't grab that!");
                Thread.sleep(500);
                return;
            case "treasure":
                Board.win();
                System.out.println("\n\nYou found the treasure! Hooray! ");
                Thread.sleep(1000);
                return;
            case "secret":
                if(!weapons.contains("The Radiant Dissonance Of The Creator")){
                    weapons.add("The Radiant Dissonance Of The Creator");
                    Board.setCurRoom("");
                    System.out.println("\n\nYou picked up The Radiant Dissonance Of The Creator");
                    Thread.sleep(500);
                    System.out.println("\nInventory: ");
                    Thread.sleep(200);
                    for (String s : weapons) {
                        System.out.println(s + " ");
                        Thread.sleep(200);
                    }
                    Thread.sleep(750);
                }
                else {
                    System.out.println("\n\nYou already possess The Radiant Dissonance Of The Creator");
                    Thread.sleep(500);
                    System.out.println("\nYou must turn back...");
                    Thread.sleep(1000);
                }
                return;
            default:
                System.out.println("\n\nThere is nothing to grab");
                Thread.sleep(500);
                return;
        }
    }


    public void attack() throws InterruptedException {
        if (Board.getCurRoom().equals("secret") && !weapons.contains("The Radiant Dissonance Of The Creator")) {
            System.out.println("\n\nThe fabric of space and time opens wide to swallow you whole. You are damned to an eternity in the black expanse of nothing.");
            Thread.sleep(1000);
            Board.hasWon = true;
            return;
        }
        else if (!Board.getCurRoom().equals("monster") && !Board.getCurRoom().equals("boss")) {
            if (weapons.contains("sword")){
                System.out.println("\n\nYou wildly swing your sword around the empty room. You accidentally stab yourself, and die due to blood loss.");
                Thread.sleep(1000);
                Board.hasWon = true;
                return;
            }
        }
        else if (weapons.contains("The Radiant Dissonance Of The Creator")) {
            System.out.println("\n\nYou obliterated your enemy with The Radiant Dissonance Of The Creator. You feel guilt.");
            Board.setCurRoom("");
            Thread.sleep(500);
            return;
        }
        else if (!weapons.contains("sword") && Board.getCurRoom().equals("monster")) {
            System.out.println("\n\nYou died to the monster. You need a weapon to attack.");
            Thread.sleep(500);
            Board.hasWon = true;
            return;
        }
        else if (Board.getCurRoom().equals("monster")) {
            Board.setCurRoom("");
            weapons.remove("sword");
            System.out.println("\n\nYou defeated the monster");
            Thread.sleep(500);
            return;
        }
        else if(Board.getCurRoom().equals("boss")) {
            if (weapons.contains("magic rocks") && weapons.contains("sword")) {
                System.out.println("\n\nUsing your magic rocks, you enchant your sword with the ability to pierce armor and strike the boss through his heart.");
                Thread.sleep(250);
                System.out.println("\nThe boss is dead");
                Thread.sleep(750);
                return;
            } 
            else {
                System.out.println("\n\nYou've died at the hands of the boss. You need a weapon and a magical item to attack him.");
                Thread.sleep(750);
                Board.hasWon = true;
                return;
            }
        }
    }


    public static void help() throws InterruptedException {
        System.out.print("\n\nYou called for help");
        for(int i = 1; i <= 3; i++){
            System.out.print(" . ");
            Thread.sleep(500);
        }
        System.out.print("\nSuddenly you are blessed with divine knowledge!");
        Thread.sleep(500);
        // Give the user help aka tell them the commands
        System.out.println("\n\nYou realize that all of your commands must be in lowercase");
        Thread.sleep(400);
        System.out.println("You understand that you can move left and right through hallways, and up and down using stairs");
        Thread.sleep(400);
        System.out.println("You come to the conclusion that you can grab items and attack monsters");
        Thread.sleep(400);
        System.out.println("You know you can dodge, although you are quite clumsy and might hurt yourself");
        Thread.sleep(500);
        System.out.print("\n\nPress Enter to continue on your adventure. ");
    }
}