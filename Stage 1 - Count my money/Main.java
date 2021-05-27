package budget;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> dataStorage = new ArrayList<>();
        double total = 0.0;

        while (scanner.hasNext()) {

            String nextLine = scanner.nextLine();
            double expense = Double.parseDouble(nextLine.substring(nextLine.lastIndexOf('$') + 1));
            total += expense;
            dataStorage.add(nextLine);
        }

        dataStorage.forEach(System.out::println);
        System.out.println("\nTotal: $" + total);
    }
}
