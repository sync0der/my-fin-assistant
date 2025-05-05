package syncoder.myfin.service;

import syncoder.myfin.dto.LoanDto;
import syncoder.myfin.dto.RequestLoanDto;

import java.util.List;

public interface LoanService {
    LoanDto create(RequestLoanDto requestLoanDto);

    List<LoanDto> getAll();

    List<LoanDto> getByLoanType(String loanType);
    void delete(Long id);
    LoanDto update(Long id, LoanDto loanDto);
}
