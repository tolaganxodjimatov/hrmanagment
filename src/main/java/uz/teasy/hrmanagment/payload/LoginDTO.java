package uz.teasy.hrmanagment.payload;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Email;

@Data
public class LoginDTO {
    @NonNull
    @Email
    private String email;
    @NonNull
    private String password;
}
