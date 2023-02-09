package ru.neoflex.dossier.service.strategy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ru.neoflex.dossier.data.dto.Application;
import ru.neoflex.dossier.data.dto.EmailMessageDTO;
import ru.neoflex.dossier.data.enums.Theme;
import ru.neoflex.dossier.service.feign.FeignCustomClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class SignDocumentsStrategy implements EmailSendStrategy {

    private final JavaMailSender javaMailSender;
    private final FeignCustomClient feignCustomClient;

    @Override
    public void sendMail(EmailMessageDTO emailMessageDTO) {

        try {
            Application application = feignCustomClient.getApplicationById(emailMessageDTO.getApplicationId());
            Integer sesCode = application.getSesCode();
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("${mail.username}");
            mailMessage.setTo(emailMessageDTO.getAddress());
            mailMessage.setSubject(emailMessageDTO.getTheme().toString());
            mailMessage.setText("Здравствуйте, " + emailMessageDTO.getAddress() + " ваша подпись для документов " +
                    sesCode);
            javaMailSender.send(mailMessage);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    @Override
    public Theme getTheme() {

        return Theme.SIGN_DOCUMENTS_WITH_SES_CODE;
    }
}
