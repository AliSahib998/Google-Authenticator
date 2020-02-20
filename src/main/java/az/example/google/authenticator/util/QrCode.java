package az.example.google.authenticator.util;


import org.springframework.stereotype.Component;

@Component
public class QrCode {


    public String qrCodeGenerator(String token) {
        return "https://zxing.org/w/chart?cht=qr&chs=250x250&chld=M&choe=UTF-8&chl=otpauth://totp//2FaExample.com?secret="
                + token +
                "&issuer=/2FaExample";
    }
}
