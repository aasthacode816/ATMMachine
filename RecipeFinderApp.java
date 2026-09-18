import java.util.Scanner;

public class RecipeFinderApp{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== RECIPE FINDER =====");
        System.out.println("1. Pizza");
        System.out.println("2. Pasta");
        System.out.println("3. Biryani");
        System.out.println("4. Sandwich");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                System.out.println("\nRecipe: Pizza");
                System.out.println("Ingredients: Flour, Cheese, Tomato");
                System.out.println("Steps: Prepare dough, add toppings and bake.");
                break;

            case 2:
                System.out.println("\nRecipe: Pasta");
                System.out.println("Ingredients: Pasta, Tomato Sauce, Cheese");
                System.out.println("Steps: Boil pasta, add sauce and cook.");
                break;

            case 3:
                System.out.println("\nRecipe: Biryani");
                System.out.println("Ingredients: Rice, Chicken, Spices");
                System.out.println("Steps: Cook rice, prepare masala and mix.");
                break;

            case 4:
                System.out.println("\nRecipe: Sandwich");
                System.out.println("Ingredients: Bread, Vegetables, Cheese");
                System.out.println("Steps: Add ingredients between bread and toast.");
                break;

            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
}