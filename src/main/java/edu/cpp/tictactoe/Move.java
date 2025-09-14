package edu.cpp.tictactoe;

public class Move {
    private final int row;
    private final int col;
    private final Mark mark;


    public Move(int row, int col, Mark mark) {
        //make sure it's valid
        if (row < 0 || col < 0) {
            throw new IllegalArgumentException("Row and column must be greater than or equal to 0");
        }
        if (mark == null) {
            throw new IllegalArgumentException("Mark cannot be null");
        }

        this.row = row;
        this.col = col;
        this.mark = mark;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public Mark getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return "(" + row + ", " + col + ")";
    }
}
