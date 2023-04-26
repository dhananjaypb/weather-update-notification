package org.weather.update.notification.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/*
 * This class is used for configurations
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "org.weather.update.notification" })
public class FrontController {

}
