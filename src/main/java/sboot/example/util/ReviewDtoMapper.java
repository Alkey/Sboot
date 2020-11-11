package sboot.example.util;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import sboot.example.dto.ReviewDto;

@RequiredArgsConstructor
public class ReviewDtoMapper {
    private final CsvReaderUtil readerUtil;

    public List<ReviewDto> getReviewDto() {
        List<String[]> reviews = readerUtil.read();
        if (reviews.isEmpty()) {
            throw new RuntimeException("File is empty!");
        }
        List<ReviewDto> dtos = new ArrayList<>();
        for (int i = 1; i < reviews.size(); i++) {
            ReviewDto dto = new ReviewDto();
            String[] review = reviews.get(i);
            dto.setAmazonProductId(review[1]);
            dto.setAmazonUserId(review[2]);
            dto.setUserName(review[3]);
            dto.setUserScore(Long.parseLong(review[6]));
            dto.setCommentText(review[9]);
            dtos.add(dto);
        }
        return dtos;
    }
}
