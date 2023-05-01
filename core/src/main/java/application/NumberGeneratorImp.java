package application;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Slf4j
public class NumberGeneratorImp implements NumberGenerator {
    // == fields ==
    private final Random random = new Random();
    @Getter
    private final int minNumber;
    @Getter
    private final int maxNumber;

    // == constructor ==
    @Autowired
    public NumberGeneratorImp(@MinNumber int minNumber, @MaxNumber int maxNumber) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
    }

    // == public methods ==
    @Override
    public int next() {
        return random.nextInt(maxNumber - minNumber + 1) + minNumber;
    }
}
