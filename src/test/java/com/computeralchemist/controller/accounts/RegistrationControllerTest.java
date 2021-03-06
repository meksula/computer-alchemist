package com.computeralchemist.controller.accounts;

import com.computeralchemist.domain.users.Address;
import com.computeralchemist.domain.users.User;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Author
 * Karol Meksuła
 * 24-05-2018
 * */

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class RegistrationControllerTest {

    private MediaType mediaType = new MediaType(MediaType.APPLICATION_JSON_UTF8.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @Autowired
    private WebApplicationContext context;

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Autowired
    public void setMessageConverter(HttpMessageConverter<?>[] convs) {
        mappingJackson2HttpMessageConverter = Arrays.stream(convs)
                .filter(converter -> converter instanceof MappingJackson2HttpMessageConverter)
                .findAny()
                .orElse(null);
    }

    private MockMvc mockMvc;

    private final String USERNAME = "MikołajKopernik";
    private final String NAME = "Mikołaj";
    private final String SURNAME = "Kopernik";
    private final String EMAIL = "Kopernik@Mikołaj.com";
    private final String PASSWORD = "Kopernik22222";
    private final int BORN = 1994;

    private User prepareValidUser() {
        User user = new User();
        user.setUsername(USERNAME);
        user.setName(NAME);
        user.setSurname(SURNAME);
        user.setEmail(EMAIL);
        user.setPassword(PASSWORD);
        user.setBornyear(BORN);
        user.setAddress(new Address());

        return user;
    }

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void shouldSuccessfullSaveNewUserInDatabase() throws Exception {
        mockMvc.perform(post("/registration")
                .content(new ObjectMapper().writeValueAsBytes(prepareValidUser()))
                .contentType(mediaType)
                .accept(mediaType))
                .andDo(print())
                .andExpect(status().isCreated());
    }

}