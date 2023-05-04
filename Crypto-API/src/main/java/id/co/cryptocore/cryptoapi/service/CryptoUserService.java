package id.co.cryptocore.cryptoapi.service;

import id.co.cryptocore.cryptoapi.model.CryptoUserDetail;
import id.co.cryptocore.cryptoapi.model.User;
import id.co.cryptocore.cryptoapi.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class CryptoUserService implements UserDetailsService {
    private final UserRepository userRepository;

    public CryptoUserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("No User Found !!");
        }
        return new CryptoUserDetail(user);
    }
}
