package cross1usf.savingsservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Savings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private final Integer accountNumber;
    private Integer balance;
    protected Integer userId;

    public Savings(Integer accountNumber, Integer balance, Integer userId) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.userId = userId;
    }


}
