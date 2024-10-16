class Loan {
    private double loanAmount;
    private int loanDurationInYears;
    private static final double INTEREST_RATE = 0.05; // 5% yearly interest

    public Loan(double loanAmount, int loanDurationInYears) {
        this.loanAmount = loanAmount;
        this.loanDurationInYears = loanDurationInYears;
    }

    public double calculateEMI() {
        double monthlyInterestRate = INTEREST_RATE / 12;
        int totalMonths = loanDurationInYears * 12;
        return (loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, totalMonths)) /
               (Math.pow(1 + monthlyInterestRate, totalMonths) - 1);
    }

    public void applyForLoan(BankAccount account) {
        System.out.println("Loan applied: " + loanAmount);
        account.deposit(loanAmount); // Deposit loan to the account
        account.addTransaction("Loan Amount Credited: " + loanAmount);
    }
}