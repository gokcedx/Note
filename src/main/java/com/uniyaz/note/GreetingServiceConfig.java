package com.uniyaz.note;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Kübra VARICI
 */
@Configuration
public class GreetingServiceConfig {

    @Bean
    @ConditionalOnProperty(name = "language.name", havingValue = "english", matchIfMissing = true)
    public GreetingService englishGreetingService() {
        return new EnglishGreetingService();
    }

    @Bean
    @ConditionalOnProperty(name = "language.name", havingValue = "french")
    public GreetingService frenchGreetingService() {
        return new FrenchGreetingService();
    }
}
