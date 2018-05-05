package com.computeralchemist.domain.pickpocket.parser.xkom;

import com.computeralchemist.domain.components.ComponentType;
import com.computeralchemist.domain.components.disk.Disk;
import com.computeralchemist.domain.components.disk.DiskParameters;
import com.computeralchemist.domain.components.disk.DriveType;
import com.computeralchemist.domain.pickpocket.parser.AbstractHtmlParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author
 * Karol Meksuła
 * 01-05-2018
 * */

public class DiskHtmlParserXkom extends AbstractHtmlParser {
    private Disk disk;
    private DiskParameters parameters;

    private final int TYPE_INDEX = 5;
    private final int FORMAT_INDEX = 7;
    private final int CAPACITY_INDEX = 6;
    private final int READ_SPEED_INDEX = 10;
    private final int WRITE_SPEED_INDEX = 11;

    public DiskHtmlParserXkom() {
        super.computerComponent = new Disk();
        disk = (Disk) computerComponent;
        parameters = new DiskParameters();
        disk.setDiskParameters(parameters);
    }

    @Override
    public void documentToObject() {
        disk.setComponentType(ComponentType.disk);

        setProducent();
        setModel();
        setType();
        setFormat();
        setCapacity();
        setReadSpeed();
        setWriteSpeed();
    }

    private void setType() {
        String type = fetchTrTags().get(TYPE_INDEX).select("td").text();
        String result = "";

        Pattern pattern = Pattern.compile("[A-Z]{3}");
        Matcher matcher = pattern.matcher(type);
        if (matcher.find())
            result = matcher.group();

        parameters.setType(DriveType.valueOf(result));
    }

    private void setFormat() {
        String format = fetchTrTags().get(FORMAT_INDEX).select("td").text();
        parameters.setFormat(format);
    }

    private void setCapacity() {
        String capacity = fetchTrTags().get(CAPACITY_INDEX).select("td").text();
        double capacityDouble = extractDoubleFromString(capacity);
        parameters.setCapacity((int) capacityDouble);
    }

    private void setReadSpeed() {
        String read = fetchTrTags().get(READ_SPEED_INDEX).select("td").text();
        double readSpeed = extractDoubleFromString(read);
        parameters.setReadSpeed(readSpeed);
    }

    private void setWriteSpeed() {
        String write = fetchTrTags().get(WRITE_SPEED_INDEX).select("td").text();
        double writeSpeed = extractDoubleFromString(write);
        parameters.setWriteSpeed(writeSpeed);
    }

}
