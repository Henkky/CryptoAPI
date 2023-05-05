package id.co.cryptocore.cryptoapi.controller;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import id.co.cryptocore.cryptoapi.model.DTO.WalletBalanceDTO;
import id.co.cryptocore.cryptoapi.service.GatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("crypto")
public class CryptoController {
    @Autowired
    GatewayService gatewayService;

    @GetMapping("/inquiry/{userid}")
    public JsonObject findAccountByUserId(@PathVariable("userid") String userId){
        return gatewayService.callGetAccountById(userId);
    }

    @PutMapping("/deduct")
    public JsonObject deductWalletBalance(@RequestBody WalletBalanceDTO requestBody){
        return gatewayService.callDeductBalance(requestBody);
    }

    @PutMapping("/add")
    public JsonObject addWalletBalance(@RequestBody WalletBalanceDTO requestBody){
        return gatewayService.callAddBalance(requestBody);
    }


}
