import java.util.*;

import static java.util.Collections.*;

public class Main {
//declare variables

    //gfsaf

    static Double n;
    private static String userString;
    private static int menuChoice;
    static List<Integer> validInt= Arrays.asList(1,2,3,4);
    static ArrayList<Double> nums = new ArrayList<>();
    private static String word;

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        //prompt user to enter numbers
        System.out.println("Please Enter a set of numbers: ");
        char choice;
        boolean error;
        do {
            System.out.println("Enter number");
            error=false; //set error to false to initiate dowhile loop
            do {
                error = false;
                try {
                    n = userInput.nextDouble();
                    nums.add(n);
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid number: ");
                    error =true;
                    userInput.next();
                }
            } while (error);
            System.out.println("Please enter Y to continue, anything else to exit.");
            choice =userInput.next().toUpperCase().charAt(0);

        }while(choice == 'Y');

        System.out.println("What would you like to do with the set of numbers?");
        System.out.println("MENU");
        System.out.println("1. Sort Ascending");
        System.out.println("2. Sort Descending");
        System.out.println("3. Find Max Value");
        System.out.println("4. Find Minimum Value");

        do{
            error =false;
            try {
                menuChoice = userInput.nextInt();
                if(!validInt.contains(menuChoice)){
                    System.out.println("Please enter a valid choice!");
                    error =true;

                }

            } catch (InputMismatchException exception) {
                System.out.println("Please enter a choice 1-4!");
                error =true;
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
                    nums.sort(Collections.reverseOrder());
                    System.out.println(nums);
                    break;
                case 3:
                    System.out.println("Maximum value is: "+ max(nums));
                    break;
                case 4:
                    System.out.println("Minimum value is: "+min(nums));
            }

        }while(error);

        System.out.println("");

        System.out.println("Please enter a string: ");
        userInput.next();
        do {
            error = false;
            try {
                userString= userInput.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a string!");
                error =true;
            }
        } while (error);

        System.out.println("Enter word you would like to count: ");
        do {
            error = false;
            try {
                word=userInput.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a string!");
                error =true;
            }
        } while (error);
        System.out.print("Number of times word appears in the string: ");
        System.out.println(userString.split(word,-1).length-1);
        }

    }

