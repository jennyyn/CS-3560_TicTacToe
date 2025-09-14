package edu.cpp.tictactoe;

public class Game {
    private final Player player1;
    private final Player player2;
    private final Board board = new Board();

    public Game ( Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;

    }

    public Board getBoard() {
        return board;
    }
    public void run() {
        Player current = player1;

        while (board.winner().isEmpty() && !board.isFull()) {
            Move move;

            while (true) {
                //asking player for move
                board.print();
                try {
                    move = current.nextMove(board); // human or AI
                    board.place(move);               // only here we actually place
                    break;
                    // valid move, exit retry loop
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid move! " + e.getMessage());
                }
                //Move move = current.nextMove(board);
            }

            if (board.winner().isPresent()) {
                board.print();
                System.out.println(current.mark + " player won!");
                break;
            }

            if (board.winner().isEmpty() && board.isFull()) {
                board.print();
                System.out.println("It's a draw!");
            }

            if (current.equals(player1)) {
                current = player2;
            }
            else {
                current = player1;
            }
        }

    }



}
