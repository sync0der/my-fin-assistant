package syncoder.myfin.dto;

import lombok.Builder;
import lombok.Data;
import syncoder.myfin.entity.ExchangeRates;

import java.util.List;

@Data
@Builder
public class BankDto {
    private Long id;
    private String name;
    private String image;
    private String officialName;
    private String email;
    private List<String> supportPhoneNumbers;
    private String website;
    private List<ExchangeRates> exchangeRates;
}
