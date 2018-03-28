package com.computeralchemist.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Author
 * Karol Meksuła
 * 27-03-2018
 * */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.computeralchemist.controller")
public class WebServletConfig {

}
