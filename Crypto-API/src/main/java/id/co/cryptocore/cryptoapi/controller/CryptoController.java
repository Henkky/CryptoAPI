package id.co.cryptocore.cryptoapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("crypto")
public class CryptoController {
    @GetMapping("/getaccounts")
    public String helloWorld(){
        return "Hello world";
    }

    @GetMapping("/hello")
    public String helloWorlda(){
        return "Hello world 1";
    }
}
