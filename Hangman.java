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
	
	public void chooseRandomWord() {
		String[] randomWords = {"helicoptor", "library", "incapacitate"};
		int numberOfChoices = randomWords.length;
		
		int randomNumber = rng.nextInt(numberOfChoices);
		randomWord = randomWords[randomNumber];
		
	}
	
	public void askForALetter() {
		guessedLetter = myScanner.next().charAt(0);
	}
	
	public void searchForThatLetter() {
		boolean wasItFound = false;
		for (int i = 0; i < randomWord.length(); i++) {
			if (guessedLetter == randomWord.charAt(i)) {
				wasItFound = true;
				System.out.println("The letter was found");
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
	
	public void playGame() {
		chooseRandomWord();
		System.out.println(randomWord);
		
		System.out.print("Word: ");
		System.out.println("\n");
		System.out.print("Misses: "); 
		for (int i = 0; i < numberOfMisses; i++) {
			System.out.print(letterMisses[i] + " ");
		}
		System.out.println("\n");
		System.out.print("Guess: ");
		askForALetter();
		searchForThatLetter();
		System.out.print("Misses: "); 
		for (int i = 0; i < numberOfMisses; i++) {
			System.out.print(letterMisses[i] + " ");
		}
		
		
	}
	
	public static void main(String[] args) {
		Hangman hangmanGame = new Hangman();
		
		hangmanGame.playGame();
	}

}
// TODO: MAKE A PRINT MISSES METHOD TO REPLACE FOR LOOP IN PLAYGAME
// REARRANGE PLAYGAME SO SHIT HAPPENS IN THE RIGHT ORDER
