package sboot.example.controller;

import java.io.FileNotFoundException;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import sboot.example.dto.ReviewDto;
import sboot.example.model.Role;
import sboot.example.service.CsvParserService;
import sboot.example.service.InjectDataService;
import sboot.example.service.RoleService;

@Component
@RequiredArgsConstructor
public class InjectController {
    private static final String PATH = "classpath:reviews_file.csv";
    private final CsvParserService csvParserService;
    private final InjectDataService injectDataService;
    private final RoleService roleService;

    @PostConstruct
    public void injectDataToDb() throws FileNotFoundException {
        roleService.save(Role.of("ADMIN"));
        roleService.save(Role.of("USER"));
        List<ReviewDto> dtos = csvParserService
                .parseFile(ResourceUtils.getFile(PATH));
        injectDataService.saveUsersToDbFromReviewDto(dtos);
        injectDataService.saveProductsToDbFromReviewDto(dtos);
        injectDataService.saveCommentsToDbFromReviewDto(dtos);
        injectDataService.saveWordsToDbFromReviewDto(dtos);
    }
}
