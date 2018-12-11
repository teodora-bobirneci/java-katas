package katas.panagram;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PanagramCheckerTest {

    @Test
    public void test1() {
        assertTrue(new PangramChecker().check("The quick brown fox jumps over the lazy dog."));
    }

    @Test
    public void test2() {
        assertFalse(new PangramChecker().check("You shall not pass!"));
    }

}
