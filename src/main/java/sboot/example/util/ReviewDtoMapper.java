package sboot.example.util;

import sboot.example.dto.ReviewDto;

public class ReviewDtoMapper {
    public ReviewDto getReviewDto(String[] review) {
        ReviewDto dto = new ReviewDto();
        dto.setAmazonProductId(review[1]);
        dto.setAmazonUserId(review[2]);
        dto.setAmazonProfileName(review[3]);
        dto.setAmazonHelpfulnessNumerator(Long.parseLong(review[4]));
        dto.setAmazonHelpfulnessDenominator(Long.parseLong(review[5]));
        dto.setUserScore(Long.parseLong(review[6]));
        dto.setTime(Long.parseLong(review[7]));
        dto.setSummary(review[8]);
        dto.setCommentText(review[9]);
        return dto;
    }
}

