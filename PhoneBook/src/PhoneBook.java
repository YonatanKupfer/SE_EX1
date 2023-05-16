import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class PhoneBook{

    private ArrayList<Contact> contactList;

    public PhoneBook(){
        this.contactList = new ArrayList<Contact>();
    }

    public void setContactList(ArrayList<Contact> contactList){
        this.contactList = contactList;
    }

    public ArrayList<Contact> getContactList(){
        return this.contactList;
    }

    

    public static void menu(){

        System.out.println("Welcome to the menu");
        System.out.println("What would you like to do?");
        System.out.println("1. Add a new contact");
        System.out.println("2. Delete a contact (by name)");
        System.out.println("3. Display all contacts");
        System.out.println("4. Search for a contact (by name)");
        System.out.println("5. Sort contacts by name");
        System.out.println("6. Sort contacts by phone number");
        System.out.println("7. Remove duplicates");
        System.out.println("8. Reverse the contact list");
        System.out.println("9. Save to file");
        System.out.println("10. Load from file");
        System.out.println("11. Exit");

    }
    //add a contact
    public void addContact(Contact contact) {
        this.contactList.add(contact);
    }
    //delete a contact
    public void deleteContact(String name) {
        Iterator<Contact> iter = this.contactList.iterator();
        while (iter.hasNext()) {
            Contact contact = iter.next();
            if (contact.getName().equals(name)) {
                iter.remove();
                return;
            }
        }
    }

    //display all contacts
    public void displayContacts() {
        Iterator<Contact> iter = this.contactList.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        System.out.println();
    }

    //search for a contact

    //sort contacts by name

    //sort contacts by phone number

    //remove duplicates

    //reverse the contact list

    //save to file

    //load from file


    public static void menuLoop(){
        Scanner reader = new Scanner(System.in);

        while(true){
            menu();
            int choice = reader.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter name");
                    String name = reader.nextLine();
                    System.out.println("Enter number");
                    String number = reader.nextLine();
                    Contact contact = new Contact(name, number);
                    addContact(contact));
                    break;
                case 2:
                    deleteContact();
                    break;
                case 3:
                    displayContacts();
                    break;
                case 4:
                    searchContact();
                    break;
                case 5:
                    sortByName();
                    break;
                case 6:
                    sortByNumber();
                    break;
                case 7:
                    removeDuplicates();
                    break;
                case 8:
                    reverseList();
                    break;
                case 9:
                    saveToFile();
                    break;
                case 10:
                    loadFromFile();
                    break;
                case 11:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}