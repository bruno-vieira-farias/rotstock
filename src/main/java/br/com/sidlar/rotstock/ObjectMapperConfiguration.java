package br.com.sidlar.rotstock;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ObjectMapperConfiguration {

    @Primary
    @Bean
    public ObjectMapper customObjectMapper() {
        return new CustomObjectMapper();
    }

    static class CustomObjectMapper extends ObjectMapper {
        public CustomObjectMapper() {
            registerModule(new GuavaModule());
            registerModule(new JodaModule());
            registerModule(new JSR310Module());
            registerModule(new Jdk8Module());
            configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        }
    }
}