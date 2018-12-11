package katas.panagram;

import java.util.HashSet;
import java.util.Set;

public class PangramChecker {

    private static final int LOWERCASE_CHARS_SUM = 2847;

    public boolean check(String sentence) {
        int charSum = 0;

        Set<Character> unique = new HashSet<>();
        for (char c : sentence.toLowerCase().toCharArray()) {
            unique.add(c);
        }

        for (int c : unique) {
            if (isLowerCaseLetter(c)) {
                charSum = charSum + c;
            }
        }
        return charSum == LOWERCASE_CHARS_SUM;
    }

    private boolean isLowerCaseLetter(int c) {
        return c > 96 && c < 123;
    }

}
