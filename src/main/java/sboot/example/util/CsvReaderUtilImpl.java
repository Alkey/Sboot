package sboot.example.util;

import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvReaderUtilImpl implements CsvReaderUtil {
    @Override
    public List<String[]> read(File file) {
        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            return reader.readAll();
        } catch (IOException e) {
            throw new RuntimeException("Can't read CSV " + file, e);
        }
    }
}
