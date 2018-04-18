package com.computeralchemist.domain.components;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author
 * Karol Meksuła
 * 08-04-2018
 * */

public class ComponentTypeExtracter {
    private static ComponentTypeExtracter ourInstance = new ComponentTypeExtracter();

    public static ComponentTypeExtracter getInstance() {
        return ourInstance;
    }

    private ComponentTypeExtracter() {
    }

    private final String PATTERN_MAIN = "(\"componentType\":\"[a-z]{3,}\")";
    private final String PATTERN_SEC = ":\"[a-z]{3,}";

    public String extractTypeFromJson(String json) {
        String firstStep = extractingType(json);
        String result = finalExtracting(firstStep);

        if (isComponentExist(result))
            return result;

        throw new NoSuchComponentException(result);
    }

    public String extractComputerTypeFromJson(String json) {
        return finalExtracting(json);
    }

    private String extractingType(String json) {
        Pattern pattern = Pattern.compile(PATTERN_MAIN);
        Matcher matcher = pattern.matcher(json);
        String type = "";
        if (matcher.find())
            type = matcher.group();

        return type;
    }

    private String finalExtracting(String firstStep) {
        Pattern pattern = Pattern.compile(PATTERN_SEC);
        Matcher matcher = pattern.matcher(firstStep);

        String result = "";
        if (matcher.find())
            result = matcher.group();

        result = result.substring(2);
        return result.toLowerCase();
    }

    private boolean isComponentExist(String result) {
        try {
            ComponentType.valueOf(result);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
