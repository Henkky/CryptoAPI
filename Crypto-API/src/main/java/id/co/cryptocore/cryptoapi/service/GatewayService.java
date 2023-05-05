package id.co.cryptocore.cryptoapi.service;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import id.co.cryptocore.cryptoapi.config.UrlProps;
import id.co.cryptocore.cryptoapi.model.DTO.WalletBalanceDTO;
import id.co.cryptocore.cryptoapi.utils.ApiResponse;
import id.co.cryptocore.cryptoapi.utils.WebClientHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GatewayService {
    @Autowired
    UrlProps urlProps;

    public JsonObject callDeductBalance(WalletBalanceDTO requestBody){
        String url = urlProps.getBalanceDeductUrl();
        String data = WebClientHelper.callPutApi(url, requestBody);

        Gson gson = new Gson();
        return gson.fromJson(data, JsonObject.class);
    }
}
