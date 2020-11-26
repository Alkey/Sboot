package sboot.example.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sboot.example.dao.CommentDao;
import sboot.example.model.Comment;
import sboot.example.service.CommentService;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentDao dao;

    @Override
    public Comment save(Comment comment) {
        return dao.save(comment);
    }

    @Override
    public Comment findById(Long id) {
        return dao.getOne(id);
    }

    @Override
    public List<Comment> saveAll(List<Comment> comments) {
        return dao.saveAll(comments);
    }
}
