package application.config;

import application.GuessCount;
import application.MaxNumber;
import application.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "application")
@PropertySource("classpath:config/game.properties")
public class GameConfig {
    // == fields ==
    @Value("${game.minNumber:5}")
    private int minNumber;
    @Value("${game.maxNumber:44}")
    private int maxNumber;
    @Value("${game.guessCount:4}")
    private int guessCount;

    // == bean methods ==
    @Bean
    @MinNumber
    public int minNumber() {
        return minNumber;
    }

    @Bean
    @MaxNumber
    public int maxNumber() {
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }
}
