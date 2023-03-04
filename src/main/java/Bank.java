import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class Bank {
    private static Scanner scanner = new Scanner(System.in);
    static User user1 = new User(UUID.randomUUID(), null, null, Genders.OTHER, null, 0.00);

    public static boolean signUp() {

        System.out.println("Enter you first name:");
        String name = scanner.nextLine();
        user1.setName(name);

        System.out.println("Enter you last name:");
        String lastName = scanner.nextLine();
        user1.setLastName(lastName);

        chooseGender();

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
        user1.setAccountNumber(accountNum);
        return false;

    }

    private static void chooseGender() {
        System.out.println("Choose your gender:");
        System.out.println("1. Male");
        System.out.println("2. Female");
        System.out.println("3. Other/Do not want to disclose");
        System.out.println("Select an option:");
        int option = scanner.nextInt();
        switch (option) {
            case 1 -> {
                user1.setGender(Genders.FEMALE);
            }
            case 2 -> {
                user1.setGender(Genders.MALE);
            }
            case 3 -> {
                user1.setGender(Genders.OTHER);
            }
            default -> {
                System.out.println("Invalid option. Try again.");
                chooseGender();
            }
        }
    }
        public static void debitBalance () {
            System.out.println("Deposit amount: ");
            double debit = scanner.nextDouble();
            double newBalance = Bank.user1.getBalance() + debit;
            user1.setBalance(newBalance);
        }
        public static void creditBalance () {
            System.out.println("Withdrawal amount: ");
            double credit = scanner.nextDouble();
            double newBalanceTwo = Bank.user1.getBalance() - credit;
            user1.setBalance(newBalanceTwo);
        }
        public static void showBalance () {
            System.out.println(user1.getBalance());
        }

    }


