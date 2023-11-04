import java.util.Scanner;
import java.util.Random;

public class NumberGame {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
Random random = new Random();
int minNumber = 30;
int maxNumber = 100;
int maxAttempts = 10;
int score = 0;
System.out.println("Welcome to the Guessing Number game!");
while (true) {
int targetNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;
int attempts = 0;
System.out.println("I'm thinking of a number between " + minNumber + " to " + maxNumber + ".");
while (attempts < maxAttempts) {
System.out.print("Enter your guessing number: ");
int userGuess = scanner.nextInt();
    attempts++;
if (userGuess < minNumber || userGuess > maxNumber) {
System.out.println("Please guess a number within the specified range.");
} else if (userGuess < targetNumber) {
System.out.println("Too low! Try again.");
} else if (userGuess > targetNumber) {
System.out.println("Too high! Try again.");
} else {
System.out.println("It's correct!!.");
System.out.println("Congratulations! You guessed the correct number " + targetNumber + " in " + attempts + " attempts.");
score++;
break;
}
if (attempts == maxAttempts) {
System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + targetNumber + "."); 
}
}
System.out.print("Do you want to play again? (yes/no): ");
String playAgain = scanner.next();
if (!playAgain.equalsIgnoreCase("yes")) {
break;
}
}
System.out.println("Your final score is " + score + " rounds won. Thanks for playing the game!");
scanner.close();
    }
}






