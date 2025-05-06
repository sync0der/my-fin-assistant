package syncoder.myfin.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContactPaymentRequestDto {
    private String receiverName;
    private String phoneNumber;
    private double amount;
}
