package sboot.example.util;

import sboot.example.dto.ReviewDto;

public class ReviewDtoMapper {
    private static final int PRODUCT_ID = 1;
    private static final int USER_ID = 2;
    private static final int PROFILE_NAME = 3;
    private static final int HELPFULNESS_NUMERATOR = 4;
    private static final int HELPFULNESS_DENOMINATOR = 5;
    private static final int SCORE = 6;
    private static final int TIME = 7;
    private static final int SUMMARY = 8;
    private static final int COMMENT = 9;

    public ReviewDto getReviewDto(String[] review) {
        ReviewDto dto = new ReviewDto();
        dto.setAmazonProductId(review[PRODUCT_ID]);
        dto.setAmazonUserId(review[USER_ID]);
        dto.setAmazonProfileName(review[PROFILE_NAME]);
        dto.setAmazonHelpfulnessNumerator(Long.parseLong(review[HELPFULNESS_NUMERATOR]));
        dto.setAmazonHelpfulnessDenominator(Long.parseLong(review[HELPFULNESS_DENOMINATOR]));
        dto.setUserScore(Long.parseLong(review[SCORE]));
        dto.setTime(Long.parseLong(review[TIME]));
        dto.setSummary(review[SUMMARY]);
        dto.setCommentText(review[COMMENT]);
        return dto;
    }
}

