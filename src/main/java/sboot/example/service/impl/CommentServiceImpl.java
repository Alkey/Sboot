package sboot.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sboot.example.dao.CommentDao;
import sboot.example.model.Comment;
import sboot.example.service.CommentService;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentDao commentDao;

    @Override
    public Comment save(Comment comment) {
        return commentDao.save(comment);
    }

    @Override
    public Comment findById(Long id) {
        return commentDao.getOne(id);
    }
}
