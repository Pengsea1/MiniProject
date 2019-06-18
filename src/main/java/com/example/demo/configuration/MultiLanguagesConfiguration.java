package com.example.demo.configuration;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class MultiLanguagesConfiguration extends WebMvcConfigurerAdapter {
 @Bean
 public LocaleResolver localeResolver(){
     SessionLocaleResolver slr=new SessionLocaleResolver();
     slr.setDefaultLocale(Locale.US);
     return slr;
 }
 @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
     LocaleChangeInterceptor lci=new LocaleChangeInterceptor();
     lci.setParamName("lang");
     return lci;
 }
    @Bean
    MessageSource messageSource(){
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasename("messages");
        resourceBundleMessageSource.setDefaultEncoding("UTF-8");
        return resourceBundleMessageSource;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}
