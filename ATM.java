import java.util.Scanner;

class Bank_Account {
    private double balance;

    public Bank_Account(double initial_Balance) {
        balance = initial_Balance;
    }

    public double get_Balance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance!!!!!!!");
        }
    }
}

public class ATM {
    private Bank_Account user_Account;

    public ATM(Bank_Account account) {
        user_Account = account;
    }

    public void perform_Transaction() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            System.out.print("Enter your choice (1-4): ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    check_Balance();
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: $");
                    double deposit_Amount = sc.nextDouble();
                    deposit(deposit_Amount);
                    break;
                case 3:
                    System.out.print("Enter the amount to withdraw: $");
                    double withdraw_Amount = sc.nextDouble();
                    withdraw(withdraw_Amount);
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void check_Balance() {
        System.out.println("Current Balance: $" + user_Account.get_Balance());
    }

    public void deposit(double amount) {
        user_Account.deposit(amount);
    }

    public void withdraw(double amount) {
        user_Account.withdraw(amount);
    }

    public static void main(String[] args) {
        Bank_Account account = new Bank_Account(1000.0);
        ATM atm = new ATM(account);
        atm.perform_Transaction();
    }
}
