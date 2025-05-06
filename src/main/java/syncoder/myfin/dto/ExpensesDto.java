package syncoder.myfin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ExpensesDto {
    private double amount;
    private String categoryName;
    private String receiverCardNumber;
    private String receiverName;
    private String receiverPhoneNumber;
}
