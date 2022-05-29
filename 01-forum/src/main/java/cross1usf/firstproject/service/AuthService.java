package cross1usf.firstproject.service;

import cross1usf.firstproject.config.userdetails.MyUserDetails;
import cross1usf.firstproject.config.jwt.JwtProvider;
import cross1usf.firstproject.dto.AuthenticationResponse;
import cross1usf.firstproject.dto.LoginRequest;
import cross1usf.firstproject.dto.RegisterRequest;
import cross1usf.firstproject.exceptions.TokenNotFoundException;
import cross1usf.firstproject.model.security.Role;
import cross1usf.firstproject.model.security.User;
import cross1usf.firstproject.model.security.VerificationToken;
import cross1usf.firstproject.repository.RoleRepository;
import cross1usf.firstproject.repository.TokenRepository;
import cross1usf.firstproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenRepository tokenRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;


    @Transactional
    public void register(RegisterRequest registerRequest){
        Set<Role> roles = new HashSet<>();
        Optional<Role> role = roleRepository.findByName("USER");
        roles.add(role.get());
        User user = User.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .username(registerRequest.getUsername())
                .email(registerRequest.getEmail())
                .roles(roles)
                .build();
        generateTokenForUser(user);
        userRepository.save(user);

    }
    public void generateTokenForUser(User user){
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);
        tokenRepository.save(verificationToken);

    }

    @Transactional
    public void verifyAccount(String token){
    VerificationToken findToken = tokenRepository.findByToken(token).orElseThrow(() -> new TokenNotFoundException("Token Not Found" + token));
    String username = findToken.getUser().getUsername();
    User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found with the token " + token));
    user.setEnabled(true);

    }

    @Transactional
    public AuthenticationResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()));
        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateAccessToken(myUserDetails.getUsername());
        return new AuthenticationResponse(token, myUserDetails.getUsername());
    }

    @Transactional
    public User getUser() {
        String authentication = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(authentication).orElseThrow(() -> new UsernameNotFoundException("User not found!"));
    }
}


