package sboot.example.service;

import java.util.List;
import sboot.example.model.Comment;

public interface CommentService {
    Comment save(Comment comment);

    Comment findById(Long id);

    List<Comment> saveAll(List<Comment> comments);

    List<Comment> getAll();
}
