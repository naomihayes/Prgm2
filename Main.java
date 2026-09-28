import java.util.Scanner;
//NAME: Naomi Hayes
//PROGRAM: Program 2 - 201R
//DATE: 9.27.26

class Main {

    public static void main(String[] args) {
        //define variables
        char choice = 'n';
        //scanner is defined for you
        Scanner scanner = new Scanner(System.in);
 
        //get the value of choice from displayMenu(scanner)
        choice = displayMenu(scanner);
        
        //as long as user wants to continue
        while (choice != 'c') {
            switch (choice) {
                //case a: convert from binary to decimal
                case 'a':
                    if (binToDec(scanner) == -1)
                        System.out.println("Invalid binary number.");
                    break;

                //case b: convert from decimal to binary
                case 'b':
                    if (decToBin(scanner) == -1)
                        System.out.println("Invalid decimal number.");
                    break;

                //case c: exit program
                case 'c':
                    System.out.println("Exiting program.");
                    break;


                default:
                    System.out.println("Invalid choice.");
            }
            // add another call to displayMenu
            choice = displayMenu(scanner);
        }

        scanner.close();
    }

    //PRE: accepts scanner object
    //POST: returns a valid value of a,b or c to main
    public static char displayMenu(Scanner scanner) {
        char choice = 'n';

        //while loop that repeats if the choice made is not a, b, or c
        while (choice != 'a' && choice != 'b' && choice != 'c'){
            //display menu choices
            System.out.println("a. Convert binary to decimal");
            System.out.println("b. Convert decimal to binary");
            System.out.println("c. Exit");

            //prompt user to enter choice
            System.out.print("Enter your choice (a, b, or c): ");

            //this code has been provided since scanner input is new...
            String input = scanner.nextLine().trim().toLowerCase();
            choice = input.charAt(0);
        }

        return choice;
    }

    //PRE: accepts scanner object
    //POST: prompts user to enter a binary number
    //      will calculate & print binary value entered & decimal equivalent
    public static int binToDec(Scanner scanner) {

        //define variables used
        int decimal = 0;
        int pow = 1;

        //prompt user to enter a binary number
        System.out.print("Enter a binary number: ");

        //use the following to get scanner input
        String binary = scanner.nextLine().trim();


        //for each 'i' character position in binary
        //  starting at binary.length -1 (going to 0)
        for (int i = binary.length() - 1; i >= 0; i--) {
            char c = binary.charAt(i);

            if (c== '1') {             //      if charAt is '1': decimal += pow
                                    //      else if charAt is not '0': return -1
                decimal += pow;
            } else if (c != '0') {
                return -1;
            }

            pow *= 2;     //      pow *= 2
        
        }

        //display Binary input and Decimal output
        System.out.println("Binary: " + binary);
        System.out.println("Decimal: " + decimal);

        return 1;
    }

    //PRE: accepts an input string
    //POST: returns true if the string has only 0-9, else false 
    public static boolean isDigits(String str) {
        //loop str
        //  use Character.isDigit function to check each character for valid numeric value
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static int decToBin(Scanner scanner) {
    
        //prompt user to enter a binary number
        System.out.print("Enter a decimal number: ");

        //get scanner input (similar to above)
        String input = scanner.nextLine().trim();

        // //check for digits
        if (!isDigits(input) || input.isEmpty()) {
            return -1;
        }

        //this line converts the input string to an integer
        int decimal = Integer.parseInt(input);

        //define other variables needed for conversion including output string for Binary value
        String binary = "";

        if (decimal == 0) {
            binary = "0";
        } else {
            while (decimal != 0) {
            //get remainder of modulus 2 & add to binary string
            int remainder = decimal % 2;
            binary = remainder + binary;

            //update decimal to cut off last digit
            decimal = decimal/ 2;
            }
        }

    System.out.println("Decimal: " + input);
    System.out.println("Binary: " + binary);
    return 1;
    }
}