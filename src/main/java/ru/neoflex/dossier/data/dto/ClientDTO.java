package ru.neoflex.dossier.data.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.neoflex.dossier.data.jsonb.EmploymentJsonb;
import ru.neoflex.dossier.data.jsonb.PassportJsonb;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class ClientDTO {

    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDate birthDate;
    private String email;
    private String gender;
    private String maritalStatus;
    private Integer dependentAmount;
    private PassportJsonb passport;
    private EmploymentJsonb employment;
}
