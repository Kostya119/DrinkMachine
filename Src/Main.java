import EnumHelper.DrinksMachine;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DrinksMaker drinksMaker = new DrinksMaker();
        Scanner scanner = new Scanner(System.in);

        boolean orderMore = true;

        while (orderMore) {
            System.out.println("Available drinks: ");
            for (DrinksMachine drink : DrinksMachine.values()) {
                System.out.println(drink);
            }

            System.out.println("Do you want to order drinks? (type 'no' to exit menu)");
            System.out.print("Enter your drink choice: ");

            String drinkChoice = scanner.nextLine().toUpperCase();

            if (drinkChoice.equals("NO")) {
                orderMore = false;
                continue;
            }

            try {
                DrinksMachine chosenDrink = DrinksMachine.valueOf(drinkChoice);
                drinksMaker.makeDrink(chosenDrink);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid drink choice. Please try again.");
                continue;
            }
        }

        int totalDrinksCount = drinksMaker.getTotalDrinksCount();
        double totalAmount = drinksMaker.getTotalAmount();

        System.out.println("Total drinks made: " + totalDrinksCount);
        System.out.println("Total amount to be paid: $" + totalAmount);

        scanner.close();
    }
}