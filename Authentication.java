public static boolean authenticate() {
    System.out.print("Enter username: ");
    String username = scanner.nextLine();
    System.out.print("Enter password: ");
    String password = scanner.nextLine();

    User user = new User("admin", "password123");
    return user.login(username, password);
}