abstract class BankAccount {
    protected String accountHolderName;
    protected long accountNumber;
    protected double balance;
    protected List<String> transactionHistory;

    public BankAccount(String accountHolderName, long accountNumber, double initialDeposit) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = initialDeposit;
        this.transactionHistory = new ArrayList<>();
        addTransaction("Initial Deposit: " + initialDeposit);
    }

    public abstract void addInterest(); // Abstract method for adding interest

    public void deposit(double amount) { balance += amount; addTransaction("Deposit: " + amount); }
    public void withdraw(double amount) {
        if (amount <= balance) { balance -= amount; addTransaction("Withdraw: " + amount); } 
        else { System.out.println("Insufficient balance!"); }
    }

    public void addTransaction(String transaction) { transactionHistory.add(transaction); }
    public List<String> getTransactionHistory() { return transactionHistory; }
    public void displayTransactionHistory() { for (String transaction : transactionHistory) { System.out.println(transaction); } }
}

class CheckingAccount extends BankAccount {
    public CheckingAccount(String accountHolderName, long accountNumber, double initialDeposit) {
        super(accountHolderName, accountNumber, initialDeposit);
    }

    @Override
    public void addInterest() { /* Checking accounts do not accrue interest */ }
}

class SavingsAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.03;

    public SavingsAccount(String accountHolderName, long accountNumber, double initialDeposit) {
        super(accountHolderName, accountNumber, initialDeposit);
    }

    @Override
    public void addInterest() {
        balance += balance * INTEREST_RATE;
        addTransaction("Interest added: " + (balance * INTEREST_RATE));
    }
}

class BusinessAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.01;

    public BusinessAccount(String accountHolderName, long accountNumber, double initialDeposit) {
        super(accountHolderName, accountNumber, initialDeposit);
    }

    @Override
    public void addInterest() {
        balance += balance * INTEREST_RATE;
        addTransaction("Business Interest added: " + (balance * INTEREST_RATE));
    }
}