package br.com.ferreirafelipe.todo.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Locale;

@Configuration
public class InternacionalizacaoConfig {
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource msgSource =
                new ReloadableResourceBundleMessageSource();

        msgSource.setBasename("classpath:message");
        msgSource.setDefaultEncoding("UTF-8");
        msgSource.setDefaultLocale(Locale.getDefault());

        return msgSource;
    }

    @Bean
    public LocalValidatorFactoryBean validatorFactoryBean() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
}
