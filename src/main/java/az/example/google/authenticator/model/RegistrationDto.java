package az.example.google.authenticator.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean using2FA;
}
