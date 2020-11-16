package sboot.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;
import sboot.example.util.CsvReaderUtil;
import sboot.example.util.CsvReaderUtilImpl;

public class CsvReaderUtilImplTest {
    private static final String PATH = "classpath:test_csv_reader.csv";
    private static CsvReaderUtil reader;

    @BeforeAll
    public static void init() {
        reader = new CsvReaderUtilImpl();
    }

    @Test
    public void readFileWithCorrectPath() throws FileNotFoundException {
        List<String[]> result;
        File file = ResourceUtils.getFile(PATH);
        result = reader.read(file);
        assertEquals(10, result.get(0).length);
    }

    @Test
    public void readFileWithIncorrectPath() {
        assertThrows(FileNotFoundException.class, () ->
                new CsvReaderUtilImpl().read(ResourceUtils.getFile("classpath:tet.csv")));
    }

    @Test
    public void chekForCorrectReadFile() throws FileNotFoundException {
        List<String[]> list = List.of(new String[]{"Id", "ProductId", "UserId", "ProfileName",
                        "HelpfulnessNumerator", "HelpfulnessDenominator", "Score",
                        "Time", "Summary", "Text"},
                new String[]{"1", "B001E4KFG0", "A3SGXH7AUHU8GW", "delmartian", "1",
                        "1", "5", "1303862400",
                        "Good Quality Dog Food", "I have bought several of the Vitality "
                        + "canned dog food products and have found them all "
                        + "to be of good quality. The product looks more like "
                        + "a stew than a processed meat and it smells better. "
                        + "My Labrador is finicky and she appreciates this product better than  most."});
        File file = ResourceUtils.getFile(PATH);
        List<String[]> read = reader.read(file);
        for (int i = 0; i < read.size(); i++) {
            assertArrayEquals(list.get(i), read.get(i));
        }
    }
}
