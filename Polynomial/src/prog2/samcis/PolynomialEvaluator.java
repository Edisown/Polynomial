/**
 * Name: Edison M. Malasan
 * Date: 12/05/2024
 */
package prog2.samcis;

import java.util.*;


public class PolynomialEvaluator  {
    public static void main(String[] args) {
        PolynomialEvaluator myProgram;
        try{
            myProgram = new PolynomialEvaluator();
            myProgram.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("This simple application will help you evaluate a polynomial in x.\n"+
                "You will be asked to enter the terms of the polynomial in x.\n" +
                "Then, you will be asked to enter the value of x for which the value of the polynomial will be computed\n" +
                "The following is an example of a polynomial in: " +
                "x^5+4x^3+5x^2-3x+1\n" +
                "The value of the polynomial if x is 2 is: 79.0\n");


        System.out.println("Press enter to continue...");
        scanner.nextLine();

        System.out.println("\nYou must now enter a polynomial in x to be evaluated.");
        Polynomial polynomial = new Polynomial();

        System.out.print("What is the degree of the polynomial? : ");
        int degree = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                degree = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer value for the degree.");
                scanner.next(); 
            }
        }

        for (int i = degree; i >= 0; i--) {
            System.out.print("What is the numerical coefficient of the term with x ^ " + i + ": ");
            int numericalCoefficient = 0;
            validInput = false;
            while (!validInput) {
                try {
                    numericalCoefficient = scanner.nextInt();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter an integer value for the numerical coefficient.");
                    scanner.next();
                }
            }
            polynomial.add(new Term(numericalCoefficient, 'x', i));
        }

        System.out.println("The polynomial in x that you have entered is:");
        System.out.println(polynomial);
        System.out.println("Press enter to continue...");
        scanner.nextLine();
        scanner.nextLine();

        System.out.print("What value of x would you like the polynomial to assume? : ");
        int x = 0;
        validInput = false;
        while (!validInput) {
            try {
                x = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer value for x.");
                scanner.next();
            }
        }

        int result = (int) polynomial.evaluator();
        System.out.println("The value of the polynomial " + polynomial + " if x is " + x + " is : " + result);

        scanner.close();
    }

}
