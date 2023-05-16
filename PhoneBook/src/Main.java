//import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Scanner reader = new Scanner(System.in);// Create a Scanner object
        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.addContact(new Contact("John", "1234567"));
        myPhoneBook.addContact(new Contact("Jane", "7654321"));
        myPhoneBook.addContact(new Contact("Joe", "1122334"));
        myPhoneBook.addContact(new Contact("Dvir", "7766554"));
        myPhoneBook.addContact(new Contact("Yonatan", "1231231"));

        myPhoneBook.menuLoop();
        
    }
}
