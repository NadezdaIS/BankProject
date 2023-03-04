import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class Bank {
    private static Scanner scanner = new Scanner(System.in);
    static ArrayList<User> users = new ArrayList<User>();

    public static void signUp() {

        System.out.println("Enter you first name:");
        String name = scanner.nextLine();

        System.out.println("Enter you last name:");
        String lastName = scanner.nextLine();

        System.out.println("Choose your gender:");
        System.out.println("1. Male");
        System.out.println("2. Female");
        System.out.println("3. Other/Do not want to disclose");
        System.out.println("Select an option:");
        int option = scanner.nextInt();
        char gender = 0;
        switch (option) {
            case 1 -> {
                gender = 'm';
            }
            case 2 -> {
                gender = 'f';
            }
            case 3 -> {
                gender = 'o';
            }
            default -> {
                System.out.println("Invalid option. Try again.");
                signUp();
            }
        }

        BigInteger maxLimit = new BigInteger("9000000000000");
        BigInteger minLimit = new BigInteger("1000000000000");
        BigInteger bigInteger = maxLimit.subtract(minLimit);
        Random randomNum = new Random();
        int length = maxLimit.bitLength();
        BigInteger accountNum = new BigInteger(length, randomNum);
        if (accountNum.compareTo(minLimit) < 0)
            accountNum = accountNum.add(minLimit);
        if (accountNum.compareTo(bigInteger) >= 0)
            accountNum = accountNum.mod(bigInteger).add(minLimit);

        User user = new User(UUID.randomUUID(), name, lastName, gender, accountNum, 0.00);
        users.add(user);
    }


        public static void debitBalance () {
            System.out.println("Deposit amount: ");
            double debit = scanner.nextDouble();
            double newBalance = User.getBalance() + debit;
            User.setBalance(newBalance);
        }
        public static void creditBalance () {
            System.out.println("Withdrawal amount: ");
            double credit = scanner.nextDouble();
            double newBalanceTwo = User.getBalance() - credit;
            User.setBalance(newBalanceTwo);
        }
        public static void showBalance () {
            System.out.println(User.getBalance());
        }

    }


