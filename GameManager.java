import java.util.Scanner;

public class GameManager {
    Scanner myScanner = new Scanner(System.in);

    private void chooseGame() {
        int gameNumber;
        System.out.println("\nWelcome to Greg's game room");
        System.out.println("Choose a game:");
        System.out.println("1. Hangman");
        System.out.println("2. Tic Tac Toe");
        gameNumber = myScanner.nextInt();
        if (gameNumber == 1) {
            Hangman hangmanGame = new Hangman(Hangman.chooseDifficultyLevel());
            hangmanGame.playGame();
        }
        else if (gameNumber == 2) {
            TicTacToe theGame = new TicTacToe();
            theGame.playTicTacToe();
        }
        else {
            System.out.println("That is not a valid game, try again");
            chooseGame();
        }
    }

    public static void main (String[] args) {
        GameManager myGames = new GameManager();
        myGames.chooseGame();
    }
}

// TODO: MAKE A GAME MANAGER CLASS THAT ALLOWS
// YOU TO CHOOSE BETWEEN TICTACTOE AND HANGMAN
