package com.fpt.assigngeneral.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/**
 * Configuration class for setting up internationalization and localization in the Spring Boot application.
 */
@Configuration
public class AppConfig implements WebMvcConfigurer {

    /**
     * Configures the locale resolver bean.
     *
     * @return The configured {@link LocaleResolver} bean.
     */
    @Bean
    LocaleResolver localeResolver() {
        SessionLocaleResolver resolver = new SessionLocaleResolver();
        resolver.setDefaultLocale(new Locale("vi"));
        return resolver;
    }

    /**
     * Configures the locale change interceptor bean.
     *
     * @return The configured {@link LocaleChangeInterceptor} bean.
     */
    @Bean
    LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    /**
     * Adds the locale change interceptor to the interceptor registry.
     *
     * @param registry The {@link InterceptorRegistry} to which the locale change interceptor is added.
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    /**
     * Configures the message source bean for internationalization.
     *
     * @return The configured {@link MessageSource} bean.
     */
    @Bean
    MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages\\message");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
