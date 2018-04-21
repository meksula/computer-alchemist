package com.computeralchemist.controller.components;

import com.computeralchemist.repository.RepositoryProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;
import java.util.Arrays;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated())
                .andExpect(header().string("location", containsString("http://localhost/set/gaming/1")));
    }

    @Test
    public void initNewCompSetTest_shouldNotSaveSet() throws Exception {
        mockMvc.perform(post("/set/" + USER_NAME)
                .content(INVALID_JSON_TYPE)
                .contentType(mediaType)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotModified());
    }

    private final long JUST_SAVED_ID = 1;
    private final long INVALID_ID = 44;

    @Test
    public void getCompSet_shouldFindSetCorrectly() throws Exception {
        mockMvc.perform(get("/set/" + SET_TYPE + "/" + JUST_SAVED_ID))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void getCompSet_shouldNotFindSet() throws Exception {
        mockMvc.perform(get("/set/" + SET_TYPE + "/" + INVALID_ID))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void getCompSetList_shouldGetCorrectly() throws Exception {
        mockMvc.perform(get("/set/" + SET_TYPE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(status().isOk());
    }

    private final String INVALID_TYPE = "notSupported";

    @Test
    public void getCompSetList_shouldNotGetCorrectly() throws Exception {
        mockMvc.perform(get("/set/" + INVALID_TYPE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound());
    }

}















