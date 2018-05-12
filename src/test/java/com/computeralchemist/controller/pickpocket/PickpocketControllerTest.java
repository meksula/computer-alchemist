package com.computeralchemist.controller.pickpocket;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.Matchers.*;

/**
 * @Author
 * Karol Meksuła
 * 01-05-2018
 * */

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class PickpocketControllerTest {
    private MediaType mediaType = new MediaType(MediaType.APPLICATION_JSON_UTF8.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    @Autowired
    private WebApplicationContext applicationContext;

    private MockMvc mockMvc;

    private HttpMessageConverter jacksonConverter;

    @Autowired
    public void setMessageConverter(HttpMessageConverter<?>[] converters) {
        jacksonConverter = Arrays.stream(converters)
                .filter(c -> c instanceof MappingJackson2HttpMessageConverter)
                .findAny()
                .orElse(null);
    }

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
    }

    @Test
    public void instantiateTest() {
        assertNotNull(applicationContext);
        assertNotNull(jacksonConverter);
    }


    private final String TYPE = "gpu";
    private final String LINK = "https://www.x-kom.pl/p/317002-karta-graficzna-nvidia-msi-geforce-gtx-1060-gaming-x-6gb-gddr5.html";
    private final String INVALID_TYPE = "sev3d";

    @Test
    public void requestShouldReturnCorrectComputerComponentObject() throws Exception {
        mockMvc.perform(post("/pickpocket/" + TYPE)
                .content(LINK)
                .contentType(mediaType)
                .accept(mediaType))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void requestShouldThrowException() throws Exception {
        mockMvc.perform(post("/pickpocket/" + INVALID_TYPE)
                .content(LINK)
                .contentType(mediaType)
                .accept(mediaType))
                .andDo(print())
                .andExpect(status().isConflict());
    }

    @Test
    public void requestShouldReturnListOfProperties() throws Exception {
        mockMvc.perform(post("/pickpocket/" + TYPE + "/properties")
                .content(LINK)
                .contentType(mediaType)
                .accept(mediaType))
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(14)));
    }

}