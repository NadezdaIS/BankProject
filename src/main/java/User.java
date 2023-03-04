import java.math.BigInteger;
import java.util.UUID;
public class User {
    public final UUID id;
    private String name;
    private String lastName;

    private char gender;
    private BigInteger accountNumber;

    private static double balance;


    public User(UUID id, String name, String lastName, char gender, BigInteger accountNumber, double balance) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigInteger getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(BigInteger accountNumber) {
        this.accountNumber = accountNumber;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public static double getBalance() {
        return balance;
    }

    public static void setBalance(double balance) {
        User.balance = balance;
    }
}
