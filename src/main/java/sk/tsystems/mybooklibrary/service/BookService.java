package sk.tsystems.mybooklibrary.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sk.tsystems.mybooklibrary.controller.exceptions.ForbiddenTitleException;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {
    private final List<String> forbiddenWords = Arrays.asList("Microsoft");

    public void isForbidden(String title) {
        if (forbiddenWords.stream().anyMatch(forbiddenWord -> title.toLowerCase().contains(forbiddenWord.toLowerCase())))
            throw new ForbiddenTitleException("Titles contianing: " + title + " are forbidden!");
    }
}
