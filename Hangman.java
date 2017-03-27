import java.util.Random;
import java.util.Scanner;

public class Hangman {
	Random rng = new Random();
	Scanner myScanner = new Scanner(System.in);
	char guessedLetter;
	String randomWord;
	int numberOfMisses = 0;
    int numberOfMissesAllowed;
	char[] letterMisses;
	char[] theRandomWord;
    char[] notGuessedArray;
	int correctGuesses = 0;
	// add as many or few words as you want here
	String[] randomWords = {"verisimilitude", "whey", "sharpener", "refrigerator", "earbuds", "spectacles", "illumination"};

	public Hangman(String difficultyLevel) {
		numberOfMissesAllowed = determineDifficultyLevel(difficultyLevel);
		letterMisses = new char[numberOfMissesAllowed];
	}

    private int determineDifficultyLevel(String difficultyLevel) {
        while(true) {
            if (difficultyLevel.equals("easy")) {
    			return 8;
    		}
    		else if (difficultyLevel.equals("medium")) {
                return 6;
    		}
    		else if (difficultyLevel.equals("hard")) {
    			return 5;
    		}
            else {
                System.out.println("That is not a choice, try again");
                difficultyLevel = chooseDifficultyLevel();
            }
        }
    }

	private void chooseRandomWord() {
		int numberOfChoices = randomWords.length;
		int randomNumber = rng.nextInt(numberOfChoices);

		randomWord = randomWords[randomNumber];
		theRandomWord = new char[randomWord.length()];
	}

	private void askForALetter() {
		System.out.print("\nGuess: ");
		guessedLetter = myScanner.next().charAt(0);
	}

	private void searchForThatLetter() {
		boolean wasItFound = false;
		for (int i = 0; i < randomWord.length(); i++) {
			if (guessedLetter == randomWord.charAt(i)) {
				wasItFound = true;
				notGuessedArray[i] = guessedLetter;
				correctGuesses = correctGuesses + 1;
			}
		}
		if (!wasItFound) {
			numberOfMisses = numberOfMisses + 1;
			if (numberOfMisses >= numberOfMissesAllowed) {
				System.out.println("\nYou ran out of misses!");
				System.out.println("You lose!");
				tellUserTheWord();
				System.exit(0);
			}
			else {
				System.out.println("\nNot one of the letters");
				letterMisses[numberOfMisses - 1] = guessedLetter;
			}
		}
	}

	// make an array of chars with the letters of the randomWord string
	private void convertRandomWordToArray() {
		for (int i = 0; i < randomWord.length(); i++) {
			theRandomWord[i] = randomWord.charAt(i);
		}
	}

	private void initializeGuessesArray() {
		notGuessedArray = new char[randomWord.length()];
		for (int i = 0; i < randomWord.length(); i++) {
			notGuessedArray[i] = '_';
		}
	}

	private void tellUserTheWord() {
		System.out.println("The word was: " + randomWord);
	}

	// make an array of chars showing their correct guesses, otherwise
	// having an underscore in that spot
	private void correctGuessesArray() {
		for (int i = 0; i < notGuessedArray.length; i++) {
			System.out.print(notGuessedArray[i] + " ");
		}
	}

	private void printMisses() {
		System.out.print("Misses: ");
		for (int i = 0; i < numberOfMisses; i++) {
			System.out.print(letterMisses[i] + " ");
		}
		System.out.println("\n");
	}

	private boolean enoughCorrectGuesses() {
		if (correctGuesses == randomWord.length()) {
			return true;
		}
		return false;
	}

	public static String chooseDifficultyLevel() {
        Scanner myScanner = new Scanner(System.in);
        String difficultyLevel;
		System.out.println("Choose a difficulty level. Your choices are \"easy\", \"medium\", or \"hard\"");
		System.out.print("Difficulty: ");
		difficultyLevel = myScanner.nextLine();

		return difficultyLevel;
	}

	public void playGame() {
		chooseRandomWord();
		convertRandomWordToArray();

		System.out.println("\nYou are only allowed " + numberOfMissesAllowed + " missed letters. Guess carefully!");
		initializeGuessesArray();

		while (!enoughCorrectGuesses()) {
			correctGuessesArray();
			askForALetter();
			searchForThatLetter();
			printMisses();
		}
		tellUserTheWord();
		System.out.println("\nYou win!");

	}

	public static void main(String[] args) {
		Hangman hangmanGame = new Hangman(chooseDifficultyLevel());

		hangmanGame.playGame();
	}

}
