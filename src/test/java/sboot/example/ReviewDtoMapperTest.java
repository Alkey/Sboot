package sboot.example;

import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import sboot.example.dto.ReviewDto;
import sboot.example.util.ReviewDtoMapper;
import sboot.example.util.CsvReaderUtil;
import sboot.example.util.CsvReaderUtilImpl;

public class ReviewDtoMapperTest {
    private static final List<String[]> LIST_FROM_CORRECT_FILE = List.of(
            new String[]{"Id", "ProductId", "UserId",
                    "ProfileName", "HelpfulnessNumerator",
                    "HelpfulnessDenominator", "Score", "Time", "Summary", "Text"},
            new String[]{"1", "B001E4KFG0", "A3SGXH7AUHU8GW", "delmartian",
                    "1", "1", "5", "1303862400", "Good Quality Dog Food",
                    "I have bought several of the Vitality canned dog food products"
                            + " and have found them all to be of good quality. "
                            + "The product looks more like a stew than a processed meat and it smells better. "
                            + "My Labrador is finicky and she appreciates this product better than  most."});
    private final CsvReaderUtil util = Mockito.mock(CsvReaderUtilImpl.class);
    private final ReviewDtoMapper mapper = new ReviewDtoMapper(util);

    @Test
    public void createDtoWithCorrectList() {
        when(util.read()).thenReturn(LIST_FROM_CORRECT_FILE);
        ReviewDto dto = new ReviewDto();
        dto.setUserName(LIST_FROM_CORRECT_FILE.get(1)[3]);
        dto.setCommentText(LIST_FROM_CORRECT_FILE.get(1)[9]);
        dto.setUserScore(Long.parseLong(LIST_FROM_CORRECT_FILE.get(1)[6]));
        dto.setAmazonUserId(LIST_FROM_CORRECT_FILE.get(1)[2]);
        dto.setAmazonProductId(LIST_FROM_CORRECT_FILE.get(1)[1]);
        assertEquals(List.of(dto), mapper.getReviewDto());
        verify(util).read();
    }

    @Test
    public void checkCreateDtoWithEmptyList() {
        when(util.read()).thenReturn(Collections.emptyList());
        assertThrows(RuntimeException.class, mapper::getReviewDto);
        verify(util).read();
    }
}
