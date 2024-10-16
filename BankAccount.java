import java.util.*;

// Class for Bank Account
class BankAccount {
    private String accountHolderName;
    private long accountNumber;
    private double balance;
    private List<String> transactionHistory;

    public BankAccount(String accountHolderName, long accountNumber, double initialDeposit) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = initialDeposit;
        this.transactionHistory = new ArrayList<>();
        addTransaction("Initial Deposit: " + initialDeposit);
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        addTransaction("Deposit: " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            addTransaction("Withdraw: " + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void addTransaction(String transaction) {
        transactionHistory.add(transaction);
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void displayTransactionHistory() {
        System.out.println("Transaction history for account: " + accountNumber);
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

// Bank Management System
public class BankManagementSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<Long, BankAccount> bankAccounts = new HashMap<>();
    private static long accountNumberCounter = 1000;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n==== Bank Management System ====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Balance");
            System.out.println("5. View Transaction History");
            System.out.println("6. Delete Account");
            System.out.println("7. Search Account");
            System.out.println("8. Generate Reports");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (option) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    viewBalance();
                    break;
                case 5:
                    viewTransactionHistory();
                    break;
                case 6:
                    deleteAccount();
                    break;
                case 7:
                    searchAccount();
                    break;
                case 8:
                    generateReports();
                    break;
                case 9:
                    System.out.println("Exiting the system...");
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static void createAccount() {
        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter initial deposit: ");
        double initialDeposit = scanner.nextDouble();

        BankAccount newAccount = new BankAccount(name, accountNumberCounter++, initialDeposit);
        bankAccounts.put(newAccount.getAccountNumber(), newAccount);

        System.out.println("Account created successfully! Account Number: " + newAccount.getAccountNumber());
    }

    private static void deposit() {
        System.out.print("Enter account number: ");
        long accountNumber = scanner.nextLong();
        BankAccount account = bankAccounts.get(accountNumber);

        if (account != null) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
            System.out.println("Deposit successful. New Balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void withdraw() {
        System.out.print("Enter account number: ");
        long accountNumber = scanner.nextLong();
        BankAccount account = bankAccounts.get(accountNumber);

        if (account != null) {
            System.out.print("Enter withdraw amount: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
            System.out.println("Withdraw successful. New Balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void viewBalance() {
        System.out.print("Enter account number: ");
        long accountNumber = scanner.nextLong();
        BankAccount account = bankAccounts.get(accountNumber);

        if (account != null) {
            System.out.println("Current Balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void viewTransactionHistory() {
        System.out.print("Enter account number: ");
        long accountNumber = scanner.nextLong();
        BankAccount account = bankAccounts.get(accountNumber);

        if (account != null) {
            account.displayTransactionHistory();
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void deleteAccount() {
        System.out.print("Enter account number: ");
        long accountNumber = scanner.nextLong();

        if (bankAccounts.remove(accountNumber) != null) {
            System.out.println("Account deleted successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void searchAccount() {
        System.out.print("Enter account number: ");
        long accountNumber = scanner.nextLong();
        BankAccount account = bankAccounts.get(accountNumber);

        if (account != null) {
            System.out.println("Account found! Name: " + account.getAccountHolderName() + ", Balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void generateReports() {
        double totalDeposits = 0, totalWithdrawals = 0;

        System.out.println("\n==== Bank Report ====");
        for (BankAccount account : bankAccounts.values()) {
            List<String> transactions = account.getTransactionHistory();
            for (String transaction : transactions) {
                if (transaction.startsWith("Deposit")) {
                    totalDeposits += Double.parseDouble(transaction.split(": ")[1]);
                } else if (transaction.startsWith("Withdraw")) {
                    totalWithdrawals += Double.parseDouble(transaction.split(": ")[1]);
                }
            }
        }
        System.out.println("Total Deposits: " + totalDeposits);
        System.out.println("Total Withdrawals: " + totalWithdrawals);
    }
}