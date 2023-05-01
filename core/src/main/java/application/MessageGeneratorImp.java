package application;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageGeneratorImp implements MessageGenerator {
    // == fields ==
    private final Game game;

    // == constructor ==
    public MessageGeneratorImp(Game game) {
        this.game = game;
    }

    // == init ==
    @PostConstruct
    public void init() {
        log.info("game = {}", game);
    }

    // == public methods ==
    @Override
    public String getMainMessage() {
        int smallest = game.getSmallest();
        int biggest = game.getBiggest();
        return "Number is between " + smallest + " and " + biggest + ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {

        if (game.isGameWon()) {
            return "You guessed it! The number was " + game.getNumber();
        }

        if (game.isGameLost()) {
            return "You lost. The number was " + game.getNumber();
        }

        if (!game.isValidNumberRange()) {
            return "Invalid Number Range!";
        }

        if (game.getRemainingGuesses() == game.getGuessCount()) {
            return "What is your first guess?";
        } else {
            String direction = game.getGuess() < game.getNumber() ? "Higher" : "Lower";
            String guesses = game.getRemainingGuesses() == 1 ? "guess" : "guesses";
            return direction + "! You have " + game.getRemainingGuesses() + " " + guesses + " left";
        }
    }


}
