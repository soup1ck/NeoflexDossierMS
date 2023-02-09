package ru.neoflex.dossier.mapper;

import org.mapstruct.Mapper;
import ru.neoflex.dossier.data.dto.Client;
import ru.neoflex.dossier.data.dto.ClientDTO;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientDTO toClientDTO(Client client);
}
