package sboot.example.util;

import com.opencsv.CSVReader;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CsvReaderUtilImpl implements CsvReaderUtil {
    private final CSVReader reader;

    @Override
    public List<String[]> read() {
        try (reader) {
            return reader.readAll();
        } catch (IOException e) {
            throw new RuntimeException("Can't read CSV", e);
        }
    }
}
