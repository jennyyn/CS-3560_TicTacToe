package edu.cpp.tictactoe;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomAIPlayer extends Player {

    private final Random rand = new Random();

    public RandomAIPlayer (String name, Mark mark) {
        super(mark); //call Player constructor to set the mark
    }

    @Override
    public Move nextMove (Board board) {
        List<Move> availableMoves = new ArrayList<>();

        //Scanning board for empty cells
        for (int r = 0; r < board.getSize(); r++) {
            for (int c = 0; c < board.getSize(); c++) {
                if(board.getCell(r,c) == Mark.EMPTY) {
                    availableMoves.add(new Move(r,c,mark));
                }
            }
        }


        if(availableMoves.isEmpty()) {
            throw new IllegalStateException("No moves available.");
        }

        //choose out of available moves
        Move move = availableMoves.get(rand.nextInt(availableMoves.size()));
        System.out.println("Computer O moves to " + move.toString());
        return move;


    }
}
