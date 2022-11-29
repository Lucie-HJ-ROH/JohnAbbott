package assignment02;

import java.util.*;

public class PlayLadderAndSnake {

    public static void main(String[] args) {

        int nPlayers; // number of players.

        String gameEnd = "\n================================Game END====================================";
        Scanner kb = new Scanner(System.in);
        System.out.println("Welcome to the Ladder and Snake Game work << by Hyunju Roh>>\n ");


        /** Until the user inputs the valid number,
         *  prompt ask you the appropriate number of players between 2-4
         */

        System.out.print("Enter the # of players for your game (Number between 2-4) ====>  ");
        nPlayers = kb.nextInt();

        int count = 1; // count for check the bad attempt.
        while (count < 4) {
            if (nPlayers < 2 || nPlayers > 4) {
                System.out.printf("\nBad Attempt %d  - Invalid # of players. Please enter a # between 2 and 4 inclusively ====>  ", count);
                nPlayers = kb.nextInt();
                count++;
            } else {
                break;
            }
        }

        if (count == 4 && (nPlayers < 2 || nPlayers > 4)) {
            System.out.printf("\nBad Attempt %d! You have exhausted all your chances. Program will terminate. ", count);
            System.out.println(gameEnd);
            System.exit(0);
        }


        System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<GAME START>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
        System.out.printf(">> Game is Played by %d players \n", nPlayers);

        System.out.println(">> Now deciding which player will start playing");
        ArrayList<LadderAndSnake> gamers = new ArrayList();
        gamers = playerOrder(gamers, nPlayers); // decide order


        System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<<<Let's Begin the play>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
        int winner = 0; // save the index of winner.
        boolean find = false;
        int cnt = 0;
//        while (find == false) {
//            for (int i = 0; i < nPlayers; i++) {
//                gamers.get(i).play();
//                if (gamers.get(i).getSquare() == 100) {
//                    winner = i;
//                    find = true;
//                    break;
//                }
//            }
//            System.out.println("Game is not over : Flipping again");
//        }

        System.out.println("\nFinally, Player #" + gamers.get(winner).getIndex() + " WIN");
        System.out.println("Congratulation!!!!!!!!!!!");


        System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<<<Game Over>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
    }


    public static ArrayList<LadderAndSnake> playerOrder(ArrayList<LadderAndSnake> gamers, int nPlayers) {
        ArrayList<LadderAndSnake> orderedPlayer = new ArrayList<>();

        for (int i = 0; i < nPlayers; i++) {
            gamers.add(new LadderAndSnake(i + 1));
            System.out.println("Player #" + gamers.get(i).getIndex() + " got a dice value of " + gamers.get(i).getOrder());
        }

        Collections.sort(gamers, new PlayerOrderComparator().reversed()); // first order.


        //compare and reorder
        for (int i = 0; i < nPlayers - 1; i++) {
            for (int j = i; j < nPlayers; j++) {
                if (gamers.get(i).equals(gamers.get(j)) && (i != j)) {
                    System.out.println("A tie was achieved between Player " + gamers.get(i).getIndex() + " and Player " + gamers.get(j).getIndex());
                    System.out.println("Attempting to break the tie");
                    gamers.get(i).setOrder();
                    gamers.get(j).setOrder();
                    System.out.println("Player #" + gamers.get(i).getIndex() + " got a dice value of " + gamers.get(i).getOrder());
                    System.out.println("Player #" + gamers.get(j).getIndex() + " got a dice value of " + gamers.get(j).getOrder());

                    if (gamers.get(i).getOrder() < gamers.get(j).getOrder()) {
                        gamers.add(i, gamers.get(j));
                        gamers.remove(j + 1);

                    }
                    i = nPlayers;
                    j = nPlayers;
                    break;
                }

            }
        }

        for (int i = 0; i < nPlayers; i++) {
            System.out.print("Player #" + gamers.get(i).getIndex() + " , ");
        }


        return gamers;
    }
}

/**
 * Compare to Order number among players.
 */
class PlayerOrderComparator implements Comparator<LadderAndSnake> {

    @Override
    public int compare(LadderAndSnake o1, LadderAndSnake o2) {
        if (o1.getOrder() > o2.getOrder()) {
            return 1;
        } else if (o1.getOrder() < o2.getOrder()) {
            return -1;
        } else {
            return 0;
        }
    }
}
