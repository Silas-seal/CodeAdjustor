/*
 * Person Class!
 */
package control;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Seumx Plus
 */

public class Person {
    
     private StringProperty firstName;
     public void setFirstName(String value) { firstNameProperty().set(value); }
     
     public String getFirstName() { return firstNameProperty().get(); }
     
     public StringProperty firstNameProperty() {
         if (firstName == null) firstName = new SimpleStringProperty(this, "firstName");
         return firstName;
     }

     private StringProperty lastName;
     public void setLastName(String value) { lastNameProperty().set(value); }
     
     public String getLastName() { return lastNameProperty().get(); }
     
     public StringProperty lastNameProperty() {
         if (lastName == null) lastName = new SimpleStringProperty(this, "lastName");
         return lastName;
     }
     
     private StringProperty contact;
     public void setContact(String value) { contactProperty().set(value); }
     
     public String getContact() { return contactProperty().get(); }
     
     public StringProperty contactProperty() {
         if (contact == null) contact = new SimpleStringProperty(this, "contact");
         return contact;
     }
     
     private StringProperty address;
     public void setAddress(String value) { addressProperty().set(value); }
     
     public String getAddress() { return addressProperty().get(); }
     
     public StringProperty addressProperty() {
         if (address == null) address = new SimpleStringProperty(this, "address");
         return address;
     }
 }
