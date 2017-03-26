import java.util.Random;
import java.util.Scanner;

public class Hangman {
	Random rng = new Random();
	Scanner myScanner = new Scanner(System.in);
	char guessedLetter;
	String randomWord;
	int numberOfMisses = 0;
	int numberOfMissesAllowed = 8;
	char[] letterMisses = new char[numberOfMissesAllowed];
	char[] theRandomWord;
	char[] notGuessedArray;

	public void chooseRandomWord() {
		String[] randomWords = {"helicoptor", "library", "incapacitate"};
		int numberOfChoices = randomWords.length;

		int randomNumber = rng.nextInt(numberOfChoices);
		randomWord = randomWords[randomNumber];
		theRandomWord = new char[randomWord.length()];
	}

	public void askForALetter() {
		System.out.print("Guess: ");
		guessedLetter = myScanner.next().charAt(0);
	}

	public void searchForThatLetter() {
		boolean wasItFound = false;
		for (int i = 0; i < randomWord.length(); i++) {
			if (guessedLetter == randomWord.charAt(i)) {
				wasItFound = true;
				System.out.println("The letter was found");
				notGuessedArray[i] = guessedLetter;
			}
		}
		if (wasItFound == false) {
			numberOfMisses = numberOfMisses + 1;
			if (numberOfMisses >= numberOfMissesAllowed) {
				System.out.println("\nYou lose, dumbass!");
			}
			else {
				System.out.println("Not one of the letters");
				letterMisses[numberOfMisses - 1] = guessedLetter;
			}
		}
	}
	// make an array of chars with the letters of the randomWord string
	public void randomWordToArray() {
		for (int i = 0; i < randomWord.length(); i++) {
			theRandomWord[i] = randomWord.charAt(i);
		}
	}
	// make an array of chars showing their correct guesses, otherwise
	// having an underscore in that spot
	public void initializeGuessesArray() {
		notGuessedArray = new char[randomWord.length()];
		for (int i = 0; i < randomWord.length(); i++) {
			notGuessedArray[i] = '_';
			//System.out.print(notGuessedArray[i] + " ");
		}
	}

	public void correctGuessesArray() {
		for (int i = 0; i < randomWord.length(); i++) {
			System.out.print(notGuessedArray[i] + " ");
			//System.out.print(notGuessedArray[i] + " ");
		}
	}

	public void printMisses() {
		System.out.print("Misses: ");
		for (int i = 0; i < numberOfMisses; i++) {
			System.out.print(letterMisses[i] + " ");
		}
		System.out.print("\n");
	}

	public void playGame() {
		chooseRandomWord();
		randomWordToArray();
		initializeGuessesArray();
		while (true) {
			askForALetter();
			searchForThatLetter();
			correctGuessesArray();
		}

	}

	public static void main(String[] args) {
		Hangman hangmanGame = new Hangman();

		hangmanGame.playGame();
	}

}

// REARRANGE PLAYGAME SO SHIT HAPPENS IN THE RIGHT ORDER
