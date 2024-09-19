import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int choice, cardNumber;

        Circle circ;
        Rectangle rect;
        Square sq;
        CreditCardPayment credit;
        PaypalPayment paypal;
        WashingMachine wMachine;
        Refrigerator ref;

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter class to test:");
        System.out.println("1. Circle");
        System.out.println("2. Rectangle");
        System.out.println("3. Square");
        System.out.println("4. Credit Card Payment");
        System.out.println("5. Paypal Payment");
        System.out.println("6. Washing Machine");
        System.out.println("7. Refrigerator");
        System.out.println("8. Exit");
        
        do {
            

            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter radius: ");
                    circ = new Circle(scan.nextDouble());
                    scan.nextLine();

                    System.out.println("Area: " + circ.area());
                    break;
                case 2:
                    System.out.println("Enter width and height:");
                    rect = new Rectangle(scan.nextDouble(), scan.nextDouble());

                    scan.nextLine();

                    System.out.println("Area: " + rect.calculateArea());
                    System.out.println("Perimeter: " + rect.calculatePerimeter());
                    break;
                case 3: 
                    System.out.print("Enter side: ");
                    sq = new Square(scan.nextDouble());
                    scan.nextLine();

                    System.out.println("Area: " + sq.area());
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
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 8);
    }
}
