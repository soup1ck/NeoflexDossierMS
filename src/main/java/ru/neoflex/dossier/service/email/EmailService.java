package ru.neoflex.dossier.service.email;

import org.springframework.stereotype.Service;
import ru.neoflex.dossier.data.dto.EmailMessageDTO;

@Service
public interface EmailService {

    void sendMessage(EmailMessageDTO emailMessageDTO);
}
