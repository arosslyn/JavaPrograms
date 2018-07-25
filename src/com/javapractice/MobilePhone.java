package com.javapractice;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact>myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }
    public boolean addNewContact(Contact contact){
        if(findContact(contact.getName()) >= 0){
            System.out.println("Contact is already on file.");
            return false;
        }
        myContacts.add(contact);
        return true;
    }
    public boolean  updateContact(Contact oldContact, Contact newContact){
        int foundPosition = findContact(oldContact);
        if(foundPosition < 0){
            System.out.println(oldContact.getName() + " ,was not found");
            return false;
        }else if (findContact(newContact.getName()) != -1){
            System.out.println("contact with name" + newContact.getName() +
                               "already exists. Update was not successful."
            );
            return false;
        }
        this.myContacts.set(foundPosition, newContact);
        System.out.println(newContact.getName() + " ,has replaced " + oldContact);
        return true;
    }
    public boolean removeContact(Contact contact){
        int foundPosition = findContact(contact);
        if(foundPosition < 0){
            System.out.println(contact.getName() + " ,was not found");
            return false;
        }
        this.myContacts.remove(foundPosition);
        System.out.println(contact.getName() + " was removed.");
        return true;
    }
    private int findContact(Contact contact){
        return this.myContacts.indexOf(contact);
        // returns an integer showing us where the position of the contact is in the arrayList
    }
    private int findContact(String contactName){
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if(contact.getName().equals(contactName)){
                return i;
            }
        }
        return -1;
        // if contact index is present, greater than 1 return contact position otherwise return one.
    }
    public String queryContact(Contact contact){
        if(findContact(contact) < 0){
            return contact.getName();
        }
        return null;
    }
    public Contact queryContact (String name){
        int position = findContact(name);
        if(position >= 0){
            return this.myContacts.get(position);
            // we are checking to see name exists in a position in the array list and if it does then we return that
            // name otherwise we return null.
        }
        return null;

    }
    public void printContacts(){
        System.out.println("Contact List: ");
        for (int i = 0; i < this.myContacts.size() ; i++) {
            System.out.println(this.myContacts.get(i).getName() + " -> " +
                                this.myContacts.get(i).getPhoneNumber());
        }
    }

}
