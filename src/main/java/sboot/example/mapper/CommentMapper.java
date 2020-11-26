package sboot.example.mapper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.springframework.stereotype.Component;
import sboot.example.dto.ReviewDto;
import sboot.example.model.Comment;

@Component
public class CommentMapper {
    public Comment getComment(ReviewDto dto) {
        Comment comment = new Comment();
        comment.setHelpfulnessDenominator(dto.getAmazonHelpfulnessDenominator());
        comment.setHelpfulnessNumerator(dto.getAmazonHelpfulnessNumerator());
        comment.setScore(dto.getUserScore());
        comment.setTime(LocalDateTime.ofInstant(Instant.ofEpochMilli(dto.getTime()),
                ZoneId.systemDefault()));
        comment.setSummary(dto.getSummary());
        comment.setText(dto.getCommentText());
        return comment;
    }
}
