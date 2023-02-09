package ru.neoflex.dossier.data.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.neoflex.dossier.data.jsonb.PaymentScheduleJsonb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString
public class Credit implements Serializable {

    private Long creditId;
    private BigDecimal amount;
    private Integer term;
    private BigDecimal monthlyPayment;
    private BigDecimal rate;
    private BigDecimal psk;
    private List<PaymentScheduleJsonb> paymentSchedule;
    private Boolean insuranceEnable;
    private Boolean salaryClient;
    private String creditStatus;
}
