package cross1usf.customerservice.service;

import cross1usf.customerservice.client.SavingsClient;
import cross1usf.customerservice.dto.RegisterRequest;
import cross1usf.customerservice.mappers.RegisterMapper;
import cross1usf.customerservice.model.Address;
import cross1usf.customerservice.model.Customer;
import cross1usf.customerservice.repository.AddressRepository;
import cross1usf.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RegisterMapper registerMapper;
    private final AddressRepository addressRepository;
    private final SavingsClient savingsClient;

    public CustomerService(CustomerRepository customerRepository, RegisterMapper registerMapper, AddressRepository addressRepository, SavingsClient savingsClient) {
        this.customerRepository = customerRepository;
        this.registerMapper = registerMapper;
        this.addressRepository = addressRepository;
        this.savingsClient = savingsClient;
    }


    public void register(RegisterRequest registerRequest) {
        Customer customer = registerMapper.mapCustomer(registerRequest);
        customerRepository.save(customer);
        /*Address address = registerMapper.mapAddress(registerRequest.getAddressDto());
        addressRepository.save(address);*/

    }







}
