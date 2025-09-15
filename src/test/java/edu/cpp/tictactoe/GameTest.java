package edu.cpp.tictactoe;

//import org.junit.Test;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    @Test
    public void xWinsInTopRow() {

        ScriptedPlayer x = new ScriptedPlayer(Mark.X, Arrays.asList(
                new Move (0,0, Mark.X),
                new Move (0,1, Mark.X),
                new Move (0,2, Mark.X)
                ));

        ScriptedPlayer o = new ScriptedPlayer(Mark.O, Arrays.asList(
                new Move(1,0, Mark.O),
                new Move(1,1, Mark.O)
        ));

        Game game = new Game( x, o);
        game.run();

        assertEquals(Optional.of(Mark.X), game.getBoard().winner());
    }

    @Test
    public void xWinsInMiddleRow() {

        ScriptedPlayer x = new ScriptedPlayer(Mark.X, Arrays.asList(
                new Move (1,0, Mark.X),
                new Move (1,1, Mark.X),
                new Move (1,2, Mark.X)
        ));

        ScriptedPlayer o = new ScriptedPlayer(Mark.O, Arrays.asList(
                new Move(0,0, Mark.O),
                new Move(0,1, Mark.O)
        ));

        Game game = new Game( x, o);
        game.run();

        assertEquals(Optional.of(Mark.X), game.getBoard().winner());
    }

    @Test
    public void xWinsInBottomRow() {

        ScriptedPlayer x = new ScriptedPlayer(Mark.X, Arrays.asList(
                new Move (2,0, Mark.X),
                new Move (2,1, Mark.X),
                new Move (2,2, Mark.X)
        ));

        ScriptedPlayer o = new ScriptedPlayer(Mark.O, Arrays.asList(
                new Move(0,0, Mark.O),
                new Move(0,1, Mark.O)
        ));

        Game game = new Game( x, o);
        game.run();

        assertEquals(Optional.of(Mark.X), game.getBoard().winner());
    }

    @Test
    public void xWinsFirstColumn() {

        ScriptedPlayer x = new ScriptedPlayer(Mark.X, Arrays.asList(
                new Move (0,0, Mark.X),
                new Move (1,0, Mark.X),
                new Move (2,0, Mark.X)
        ));

        ScriptedPlayer o = new ScriptedPlayer(Mark.O, Arrays.asList(
                new Move(1,2, Mark.O),
                new Move(1,1, Mark.O)
        ));

        Game game = new Game( x, o);
        game.run();

        assertEquals(Optional.of(Mark.X), game.getBoard().winner());
    }

    @Test
    public void xWinsSecondColumn() {

        ScriptedPlayer x = new ScriptedPlayer(Mark.X, Arrays.asList(
                new Move (0,1, Mark.X),
                new Move (1,1, Mark.X),
                new Move (2,1, Mark.X)
        ));

        ScriptedPlayer o = new ScriptedPlayer(Mark.O, Arrays.asList(
                new Move(2,2, Mark.O),
                new Move(0,2, Mark.O)
        ));

        Game game = new Game( x, o);
        game.run();

        assertEquals(Optional.of(Mark.X), game.getBoard().winner());
    }

    @Test
    public void xWinsLastColumn() {

        ScriptedPlayer x = new ScriptedPlayer(Mark.X, Arrays.asList(
                new Move (0,2, Mark.X),
                new Move (1,2, Mark.X),
                new Move (2,2, Mark.X)
        ));

        ScriptedPlayer o = new ScriptedPlayer(Mark.O, Arrays.asList(
                new Move(0,1, Mark.O),
                new Move(2,1, Mark.O)
        ));

        Game game = new Game( x, o);
        game.run();

        assertEquals(Optional.of(Mark.X), game.getBoard().winner());
    }

    @Test
    public void xWinsFirstDiagonal() {

        ScriptedPlayer x = new ScriptedPlayer(Mark.X, Arrays.asList(
                new Move (0,0, Mark.X),
                new Move (1,1, Mark.X),
                new Move (2,2, Mark.X)
        ));

        ScriptedPlayer o = new ScriptedPlayer(Mark.O, Arrays.asList(
                new Move(1,2, Mark.O),
                new Move(1,0, Mark.O)
        ));

        Game game = new Game( x, o);
        game.run();

        assertEquals(Optional.of(Mark.X), game.getBoard().winner());
    }

    @Test
    public void xWinsSecondDiagonal() {

        ScriptedPlayer x = new ScriptedPlayer(Mark.X, Arrays.asList(
                new Move (0,2, Mark.X),
                new Move (1,1, Mark.X),
                new Move (2,0, Mark.X)
        ));

        ScriptedPlayer o = new ScriptedPlayer(Mark.O, Arrays.asList(
                new Move(1,2, Mark.O),
                new Move(1,0, Mark.O)
        ));

        Game game = new Game( x, o);
        game.run();

        assertEquals(Optional.of(Mark.X), game.getBoard().winner());
    }

    @Test
    public void oWinsGame() {

        ScriptedPlayer x = new ScriptedPlayer(Mark.X, Arrays.asList(
                new Move (0,0, Mark.X),
                new Move (2,0, Mark.X),
                new Move (2,1, Mark.X)
        ));

        ScriptedPlayer o = new ScriptedPlayer(Mark.O, Arrays.asList(
                new Move(1,0, Mark.O),
                new Move(1,1, Mark.O),
                new Move(1,2, Mark.O)
        ));

        Game game = new Game( x, o);
        game.run();

        assertEquals(Optional.of(Mark.O), game.getBoard().winner());
    }

    @Test
    public void gameEndsInDraw() {
        ScriptedPlayer x = new ScriptedPlayer(Mark.X, Arrays.asList(
                new Move(0,0, Mark.X),
                new Move(0,1, Mark.X),
                new Move(1,1, Mark.X),
                new Move(2,0, Mark.X),
                new Move(1,2, Mark.X)
        ));

        ScriptedPlayer o = new ScriptedPlayer(Mark.O, Arrays.asList(
                new Move(0,2, Mark.O),
                new Move(1,0, Mark.O),
                new Move(2,2, Mark.O),
                new Move(2,1, Mark.O)
        ));

        Game game = new Game(x, o);
        game.run();

        assertTrue(game.getBoard().isFull());
        assertEquals(Optional.empty(), game.getBoard().winner());
    }


}
