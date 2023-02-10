package ru.neoflex.dossier.mapper;

import org.mapstruct.Mapper;
import ru.neoflex.dossier.data.dto.Credit;
import ru.neoflex.dossier.data.dto.CreditDTO;

@Mapper(componentModel = "spring")
public interface CreditMapper {

    CreditDTO toCreditDTO(Credit credit);
}
