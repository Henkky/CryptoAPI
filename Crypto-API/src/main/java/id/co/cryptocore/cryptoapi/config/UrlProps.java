package id.co.cryptocore.cryptoapi.config;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class UrlProps {
    @Value("${internal.core.account.security.url}")
    String accountSecurityUrl;
}
