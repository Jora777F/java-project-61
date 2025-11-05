package hexlet.code.util;

import java.security.SecureRandom;

public class RandomGenerator {

    private static final SecureRandom RANDOM = new SecureRandom();

    public static int generateNumber(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }
}
