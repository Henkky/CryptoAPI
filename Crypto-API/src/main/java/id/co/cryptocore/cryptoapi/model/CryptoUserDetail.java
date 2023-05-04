package id.co.cryptocore.cryptoapi.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class CryptoUserDetail implements UserDetails {
    private final User cryptoUser;

    public CryptoUserDetail(User cryptoUser) {
        this.cryptoUser = cryptoUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(cryptoUser.getRole());
        return Arrays.asList(authority);
    }

    @Override
    public String getPassword() {
        return cryptoUser.getPassword();
    }

    @Override
    public String getUsername() {
        return cryptoUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return cryptoUser.isEnabled();
    }
}
