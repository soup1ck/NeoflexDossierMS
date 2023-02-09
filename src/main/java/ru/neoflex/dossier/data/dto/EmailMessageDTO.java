package ru.neoflex.dossier.data.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.neoflex.dossier.data.enums.Theme;

@Getter
@Setter
@ToString
public class EmailMessageDTO {

    private String address;
    private Theme theme;
    private Long applicationId;
}