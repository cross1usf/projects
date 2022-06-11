package cross1usf.customerservice.model;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String street;
    private String city;
    private String state;
    private Integer zip;

    @OneToOne
    @JoinColumn(name = "customer", referencedColumnName = "id")
    private Customer customer;

    public Address(String street, String city, String state, Integer zip, Customer customer) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.customer = customer;
    }
}
