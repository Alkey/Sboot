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
    private static final String CORRECT_PATH = "src/test/resources/correct_path.csv";
    private static final String INCORRECT_PATH = "src/test/resources/correct/path.csv";
    private static final List<String[]> CORRECT_LIST =
            List.of(new String[]{"ID", "NAME"}, new String[]{"1", "Bob"});

    @Test
    public void readFileWithCorrectPath() throws FileNotFoundException {
        List<String[]> result;
        CsvReaderUtil reader = new CsvReaderUtilImpl(new CSVReader(new FileReader(CORRECT_PATH)));
        result = reader.read();
        assertEquals(2, result.get(0).length);
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
