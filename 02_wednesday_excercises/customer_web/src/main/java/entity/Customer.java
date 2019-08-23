package entity;

import java.util.Date;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;

/**
 *
 * @author ibenk
 */
public class Customer {

    private String firstName;
    private String lastName;

    @Temporal(DATE)
    private java.util.Date created;

    public Customer() { }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.created = new Date(); //the date of today
    }

}
