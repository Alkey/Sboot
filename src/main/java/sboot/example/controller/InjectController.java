package sboot.example.controller;

import java.io.FileNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sboot.example.dto.ReviewDto;
import sboot.example.model.Role;
import sboot.example.service.CsvParserService;
import sboot.example.service.InjectDataService;
import sboot.example.service.RoleService;

@Controller
@RequestMapping("/inject")
@RequiredArgsConstructor
public class InjectController {
    private static final String PATH = "classpath:reviews_file.csv";
    private final CsvParserService csvParserService;
    private final InjectDataService injectDataService;
    private final RoleService roleService;

    @GetMapping
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
