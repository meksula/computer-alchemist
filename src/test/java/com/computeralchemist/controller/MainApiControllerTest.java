package com.computeralchemist.controller;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class MainApiControllerTest {

    @Test
    public void shouldReadFile() throws URISyntaxException, IOException {
        Path path = Paths.get("/home/karol/computer-alchemist/api-doc.txt");

        StringBuilder data = new StringBuilder();
        Stream<String> lines = Files.lines(path);
        lines.forEach(line -> data.append(line).append("\n"));
        lines.close();

    }
}