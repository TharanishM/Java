import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        String[] choice = {"rock", "paper", "scissors"};
        String playAgain = "yes";

        System.out.println("");
        System.out.println("Welcome to RPS Game");

        while (playAgain.equalsIgnoreCase("yes")) {

            try {
                System.out.println("Enter your choice (Rock, Paper, Scissors):");

                String userChoice = scan.nextLine().toLowerCase();

                if (!userChoice.equals("rock") &&
                    !userChoice.equals("paper") &&
                    !userChoice.equals("scissors")) {

                    throw new IllegalArgumentException("Invalid choice!");
                }

                String computerChoice = choice[random.nextInt(3)];
                System.out.println("Computer Choice: " + computerChoice);

                if (userChoice.equals(computerChoice)) {
                    System.out.println("It's a Tie!");
                } else if (
                    (userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                    (userChoice.equals("paper") && computerChoice.equals("rock")) ||
                    (userChoice.equals("scissors") && computerChoice.equals("paper"))
                ) {
                    System.out.println("You Win!");
                } else {
                    System.out.println("You Lose!");
                }

                System.out.println("Do you want to play again? (yes/no):");
                playAgain = scan.nextLine().toLowerCase();

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please enter rock, paper, or scissors only.\n");
            } catch (Exception e) {
                System.out.println("Unexpected error occurred: " + e.getMessage());
            }
        }

        System.out.println("Thanks for playing!");
    }
}
