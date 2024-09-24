import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        int choice = 0, cardNumber;

        Circle circ;
        Rectangle rect;
        Square sq;
        CreditCardPayment credit;
        PaypalPayment paypal;
        WashingMachine wMachine;
        Refrigerator ref;

        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Enter class to test:");
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Square");
            System.out.println("4. Credit Card Payment");
            System.out.println("5. Paypal Payment");
            System.out.println("6. Washing Machine");
            System.out.println("7. Refrigerator");
            System.out.println("8. Exit");
            try {
                choice = scan.nextInt();
                scan.nextLine();

                switch (choice) {
                    case 1:
                        try {
                            System.out.print("Enter radius: ");
                            circ = new Circle(scan.nextDouble());
                            scan.nextLine();

                            System.out.println("Area: " + circ.area());
                        } catch (IllegalArgumentException e) {
                            System.out.println(e);
                        }
                        break;
                    case 2:
                        try {
                            System.out.println("Enter width and height:");
                            rect = new Rectangle(scan.nextDouble(), scan.nextDouble());

                            scan.nextLine();

                            System.out.println("Area: " + rect.calculateArea());
                            System.out.println("Perimeter: " + rect.calculatePerimeter());
                        } catch (IllegalArgumentException e) {
                            System.out.println(e);
                        }
                        break;
                    case 3: 
                        try {
                            System.out.print("Enter side: ");
                            sq = new Square(scan.nextDouble());
                            scan.nextLine();

                            System.out.println("Area: " + sq.area());
                        } catch (IllegalArgumentException e) {
                            System.out.println(e);
                        }
                        break;
                    case 4:
                        System.out.println("Enter credentials (card number, card holder name, expiration date, cvv)");

                        cardNumber = scan.nextInt();
                        scan.nextLine();

                        credit = new CreditCardPayment(cardNumber, scan.nextLine(), scan.nextLine(), scan.nextInt());
                        scan.nextLine();

                        credit.processPayment();
                        break;
                    case 5:
                        System.out.println("Enter email: ");
                        paypal = new PaypalPayment(scan.nextLine());

                        paypal.processPayment();
                        break;
                    case 6:
                        wMachine = new WashingMachine();

                        wMachine.turnOn();
                        wMachine.turnOff();

                        break;
                    case 7:
                        ref = new Refrigerator();

                        ref.turnOn();
                        ref.turnOff();

                        break;
                    case 8:
                        System.out.println("Thank you for using this program");
                        
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
                scan.nextLine();
            }
        } while (choice != 8);
    }
}
