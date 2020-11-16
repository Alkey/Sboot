package sboot.example;

import java.io.FileNotFoundException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;
import sboot.example.dto.ReviewDto;
import sboot.example.service.CsvParserService;
import sboot.example.util.CsvReaderUtilImpl;
import sboot.example.util.ReviewDtoMapper;

public class CsvParserServiceTest {
    private static CsvParserService service;

    @BeforeAll
    public static void init() {
        service = new CsvParserService(new CsvReaderUtilImpl(), new ReviewDtoMapper());
    }

    @Test
    public void checkWithCorrectFile() throws FileNotFoundException {
        List<ReviewDto> actual = service
                .parseFile(ResourceUtils.getFile("classpath:test_csv_reader.csv"));
        ReviewDto dto = new ReviewDto();
        dto.setAmazonProductId("B001E4KFG0");
        dto.setAmazonUserId("A3SGXH7AUHU8GW");
        dto.setAmazonProfileName("delmartian");
        dto.setAmazonHelpfulnessNumerator(Long.parseLong("1"));
        dto.setAmazonHelpfulnessDenominator(Long.parseLong("1"));
        dto.setUserScore(Long.parseLong("5"));
        dto.setTime(Long.parseLong("1303862400"));
        dto.setSummary("Good Quality Dog Food");
        dto.setCommentText("I have bought several of the Vitality canned dog food products"
                + " and have found them all to be of good quality. "
                + "The product looks more like a stew than a processed meat and it smells better. "
                + "My Labrador is finicky and she appreciates this product better than  most.");
        assertEquals(dto, actual.get(0));
    }

    @Test
    public void checkWithEmptyFile() {
        assertThrows(RuntimeException.class, () ->
                service.parseFile(ResourceUtils.getFile("classpath:empty.csv")));
    }
}
