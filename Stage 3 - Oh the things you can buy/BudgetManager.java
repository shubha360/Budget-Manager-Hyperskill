package budget;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class BudgetManager {

    private double balance;

    private final Map<String, Double> foodPurchaseList;
    private double totalExpenseFood;

    private final Map<String, Double> clothPurchaseList;
    private double totalExpenseCloth;

    private final Map<String, Double> entertainmentPurchaseList;
    private double totalExpenseEntertainment;

    private final Map<String, Double> otherPurchaseList;
    private double totalExpenseOther;

    private final Map<String, Double> allPurchaseList;
    private double totalExpenseAll;

    private final Scanner scanner;

    public BudgetManager() {

        this.balance = 0.0;

        this.foodPurchaseList = new LinkedHashMap<>();
        this.clothPurchaseList = new LinkedHashMap<>();
        this.entertainmentPurchaseList = new LinkedHashMap<>();
        this.otherPurchaseList = new LinkedHashMap<>();
        allPurchaseList = new LinkedHashMap<>();

        this.totalExpenseFood = 0.0;
        this.totalExpenseCloth = 0.0;
        this.totalExpenseEntertainment = 0.0;
        this.totalExpenseOther = 0.0;
        this.totalExpenseAll = 0.0;

        this.scanner = new Scanner(System.in);
    }

    public void startProgram() {

        while (true) {

            System.out.println("Choose your action:\n" +
                    "1) Add income\n" +
                    "2) Add purchase\n" +
                    "3) Show list of purchases\n" +
                    "4) Balance\n" +
                    "0) Exit");

            int selection = scanner.nextInt();
            scanner.nextLine();

            switch (selection) {

                case 1:

                    addIncome();
                    break;

                case 2:

                    addPurchase();
                    break;

                case 3:

                    showList();
                    break;

                case 4:

                    showBalance();
                    break;

                case 0:

                    System.out.println();
                    System.out.println("Bye!");
                    return;
            }
        }
    }

    private void showBalance() {

        System.out.println();
        System.out.printf("Balance: $%.2f\n", balance);
        System.out.println();
    }

    private void addIncome() {

        System.out.println();
        System.out.println("Enter income:");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        balance += amount;
        System.out.println("Income was added!");
        System.out.println();
    }

    private void addPurchase() {

        String name;
        double price;

        while (true) {

            System.out.println();
            System.out.println("Choose the type of purchase\n" +
                    "1) Food\n" +
                    "2) Clothes\n" +
                    "3) Entertainment\n" +
                    "4) Other\n" +
                    "5) Back");

            int selection = scanner.nextInt();
            scanner.nextLine();

            switch (selection) {

                case 1:

                    System.out.println();

                    name = obtainName();
                    price = obtainPrice();

                    foodPurchaseList.put(name, price);
                    totalExpenseFood += price;

                    allPurchaseList.put(name, price);
                    totalExpenseAll += price;

                    System.out.println();
                    break;

                case 2:

                    System.out.println();

                    name = obtainName();
                    price = obtainPrice();

                    clothPurchaseList.put(name, price);
                    totalExpenseCloth += price;

                    allPurchaseList.put(name, price);
                    totalExpenseAll += price;

                    System.out.println();
                    break;

                case 3:

                    System.out.println();

                    name = obtainName();
                    price = obtainPrice();

                    entertainmentPurchaseList.put(name, price);
                    totalExpenseEntertainment += price;

                    allPurchaseList.put(name, price);
                    totalExpenseAll += price;

                    System.out.println();
                    break;

                case 4:

                    System.out.println();

                    name = obtainName();
                    price = obtainPrice();

                    otherPurchaseList.put(name, price);
                    totalExpenseOther += price;

                    allPurchaseList.put(name, price);
                    totalExpenseAll += price;

                    System.out.println();
                    break;

                case 5:
                    System.out.println();
                    return;
            }
        }
    }

    private String obtainName() {

        System.out.println("Enter purchase name:");
        return scanner.nextLine();
    }

    private double obtainPrice() {

        System.out.println("Enter its price:");
        double price = scanner.nextDouble();
        scanner.nextLine();
        return price;
    }

    private void showList() {

        if (allPurchaseList.isEmpty()) {

            System.out.println();
            System.out.println("The purchase list is empty.");
            System.out.println();
            return;
        }

        while (true) {

            System.out.println();
            System.out.println("Choose the type of purchases\n" +
                    "1) Food\n" +
                    "2) Clothes\n" +
                    "3) Entertainment\n" +
                    "4) Other\n" +
                    "5) All\n" +
                    "6) Back");

            int selection = scanner.nextInt();
            scanner.nextLine();

            switch (selection) {

                case 1:

                    System.out.println();
                    System.out.println("Food:");

                    if (foodPurchaseList.isEmpty()) {
                        System.out.println("The purchase list is empty!");
                    } else {
                        printList(foodPurchaseList);
                        System.out.printf("Total sum: $%.2f\n", totalExpenseFood);
                    }

                    System.out.println();
                    break;

                case 2:

                    System.out.println();
                    System.out.println("Cloth:");

                    if (clothPurchaseList.isEmpty()) {
                        System.out.println("The purchase list is empty!");
                    } else {
                        printList(clothPurchaseList);
                        System.out.printf("Total sum: $%.2f\n", totalExpenseCloth);
                    }

                    System.out.println();
                    break;

                case 3:

                    System.out.println();
                    System.out.println("Entertainment:");

                    if (entertainmentPurchaseList.isEmpty()) {
                        System.out.println("The purchase list is empty!");
                    } else {
                        printList(entertainmentPurchaseList);
                        System.out.printf("Total sum: $%.2f\n", totalExpenseEntertainment);
                    }

                    System.out.println();
                    break;

                case 4:

                    System.out.println();
                    System.out.println("Other:");

                    if (entertainmentPurchaseList.isEmpty()) {
                        System.out.println("The purchase list is empty!");
                    } else {
                        printList(otherPurchaseList);
                        System.out.printf("Total sum: $%.2f\n", totalExpenseOther);
                    }

                    System.out.println();
                    break;

                case 5:

                    System.out.println();
                    System.out.println("All:");
                    printList(allPurchaseList);
                    System.out.printf("Total sum: $%.2f\n", totalExpenseAll);
                    System.out.println();
                    break;

                case 6:
                    System.out.println();
                    return;
            }
        }
    }

    private void printList(Map<String, Double> list) {

        for (var entry : list.entrySet()) {
            System.out.printf("%s $%.2f\n", entry.getKey(), entry.getValue());
        }
    }
}
