package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NumberGeneratorImp implements NumberGenerator {
    // == fields ==
    private final Random random = new Random();
    private final int minNumber;
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

    @Override
    public int getMinNumber() {
        return minNumber;
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}
