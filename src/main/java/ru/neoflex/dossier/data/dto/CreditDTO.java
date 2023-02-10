package ru.neoflex.dossier.data.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.neoflex.dossier.data.jsonb.PaymentScheduleJsonb;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString
public class CreditDTO {

    private BigDecimal amount;
    private Integer term;
    private BigDecimal monthlyPayment;
    private BigDecimal rate;
    private BigDecimal psk;
    private List<PaymentScheduleJsonb> paymentSchedule;
}
