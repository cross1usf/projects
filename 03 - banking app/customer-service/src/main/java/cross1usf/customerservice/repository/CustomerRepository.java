package cross1usf.customerservice.repository;

import cross1usf.customerservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findByUsername(String username);

}
