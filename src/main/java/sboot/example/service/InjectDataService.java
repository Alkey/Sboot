package sboot.example.service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sboot.example.dto.ReviewDto;
import sboot.example.mapper.CommentMapper;
import sboot.example.mapper.ProductMapper;
import sboot.example.mapper.UserMapper;
import sboot.example.model.Comment;
import sboot.example.model.Product;
import sboot.example.model.Role;
import sboot.example.model.User;
import sboot.example.model.Word;

@RequiredArgsConstructor
@Service
public class InjectDataService {
    private static final String REGEX = "\\W+";
    private static final String DEFAULT_PASSWORD = "1111";
    private static final String DEFAULT_ROLE = "USER";
    private final UserMapper userMapper;
    private final ProductMapper productMapper;
    private final CommentMapper commentMapper;
    private final UserService userService;
    private final ProductService productService;
    private final CommentService commentService;
    private final RoleService roleService;
    private final WordService wordService;

    public List<User> saveUsersToDbFromReviewDto(List<ReviewDto> dtos) {
        Role role = roleService.findByName(DEFAULT_ROLE);
        return userService.saveAll(dtos.stream()
                .map(userMapper::getUser)
                .peek(user -> {
                    user.setPassword(DEFAULT_PASSWORD);
                    user.setRoles(Set.of(role));
                })
                .collect(Collectors.toList()));
    }

    public List<Product> saveProductsToDbFromReviewDto(List<ReviewDto> dtos) {
        return productService.saveAll(dtos.stream()
                .map(productMapper::getProduct)
                .collect(Collectors.toList()));
    }

    public List<Comment> saveCommentsToDbFromReviewDto(List<ReviewDto> dtos) {
        return commentService.saveAll(dtos.stream()
                .map(d -> {
                    Comment comment = commentMapper.getComment(d);
                    comment.setUser(userService.findByAmazonUserId(d.getAmazonUserId()));
                    comment.setProduct(productService.findByAmazonId(d.getAmazonProductId()));
                    return comment;
                })
                .collect(Collectors.toList()));
    }

    public List<Word> saveWordsToDbFromReviewDto(List<ReviewDto> dtos) {
        StringBuilder builder = new StringBuilder();
        dtos.forEach(d -> builder.append(d.getCommentText()).append(" "));
        return wordService.saveAll(Arrays.stream(builder.toString()
                .toLowerCase().trim().split(REGEX))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .map(e -> {
                    Word word = new Word();
                    word.setWord(e.getKey());
                    word.setQuantity(e.getValue());
                    return word;
                })
                .collect(Collectors.toList()));
    }
}
