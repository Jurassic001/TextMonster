public class Board {
    final static String[][] board = {
        {"treasure", "boss", "monster", "stair down", "sword"},
        {"stair down", "prize", "monster", "stair up", "sword", "j", "j", "j", "j", "j", "j", "j", "j", "j", "j", "j", "j", "j", "j", "j", "j", "secret"},
        {"stair up", "monster", "magic rocks", "sword", "sword"}
    };

    static boolean hasWon;
    Player player;


    public Board(Player p) {
        hasWon = false;
        player = p;
    }


    public static void win() {
        hasWon = true;
    }


    public static void reset() {
        hasWon = false;
    }


    public static String getCurRoom() {
        return board[Player.getPos()[0]][Player.getPos()[1]];
    }


    public static void setCurRoom(String newItem) {
        board[Player.getPos()[0]][Player.getPos()[1]] = newItem;
    }


    public void printCurRoom() throws InterruptedException {
        switch (board[Player.getPos()[0]][Player.getPos()[1]]) {
            case "":
                System.out.println("You see nothing");
                break;
            case "sword":
                System.out.println("You see a sword");
                break;
            case "monster":
                System.out.println("You see a monster");
                break;
            case "stair up":
                System.out.println("You see stairs going up");
                break;
            case "stair down":
                System.out.println("You see stairs going down");
                break;
            case "prize":
                System.out.println("You see a prize");
                break;
            case "magic rocks":
                System.out.println("You see magic rocks");
                break;
            case "stick":
                System.out.println("You see a stick");
                break;
            case "boss":
                System.out.println("You see the boss");
                break;
            case "treasure":
                System.out.println("You see treasure");
                break;
            case "j":
                System.out.println("You see \uD83D\uDCA7\uFE0E☜\uFE0E\uD83D\uDC4D\uFE0E☼\uFE0E☜\uFE0E❄\uFE0E\uD83D\uDCA7\uFE0E \uD83D\uDD46\uFE0E☠\uFE0E☞\uFE0E⚐\uFE0E☹\uFE0E\uD83D\uDC4E\uFE0E\uD83D\uDCEA\uFE0E \uD83D\uDCA3\uFE0E✡\uFE0E\uD83D\uDCA7\uFE0E❄\uFE0E☜\uFE0E☼\uFE0E✡\uFE0E \uD83D\uDD46\uFE0E☠\uFE0E❄\uFE0E⚐\uFE0E☹\uFE0E\uD83D\uDC4E\uFE0E  (This is an intended, secret feature)");
                break;
            case "secret":
                System.out.println("You see the fabric of space and time ripping beneath you. You're too far in Miss. Jones\n");
                String[] turnback = {"t", "u", "r", "n", " ", "b", "a", "c", "k", " ", ".", " ", ".", " ", ".", " "};   
                for(int i = 0; i < 3; i++){
                    for(String c : turnback){
                        System.out.print(c);
                        Thread.sleep(50);
                    }
                }
                System.out.println("");             
                break;
        }
    }

    public void printCastle() {
        // Print the roof
        System.out.println("\n\n");
        System.out.println("                    ^                     ");
        System.out.println("                   / \\                    ");
        System.out.println("                  /   \\                    ");
        System.out.println("                 /  +  \\                    ");
        System.out.println("                /       \\                    ");
        System.out.println("               /         \\                    ");
        System.out.println("              /           \\                    ");
        System.out.println("             /|           |\\                    ");
        System.out.println("            / |           | \\                    ");

        if (Player.getPos()[0] != 0) {
            System.out.println("           /  |           |  \\                    "); // top floor
        } else {
            if (Player.getPos()[1] == 0) {
                System.out.println("           /  | @ _ _ _ _ |  \\                    ");
            } else if (Player.getPos()[1] == 1) {
                System.out.println("           /  | $ @ _ _ _ |  \\                    ");
            } else if (Player.getPos()[1] == 2) {
                System.out.println("           /  | $ _ @ _ _ |  \\                    ");
            } else if (Player.getPos()[1] == 3) {
                System.out.println("           /  | $ _ _ @ _ |  \\                    ");
            } else if (Player.getPos()[1] == 4) {
                System.out.println("           /  | $ _ _ _ @ |  \\                    ");
            }
        }
        System.out.println("              |      _    |                         ");
        System.out.println("              |       _   |                         ");
        System.out.println("              |      _    |                         ");


        if (Player.getPos()[0] != 1) {
            System.out.println("              |           }                      "); // floor 1
        } else {
            if (Player.getPos()[1] == 0) {
                System.out.println("              | @ _ _ _ _ !                      ");
            } else if (Player.getPos()[1] == 1) {
                System.out.println("              | _ @ _ _ _ \\                      ");
            } else if (Player.getPos()[1] == 2) {
                System.out.println("              | _ _ @ _ _ :                      ");
            } else if (Player.getPos()[1] == 3) {
                System.out.println("              | _ _ _ @ _ (                      ");
            } else if (Player.getPos()[1] == 4) {
                System.out.println("              | _ _ _ _ @ !                      ");
            }
        }
        System.out.println("              | _         |                         ");
        System.out.println("              |  _        |                         ");
        System.out.println("              | _         |                         ");


        if (Player.getPos()[0] != 2) {
            System.out.println("              |           |                      "); // floor 2
        } else {
            if (Player.getPos()[1] == 0) {
                System.out.println("              | @ _ _ _ _ |                      ");
            } else if (Player.getPos()[1] == 1) {
                System.out.println("              | _ @ _ _ _ |                      ");
            } else if (Player.getPos()[1] == 2) {
                System.out.println("              | _ _ @ _ _ |                      ");
            } else if (Player.getPos()[1] == 3) {
                System.out.println("              | _ _ _ @ _ |                      ");
            } else if (Player.getPos()[1] == 4) {
                System.out.println("              | _ _ _ _ @ |                      ");
            }
        }
        System.out.println("_____(_}______|___________|_______(________))_{_______");
    }
}