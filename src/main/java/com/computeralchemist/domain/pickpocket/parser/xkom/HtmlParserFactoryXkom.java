package com.computeralchemist.domain.pickpocket.parser.xkom;

import com.computeralchemist.controller.exception.BadComponentTypeException;
import com.computeralchemist.domain.pickpocket.parser.AbstractHtmlParser;
import com.computeralchemist.domain.pickpocket.parser.HtmlParserFactory;

/**
 * @Author
 * Karol Meksuła
 * 01-05-2018
 * */

public class HtmlParserFactoryXkom implements HtmlParserFactory {

    @Override
    public AbstractHtmlParser createOne(String componentType) {
        if (componentType.equals("cpu"))
            return new CpuHtmlParserXkom();
        else if (componentType.equals("motherboard"))
            return new MotherboardHtmlParserXkom();
        else if (componentType.equals("ram"))
            return new RamHtmlParserXkom();
        else if (componentType.equals("disk"))
            return new DiskHtmlParserXkom();
        else if (componentType.equals("supply"))
            return new SupplyHtmlParserXkom();
        else if (componentType.equals("computercase"))
            return new ComputerCaseHtmlParserXkom();
        else if (componentType.equals("gpu"))
            return new GraphicsCardHtmlParserXkom();

        else throw new BadComponentTypeException(componentType);
    }
}
