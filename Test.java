package test;
import game.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Game game = new Game("PLAYER1", "PLAYER2");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            game.showBoard(System.out);
            System.out.println(game.getPlayer1() + "'s turn.");
            System.out.println("Enter a command (mv, cp, undo, status, quit):");
            String command = scanner.nextLine();

            if (command.equals("mv")) {
                System.out.println("Enter move (e.g. a2a4):");
                String moveString = scanner.nextLine();
                Move move = new Move(moveString);
                if (game.move(move)) {
                    System.out.println(game.getPlayer1() + " moves: " + moveString);
                } else {
                    System.out.println("Illegal move!");
                }
            } else if (command.equals("cp")) {
                System.out.println("Enter capture (e.g. a1b2):");
                String captureString = scanner.nextLine();
                if (captureString == "a2b3") {
                    System.out.println(game.getPlayer1() + " captures: " + captureString);
                } else {
                    System.out.println("Illegal capture!");
                }
            } else if (command.equals("undo")) {
                game.undo();
            } else if (command.equals("status")) {
                game.printStatus();
            } else if (command.equals("quit")) {
                break;
            }


        }//end while loop
    }//end main
}//end test class


