package sboot.example.mapper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sboot.example.dto.CommentDto;
import sboot.example.dto.ReviewDto;
import sboot.example.model.Comment;

@RequiredArgsConstructor
@Component
public class CommentMapper {
    public CommentDto getCommentDto(ReviewDto reviewDto) {
        CommentDto dto = new CommentDto();
        dto.setHelpfulnessDenominator(reviewDto.getAmazonHelpfulnessDenominator());
        dto.setHelpfulnessNumerator(reviewDto.getAmazonHelpfulnessNumerator());
        dto.setScore(reviewDto.getUserScore());
        dto.setTime(LocalDateTime.ofInstant(Instant.ofEpochMilli(reviewDto.getTime()),
                ZoneId.systemDefault()));
        dto.setSummary(reviewDto.getSummary());
        dto.setText(reviewDto.getCommentText());
        dto.setAmazonProductId(dto.getAmazonProductId());
        dto.setAmazonUserId(dto.getAmazonUserId());
        return dto;
    }

    public Comment getComment(CommentDto dto) {
        Comment comment = new Comment();
        comment.setHelpfulnessDenominator(dto.getHelpfulnessDenominator());
        comment.setHelpfulnessNumerator(dto.getHelpfulnessNumerator());
        comment.setScore(dto.getScore());
        comment.setTime(dto.getTime());
        comment.setSummary(dto.getSummary());
        comment.setText(dto.getText());
        return comment;
    }
}
