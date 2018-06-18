package katas.digitalroot;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class DRootTest
{
	@Test
	public void Tests()
	{
		assertEquals(0, DRoot.digital_root(0));
		assertEquals(1, DRoot.digital_root(10));
		assertEquals(7, DRoot.digital_root(16));
		assertEquals(2, DRoot.digital_root(493193));
	}
}
