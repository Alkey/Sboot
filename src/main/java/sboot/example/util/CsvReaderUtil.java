package sboot.example.util;

import java.io.File;
import java.util.List;

public interface CsvReaderUtil {
    List<String[]> read(File file);
}
