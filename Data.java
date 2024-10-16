import java.io.*;

public static void saveAccountsToFile() {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("accounts.dat"))) {
        oos.writeObject(bankAccounts);
        System.out.println("Account data saved.");
    } catch (IOException e) {
        System.out.println("Error saving data: " + e.getMessage());
    }
}

public static void loadAccountsFromFile() {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("accounts.dat"))) {
        bankAccounts = (HashMap<Long, BankAccount>) ois.readObject();
        System.out.println("Account data loaded.");
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Error loading data: " + e.getMessage());
    }
}