import java.util.*;

import static java.util.Collections.*;

public class Main {

    static Double n;
    private static String userString;
    private static int menuChoice;
    private static char choice;
    static List<Integer> validInt= Arrays.asList(1,2,3,4);
    private static boolean error;
    static ArrayList<Double> nums = new ArrayList<>();
    private static String word;

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please Enter a set of numbers: ");
        do {
            System.out.println("Enter number");

            do {
                error = false;
                try {
                    n = userInput.nextDouble();
                    nums.add(n);
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid number: ");
                    error=true;
                }
            } while (error);
            System.out.println("Please enter Y to continue, anything else to exit.");
            choice=userInput.next().toUpperCase().charAt(0);

        }while(choice == 'Y');

        System.out.println("What would you like to do with the set of numbers?");
        System.out.println("MENU");
        System.out.println("1. Sort Ascending");
        System.out.println("2. Sort Descending");
        System.out.println("3. Find Max Value");
        System.out.println("4. Find Minimum Value");

        do{
            error=false;
            try {
                menuChoice = userInput.nextInt();
                if(!validInt.contains(menuChoice)){
                    error=true;
                }

            } catch (InputMismatchException exception) {
                System.out.println("Please enter a choice 1-4!");
                error=true;
                userInput.next();

            }
            switch (menuChoice){
                case 1:
                    Collections.sort(nums);
                    System.out.println("Set of numbers in ascending order: ");
                    System.out.println(nums);
                    break;
                case 2:
                    System.out.println("Set of numbers in descending order: ");
                    Collections.sort(nums,Collections.reverseOrder());
                    System.out.println(nums);
                    break;
                case 3:
                    System.out.println("Maximum value is: "+ max(nums));
                    break;
                case 4:
                    System.out.println("Minimum value is: "+min(nums));
            }

        }while(error);
        userInput.next();


        do {
            System.out.println("Please enter a string: ");
            error = false;
            try {
                userString= userInput.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a string!");
                error=true;
            }
        } while (error);

        System.out.println("Enter word you would like to count: ");
        do {
            error = false;
            try {
                word=userInput.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a string!");
                error=true;
            }
        } while (error);
        System.out.println(userString.split(word,-1).length-1);
        }

    }

