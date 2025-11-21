import java.util.Random;
import java.util.Scanner;
class Player {
    private String choice;

    public String getChoice(Scanner scan) {
        System.out.println("Enter your choice (Rock, Paper, Scissors): ");
        choice = scan.nextLine().toLowerCase();
        return choice;
    }
}

class Computer {
    private String[] choices = {"rock", "paper", "scissors"};
    private Random random = new Random();

    public String getChoice() {
        return choices[random.nextInt(3)];
    }
}

class RPSGame {
    private Player player;
    private Computer computer;

    public RPSGame() {
        player = new Player();
        computer = new Computer();
    }

    public void startGame() {
        Scanner scan = new Scanner(System.in);
        String playAgain = "yes";

        System.out.println("************************");
        System.out.println("Welcome to RPS Game");

        while (playAgain.equalsIgnoreCase("yes")) {

            String userChoice = player.getChoice(scan);

            if (!userChoice.equals("rock") && 
                !userChoice.equals("paper") && 
                !userChoice.equals("scissors")) {
                System.out.println("Invalid input! Please choose rock, paper, or scissors.");
                continue;
            }

            String computerChoice = computer.getChoice();
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

            System.out.println("Do you want to play again? (yes/no): ");
            playAgain = scan.nextLine().toLowerCase();
        }

        System.out.println("Thanks for playing!");
        scan.close();
    }
}

public class RPS {
    public static void main(String[] args) {
        RPSGame game = new RPSGame();
        game.startGame();
    }
}
