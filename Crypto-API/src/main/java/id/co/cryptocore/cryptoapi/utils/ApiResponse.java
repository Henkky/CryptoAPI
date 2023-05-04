package id.co.cryptocore.cryptoapi.utils;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T> {
    private boolean status;
    private String message;
    private T data;
}
