import java.util.Random;
import java.util.Scanner;
public class RPS {
    public static boolean isValid(String choice) {
        return choice.equals("rock") ||
               choice.equals("paper") ||
               choice.equals("scissors");
    }
    public static String getComputerChoice(String[] choices, Random random) {
        return choices[random.nextInt(3)];
    }
    public static String getResult(String user, String computer) {
        if (user.equals(computer)) {
            return "It's a Tie!";
        } else if (
            (user.equals("rock") && computer.equals("scissors")) ||
            (user.equals("paper") && computer.equals("rock")) ||
            (user.equals("scissors") && computer.equals("paper"))
        ) {
            return "You Win!";
        } else {
            return "You Lose!";
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        String[] choice = {"rock", "paper", "scissors"};
        String playAgain = "yes";

        System.out.println("");
        System.out.println("Welcome to RPS Game");

        while (playAgain.equalsIgnoreCase("yes")) {

            System.out.println("Enter your choice (rock, paper, scissors):");
            String userChoice = scan.nextLine().toLowerCase();

            if (!isValid(userChoice)) {
                System.out.println("Invalid input! Please choose rock, paper, or scissors.");
                continue;
            }

            String computerChoice = getComputerChoice(choice, random);
            System.out.println("Computer Choice: " + computerChoice);

            System.out.println(getResult(userChoice, computerChoice));

            System.out.println("Do you want to play again? (yes/no):");
            playAgain = scan.nextLine().toLowerCase();
        }

        System.out.println("Thanks for playing!");
    }
}
