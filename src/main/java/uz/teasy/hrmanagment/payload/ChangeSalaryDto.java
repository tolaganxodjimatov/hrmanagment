package uz.teasy.hrmanagment.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChangeSalaryDto {
    @NotNull
    private String email;

    @NotNull
    private Double salary;
}
