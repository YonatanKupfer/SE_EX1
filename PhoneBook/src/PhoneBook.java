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
    public void deleteContact() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter name");
        String name = reader.nextLine();
        reader.close();
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
    public void searchContact() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter name");
        String name = reader.nextLine();
        reader.close();
        boolean found = false;
        Iterator<Contact> iter = this.contactList.iterator();
        while (iter.hasNext()) {
            Contact contact = iter.next();
            if (contact.getName().equals(name)) {
                System.out.println(contact);
                found = true;
            }
        }
        if (!found){
            System.out.println("Contact not found");
        }
    }
    //sort contacts by name
    public void sortByName() {
        this.contactList.sort((a, b) -> a.getName().compareTo(b.getName()));
    }

    //sort contacts by phone number
    public void sortByNumber() {
        this.contactList.sort((a, b) -> a.getNumber().compareTo(b.getNumber()));
    }

    //remove duplicates
    public void removeDuplicates() {
        ArrayList<Contact> newList = new ArrayList<Contact>();
        Iterator<Contact> iter = this.contactList.iterator();
        while (iter.hasNext()) {
            Contact contact = iter.next();
            if (!newList.contains(contact)) {
                newList.add(contact);
            }
        }
        this.contactList = newList;
    }

    //reverse the contact list
    public void reverseList() {
        ArrayList<Contact> newList = new ArrayList<Contact>();
        Iterator<Contact> iter = this.contactList.iterator();
        while (iter.hasNext()) {
            Contact contact = iter.next();
            newList.add(0, contact);
        }
        this.contactList = newList;
    }
    //save to file
    public void saveToFile() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter file name");
        String fileName = reader.nextLine();
        reader.close();
        try{
            File file = new File(fileName + ".txt");
            file.createNewFile();
            try{
                FileWriter writer = new FileWriter(fileName + ".txt");
                Iterator<Contact> iter = this.contactList.iterator();
                while (iter.hasNext()) {
                    Contact contact = iter.next();
                    writer.write(contact.getName() + "-" + contact.getNumber() + "\n");
                }
                writer.close();
                System.out.println("Successfully wrote to the file");
            } catch(IOException e){
                System.out.println("An error occurred");
                e.printStackTrace();
            }

        } catch(IOException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }

    }


    
    //load from file
    public void loadFromFile(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter file name");
        String fileName = reader.nextLine();
        reader.close();
        try{
            File file = new File(fileName + ".txt");
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNextLine()){
                String data = fileReader.nextLine();
                String[] contactData = data.split("-");
                Contact contact = new Contact(contactData[0], contactData[1]);
                this.addContact(contact);
            }
            fileReader.close();
        } catch(FileNotFoundException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }

    }

    public void menuLoop(){
        boolean loop = true;
        
        Scanner reader = new Scanner(System.in);
        while(loop){
        	menu();
            int choice = reader.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter name");
                    String name = reader.nextLine();
                    System.out.println("Enter number");
                    String number = reader.nextLine();
                    Contact contact = new Contact(name, number);
                    this.addContact(contact);
                    break;
                case 2:
                    this.deleteContact();
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
                    System.out.println("Goodbye! exiting");
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        reader.close();
    }
}