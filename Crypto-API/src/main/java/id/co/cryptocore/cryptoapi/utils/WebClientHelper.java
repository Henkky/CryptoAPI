package id.co.cryptocore.cryptoapi.utils;

import org.springframework.http.MediaType;
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

    public static <T> String callPostApi(String url, T data){
        WebClient.Builder builder = WebClient.builder();
        String response = builder.build()
                .post()
                .uri(url)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(data)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return response;
    }

    public static <T> String callPutApi(String url, T data){
        WebClient.Builder builder = WebClient.builder();
        String response = builder.build()
                .put()
                .uri(url)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(data)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return response;
    }
}
