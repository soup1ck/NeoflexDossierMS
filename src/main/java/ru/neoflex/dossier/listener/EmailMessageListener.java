package ru.neoflex.dossier.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ru.neoflex.dossier.data.dto.EmailMessageDTO;
import ru.neoflex.dossier.service.email.EmailServiceImpl;

@Slf4j
@Component
@RequiredArgsConstructor
public class EmailMessageListener {

    private final EmailServiceImpl emailServiceImpl;

    @KafkaListener(groupId = "notificationId",
            topics = {"finish-registration",
                    "create-documents",
                    "send-documents",
                    "send-ses",
                    "credit-issued"})
    public void finishRegistrationListener(@Payload EmailMessageDTO emailMessageDTO) {
        emailServiceImpl.sendMessage(emailMessageDTO);
    }
}
