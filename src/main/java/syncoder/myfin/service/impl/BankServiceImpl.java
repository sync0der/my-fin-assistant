package syncoder.myfin.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import syncoder.myfin.dto.BankDto;
import syncoder.myfin.dto.mapper.BankMapper;
import syncoder.myfin.entity.Bank;
import syncoder.myfin.entity.ExchangeRates;
import syncoder.myfin.repository.BankRepository;
import syncoder.myfin.service.BankService;
import syncoder.myfin.service.S3Service;

import java.util.List;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {


    private final BankMapper bankMapper;
    private final BankRepository bankRepository;
    private final S3Service s3Service;

    @Override
    public BankDto create(BankDto bankDto) {
        Bank entity = bankMapper.toEntity(bankDto);
        Bank bank = bankRepository.save(entity);
        return bankMapper.toDto(bank);
    }

    @Override
    public BankDto setImage(Long id, MultipartFile file) {
        Bank bank = get(id);
        bank.setImage(s3Service.uploadFile(file));
        bankRepository.save(bank);

        return bankMapper.toDto(bank);
    }

    private Bank get(Long id) {
        return bankRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<BankDto> getAll() {
        return bankRepository.findAll()
                .stream()
                .map(bankMapper::toDto)
                .toList();
    }

    @Override
    public BankDto update(Long id, BankDto updateDto) {
        Bank bank = get(id);
        updateIfNotNull(updateDto.getName(), bank::setName);
        updateIfNotNull(updateDto.getOfficialName(), bank::setOfficialName);
        updateIfNotNull(updateDto.getEmail(), bank::setEmail);
        updateIfNotNull(updateDto.getSupportPhoneNumbers(), bank::setSupportPhoneNumbers);
        updateIfNotNull(updateDto.getWebsite(), bank::setWebsite);
        Bank updatedBank = bankRepository.save(bank);
        return bankMapper.toDto(updatedBank);
    }

    @Override
    public BankDto setExchangeRate(Long id, List<ExchangeRates> exchangeRates) {
        Bank bank = get(id);
        bank.setExchangeRates(exchangeRates);
        return bankMapper.toDto(bankRepository.save(bank));
    }

    private <T> void updateIfNotNull(T newValue, Consumer<T> setter) {
        if (newValue != null) {
            setter.accept(newValue);
        }
    }
}
