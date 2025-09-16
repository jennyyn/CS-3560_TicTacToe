# CS 3560 README Questions
## Where did encapsulation prevent bugs?
  In the Move and Board class, encapsulation keeps fields like row, col, mark, and board private which prevents external code from modifying these fields, potentially placing them out of bounds or overwriting other moves.

## Why inheritance here (vs. strategy/composition)?
 Inheritance works better for the tic tac toe game because RandomAIPlayer and HumanPlayer have an is-a relationship with the Player class. Composition could have been used if I wanted dynamic strategies mid-game but for a simple tic tac toe, inheritance works well.

## What would you refactor if the rules changed to 4‑in‑a‑row on a 5×5 board?
 I would have to increase the size of the board to 5x5 in the board class and modify my winner() method to check for more consecutive marks.
