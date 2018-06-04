package katas.berlinclock;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class BerlinClockTest {

    @Test(expected = IllegalArgumentException.class)
    public void givenNullInput_shouldThrowException() {
        new BerlinClock(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenRandomStringInput_shouldThrowException() {
        new BerlinClock(randomAlphanumeric(10));
    }

    @Test
    @Parameters({"19:32:54, Y", "19:32:20, Y"})
    public void whenEvenSeconds_TopYellowLightIsOn(String time, String berlinClockTime) {
        BerlinClock clock = new BerlinClock(time);
        assertEquals(berlinClockTime, clock.topLight());
    }

    @Test
    @Parameters({"19:32:57, O", "21:21:21, O"})
    public void whenOddSeconds_TopYellowLightIsOff(String time, String topYellowLightStatus) {
        BerlinClock clock = new BerlinClock(time);
        assertEquals(topYellowLightStatus, clock.topLight());
    }

    @Test
    @Parameters({"3:14:15, OOOO",
            "5:22:23, ROOO",
            "9:34:43, ROOO",
            "10:42:22, RROO",
            "14:33:36, RROO",
            "15:00:00, RRRO",
            "18:35:22, RRRO",
            "20:00:00, RRRR",
            "23:59:59, RRRR"})
    public void shouldLightFirstRedLightsForEach5Hours(String time, String firstRedLightRow) {
        BerlinClock clock = new BerlinClock(time);
        assertEquals(firstRedLightRow, clock.firstRedLightRow());
    }

    @Test
    @Parameters({"1:14:15, ROOO",
            "2:22:23, RROO",
            "3:34:43, RRRO",
            "4:42:22, RRRR",
            "0:33:36, OOOO"})
    public void shouldLightSecondRedLightsForEachMod5Hours(String time, String secondRedLightRow) {
        BerlinClock clock = new BerlinClock(time);
        assertEquals(secondRedLightRow, clock.secondRedLightRow());
    }

    @Test
    @Parameters({"8:4:21, OOOOOOOOOOO",
            "8:7:21, YOOOOOOOOOO",
            "8:21:33, YYRYOOOOOOO",
            "8:30:00, YYRYYROOOOO",
            "8:44:00, YYRYYRYYOOO",
            "8:59:00, YYRYYRYYRYY"})
    public void shouldLightYellowLightsForEach5MinutesAndRedForEach15(String time, String yellowRedLightRow) {
        BerlinClock clock = new BerlinClock(time);
        assertEquals(yellowRedLightRow, clock.yellowRedLightRow());
    }
}
