package ru.neoflex.dossier.data.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.neoflex.dossier.data.jsonb.LoanOfferJsonb;
import ru.neoflex.dossier.data.jsonb.StatusHistoryJsonb;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@ToString
public class Application {

    private Long applicationId;
    private Client client;
    private Credit credit;
    private String status;
    private Timestamp creationDate;
    private LoanOfferJsonb appliedOffer;
    private Timestamp signDate;
    private Integer sesCode;
    private List<StatusHistoryJsonb> statusHistory;
}
