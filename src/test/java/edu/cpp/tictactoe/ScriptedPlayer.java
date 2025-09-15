package edu.cpp.tictactoe;

import java.util.*;

public class ScriptedPlayer extends Player{
    private final List<Move> moves;
    private int index = 0;
    public ScriptedPlayer(Mark mark, List<Move> moves) {
        super(mark);
        this.moves = moves;
    }

    @Override
    public Move nextMove(Board board) {
        if (index >= moves.size()) {
            throw new IllegalStateException("No more moves scripted");
        }
        return moves.get(index++);
    }
}
