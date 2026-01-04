import java.util.Scanner;

public class ATMSimulation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double balance = 1000.0; // Initial balance
        String correctPin = "1234";
        int pinAttempts = 3;

        // PIN Authentication with 3 attempts
        while (pinAttempts > 0) {
            System.out.print("Enter PIN: ");
            String pin = scanner.nextLine();

            if (pin.equals(correctPin)) {
                break;
            } else {
                pinAttempts--;
                System.out.println("Incorrect PIN. Attempts left: " + pinAttempts);
            }

            if (pinAttempts == 0) {
                System.out.println("Account locked. Try again later.");
                scanner.close();
                return;
            }
        }

        String name = "Simiyon A";
        System.out.println("\nWelcome to ATM Simulation, " + name);

        boolean exit = false;

        // Transaction history
        String[] history = new String[10];
        int historyIndex = 0;

        // Menu loop
        while (!exit) {

            System.out.println("\n------ ATM MENU ------");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Current Balance: $" + balance);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();

                    if (withdrawAmount <= 0) {
                        System.out.println("Invalid amount.");
                    } else if (withdrawAmount <= balance) {
                        balance -= withdrawAmount;
                        System.out.println("Withdrawal successful.");
                        history[historyIndex++] = "Withdrawn: $" + withdrawAmount;
                    } else {
                        System.out.println("Insufficient funds.");
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();

                    if (depositAmount <= 0) {
                        System.out.println("Invalid amount.");
                    } else {
                        balance += depositAmount;
                        System.out.println("Deposit successful.");
                        history[historyIndex++] = "Deposited: $" + depositAmount;
                    }
                    break;

                case 4:
                    System.out.println("\n--- Transaction History ---");
                    if (historyIndex == 0) {
                        System.out.println("No transactions yet.");
                    } else {
                        for (int i = 0; i < historyIndex; i++) {
                            System.out.println((i + 1) + ". " + history[i]);
                        }
                    }
                    break;

                case 5:
                    exit = true;
                    System.out.println("Thank you for using ATM. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}
