package org.example.indianoil;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TruckService truckService = new TruckService();

        while (true) {
            System.out.println("1. Log Truck Arrival");
            System.out.println("2. Record Unloading");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter license plate: ");
                    String licensePlate = scanner.next();
                    System.out.print("Enter driver name: ");
                    String driverName = scanner.next();
                    System.out.print("Enter product type: ");
                    String productType = scanner.next();
                    truckService.logTruckArrival(licensePlate, driverName, productType);
                    break;
                case 2:
                    System.out.print("Enter truck ID: ");
                    int truckId = scanner.nextInt();
                    System.out.print("Enter quantity: ");
                    double quantity = scanner.nextDouble();
                    truckService.recordUnloading(truckId, quantity);
                    break;
                case 3:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

