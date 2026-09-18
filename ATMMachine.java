import java.util.Scanner;

public class ATMMachine {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int balance = 5000;
        int choice, amount;

        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();

        if (pin == 1234) {

            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Balance = ₹" + balance);
                    break;

                case 2:
                    System.out.print("Enter amount: ");
                    amount = sc.nextInt();

                    balance = balance + amount;

                    System.out.println("Money Deposited");
                    System.out.println("Balance = ₹" + balance);
                    break;

                case 3:
                    System.out.print("Enter amount: ");
                    amount = sc.nextInt();

                    if (amount <= balance) {
                        balance = balance - amount;
                        System.out.println("Money Withdrawn");
                        System.out.println("Balance = ₹" + balance);
                    } else {
                        System.out.println("Insufficient Balance");
                    }
                    break;

                case 4:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } else {
            System.out.println("Wrong PIN");
        }

        sc.close();
    }
}