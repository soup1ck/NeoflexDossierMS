package ru.neoflex.dossier.service.strategy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ru.neoflex.dossier.data.dto.EmailMessageDTO;
import ru.neoflex.dossier.data.enums.Theme;

@Slf4j
@Service
@RequiredArgsConstructor
public class FinishRegistrationStrategy implements EmailSendStrategy {

    private final JavaMailSender javaMailSender;

    @Override
    public void sendMail(EmailMessageDTO emailMessageDTO) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("${mail.username}");
            mailMessage.setTo(emailMessageDTO.getAddress());
            mailMessage.setSubject(emailMessageDTO.getTheme().toString());
            mailMessage.setText("Здравствуйте, " + emailMessageDTO.getAddress() + " ваша заявка предварительно " +
                    "одобрена, отправьте остальные данные для подсчета кредита");
            javaMailSender.send(mailMessage);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    @Override
    public Theme getTheme() {

        return Theme.FINISH_REGISTRATION;
    }
}
