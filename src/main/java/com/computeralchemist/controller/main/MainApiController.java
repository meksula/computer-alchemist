package com.computeralchemist.controller.main;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @Author
 * Karol Meksuła
 * 29-03-2018
 * */

@RestController
@RequestMapping("/doc")
public class MainApiController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String apiDoc() throws IOException {
        return readFile();
    }

    private String readFile() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("./snip-doc.txt").getFile());

        StringBuilder builder = new StringBuilder();
        Stream<String> lines = Files.lines(file.toPath());
        lines.forEach(line -> builder.append(line).append("\n"));
        lines.close();

        return builder.toString();
    }

}
