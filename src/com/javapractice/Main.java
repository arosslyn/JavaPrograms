package com.javapractice;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("682-203-7830");

    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printActions();
        while(!quit){
            System.out.println("\nEnter Action: (select 6 to show a list of all actions. ");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action){
                case 0:
                    System.out.println("\n shutting down...");
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }

        }
    }
    private static void addNewContact(){
        System.out.println("Enter new Contacts name: ");
        String name = scanner.nextLine();
        System.out.println("Enter new Contacts phone: ");
        String phoneNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(name, phoneNumber);
        if(mobilePhone.addNewContact(newContact)){
            System.out.println("New contact added name = " + name + ", phone = " + phoneNumber);
        }else
            System.out.println("Cannot add, name is already on file");
    }
    private static void updateContact(){
        System.out.println("Enter an existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if(existingContact == null){
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Enter a new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter a new phone number");
        String newPhoneNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newPhoneNumber);
        if(mobilePhone.updateContact(existingContact, newContact)){
            System.out.println("successfully updated record");
        }else{
            System.out.println("Error updating record.");
        }
    }
    private static void removeContact(){
        System.out.println("Enter an existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if(existingContact == null){
            System.out.println("Contact not found");
            return;
        }
        if (mobilePhone.removeContact(existingContact)){
            System.out.println("Contact has been removed.");
        }else{
            System.out.println("Error deleting Contact");
        }
    }
    private static void queryContact(){
        System.out.println("Enter an existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if(existingContact == null){
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Name: " + existingContact.getName() + " phone number: " + existingContact.getPhoneNumber
                ());
        if (mobilePhone.removeContact(existingContact)){
            System.out.println("Contact has been removed.");
        }else{
            System.out.println("Error deleting Contact");
        }
    }

    private static void startPhone(){
        System.out.println("Starting phone...");
    }
    private static void printActions(){
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0 - To shutdown\n" +
                           "1 - To print Contacts\n" +
                           "2 - To add a new Contact\n" +
                           "3 - To update an existing Contact\n" +
                           "4 - To remove an existing Contact\n" +
                           "5 - To Query if an existing contact exists\n" +
                           "6 - To print a list of available actions.\n");
        System.out.println("Choose your action: ");
    }
}
