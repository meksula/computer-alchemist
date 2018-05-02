package learn;

import com.computeralchemist.domain.components.gpu.GraphicsCard;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 30-04-2018
 * */

@Slf4j
public class JsoupLearningTest {
    //work great
    private final String link = "https://www.x-kom.pl/p/383500-procesory-intel-core-i5-intel-i5-8400-280ghz-9mb-box.html";

    private final String newLink = "https://www.x-kom.pl/p/317002-karta-graficzna-nvidia-msi-geforce-gtx-1060-gaming-x-6gb-gddr5.html";

    private GraphicsCard graphicsCard;

    private Document document;

    @Before
    public void setUp() {
        graphicsCard = new GraphicsCard();

        try {
            document = Jsoup.connect(newLink).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void documentLoadTest() {
        Elements elementP = document.select("p");
        List<String> descList = elementP.eachText();
        log.info(descList.get(59));
    }

   @Test
    public void shouldLoadParameters() {
       Elements element = document.select("tbody");

       Elements table = element.select("tr");
       //log.info(table.html());
       log.info(String.valueOf(table.size())); //21 size

       log.info(String.valueOf(table.get(18))); //length
       log.info(String.valueOf(table.get(16))); //power
       log.info(String.valueOf(table.get(15))); //standards <List>
       log.info(String.valueOf(table.get(14))); //connectors <List>
       log.info(String.valueOf(table.get(13))); //cooler
       log.info(String.valueOf(table.get(12))); //clock frequency
       log.info(String.valueOf(table.get(11))); //memory frequeny
       log.info(String.valueOf(table.get(9))); //memory type
       log.info(String.valueOf(table.get(8))); //memory
       log.info(String.valueOf(table.get(7))); //main connector
       log.info(String.valueOf(table.get(6))); //chipset

    }

}
