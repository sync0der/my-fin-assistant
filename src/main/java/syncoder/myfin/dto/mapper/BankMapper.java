package syncoder.myfin.dto.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import syncoder.myfin.dto.BankDto;
import syncoder.myfin.entity.Bank;

@Component
@RequiredArgsConstructor
public class BankMapper implements MapperInterface<Bank, BankDto> {


    @Override
    public BankDto toDto(Bank bank) {
        return BankDto.builder()
                .id(bank.getId())
                .name(bank.getName())
                .image(bank.getImage())
                .officialName(bank.getOfficialName())
                .email(bank.getEmail())
                .supportPhoneNumbers(bank.getSupportPhoneNumbers())
                .website(bank.getWebsite())
                .exchangeRates(bank.getExchangeRates())
                .build();
    }

    public BankDto toBasicDto(Bank bank) {
        return BankDto.builder()
                .id(bank.getId())
                .name(bank.getName())
                .image(bank.getImage())
                .officialName(bank.getOfficialName())
                .email(bank.getEmail())
                .supportPhoneNumbers(bank.getSupportPhoneNumbers())
                .website(bank.getWebsite())
                .build();
    }

    @Override
    public Bank toEntity(BankDto bankDto) {
        return Bank.builder()
                .name(bankDto.getName())
                .officialName(bankDto.getOfficialName())
                .email(bankDto.getEmail())
                .supportPhoneNumbers(bankDto.getSupportPhoneNumbers())
                .website(bankDto.getWebsite())
                .build();
    }
}
