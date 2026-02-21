package HelloWorld;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class MinimumBalanceException extends Exception {
    public MinimumBalanceException(String message) {
        super(message);
    }
}

class InvalidCustomerIdException extends Exception {
    public InvalidCustomerIdException(String message) {
        super(message);
    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class Customer {
    private int customerId;
    private String customerName;
    private double amount;

    public Customer(int customerId, String customerName, double amount) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.amount = amount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }

    public void withdraw(double withdrawAmount) {
        amount -= withdrawAmount;
    }

    @Override
    public String toString() {
        return customerId + "," + customerName + "," + amount;
    }
}

public class ASSIGNMENT6 {
    private static final double MIN_OPENING_BALANCE = 1000.0;
    private static final String FILE_NAME = "ASSIGNMENT6/customers.txt";
    private Map<Integer, Customer> customers = new HashMap<>();

    public void createAccount(int customerId, String customerName, double amount)
            throws MinimumBalanceException, InvalidCustomerIdException, InvalidAmountException {
        validateCustomerId(customerId);
        validatePositiveAmount(amount);

        if (amount < MIN_OPENING_BALANCE) {
            throw new MinimumBalanceException("Account must be created with minimum Rs. 1000.");
        }

        customers.put(customerId, new Customer(customerId, customerName, amount));
        saveRecordsToFile();
        System.out.println("Account created successfully.");
    }

    public void withdrawAmount(int customerId, double withdrawAmount)
            throws InvalidCustomerIdException, InvalidAmountException, InsufficientFundsException {
        validateCustomerId(customerId);
        validatePositiveAmount(withdrawAmount);

        Customer customer = customers.get(customerId);
        if (customer == null) {
            throw new InvalidCustomerIdException("Customer ID not found.");
        }

        if (withdrawAmount > customer.getAmount()) {
            throw new InsufficientFundsException("Withdrawal amount cannot be greater than total amount.");
        }

        customer.withdraw(withdrawAmount);
        saveRecordsToFile();
        System.out.println("Withdrawal successful. Remaining balance: Rs. " + customer.getAmount());
    }

    private void validateCustomerId(int customerId) throws InvalidCustomerIdException {
        if (customerId < 1 || customerId > 20) {
            throw new InvalidCustomerIdException("Customer ID should be in range 1 to 20.");
        }
    }

    private void validatePositiveAmount(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Entered amount should be positive.");
        }
    }

    private void saveRecordsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Customer customer : customers.values()) {
                writer.write(customer.toString());
                writer.newLine();
            }
        } catch (IOException exception) {
            System.out.println("Error while saving records: " + exception.getMessage());
        }
    }

    private void displayAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customer records available.");
            return;
        }

        System.out.println("\nCustomer Records:");
        for (Customer customer : customers.values()) {
            System.out.println("CID: " + customer.getCustomerId()
                    + ", Name: " + customer.getCustomerName()
                    + ", Balance: Rs. " + customer.getAmount());
        }
    }

    public static void main(String[] args) {
        ASSIGNMENT6 bankingSystem = new ASSIGNMENT6();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n*** ASSIGNMENT 6: BANKING MENU ***");
            System.out.println("1. Create Account");
            System.out.println("2. Withdraw Amount");
            System.out.println("3. Display Customers");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Customer ID (1-20): ");
                        int customerId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Customer Name: ");
                        String customerName = scanner.nextLine();
                        System.out.print("Enter Opening Amount: ");
                        double openingAmount = scanner.nextDouble();

                        bankingSystem.createAccount(customerId, customerName, openingAmount);
                        break;

                    case 2:
                        System.out.print("Enter Customer ID (1-20): ");
                        int withdrawCustomerId = scanner.nextInt();
                        System.out.print("Enter Amount to Withdraw: ");
                        double withdrawAmount = scanner.nextDouble();

                        bankingSystem.withdrawAmount(withdrawCustomerId, withdrawAmount);
                        break;

                    case 3:
                        bankingSystem.displayAllCustomers();
                        break;

                    case 4:
                        System.out.println("Exiting banking system.");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (MinimumBalanceException
                    | InvalidCustomerIdException
                    | InvalidAmountException
                    | InsufficientFundsException exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        } while (choice != 4);

        scanner.close();
    }
}
