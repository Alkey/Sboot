package sboot.example.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class CommentDto {
    private Long id;
    private String amazonUserId;
    private String amazonProductId;
    private Long helpfulnessNumerator;
    private Long helpfulnessDenominator;
    private Long score;
    private LocalDateTime time;
    private String summary;
    private String text;
}
