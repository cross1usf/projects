package cross1usf.firstproject.controller;

import cross1usf.firstproject.dto.AuthenticationResponse;
import cross1usf.firstproject.dto.LoginRequest;
import cross1usf.firstproject.dto.RegisterRequest;
import cross1usf.firstproject.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping
public class AuthController {

    private final AuthService authService;

    @PostMapping("/registration/register")
    public ResponseEntity<String> registerRequest(@RequestBody RegisterRequest registerRequest){
            authService.register(registerRequest);
        return new ResponseEntity<>("User Registration Successful", HttpStatus.OK);

    }


    @GetMapping("/registration/verifyaccount/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable("token") String token) {
        authService.verifyAccount(token);
        return new ResponseEntity<>("Account Verified", HttpStatus.ACCEPTED);
    }

    @PostMapping("/api/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
       /* return new ResponseEntity<>("Logged in, Token Generated!", HttpStatus.ACCEPTED);*/
    }
}
