package syncoder.myfin.dto;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    @Builder.Default
    private Set<CardDto> cards = new HashSet<>();
}
