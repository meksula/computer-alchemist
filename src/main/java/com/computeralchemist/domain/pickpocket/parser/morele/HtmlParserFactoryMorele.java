package com.computeralchemist.domain.pickpocket.parser.morele;

import com.computeralchemist.controller.exception.BadComponentTypeException;
import com.computeralchemist.domain.pickpocket.parser.AbstractHtmlParser;
import com.computeralchemist.domain.pickpocket.parser.HtmlParserFactory;

/**
 * @Author
 * Karol Meksuła
 * 02-05-2018
 * */

public class HtmlParserFactoryMorele implements HtmlParserFactory {

    @Override
    public AbstractHtmlParser createOne(String componentType) {
        if (componentType.equals("cpu"))
            return new CpuHtmlParserMorele();
        else if (componentType.equals("motherboard"))
            return new MotherboardHtmlParserMorele();
        else if (componentType.equals("ram"))
            return new RamHtmlParserMorele();
        else if (componentType.equals("disk"))
            return new DiskHtmlParserMorele();
        else if (componentType.equals("supply"))
            return new SupplyHtmlParserMorele();
        else if (componentType.equals("computercase"))
            return new ComputerCaseHtmlParserMorele();
        else if (componentType.equals("gpu"))
            return new GraphicsCardHtmlParserMorele();

        else throw new BadComponentTypeException(componentType);
    }
}
