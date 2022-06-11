package cross1usf.savingsservice.controller;

import cross1usf.savingsservice.service.SavingsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/savings")
public class SavingsController {

    private final SavingsService savingsService;

    public SavingsController(SavingsService savingsService) {
        this.savingsService = savingsService;
    }

    @GetMapping("/newaccount")
    public ResponseEntity newAccount(Integer id) {
        savingsService.newAccount(id);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
