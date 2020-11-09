package sboot.example.config;

import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Value("${input.file.path}")
    private String path;

    public CSVReader getReader() {
        try {
            return new CSVReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file: " + path, e);
        }
    }
}
