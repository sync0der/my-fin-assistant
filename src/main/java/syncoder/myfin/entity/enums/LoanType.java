package syncoder.myfin.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LoanType {
    MICROLOAN("Mikroqarz");

    private final String name;
}
