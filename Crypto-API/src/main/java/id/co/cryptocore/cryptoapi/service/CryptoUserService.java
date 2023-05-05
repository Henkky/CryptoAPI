package id.co.cryptocore.cryptoapi.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import id.co.cryptocore.cryptoapi.config.UrlProps;
import id.co.cryptocore.cryptoapi.model.CryptoUserDetail;
import id.co.cryptocore.cryptoapi.model.User;
import id.co.cryptocore.cryptoapi.utils.WebClientHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class CryptoUserService implements UserDetailsService {
    @Autowired
    private UrlProps urlProps;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String url = urlProps.getAccountSecurityUrl() + username;
        String data = WebClientHelper.callGetApi(url);
        System.out.println(data);

        Gson gson = new Gson();
        JsonObject root = gson.fromJson(data, JsonObject.class);
        JsonObject userData = root.getAsJsonObject("data");

        if(root.get("status").getAsString().equalsIgnoreCase("false")){
            throw new UsernameNotFoundException("No User Found !!");
        }

        User user = new User();
        user.setUsername(userData.get("userId").getAsString());
        String password = userData.get("password").getAsString();
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);
        System.out.println(encodedPassword);
        user.setRole(userData.get("role").getAsString());
        user.setEnabled(true);
        System.out.println(userData.get("role").getAsString());
        return new CryptoUserDetail(user);
    }
}
