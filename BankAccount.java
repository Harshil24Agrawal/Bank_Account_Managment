import java.util.Scanner;

class BankAccount {
    private String owner;
    private double balance;

    public BankAccount(String owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        }
    }

    public void showBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public String getOwner() {
        return owner;
    }
}

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter account owner name: ");
        String owner = sc.nextLine();

        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();

        BankAccount acc = new BankAccount(owner, balance);

        while (true) {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Show Balance\n0. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double dep = sc.nextDouble();
                    acc.deposit(dep);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double wd = sc.nextDouble();
                    acc.withdraw(wd);
                    break;
                case 3:
                    acc.showBalance();
                    break;
                case 0:
                    System.out.println("Thank you, " + acc.getOwner() + "!");
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
