package syncoder.myfin.component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import syncoder.myfin.dto.ExpensesDto;
import syncoder.myfin.entity.Card;
import syncoder.myfin.entity.User;
import syncoder.myfin.entity.enums.CardType;
import syncoder.myfin.repository.*;
import syncoder.myfin.service.ExpensesCategoryService;
import syncoder.myfin.service.ExpensesService;
import syncoder.myfin.service.UserService;

@Slf4j
@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {

    private final ExpensesCategoryRepository expensesCategoryRepository;
    private final ExpensesService expensesService;
    private final ExpensesCategoryService expensesCategoryService;
    private final UserRepository userRepository;
    private final CardRepository cardRepository;
    private final UserService userService;
    private final ExpensesRepository expensesRepository;
    private final BankRepository bankRepository;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findAll().isEmpty()) {
            userRepository.save(User.builder()
                    .firstName("Azizbek")
                    .lastName("Oxunov")
                    .build());
            log.info("---------> saved 1 user");
        }

        if (cardRepository.findAll().isEmpty()) {
            cardRepository.save(Card.builder()
                    .cardType(CardType.DEBIT)
                    .cardNumber("9860 1245 0706 1461")
                    .user(userService.getUser(1L))
                    .build());
            log.info("---------> saved DEBIT card");

            cardRepository.save(Card.builder()
                    .cardType(CardType.CASH)
                    .cardNumber("9860 1245 0706 1461")
                    .user(userService.getUser(1L))
                    .build());
            log.info("---------> saved CASH card");
        }

        if (expensesCategoryRepository.findAll().isEmpty()) {
            expensesCategoryService.create("Oziq-ovqat");
            expensesCategoryService.create("Transport");
            expensesCategoryService.create("Salomatlik");
            expensesCategoryService.create("O'yin-kulgi va dam olish");
            expensesCategoryService.create("Uy-joy");
            log.info("---------> saved 5 expenses categories");
        }

        if (expensesRepository.findAll().isEmpty()) {
            expensesService.paymentFromCashCard(ExpensesDto.builder()
                    .amount(256000)
                    .categoryName("Oziq-ovqat")
                    .build());
            expensesService.paymentFromCashCard(ExpensesDto.builder()
                    .amount(25000)
                    .categoryName("Transport")
                    .build());
            expensesService.paymentFromCashCard(ExpensesDto.builder()
                    .amount(84000)
                    .categoryName("O'yin-kulgi va dam olish")
                    .build());
            expensesService.paymentFromCashCard(ExpensesDto.builder()
                    .amount(45000)
                    .categoryName("Uy-joy")
                    .build());

        }
    }

    private void initializeData() {
        if (bankRepository.findAll().isEmpty()) {

        }
    }
}
