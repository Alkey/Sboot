package sboot.example.dto;

import lombok.Data;

@Data
public class ReviewDto {
    private String amazonProductId;
    private String amazonUserId;
    private String userName;
    private Long userScore;
    private String commentText;
}
