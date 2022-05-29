package cross1usf.firstproject.config.userdetails;

import cross1usf.firstproject.model.security.User;
import cross1usf.firstproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("Getting User info via JPA");
        User user =userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Cound not find user"));
        return new MyUserDetails(user);
    }
}
