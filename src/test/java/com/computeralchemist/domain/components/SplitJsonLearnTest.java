package com.computeralchemist.domain.components;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SplitJsonLearnTest {
    private final String JSON_COMP = "{\"producent\":\"Adata\",\"model\":\"SU800\",\"description\":\"Dysk półprzewodnikowy SU800 zasługuje na swoją totalną nazwę Ultimate dzięki pamięci Flash NAND 3D, która zapewnia większą gęstość zapisu, wydajność oraz niezawodność niż tradycyjna pamięć NAND 2D.\",\"urlToResource\":null,\"compatibiltyIndex\":10.0,\"componentType\":\"DISK\",\"productId\":1,\"diskParameters\":{\"type\":\"SSD\",\"format\":\"2,5\",\"capacity\":256,\"readSpeed\":560.0,\"writeSpeed\":520.0}}";
    private final Logger logger = LogManager.getLogger(SplitJsonLearnTest.class);

    @Test
    public void splitRegexTest() {
        String regex = "(\"componentType\":\"[A-Z]{3,}\")";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(JSON_COMP);
        boolean war = matcher.find();
        logger.info(matcher.group());
        logger.info(war);
        String type = matcher.group();

        String regex2 = "[A-Z]{3,}";
        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher2 = pattern2.matcher(type);

        logger.info(matcher2.find());
        logger.info(matcher2.group());
    }
}
