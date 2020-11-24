package sboot.example.service;

import sboot.example.model.Comment;

public interface CommentService {
    Comment save(Comment comment);

    Comment findById(Long id);
}
