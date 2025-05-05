package syncoder.myfin.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExpensesDto {
    private double amount;
    private String category;
}
