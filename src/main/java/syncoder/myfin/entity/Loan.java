package syncoder.myfin.entity;

import jakarta.persistence.*;
import lombok.*;
import syncoder.myfin.entity.enums.LoanType;
import syncoder.myfin.entity.enums.MicroloanApplicationMethod;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LoanType type;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Bank bank;

    private String loanName;

    private List<String> applicationMethod;

    private String currency;

    @Embedded
    private LoanTerm loanTerm;

    @Embedded
    private LoanSum loanSum;

    @Embedded
    private LoanInterestRate interestRate;

    private boolean hasDownPayment;     //первоначальный взнос

    private String collateral;      //обеспечение по кредиту

    @ElementCollection
    @CollectionTable(name = "required_documents", joinColumns = @JoinColumn(name = "loan_id"))
    private List<String> requiredDocuments;

}
