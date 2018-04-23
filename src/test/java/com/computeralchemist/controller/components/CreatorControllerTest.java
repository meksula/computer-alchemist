package com.computeralchemist.controller.components;

import com.computeralchemist.controller.exception.SetNotFoundException;
import com.computeralchemist.domain.components.ComponentType;
import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.components.disk.Disk;
import com.computeralchemist.domain.creator.ComputerSetManager;
import com.computeralchemist.domain.creator.setTypes.ComputerSet;
import com.computeralchemist.domain.creator.setTypes.ComputerSetTypes;
import com.computeralchemist.repository.RepositoryProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;
import java.util.Arrays;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Author
 * Karol Meksuła
 * 21-04-2018
 * */

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.JVM)
public class CreatorControllerTest {
    private MediaType mediaType = new MediaType(MediaType.APPLICATION_JSON_UTF8.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @Autowired
    private WebApplicationContext context;
    private HttpMessageConverter converter;
    private MockMvc mockMvc;

    @Autowired
    private RepositoryProvider repositoryProvider;

    private final String USER_NAME = "MikolajKopernik";


    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Autowired
    public void setConverter(HttpMessageConverter<?>[] messageConverter) {
        converter = Arrays.asList(messageConverter).stream()
                .filter(c -> c instanceof MappingJackson2HttpMessageConverter)
                .findAny().orElse(null);
    }

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void beanInjectionTest() {
        assertNotNull(context);
        assertNotNull(converter);
        assertNotNull(mockMvc);
        assertNotNull(repositoryProvider);
        assertNotNull(objectMapper);
    }

    private final String SET_TYPE = "gaming";
    private final String JSON_TYPE = "{\"type:\"gaming\"}";
    private final String INVALID_JSON_TYPE = "{\"type:\"gamingsd\"}";

    @Test
    public void initNewCompSetTest_shouldSaveCorrectlySet() throws Exception {
        mockMvc.perform(post("/set/" + USER_NAME)
                .content(JSON_TYPE)
                .contentType(mediaType)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(header().string("location", containsString("http://localhost/set/gaming/1")));
    }

    @Test
    public void initNewCompSetTest_shouldNotSaveSet() throws Exception {
        mockMvc.perform(post("/set/" + USER_NAME)
                .content(INVALID_JSON_TYPE)
                .contentType(mediaType)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotModified());
    }

    private final long JUST_SAVED_ID = 1;
    private final long INVALID_ID = 44;

    @Test
    public void getCompSet_shouldFindSetCorrectly() throws Exception {
        mockMvc.perform(get("/set/" + SET_TYPE + "/" + JUST_SAVED_ID))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getCompSet_shouldNotFindSet() throws Exception {
        mockMvc.perform(get("/set/" + SET_TYPE + "/" + INVALID_ID))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void getCompSetList_shouldGetCorrectly() throws Exception {
        mockMvc.perform(get("/set/" + SET_TYPE))
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(status().isOk());
    }

    private final String INVALID_TYPE = "notSupported";

    @Test
    public void getCompSetList_shouldNotGetCorrectly() throws Exception {
        mockMvc.perform(get("/set/" + INVALID_TYPE))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Autowired
    private ComputerSetManager manager;

    private final ComputerSetTypes TYPE = ComputerSetTypes.gaming;

    @Test
    public void managerHasSetLoaded_shouldReturnTrue() {
        boolean flag = manager.hasLoadedSet();
        assertTrue(flag);
    }

    private final String DISK_PRODUCENT = "Seagate";

    @Test
    public void postMethodShouldAddOrModifyComponent() throws Exception {
        ComputerSet computerSet = manager.initSet(USER_NAME, TYPE);
        manager.updateSet();
        assertEquals(USER_NAME, computerSet.getAuthor());
        long id = computerSet.getSetId();

        /*manager.loadExistComputerSet("gaming", id)
        assertNotNull();*/

        Disk disk = new Disk();
        disk.setProducent(DISK_PRODUCENT);
        disk.setComponentType(ComponentType.disk);

        long diskid = repositoryProvider.saveComponent(disk);
        disk.setProductId(diskid);
        log.info(String.valueOf(diskid));

        String diskJson = "{\"componentType\":\"disk\", \"id\":" + diskid + "}";
        log.info(diskJson);

        ComputerComponent comp = repositoryProvider.findComponent("disk", diskid);
        assertNotNull(comp);

        mockMvc.perform(put("/set/" + TYPE.toString() + "/" + id)
                .content(diskJson)
                .contentType(mediaType)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

        ComputerSet updated = repositoryProvider.findSet(TYPE.toString(), id);

        assertNotNull(updated.getDisk());
        assertEquals(DISK_PRODUCENT, updated.getDisk().getProducent());
    }

    @Test
    public void putMethodShouldNoMakeChanges() throws Exception {
        String ramJson = "{\"componentType\":\"ram\", \"id\":" + 33 + "}";

        mockMvc.perform(put("/set/" + TYPE.toString() + "/" + 1)
                .content(ramJson)
                .contentType(mediaType)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test(expected = SetNotFoundException.class)
    public void deleteMethodTest_shouldRemoveResourceFormDatabase() throws Exception {
        final long ID = 1;
        ComputerSet computerSet = repositoryProvider.findSet(TYPE.toString(), ID);
        assertNotNull(computerSet);

        //request should remove computerSet with ID = 1
        mockMvc.perform(delete("/set/" + TYPE.toString() + "/" + ID))
                .andDo(print())
                .andExpect(status().isOk());

        ComputerSet shouldBeRemoved = repositoryProvider.findSet(TYPE.toString(), ID);
        assertNull(shouldBeRemoved);
    }


}















