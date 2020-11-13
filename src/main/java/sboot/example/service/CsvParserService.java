package sboot.example.service;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import sboot.example.dto.ReviewDto;
import sboot.example.util.CsvReaderUtil;
import sboot.example.util.ReviewDtoMapper;

@RequiredArgsConstructor
public class CsvParserService {
    private final CsvReaderUtil readerUtil;
    private final ReviewDtoMapper mapper;

    public List<ReviewDto> parseFile(File file) {
        List<String[]> list = readerUtil.read(file);
        if (list.isEmpty()) {
            throw new RuntimeException("This file is empty: " + file.getAbsolutePath());
        }
        return list.stream()
                .skip(1)
                .map(mapper::getReviewDto)
                .collect(Collectors.toList());
    }
}
