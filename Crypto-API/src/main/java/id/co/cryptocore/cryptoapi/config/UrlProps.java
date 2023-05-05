package id.co.cryptocore.cryptoapi.config;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class UrlProps {
    @Value("${internal.core.account.security.url}")
    String accountSecurityUrl;

    @Value("${internal.core.account.get.url}")
    String accountGetUrl;

    @Value("${internal.core.account.getall.url}")
    String accountGetAllUrl;

    @Value("${internal.core.balance.deduct.url}")
    String balanceDeductUrl;

    @Value("${internal.core.balance.add.url}")
    String balanceAddUrl;

    @Value("${internal.core.transaction.purchase.url}")
    String transPurchaseUrl;
}
