package com.computeralchemist.domain.pickpocket.parser;

import com.computeralchemist.controller.exception.BadComponentTypeException;
import org.springframework.stereotype.Component;

/**
 * @Author
 * Karol Meksuła
 * 01-05-2018
 * */

@Component
public class HtmlParserFactoryImpl implements HtmlParserFactory {

    @Override
    public AbstractHtmlParser createOne(String componentType) {
        System.out.println("TYP: " + componentType);

        if (componentType.equals("cpu"))
            return new CpuHtmlParser();
        else if (componentType.equals("motherboard"))
            return new MotherboardHtmlParser();
        else if (componentType.equals("ram"))
            return new RamHtmlParser();
        else if (componentType.equals("disk"))
            return new DiskHtmlParser();
        else if (componentType.equals("supply"))
            return new SupplyHtmlParser();
        else if (componentType.equals("computercase"))
            return new ComputerCaseHtmlParser();
        else if (componentType.equals("gpu"))
            return new GraphicsCardHtmlParser();

        else throw new BadComponentTypeException(componentType);
    }
}
