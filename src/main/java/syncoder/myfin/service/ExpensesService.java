package syncoder.myfin.service;

import syncoder.myfin.dto.ContactPaymentRequestDto;
import syncoder.myfin.dto.ExpensesDto;

import java.util.List;

public interface ExpensesService {

    ExpensesDto paymentFromCashCard(ExpensesDto requestDto);

    ExpensesDto paymentToCard(String cardNumber, double amount);

    ExpensesDto paymentToCard(ContactPaymentRequestDto requestDto);

    List<ExpensesDto> getAll(Long cardId);
}
