package sboot.example.service;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sboot.example.dto.CommentDto;
import sboot.example.dto.ReviewDto;
import sboot.example.mapper.CommentMapper;
import sboot.example.mapper.ProductMapper;
import sboot.example.mapper.UserMapper;
import sboot.example.model.Comment;
import sboot.example.model.Role;

@RequiredArgsConstructor
@Service
public class InjectDataService {
    private static final String DEFAULT_PASSWORD = "1111";
    private static final Role DEFAULT_ROLE = Role.of("USER");
    private final CsvParserService csvParserService;
    private final UserMapper userMapper;
    private final ProductMapper productMapper;
    private final CommentMapper commentMapper;
    private final UserService userService;
    private final ProductService productService;
    private final CommentService commentService;

    public void injectData(File file) {
        List<ReviewDto> dtos = csvParserService.parseFile(file);
        dtos.stream()
                .map(userMapper::getUser)
                .forEach(user -> {
                    user.setRoles(Set.of(DEFAULT_ROLE));
                    user.setPassword(DEFAULT_PASSWORD);
                    userService.save(user);
                });
        dtos.stream()
                .map(productMapper::getProduct)
                .forEach(productService::save);
        List<CommentDto> comments = dtos.stream()
                .map(commentMapper::getCommentDto)
                .collect(Collectors.toList());
        comments.forEach(dto -> {
            Comment comment = commentMapper.getComment(dto);
            comment.setUser(userService.findByAmazonUserId(dto.getAmazonUserId()));
            comment.setProduct(productService.findByAmazonId(dto.getAmazonProductId()));
            commentService.save(comment);
        });
    }
}
