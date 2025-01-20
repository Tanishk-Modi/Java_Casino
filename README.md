Java Console Casino
===================

Welcome to **Java Console Casino**, an interactive console-based casino game project written in Java! This project simulates a virtual casino where players can test their luck by playing classic games like **Slots**, **War**, **Blackjack** and **Roulette**. Each game is designed to provide a unique gambling experience while tracking your balance across sessions.

![image](https://github.com/user-attachments/assets/42e4f82e-35cf-4bac-964d-6ad1898e3ea0)

* * * * *

Table of Contents
-----------------

-   Overview

-   Games

-   Features

-   Programming Concepts Used

-   How to Run

-   Future Improvements

* * * * *

Overview
--------

The Java Console Casino is a text-based gambling application that allows players to engage in classic casino games. Starting with a configurable balance, players can bet their money on various games, each offering different challenges and payout schemes. The objective is to stay in the game as long as possible without going bankrupt.

* * * * *

Games
-----

### 1\. Slots

Spin the virtual slot machine and try your luck to match symbols for payouts. The game is simple, fast-paced, and perfect for risk-takers.

### 2\. War

A high-stakes card game where you draw a card and face off against the computer. The player with the higher card wins the bet.

### 3\. Roulette

Place your bets on single numbers, colors (Red/Black), or Odd/Even outcomes. Spin the wheel and see where the ball lands for potential winnings.

### 4\. Blackjack

The classic, popular casino game, where you face off with the dealer in the race for 21!

* * * * *

Features
--------

-   **Interactive Gameplay**: Engaging text-based interface for playing casino games.

-   **Balance Tracking**: A dynamic balance system that updates after each bet.

-   **Game Menu**: Choose your desired game or exit the casino at any time.

-   **Input Validation**: Ensures valid bets and prevents exceeding balance.

* * * * *

Programming Concepts Used
-------------------------

This project demonstrates the following Java programming skills:

### Core Concepts:

-   **Object-Oriented Programming (OOP)**:

    -   Use of **classes** and **interfaces** (e.g., `Game` interface, `Player`, `Roulette`, etc.).

    -   Encapsulation and abstraction for managing game logic.

-   **Inheritance and Polymorphism**:

    -   Implementation of different games inheriting from the `Game` interface.

### Java Essentials:

-   **Collections**: Use of data structures like `ArrayList` to handle deck management in card games.

-   **Randomization**: Leveraging `Random` for generating outcomes (e.g., card draws, slot spins, roulette wheel).

-   **Input Handling**: Using `Scanner` to manage user input and validation.

-   **Control Flow**: Extensive use of loops and conditionals to manage game states.

### Advanced Features:

-   **Custom Logic**: Designing payout systems and win conditions for each game.

-   **Error Handling**: Preventing invalid bets and ensuring smooth gameplay.

-   **Separation of Concerns**: Modular design with distinct classes for each game.

* * * * *

How to Run
----------

### Prerequisites:

-   Ensure you have **Java 8+** installed on your machine.

-   A terminal or IDE like **IntelliJ IDEA**, **Eclipse**, or **VS Code** for running the application.

### Steps:

1.  Clone this repository:

    ```
    git clone https://github.com/your-username/java-console-casino.git
    cd java-console-casino
    ```

2.  Compile the program:

    ```
    javac -d bin src/*.java
    ```

3.  Run the program:

    ```
    java -cp bin Main
    ```

4.  Follow the on-screen instructions to start playing!

* * * * *

Future Improvements
-------------------

Here are some ideas for expanding this project:

-   **Graphical User Interface (GUI)**: Transition from console-based gameplay to a graphical interface using JavaFX or Swing.

-   **Additional Games**: Include more casino games like Poker.

-   **Enhanced Visuals**: Add ASCII art or animations for a more immersive experience.

* * * * *

License
-------

This project is open-source and available under the MIT License. Feel free to contribute and share your improvements!

* * * * *

🎰 **Good luck and have fun at the Java Console Casino!**
