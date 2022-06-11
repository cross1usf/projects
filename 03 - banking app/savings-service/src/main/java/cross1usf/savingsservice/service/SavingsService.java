package cross1usf.savingsservice.service;

import cross1usf.savingsservice.model.Savings;
import cross1usf.savingsservice.repository.SavingsRepository;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SavingsService {

    private final SavingsRepository savingsRepository;


    public SavingsService(SavingsRepository savingsRepository) {
        this.savingsRepository = savingsRepository;

    }

    public void newAccount(Integer id) {
        Integer r = new Random().nextInt(999999);
        Savings savings = new Savings(
                r,
                0,
                id
        );
        savingsRepository.save(savings);
    }
}
