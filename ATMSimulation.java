import java.util.Scanner;

public class ATMSimulation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double balance = 1000.0;        // Initial balance
        String pin = "1234";             // Default PIN
        String name = "Simiyon A";
        String lastTransaction = "No transaction yet";

        // PIN Authentication
        System.out.print("Enter PIN: ");
        String enteredPin = scanner.nextLine();

        if (!enteredPin.equals(pin)) {
            System.out.println("Invalid PIN. Access denied.");
            scanner.close();
            return;
        }

        System.out.println("\nWelcome to ATM Simulation, " + name);

        int choice;

        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Mini Statement");
            System.out.println("5. Change PIN");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Your current balance is: $" + balance);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();

                    if (withdrawAmount <= 0) {
                        System.out.println("Invalid amount.");
                    } else if (withdrawAmount > balance) {
                        System.out.println("Insufficient balance.");
                    } else if (withdrawAmount > 5000) {
                        System.out.println("Withdrawal limit exceeded (Max $5000).");
                    } else {
                        balance -= withdrawAmount;
                        lastTransaction = "Withdrawn: $" + withdrawAmount;
                        System.out.println("Withdrawal successful.");
                        System.out.println("Remaining balance: $" + balance);
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();

                    if (depositAmount <= 0) {
                        System.out.println("Invalid amount.");
                    } else {
                        balance += depositAmount;
                        lastTransaction = "Deposited: $" + depositAmount;
                        System.out.println("Deposit successful.");
                        System.out.println("Updated balance: $" + balance);
                    }
                    break;

                case 4:
                    System.out.println("\n--- Mini Statement ---");
                    System.out.println("Last Transaction: " + lastTransaction);
                    System.out.println("Available Balance: $" + balance);
                    break;

                case 5:
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter old PIN: ");
                    String oldPin = scanner.nextLine();

                    if (oldPin.equals(pin)) {
                        System.out.print("Enter new PIN: ");
                        pin = scanner.nextLine();
                        System.out.println("PIN changed successfully.");
                    } else {
                        System.out.println("Incorrect old PIN.");
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using ATM. Visit again!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 6);

        scanner.close();
    }
}
