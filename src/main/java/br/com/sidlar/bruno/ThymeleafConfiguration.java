package br.com.sidlar.bruno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uk.co.gcwilliams.jodatime.thymeleaf.JodaTimeDialect;

@Configuration
public class ThymeleafConfiguration {

    @Bean
    public JodaTimeDialect jodatimeDialect() {
        return new JodaTimeDialect();
    }

//    @Bean
//    public ClassLoaderTemplateResolver mailTemplatesResolver() {
//        ClassLoaderTemplateResolver emailTemplateResolver = new ClassLoaderTemplateResolver();
//        emailTemplateResolver.setPrefix("classpath:/templates/mail");
//        emailTemplateResolver.setSuffix(".html");
//        emailTemplateResolver.setTemplateMode("HTML5");
//        emailTemplateResolver.setCharacterEncoding("UTF-8");
//        emailTemplateResolver.setOrder(1);
//        return emailTemplateResolver;
//    }
}