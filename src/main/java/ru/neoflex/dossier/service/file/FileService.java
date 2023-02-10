package ru.neoflex.dossier.service.file;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.neoflex.dossier.data.dto.*;
import ru.neoflex.dossier.mapper.ClientMapper;
import ru.neoflex.dossier.mapper.CreditMapper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class FileService {

    private final ObjectMapper objectMapper;
    private final CreditMapper creditMapper;
    private final ClientMapper clientMapper;

    /**
     * @param application - предложение полученное из deal
     * @return file - с информацией о кредите
     * @throws IOException - ошибки формирования файла
     */
    public File createCreditFile(Application application) throws IOException {
        File file = new File("credit_document.txt");
        Credit credit = application.getCredit();
        CreditDTO creditDTO = creditMapper.toCreditDTO(credit);
        String creditDTOAsString = objectMapper.writeValueAsString(creditDTO);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(creditDTOAsString);
        writer.close();
        return file;
    }

    /**
     * @param application - предложение полученное из deal
     * @return file - с информацией о клиенте
     * @throws IOException - ошибки формирования файла
     */
    public File createClientFile(Application application) throws IOException {
        File file = new File("client_document.txt");
        Client client = application.getClient();
        ClientDTO clientDTO = clientMapper.toClientDTO(client);
        String clientDTOAsString = objectMapper.writeValueAsString(clientDTO);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(clientDTOAsString);
        writer.close();
        return file;
    }
}
