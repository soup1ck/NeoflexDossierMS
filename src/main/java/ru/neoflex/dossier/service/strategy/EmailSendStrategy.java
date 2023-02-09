package ru.neoflex.dossier.service.strategy;

import org.springframework.stereotype.Service;
import ru.neoflex.dossier.data.dto.EmailMessageDTO;
import ru.neoflex.dossier.data.enums.Theme;

@Service
public interface EmailSendStrategy {

    void sendMail(EmailMessageDTO emailMessageDTO);

    Theme getTheme();
}
