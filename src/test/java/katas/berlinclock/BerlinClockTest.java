package katas.berlinclock;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BerlinClockTest
{

	@Test
	public void whenEvenSeconds_TopYellowLightIsOn()
	{
		BerlinClock clock = new BerlinClock("19:32:54");
		assertEquals("Y", clock.topLight());
	}

}
