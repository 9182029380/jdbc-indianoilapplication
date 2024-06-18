package org.example;

// Define a sealed interface for Bank
// Define a sealed interface for Bank
sealed interface Bank1 permits SavingsAccount1, FixedDeposit1 {
    // No implementation needed
}

// Define a sealed interface for SavingsAccount
sealed interface SavingsAccount1 extends Bank1 permits HighInterestSavingsAccount1, LowInterestSavingsAccount1 {
    // No implementation needed
}

// Define a sealed interface for HighInterestSavingsAccount
sealed interface HighInterestSavingsAccount1 extends SavingsAccount1 permits HighInterestSavingsAccountForStudents1 {
    // No implementation needed
}

// Define a sealed interface for FixedDeposit
sealed interface FixedDeposit1 extends Bank1 {
    // No implementation needed
}

// Define a final class for HighInterestSavingsAccountForStudents
final class HighInterestSavingsAccountForStudents1 implements HighInterestSavingsAccount1 {
    private String accountNumber;
    private double balance;

    public HighInterestSavingsAccountForStudents1(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}

// Define a final class for LowInterestSavingsAccount
final class LowInterestSavingsAccount1 implements SavingsAccount1 {
    private String accountNumber;
    private double balance;

    public LowInterestSavingsAccount1(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}

// Define a final class for FixedDepositAccount
final class FixedDepositAccount11 implements FixedDeposit1 {
    private String accountNumber;
    private double balance;
    private int tenure;

    public FixedDepositAccount11(String accountNumber, double balance, int tenure) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.tenure = tenure;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public int getTenure() {
        return tenure;
    }
}

// Example usage
public class Main1 {
    public static void main(String[] args) {
        // Create instances of permitted classes
        HighInterestSavingsAccountForStudents1 highInterestSavingsAccountForStudents = new HighInterestSavingsAccountForStudents1("1234567890", 1000.0);
        LowInterestSavingsAccount1 lowInterestSavingsAccount = new LowInterestSavingsAccount1("9876543210", 500.0);
        FixedDepositAccount11 fixedDepositAccount = new FixedDepositAccount11("1111111111", 2000.0, 5);

        // Perform operations on the instances
        System.out.println("High Interest Savings Account for Students:");
        System.out.println("Account Number: " + highInterestSavingsAccountForStudents.getAccountNumber());
        System.out.println("Balance: " + highInterestSavingsAccountForStudents.getBalance());

        System.out.println("\nLow Interest Savings Account:");
        System.out.println("Account Number: " + lowInterestSavingsAccount.getAccountNumber());
        System.out.println("Balance: " + lowInterestSavingsAccount.getBalance());

        System.out.println("\nFixed Deposit Account:");
        System.out.println("Account Number: " + fixedDepositAccount.getAccountNumber());
        System.out.println("Balance: " + fixedDepositAccount.getBalance());
        System.out.println("Tenure: " + fixedDepositAccount.getTenure());
    }
}
