package syncoder.myfin.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import syncoder.myfin.dto.LoanDto;
import syncoder.myfin.dto.RequestLoanDto;
import syncoder.myfin.dto.mapper.LoanMapper;
import syncoder.myfin.entity.Loan;
import syncoder.myfin.repository.LoanRepository;
import syncoder.myfin.service.BankService;
import syncoder.myfin.service.LoanService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final BankService bankService;
    private final LoanRepository loanRepository;
    private final LoanMapper loanMapper;

    @Override
    public LoanDto create(RequestLoanDto requestLoanDto) {
        Loan loan = Loan.builder()
                .type(requestLoanDto.getType())
                .bank(bankService.get(requestLoanDto.getBankId()))
                .loanName(requestLoanDto.getLoanName())
                .applicationMethod(requestLoanDto.getApplicationMethod())
                .currency(requestLoanDto.getCurrency())
                .loanTerm(requestLoanDto.getLoanTerm())
                .loanSum(requestLoanDto.getLoanSum())
                .interestRate(requestLoanDto.getInterestRate())
                .hasDownPayment(requestLoanDto.isHasDownPayment())
                .collateral(requestLoanDto.getCollateral())
                .requiredDocuments(requestLoanDto.getRequiredDocs())
                .build();
        return loanMapper.toDto(loanRepository.save(loan));
    }

    @Override
    public List<LoanDto> getAll() {
        return loanRepository.findAll()
                .stream()
                .map(loanMapper::toBasicDto)
                .toList();
    }

    @Override
    public List<LoanDto> getByLoanType(String loanType) {
        return loanRepository.findAllByType(loanType)
                .stream()
                .map(loanMapper::toBasicDto)
                .toList();
    }


}
