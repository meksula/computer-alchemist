package com.computeralchemist.controller.components.motherboards;

import com.computeralchemist.config.RootConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.NestedServletException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * @Author
 * Karol Meksuła
 * 02-04-2018
 * */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
@WebAppConfiguration
public class MotherboardControllerTest {
    private final long ID = 100;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MotherboardController motherboardController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void injectCorrectly() {
        assertNotNull(motherboardController);
    }

    @Test
    public void deleteMethodTest() {
        motherboardController.deleteComponent(ID);
    }

    @Test(expected = NestedServletException.class)
    public void methodShouldThrowExpectedException() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/components/motherboards/33444444"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void methodShouldSendCorrectJSON() throws Exception {

    }

    @Test
    public void createHeaderTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        /*Class<?> object = motherboardController.getClass();
        Method method = object.getDeclaredMethod("createHeader");
        method.setAccessible(true);
        HttpHeaders headers = (HttpHeaders) method.invoke(new MotherboardController());*/
        //TODO powermock? coś nie działa w powyższym kodzie...
    }

}