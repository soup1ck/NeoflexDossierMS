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

    /**
     * @param emailMessageDTO - сообщение полученное из deal
     * Метод на основе полученного сообщения, с помощью фабрики EmailSendStrategyFactory,
     * по полученной теме выбирает стратегию отправки сообшения, после чего по выбранной стратегии сообщение
     * отправляется на почту
     */
    @Override
    public void sendMessage(EmailMessageDTO emailMessageDTO) {
        EmailSendStrategy emailSendStrategy = emailSendStrategyFactory
                .findStrategy(emailMessageDTO.getTheme());
        emailSendStrategy.sendMail(emailMessageDTO);
    }
}
