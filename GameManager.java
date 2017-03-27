public class GameManager {
    public static void main (String[] args) {
    		Hangman hangmanGame = new Hangman(Hangman.chooseDifficultyLevel());

    		hangmanGame.playGame();
    }
}
