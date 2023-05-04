package id.co.cryptocore.cryptoapi.utils;

import org.springframework.web.reactive.function.client.WebClient;

public class WebClientHelper{

    public static String callGetApi(String url){
        WebClient.Builder builder = WebClient.builder();

        String response = builder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return response;
    }
}
