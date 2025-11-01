package hexlet.code.util;

import java.security.SecureRandom;

public class RandomGenerator {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 100;
    private static final SecureRandom RANDOM = new SecureRandom();

    public static int generateNumber() {
        return RANDOM.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
    }

    public static int generateNumber(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }
}
