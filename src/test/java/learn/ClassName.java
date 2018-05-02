package learn;

import com.computeralchemist.domain.components.ram.Ram;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

@Slf4j
public class ClassName {

    @Test
    public void classnameTest() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String type = "Ram";
        Object object = Class.forName("com.computeralchemist.domain.components.ram." + type).newInstance();
        Ram ram = (Ram) object;
        assertNotNull(object);
        assertNotNull(ram);
    }
}
