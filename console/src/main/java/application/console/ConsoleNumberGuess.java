package application.console;

import application.Game;
import application.MessageGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleNumberGuess {
    // == constant ==
    private final static Logger logger = LoggerFactory.getLogger(ConsoleNumberGuess.class);
    // == fields ==
    private final Game game;
    private final MessageGenerator messageGenerator;

    // == constructor ==
    public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void start() {
        logger.info("Container ready to use");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();
            if (game.isGameWon() || game.isGameLost()) {
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again y/n");

                String playAgainString = scanner.nextLine().trim();
                if (!playAgainString.equalsIgnoreCase("y")) {
                    break;
                }
                game.reset();
            }
        }
    }
}
