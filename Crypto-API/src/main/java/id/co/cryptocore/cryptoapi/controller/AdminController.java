package id.co.cryptocore.cryptoapi.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import id.co.cryptocore.cryptoapi.config.UrlProps;
import id.co.cryptocore.cryptoapi.service.GatewayService;
import id.co.cryptocore.cryptoapi.utils.WebClientHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    GatewayService gatewayService;

    @GetMapping("/allaccounts")
    public JsonObject findAllAccounts(){
        return gatewayService.callGetAllAccounts();
    }
}
