public static void logTransaction(String message) {
    try (FileWriter fw = new FileWriter("transaction_log.txt", true)) {
        fw.write(message + "\n");
    } catch (IOException e) {
        System.out.println("Error logging transaction: " + e.getMessage());
    }
}