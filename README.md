# Task 1: Number Guessing Game

A console-based Java application built for **Task 1** of a Java Programming Internship. The game generates a random number within a set range and guides the user with feedback until they guess it or run out of attempts.

## Project Overview

The program runs an interactive command-line loop where players try to guess a secret integer between **1 and 100**.
It includes input validation, attempt limits, multi-round support, and score calculation so the game feels complete and reliable to test.

## Features

- **Random Number Generation:** Picks a random integer from `1` to `100` at the beginning of each round using `java.util.Random`.
- **Directional Feedback:** Compares each guess against the secret number and prints **Too high!**, **Too low!**, or **Correct!**
- **Attempt Limit:** Caps each round at **7 attempts** and shows how many tries remain after each wrong guess.
- **Input Validation:** Handles non-integer text and out-of-range numbers gracefully using `Scanner` checks instead of crashing.
- **Multiple Rounds:** Lets the player choose whether to start another round (`y`/`n`) once a round finishes.
- **Score & Session Summary:** Awards points based on remaining attempts and displays total rounds played, rounds won, and final score at the end.

## Code Structure

- `NumberGame.java`
  - `main(...)`: Controls the multi-round game loop, round state, scoring, and final session summary.
  - `readGuess(...)`: Prompts the user, validates integer input, and ensures the guess falls within `1`–`100`.
  - `askPlayAgain(...)`: Prompts the user to replay or exit after each round.

## Tech Stack & Tools

- **Language:** Java (JDK 25)
- **Standard Libraries:** `java.util.Random`, `java.util.Scanner`
- **Editor & Version Control:** Visual Studio Code, GitHub Desktop / GitHub

## How to Compile and Run

1. Open a terminal or command prompt inside the project folder containing `NumberGame.java`.
2. Compile the source file:
   ```bash
   javac NumberGame.java
   
3. Run the compiled program:
   ```bash
   java NumberGame

SAMPLE GAMEPLAY
```bash
=========================================
      WELCOME TO THE NUMBER GAME!        
=========================================
Guess a number between 1 and 100.
You have up to 7 attempts per round.

--- Round 1 Started ---
Attempt 1 - Enter your guess (1-100): 50
Too low!
Attempts remaining: 6
Attempt 2 - Enter your guess (1-100): 75
Too high!
Attempts remaining: 5
Attempt 3 - Enter your guess (1-100): 63
Correct! You guessed it in 3 attempts.
Round Score: +50 | Total Score: 50

Do you want to play another round? (y/n): n

=========================================
              FINAL SUMMARY              
=========================================
Rounds Played : 1
Rounds Won    : 1
Final Score   : 50
Thanks for playing!
