package uz.teasy.hrmanagment.payload;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
public class ManagerDTO {

@NonNull
    @Size(min = 3,max = 250)
    private String fullName;

    @NonNull
    @Email
    private String email;

    @NonNull
    private String password;
}


































