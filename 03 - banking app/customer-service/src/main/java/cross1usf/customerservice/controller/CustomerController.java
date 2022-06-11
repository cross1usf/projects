package cross1usf.customerservice.controller;

import cross1usf.customerservice.dto.RegisterRequest;
import cross1usf.customerservice.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {


    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequest registerRequest) {
        customerService.register(registerRequest);
        return new ResponseEntity("Account Created, please verify with the link at your email.", HttpStatus.CREATED);
    }


}
