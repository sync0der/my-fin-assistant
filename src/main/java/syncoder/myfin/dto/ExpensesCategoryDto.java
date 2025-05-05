package syncoder.myfin.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Builder
@Data
public class ExpensesCategoryDto {
    private Long id;
    private String name;
    private double totalAmount;
    private double averagePercentage;
}
