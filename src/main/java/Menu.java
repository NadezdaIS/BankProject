import java.util.Scanner;

public class Menu {
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose one option: ");
        System.out.println("1. Sign up");
        System.out.println("2. Deposit");
        System.out.println("3. Withdrawal");
        System.out.println("4. View balance");
        System.out.println("5. Log off");
        System.out.println("Your option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                Bank.signUp();
                System.out.println("Your profile is complete, please choose your next action: ");
                menu();

            case 2:
                Bank.debitBalance();
                System.out.println("Your deposit is saved, please choose your next action: ");
                menu();

            case 3:
                Bank.creditBalance();
                System.out.println("Your withdrawal is processed, please choose your next action: ");
                menu();

            case 4:
                Bank.showBalance();
                System.out.println("Please choose your next action: ");
                menu();
            case 5:

                break;
            default:
                System.out.println("Invalid option. Try again.");
                menu();
        }
    }
}
