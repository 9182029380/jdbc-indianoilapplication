package org.example;

// Define a sealed interface for Bank
sealed interface Bank permits FixedDepositAccount1, Loan, SavingsAccount {
    // No implementation needed
}

// Define a sealed interface for SavingsAccount
sealed interface SavingsAccount extends Bank permits HighInterestSavingsAccount, LowInterestSavingsAccount {
    // No implementation needed
}

// Define a sealed interface for HighInterestSavingsAccount
sealed interface HighInterestSavingsAccount extends SavingsAccount permits HighInterestSavingsAccountForStudents {
    // No implementation needed
}

// Define a sealed interface for FixedDepositAccount
sealed interface FixedDepositAccount1 extends Bank permits FixedDepositAccount {
    void showDepositAccount();
    // No implementation needed
}

// Define a final class for HighInterestSavingsAccountForStudents
non-sealed class HighInterestSavingsAccountForStudents implements HighInterestSavingsAccount {
    private String accountNumber;
    private double balance;

    public HighInterestSavingsAccountForStudents(String accountNumber, double balance) {
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
final class LowInterestSavingsAccount implements SavingsAccount {
    private String accountNumber;
    private double balance;

    public LowInterestSavingsAccount(String accountNumber, double balance) {
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
final class FixedDepositAccount implements FixedDepositAccount1 {
    private String accountNumber;
    private double balance;
    private int tenure;

    public FixedDepositAccount(String accountNumber, double balance, int tenure) {
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

    @Override
    public void showDepositAccount() {
        System.out.println("This is a Fixed Deposit Account");
    }
}

// Example usage
public class Main {
    public static void main(String[] args) {
        // Create instances of permitted classes
        HighInterestSavingsAccountForStudents highInterestSavingsAccountForStudents = new HighInterestSavingsAccountForStudents("1234567890", 1000.0);
        LowInterestSavingsAccount lowInterestSavingsAccount = new LowInterestSavingsAccount("9876543210", 500.0);
        FixedDepositAccount fixedDepositAccount = new FixedDepositAccount("1111111111", 2000.0, 5);

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