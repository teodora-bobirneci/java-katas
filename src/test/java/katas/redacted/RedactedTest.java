package katas.redacted;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RedactedTest {

    @Test
    public void check_singleWordRedacted_matches() {
        assertTrue(Redacted.redacted("XXX", "asd"));
    }

    @Test
    public void check_singleWordNotRedacted_doesNotMatch() {
        assertFalse(Redacted.redacted("asd", "dsa"));
    }

    @Test
    public void check_singleWordNotRedacted_Matches() {
        assertTrue(Redacted.redacted("asd", "asd"));
    }

    @Test
    public void checkMultipleWordsAllNotRedacted_Match() {
        assertTrue(Redacted.redacted("asd asd", "asd asd"));
    }

    @Test
    public void checkMultipleWordsAllRedacted_Match() {
        assertTrue(Redacted.redacted("XXX XXX", "asd asd"));
    }

    @Test
    public void checkMultipleWordsSomeRedacted_Match() {
        assertTrue(Redacted.redacted("XXX asd", "asd asd"));
    }

    @Test
    public void ex1() {
        String doc1 = "TOP SECRET:\nThe missile launch code for Sunday XXXXXXXXXX is:\nXXXXXXXXXXXXXXXXX";
        String doc2 = "TOP SECRET:\nThe missile launch code for Sunday 5th August is:\n7-ZERO-8X-ALPHA-1";
        assertTrue(Redacted.redacted(doc1, doc2));
    }

    @Test
    public void ex2() {
        String doc1 = "The name of the mole is Professor XXXXX";
        String doc2 = "The name of the mole is Professor Dinglemouse";
        assertFalse(Redacted.redacted(doc1, doc2));
    }

    @Test
    public void ex3() {
        String doc1 = "XXXXXXXX XXXXXXX XXXXXXXXXXXXXXXXXXX\nXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX XXXXXXXXX XXXXXXXXXXXXX XXXXX";
        String doc2 = "Area-51. Medical Report. 23/Oct/1969\nE.T. subject 4 was given an asprin after reporting sick for duty today";
        assertTrue(Redacted.redacted(doc1, doc2));
    }

    @Test
    public void ex4() {
        String doc1 = "\n\nLine1\n" + "                XXXXX";
        String doc2 = "Line1\n" + "                Line2";
        assertFalse(Redacted.redacted(doc1, doc2));
    }

    @Test
    public void ex5() {
        String doc1 = "\n\nLine1\n" + "                XXXXX";
        String doc2 = "\n\nLine1\n" + "                Line2";
        assertTrue(Redacted.redacted(doc1, doc2));
    }
}
