import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char choice;
        String input;

        File contactsFile = new File("contacts.txt");
        try {
            if (!contactsFile.exists()) {
                contactsFile.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Contacts contactList = new Contacts();
        FileHandler fileHandler = new FileHandler(contactsFile, contactList, 'r');
        Scanner scan = new Scanner(System.in);

        fileHandler.start();

        System.out.println("Contact Management Sytem");
        do {
            System.out.println("1. Add Contact\n2. View Contacts\n3. Update Contact\n4. Delete Contact\n5. Exit");
            System.out.print("Enter your choice: ");
            choice = scan.nextLine().charAt(0);

            switch (choice) {
                case '1':
                    fileHandler.setMode('a');
                    System.out.print("Enter contact name: ");
                    contactList.addContact(scan.nextLine());
                    fileHandler.start();

                    break;
                case '2':
                    contactList.readContacts();

                    break;
                case '3':
                    if (!contactList.isEmpty()){
                        fileHandler.setMode('w');
                        System.out.print("Enter the name of the contact to update: ");
                        input = scan.nextLine();
                        System.out.print("Enter the new name: ");

                        try {
                            contactList.updateContact(input, scan.nextLine());
                            fileHandler.start();
                        } catch (ContactNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Contacts is empty!");
                    }
                    break;
                case '4':
                    if (!contactList.isEmpty()){
                        fileHandler.setMode('w');
                        System.out.print("Enter the name of the contact to delete: ");

                        try {
                            contactList.deleteContact(scan.nextLine());

                            fileHandler.start();
                        } catch (ContactNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Contacts is empty!");
                    }
                    break;
                case '5':
                    System.out.println("Thank you for using this program!");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter again");
                    break;
            }
        } while (choice != '5');
    }
}
