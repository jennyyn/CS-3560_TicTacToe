package edu.cpp.tictactoe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.Optional;

public class BoardTest {
    @Test
    public void row1WinDetected() {
        Board b = new Board();
        b.place(new Move(0,0, Mark.X));
        b.place(new Move(1,0, Mark.O));
        b.place(new Move(0,1, Mark.X));
        b.place(new Move(1,1, Mark.O));
        b.place(new Move(0,2, Mark.X));
        assertEquals(Optional.of(Mark.X), b.winner());
    }

    @Test
    public void row2WinDetected() {
        Board b = new Board();
        b.place(new Move(1,0, Mark.X));
        b.place(new Move(0,0, Mark.O));
        b.place(new Move(1,1, Mark.X));
        b.place(new Move(0,1, Mark.O));
        b.place(new Move(1,2, Mark.X));
        assertEquals(Optional.of(Mark.X), b.winner());
    }

    @Test
    public void row3WinDetected() {
        Board b = new Board();
        b.place(new Move(2,0, Mark.X));
        b.place(new Move(0,0, Mark.O));
        b.place(new Move(2,1, Mark.X));
        b.place(new Move(0,1, Mark.O));
        b.place(new Move(2,2, Mark.X));
        assertEquals(Optional.of(Mark.X), b.winner());
    }

    @Test
    public void column1WinDetected() {
        Board b = new Board();
        b.place(new Move(0,0, Mark.X));
        b.place(new Move(0,1, Mark.O));
        b.place(new Move(1,0, Mark.X));
        b.place(new Move(1,1, Mark.O));
        b.place(new Move(2,0, Mark.X));
        assertEquals(Optional.of(Mark.X), b.winner());
    }

    @Test
    public void column2WinDetected() {
        Board b = new Board();
        b.place(new Move(0,1, Mark.X));
        b.place(new Move(0,0, Mark.O));
        b.place(new Move(1,1, Mark.X));
        b.place(new Move(1,2, Mark.O));
        b.place(new Move(2,1, Mark.X));
        assertEquals(Optional.of(Mark.X), b.winner());
    }

    @Test
    public void column3WinDetected() {
        Board b = new Board();
        b.place(new Move(0,2, Mark.X));
        b.place(new Move(0,0, Mark.O));
        b.place(new Move(1,2, Mark.X));
        b.place(new Move(1,1, Mark.O));
        b.place(new Move(2,2, Mark.X));
        assertEquals(Optional.of(Mark.X), b.winner());
    }

    @Test
    public void diagonal1WinDetected() {
        Board b = new Board();
        b.place(new Move(0,0, Mark.X));
        b.place(new Move(0,1, Mark.O));
        b.place(new Move(1,1, Mark.X));
        b.place(new Move(1,2, Mark.O));
        b.place(new Move(2,2, Mark.X));
        assertEquals(Optional.of(Mark.X), b.winner());
    }

    @Test
    public void diagonal2WinDetected() {
        Board b = new Board();
        b.place(new Move(2,0, Mark.X));
        b.place(new Move(0,1, Mark.O));
        b.place(new Move(1,1, Mark.X));
        b.place(new Move(1,2, Mark.O));
        b.place(new Move(0,2, Mark.X));
        assertEquals(Optional.of(Mark.X), b.winner());
    }

    @Test
    public void row1WinDetectedO() {
        Board b = new Board();
        b.place(new Move(0,0, Mark.O));
        b.place(new Move(1,0, Mark.X));
        b.place(new Move(0,1, Mark.O));
        b.place(new Move(1,1, Mark.X));
        b.place(new Move(0,2, Mark.O));
        assertEquals(Optional.of(Mark.O), b.winner());
    }

    @Test
    public void drawDetected() {
        Board b = new Board();
        b.place(new Move(0, 0, Mark.X));
        b.place(new Move(0, 2, Mark.O));
        b.place(new Move(0, 1, Mark.X));
        b.place(new Move(1, 0, Mark.O));
        b.place(new Move(1, 2, Mark.X));
        b.place(new Move(1, 1, Mark.O));
        b.place(new Move(2, 0, Mark.X));
        b.place(new Move(2, 1, Mark.O));
        b.place(new Move(2, 2, Mark.X));
        assertEquals(Optional.empty(), b.winner());
    }

    @Test
    public void fullBoardDetected() {
        Board b = new Board();
        b.place(new Move(0,0, Mark.X));
        b.place(new Move(0,2, Mark.O));
        b.place(new Move(0,1, Mark.X));
        b.place(new Move(1,0, Mark.O));
        b.place(new Move(1,2, Mark.X));
        b.place(new Move(1,1, Mark.O));
        b.place(new Move(2,0, Mark.X));
        b.place(new Move(2,1, Mark.O));
        b.place(new Move(2,2, Mark.X));
        assertTrue(b.isFull());
    }

    @Test
    public void sameCellDetected() {
        Board b = new Board();
        b.place(new Move(2,0, Mark.X));
        b.place(new Move(0,1, Mark.O));

        assertThrows(IllegalArgumentException.class, () -> {
            b.place(new Move(0,1, Mark.X));
        });


    }


}
