package syncoder.myfin.service;

import org.springframework.web.multipart.MultipartFile;
import syncoder.myfin.dto.BankDto;
import syncoder.myfin.entity.Bank;
import syncoder.myfin.entity.ExchangeRates;

import java.util.List;

public interface BankService {
    BankDto create(BankDto bankDto);

    BankDto setImage(Long id, MultipartFile file);

    Bank get(Long id);

    List<BankDto> getAll();

    BankDto update(Long id, BankDto updateDto);

    BankDto setExchangeRate(Long id, List<ExchangeRates> exchangeRates);

    void delete(Long id);
}
