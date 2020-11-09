package sboot.example;

import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import sboot.example.util.CsvReaderUtil;
import sboot.example.util.CsvReaderUtilImpl;


public class CsvReaderUtilImplTest {
    private static final String CORRECT_PATH = "src/test/resources/test.csv";
    private static final String INCORRECT_PATH = "src/test/resources/correct/path.csv";
    private static final List<String[]> CORRECT_LIST =
            List.of(new String[]{"Id", "ProductId", "UserId", "ProfileName",
                    "HelpfulnessNumerator", "HelpfulnessDenominator", "Score",
                    "Time", "Summary", "Text"},
                    new String[]{"1", "B001E4KFG0", "A3SGXH7AUHU8GW", "delmartian", "1",
                            "1", "5", "1303862400",
                            "Good Quality Dog Food", "I have bought several of the Vitality "
                            + "canned dog food products and have found them all "
                            + "to be of good quality. The product looks more like "
                            + "a stew than a processed meat and it smells better. "
                            + "My Labrador is finicky and she appreciates this product better than  most."});

    @Test
    public void readFileWithCorrectPath() throws FileNotFoundException {
        List<String[]> result;
        CsvReaderUtil reader = new CsvReaderUtilImpl(new CSVReader(new FileReader(CORRECT_PATH)));
        result = reader.read();
        assertEquals(10, result.get(0).length);
    }

    @Test
    public void readFileWithIncorrectPath() {
        assertThrows(FileNotFoundException.class, () ->
                new CsvReaderUtilImpl(new CSVReader(new FileReader(INCORRECT_PATH))));
    }

    @Test
    public void chekForCorrectReadFile() throws FileNotFoundException {
        CsvReaderUtil reader = new CsvReaderUtilImpl(new CSVReader(new FileReader(CORRECT_PATH)));
        List<String[]> read = reader.read();
        for (int i = 0; i < read.size(); i++) {
            assertArrayEquals(CORRECT_LIST.get(i), read.get(i));
        }
    }
}