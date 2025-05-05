package syncoder.myfin.dto;

import lombok.Builder;
import lombok.Data;
import syncoder.myfin.entity.LoanInterestRate;
import syncoder.myfin.entity.LoanSum;
import syncoder.myfin.entity.LoanTerm;

import java.util.List;

@Builder
@Data
public class LoanDto {
    private Long id;
    private String type;
    private BankDto bank;
    private String loanName;
    private List<String> applicationMethod;
    private String currency;
    private LoanTerm loanTerm;
    private LoanSum loanSum;
    private LoanInterestRate interestRate;
    private boolean hasDownPayment;
    private String collateral;
    private List<String> requiredDocs;
}
