package ru.neoflex.dossier.service.strategy;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import ru.neoflex.dossier.data.dto.Application;
import ru.neoflex.dossier.data.dto.EmailMessageDTO;
import ru.neoflex.dossier.data.enums.Theme;
import ru.neoflex.dossier.service.feign.FeignCustomClient;
import ru.neoflex.dossier.service.file.FileService;

import java.io.File;
import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class SendDocumentsStrategy implements EmailSendStrategy {

    private final JavaMailSender javaMailSender;
    private final FeignCustomClient feignCustomClient;
    private final FileService fileService;

    @Override
    public void sendMail(EmailMessageDTO emailMessageDTO) {

        MimeMessage mimeMessage
                = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
        try {
            mimeMessageHelper
                    = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom("${mail.username}");
            mimeMessageHelper.setTo(emailMessageDTO.getAddress());
            mimeMessageHelper.setText("Здравствуйте, " + emailMessageDTO.getAddress() + " ваши документы готовы " +
                    "ожидаем вашего подписания");
            mimeMessageHelper.setSubject(
                    emailMessageDTO.getTheme().toString());
            Application application = feignCustomClient.getApplicationById(emailMessageDTO.getApplicationId());
            File creditFile = fileService.createCreditFile(application);
            File clientFile = fileService.createClientFile(application);
            mimeMessageHelper.addAttachment("Информация о кредите.txt", creditFile);
            mimeMessageHelper.addAttachment("Информация о клиенте.txt", clientFile);
            javaMailSender.send(mimeMessage);
            feignCustomClient.updateApplicationStatus(emailMessageDTO.getApplicationId());
        } catch (MessagingException | IOException e) {
            log.info(e.getMessage());
        }
    }

    @Override
    public Theme getTheme() {

        return Theme.YOUR_LOAN_DOCUMENTS;
    }
}
