package com.computeralchemist.controller.accounts;

import com.computeralchemist.domain.users.Address;
import com.computeralchemist.domain.users.User;
import com.computeralchemist.repository.users.UserRepository;
import lombok.ToString;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;
import java.util.Arrays;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Author
 * Karol Meksuła
 * 31-05-2018
 * */

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserControllerTest {

    @Autowired
    private UserRepository userRepository;

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

    private final long USER_ID = 1000;
    private final String EMAIL = "random.email@gmail.com";

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void endpointShouldReturnUserEmailById() throws Exception {
        saveFakeUser();

        mockMvc.perform(get("/user/" + USER_ID + "/mail/")
                .accept(mediaType))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(EMAIL)));
    }

    private void saveFakeUser() {
        User user = new User();
        user.setId(USER_ID);
        user.setEmail(EMAIL);
        user.setAddress(new Address());

        userRepository.save(user);
    }

    @Test
    public void endpointShouldReturnUserAddressById() throws Exception {
        saveFakeUser();

        mockMvc.perform(get("/user/" + USER_ID + "/address/")
                .accept(mediaType))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("{\"country\":null,\"city\":null,\"zipCode\":null,\"houseNumber\":null}"));
    }

    @After
    public void tearDown() {
        userRepository.deleteAll();
    }

}