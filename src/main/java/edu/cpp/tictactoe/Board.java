package edu.cpp.tictactoe;

import java.util.Optional;
public class Board {
    private final int size;
    private final Mark[][] grid;

    //constructor
    public Board() {
        this.size = 3;
        grid = new Mark[size][size];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = Mark.EMPTY;
            }
        }

    }


    public Optional<Mark> winner() {
        //check rows or columns
        for (int i = 0; i < this.size; i++) {
            if (grid[i][0] != Mark.EMPTY && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) {
                return Optional.of(grid[i][0]);
            }
            if (grid[0][i] != Mark.EMPTY && grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]) {
                return Optional.of(grid[0][i]);
            }
        }

        //checks diagonal
        if (grid[0][0] != Mark.EMPTY && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
            return Optional.of(grid[0][0]);
        }
        if (grid[0][2] != Mark.EMPTY && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
            return Optional.of(grid[0][2]);
        }
        return Optional.empty();
    }


    public boolean isFull() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (grid[row][col] == Mark.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public Mark getCell(int x, int y) {
        return grid[x][y];
    }

    public int getSize() {
        return size;
    }

    public void reset() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                grid[row][col] = Mark.EMPTY;
            }
        }
    }

    public void place(Move mv) {
        int row = mv.getRow();
        int col = mv.getCol();
        Mark mark = mv.getMark();

        // Validate bounds
        if (row < 0 || col < 0 || row >= size || col >= size) {
            throw new IllegalArgumentException("Row and column must be between 0 and " + (size - 1));
        }

        // Validate empty spot
        if (grid[row][col] != Mark.EMPTY) {
            throw new IllegalArgumentException("Cell is already occupied");
        }

        // Place the mark
        grid[row][col] = mark;
    }

    public void print() {
        System.out.println("   0   1   2 ");
        for (int r = 0; r < size; r++) {
            System.out.print(r + " ");
            System.out.printf(" %s | %s | %s %n", grid[r][0], grid[r][1], grid[r][2]);
            if (r < 2) {
                System.out.println("  ---+---+---");
            }
        }

        System.out.println("________________________________");
    }

}
