package edu.cpp.tictactoe;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
       Scanner input = new Scanner(System.in);
       Player human = new HumanPlayer("You", Mark.X, input);
       Player computer = new RandomAIPlayer("Computer", Mark.O);
       Game game = new Game (human, computer);
       game.run();

    }
}