package id.co.cryptocore.cryptoapi.controller;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import id.co.cryptocore.cryptoapi.model.DTO.WalletBalanceDTO;
import id.co.cryptocore.cryptoapi.service.GatewayService;
import id.co.cryptocore.cryptoapi.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("crypto")
public class CryptoController {
    @Autowired
    GatewayService gatewayService;

    @GetMapping("/getaccounts")
    public String helloWorld(){
        return "Hello world";
    }

    @GetMapping("/hello")
    public String helloWorlda(){
        return "Hello world 1";
    }

    @PutMapping("/deduct")
    public JsonObject deductWalletBalance(@RequestBody WalletBalanceDTO requestBody){
        return gatewayService.callDeductBalance(requestBody);
    }


}
