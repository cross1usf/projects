package cross1usf.customerservice.mappers;

import cross1usf.customerservice.dto.AddressDto;
import cross1usf.customerservice.dto.RegisterRequest;
import cross1usf.customerservice.model.Address;
import cross1usf.customerservice.model.Customer;
import cross1usf.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class RegisterMapper {

    private CustomerRepository customerRepository;
    private RegisterRequest registerRequest;

    public RegisterMapper(CustomerRepository customerRepository, RegisterRequest registerRequest) {
        this.customerRepository = customerRepository;
        this.registerRequest = registerRequest;
    }

    public Customer mapCustomer(RegisterRequest registerRequest) {
        return new Customer(
                registerRequest.getUsername(),
                registerRequest.getEmail(),
                registerRequest.getFirstName(),
                registerRequest.getLastName(),
                registerRequest.getDob(),
                registerRequest.getPhone());
    }

    public Address mapAddress(AddressDto addressDto) {
        return new Address(
                addressDto.getStreet(),
                addressDto.getCity(),
                addressDto.getState(),
                addressDto.getZip(),
                customerRepository.findByUsername(registerRequest.getUsername())
        );
    }
}
