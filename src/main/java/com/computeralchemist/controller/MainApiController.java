package com.computeralchemist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/")
public class MainApiController {

    @GetMapping(produces = "application/json; charset=utf-8")
    public String apiDoc() throws IOException {
        return readFile();
    }

    private String readFile() throws IOException {
        Path path = Paths.get("/home/karol/computer-alchemist/snip-doc.txt");

        StringBuilder data = new StringBuilder();
        Stream<String> lines = Files.lines(path);
        lines.forEach(line -> data.append(line).append("\n"));
        lines.close();

        return data.toString();
    }

}
