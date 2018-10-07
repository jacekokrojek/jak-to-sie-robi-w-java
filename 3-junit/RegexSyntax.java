/**
 * Based on
 *  - https://www.baeldung.com/regular-expressions-java
 *
 * References
 *  - https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html
 */
package h.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegexSyntax {

    @Test
    public void givenText_whenSimpleRegexMatches_thenCorrect() {
        String regex = "foo";
        String sampleText = "foo";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sampleText);
        assertTrue(matcher.find());
    }

    @Test
    public void givenText_whenSimpleRegexMatchesTwice_thenCorrect() {
        Pattern pattern = Pattern.compile("foo");
        Matcher matcher = pattern.matcher("foofoo");
        int matches = 0;
        while (matcher.find()) {
            matches++;
        }
        assertEquals(matches, 2);
    }

    public static int runTest(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int matches = 0;
        while (matcher.find()) {
            matches++;
        }
        return matches;
    }

    @Test
    public void givenText_whenMatchesWithDotMetach_thenCorrect() {
        int matches = runTest(".", "foo");

        assertTrue(matches > 0);
    }

    @Test
    public void givenRepeatedText_whenMatchesOnceWithDotMetach_thenCorrect() {
        int matches= runTest("foo.", "foofoo");

        assertEquals(matches, 1);
    }

    @Test
    public void givenORSet_whenMatchesAny_thenCorrect() {
        int matches = runTest("[abc]", "b");

        assertEquals(matches, 1);
    }

    @Test
    public void givenORSet_whenMatchesAnyAndAll_thenCorrect() {
        int matches = runTest("[abc]", "cab");

        assertEquals(matches, 3);
    }

    @Test
    public void givenORSet_whenMatchesAllCombinations_thenCorrect() {
        int matches = runTest("[bcr]at", "bat cat rat");

        assertEquals(matches, 3);
    }

    @Test
    public void givenUpperCaseRange_whenMatchesUpperCase_thenCorrect() {
        int matches = runTest(
                "[A-Z]", "Two Uppercase alphabets 34 overall");

        assertEquals(matches, 2);
    }

    @Test
    public void givenNORSet_whenMatchesNon_thenCorrect() {
        int matches = runTest("[^abc]", "g");

        assertTrue(matches > 0);
    }

    @Test
    public void givenNORSet_whenMatchesAllExceptElements_thenCorrect() {
        int matches = runTest("[^bcr]at", "sat mat eat");

        assertTrue(matches > 0);
    }

    /**
     * Predefined character classes
     */

    @Test
    public void givenDigits_whenMatches_thenCorrect() {
        int matches = runTest("\\d", "123");

        assertEquals(matches, 3);
    }

    @Test
    public void givenNonDigits_whenMatches_thenCorrect() {
        int matches = runTest("\\D", "a6c");

        assertEquals(matches, 2);
    }

    @Test
    public void givenWhiteSpace_whenMatches_thenCorrect() {
        int matches = runTest("\\s", "a c");

        assertEquals(matches, 1);
    }

    @Test
    public void givenNonWhiteSpace_whenMatches_thenCorrect() {
        int matches = runTest("\\S", "a c");

        assertEquals(matches, 2);
    }

    @Test
    public void givenWordCharacter_whenMatches_thenCorrect() {
        int matches = runTest("\\w", "hi!");

        assertEquals(matches, 2);
    }

    @Test
    public void givenNonWordCharacter_whenMatches_thenCorrect() {
        int matches = runTest("\\W", "hi!");

        assertEquals(matches, 1);
    }

    /**
     * Quantifiers
     */
    @Test
    public void givenZeroOrOneQuantifier_whenMatches_thenCorrect() {
        int matches = runTest("i?", "hi");

        assertEquals(matches, 3);
    }
    @Test

    public void givenZeroOrOneQuantifier_whenMatches_thenCorrect2() {
        int matches = runTest("\\a{0,1}", "hi");

        assertEquals(matches, 3);
    }
    @Test
    public void givenZeroOrManyQuantifier_whenMatches_thenCorrect() {
        int matches = runTest("\\a*", "hi");

        assertEquals(matches, 3);
    }

    @Test
    public void givenOneOrManyQuantifier_whenMatches_thenCorrect() {
        int matches = runTest("\\a+", "hi");

        assertEquals(matches, 0);
    }

    @Test
    public void givenBraceQuantifier_whenMatches_thenCorrect() {
        int matches = runTest("a{3}", "aaaaaa");

        assertEquals(matches, 2);
    }
}
