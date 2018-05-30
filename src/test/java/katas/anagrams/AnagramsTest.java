package katas.anagrams;

import org.junit.Before;
import org.junit.Test;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AnagramsTest {

    private AnagramsChecker anagramsChecker;

    @Before
    public void setup() {
        anagramsChecker = new AnagramsChecker();
    }

    @Test
    public void whenAtLeastOneIsNull_returnsFalse() {
        assertFalse(anagramsChecker.check(null, randomAlphabetic(10)));
        assertFalse(anagramsChecker.check(randomAlphabetic(10), null));
    }

    @Test
    public void whenWordsHaveDifferentLengths_returnsFalse() {
        assertFalse(anagramsChecker.check(randomAlphabetic(3), randomAlphabetic(5)));
    }

    @Test
    public void whenWordsHaveTheSameLengthsButDifferentLetters_returnsFalse() {
        assertFalse(anagramsChecker.check("anagram", "bifidus"));
    }

    @Test
    public void whenWordsHaveTheSameLengthsAndSameLettersbutWithDifferentCount_returnFalse(){
        assertFalse(anagramsChecker.check("ana", "nna"));
    }

    @Test
    public void whenLetterOccurrenceMatches_returnsTrue(){
        assertTrue(anagramsChecker.check("a", "a"));
        assertTrue(anagramsChecker.check("123", "321"));
        assertTrue(anagramsChecker.check("alabala", "blalaaa"));
    }
}
