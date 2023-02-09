package ru.neoflex.dossier.service.email;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.neoflex.dossier.data.dto.EmailMessageDTO;
import ru.neoflex.dossier.service.strategy.EmailSendStrategy;
import ru.neoflex.dossier.service.strategy.EmailSendStrategyFactory;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final EmailSendStrategyFactory emailSendStrategyFactory;

    @Override
    public void sendMessage(EmailMessageDTO emailMessageDTO) {
        EmailSendStrategy emailSendStrategy = emailSendStrategyFactory
                .findStrategy(emailMessageDTO.getTheme());
        emailSendStrategy.sendMail(emailMessageDTO);
    }
}
