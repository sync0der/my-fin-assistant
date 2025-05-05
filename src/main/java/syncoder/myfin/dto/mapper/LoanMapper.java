package syncoder.myfin.dto.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import syncoder.myfin.dto.LoanDto;
import syncoder.myfin.entity.Loan;

@Component
@RequiredArgsConstructor
public class LoanMapper implements MapperInterface<Loan, LoanDto> {

    private final BankMapper bankMapper;

    @Override
    public LoanDto toDto(Loan loan) {
        return LoanDto.builder()
                .id(loan.getId())
                .type(loan.getType())
                .bankDto(bankMapper.toBasicDto(loan.getBank()))
                .loanName(loan.getLoanName())
                .applicationMethod(loan.getApplicationMethod())
                .currency(loan.getCurrency())
                .loanTerm(loan.getLoanTerm())
                .loanSum(loan.getLoanSum())
                .interestRate(loan.getInterestRate())
                .hasDownPayment(loan.isHasDownPayment())
                .collateral(loan.getCollateral())
                .requiredDocs(loan.getRequiredDocuments())
                .build();
    }

    public LoanDto toBasicDto(Loan loan){
        return LoanDto.builder()
                .id(loan.getId())
                .type(loan.getType())
                .loanName(loan.getLoanName())
                .bankDto(bankMapper.toBasicDto(loan.getBank()))
                .loanTerm(loan.getLoanTerm())
                .loanSum(loan.getLoanSum())
                .interestRate(loan.getInterestRate())
                .build();
    }



}
