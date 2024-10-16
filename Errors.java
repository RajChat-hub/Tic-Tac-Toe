public static double getValidatedAmount() {
    double amount = -1;
    while (amount <= 0) {
        try {
            System.out.print("Enter amount: ");
            amount = scanner.nextDouble();
            if (amount <= 0) {
                System.out.println("Amount must be greater than 0. Try again.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Clear the buffer
        }
    }
    return amount;
}