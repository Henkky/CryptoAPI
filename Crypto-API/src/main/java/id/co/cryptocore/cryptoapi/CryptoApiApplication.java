package id.co.cryptocore.cryptoapi;

import id.co.cryptocore.cryptoapi.utils.WebClientHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CryptoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptoApiApplication.class, args);

//		String url = "http://localhost:8080/account/identify/albert";
//		String url = "https://catfact.ninja/fact?max_length=40"
//		String data = WebClientHelper.callGetApi(url);
//		System.out.println(data);
	}

}
