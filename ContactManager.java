import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String toString() {
        return "Name: " + name + ", Phone: " + phone + ", Email: " + email;
    }
}

public class ContactManager {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Contact> contactList = new ArrayList<>();

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n==== Contact Management System ====");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear newline

            switch (choice) {
                case 1 -> addContact();
                case 2 -> viewContacts();
                case 3 -> updateContact();
                case 4 -> deleteContact();
                case 5 -> {
                    System.out.println("Exiting... Goodbye!");
                    exit = true;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    // Add new contact
    static void addContact() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        contactList.add(new Contact(name, phone, email));
        System.out.println("Contact added successfully!");
    }

    // View all contacts
    static void viewContacts() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        System.out.println("\n-- Contact List --");
        for (int i = 0; i < contactList.size(); i++) {
            System.out.println((i + 1) + ". " + contactList.get(i));
        }
    }

    // Update contact
    static void updateContact() {
        viewContacts();

        if (contactList.isEmpty()) return;

        System.out.print("Enter contact number to update: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Clear newline

        if (index < 1 || index > contactList.size()) {
            System.out.println("Invalid contact number.");
            return;
        }

        Contact contact = contactList.get(index - 1);

        System.out.print("Enter new name (leave blank to keep current): ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) contact.name = newName;

        System.out.print("Enter new phone (leave blank to keep current): ");
        String newPhone = scanner.nextLine();
        if (!newPhone.isEmpty()) contact.phone = newPhone;

        System.out.print("Enter new email (leave blank to keep current): ");
        String newEmail = scanner.nextLine();
        if (!newEmail.isEmpty()) contact.email = newEmail;

        System.out.println("Contact updated successfully!");
    }

    // Delete contact
    static void deleteContact() {
        viewContacts();

        if (contactList.isEmpty()) return;

        System.out.print("Enter contact number to delete: ");
        int index = scanner.nextInt();

        if (index < 1 || index > contactList.size()) {
            System.out.println("Invalid contact number.");
            return;
        }

        contactList.remove(index - 1);
        System.out.println("Contact deleted successfully!");
    }
}
