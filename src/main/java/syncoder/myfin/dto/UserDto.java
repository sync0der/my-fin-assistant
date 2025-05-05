    package syncoder.myfin.dto;

    import lombok.Builder;
    import lombok.Data;

    import java.util.ArrayList;
    import java.util.List;

    @Data
    @Builder
    public class UserDto {
        private Long id;
        private String firstName;
        private String lastName;
        @Builder.Default
        private List<CardDto> cards = new ArrayList<>();
    }
