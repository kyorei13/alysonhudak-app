package edu.alysonhudak.advancedjava.model.database;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Models the Person table
 *
 * @author Alyson Hudak
 */
@Entity
@Table(name="person")
public class Person implements DatabaseAccessObject{

    private int id;
    private String firstName;
    private String lastName;
    private Timestamp birthDate;

    /**
     * Primary Key - Unique ID for a particular row in the person table.
     *
     * @return an integer value
     */
    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    /**
     * Set the unique ID for a particular row in the person table.
     * This method should not be called by client code. The value is managed in internally.
     *
     * @param id a unique value.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return the person's first name
     */
    @Basic
    @Column(name = "first_name", nullable = false, insertable = true, updatable = true, length = 256)
    public String getFirstName() {
        return firstName;
    }

    /**
     * Specify the person's first name
     * @param firstName a String value
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return the person's last name
     */
    @Basic
    @Column(name = "last_name", nullable = false, insertable = true, updatable = true, length = 256)
    public String getLastName() {
        return lastName;
    }

    /**
     * Specify the person's last name
     * @param lastName a String value
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return the person's birthdate.
     */
    @Basic
    @Column(name = "birth_date", nullable = false, insertable = true, updatable = true)
    public Timestamp getBirthDate() {
        return birthDate;
    }

    /**
     * Specify the person's date of birth.
     * @param birthDate  the time the person was born.
     */
    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * This method compares two objects to ensure they are equal
     */
    @Override
    public boolean equals(Object o) {
        //if the object is equal to itself, return true
        if (this == o) return true;

        //check if o is null or is not an instance of this class
        // if so, return false
        if (o == null || getClass() != o.getClass()) return false;

        //cast o to be of type person
        Person person = (Person) o;

        //compare each attribute and return true or false result
        if (id != person.id) return false;
        if (birthDate != null ? !birthDate.equals(person.birthDate) : person.birthDate != null)
            return false;
        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null)
            return false;
        if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null)
            return false;

        return true;
    }

    /**
     * This method constructs and returns a hashcode value for the person object
     * @return a hashcode value for the person object
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        return result;
    }

    /**
     * This method overrides the toString method to display the attributes of the
     * person object as a String
     * @return String containing attributes of person object
     */
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}