package edu.cpp.tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer extends Player {

    private final Scanner scanner;

    public HumanPlayer(String name, Mark mark, Scanner scanner) {
        super(mark); //call Player constructor to set the mark
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Move nextMove (Board board) {
        while (true) {  // repeat until a valid move is entered
            try {
                System.out.print("Enter row (0-2): ");
                int row = scanner.nextInt();
                System.out.print("Enter column (0-2): ");
                int col = scanner.nextInt();

                return new Move(row, col, mark); // validate row/col >=0

            } catch (InputMismatchException e) {
                System.out.println("Please enter integers only!");
                scanner.nextLine(); // clear bad input
            }
        }

    }
}
