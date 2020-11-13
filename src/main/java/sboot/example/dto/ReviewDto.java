package sboot.example.dto;

import lombok.Data;

@Data
public class ReviewDto {
    private String amazonProductId;
    private String amazonUserId;
    private String amazonProfileName;
    private Long amazonHelpfulnessNumerator;
    private Long amazonHelpfulnessDenominator;
    private Long userScore;
    private Long time;
    private String summary;
    private String commentText;
}
