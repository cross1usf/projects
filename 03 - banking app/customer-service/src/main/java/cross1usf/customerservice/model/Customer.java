package cross1usf.customerservice.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    private final String firstName;
    private final String lastName;
    private final Date dob;
    private Integer phone;

    //Will map in the database, not sure how to here
    private Integer savingsBalance;
    private Integer checkingBalance;


    public Customer(String username, String email, String firstName, String lastName, Date dob, Integer phone) {
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.phone = phone;

    }


}
