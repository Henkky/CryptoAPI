package id.co.cryptocore.cryptoapi.model.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WalletBalanceDTO {
    private String userId;
    private String currency;
    private String balance;
}
