//Author: Jameson Pierre-Louis
//This program implements our Line class in a Junit test
package com.ss.apr.jb.four;
import org.junit.Test;
import static org.junit.Assert.*;

public class LineTest {
	
	//Tests our GetSlope function
	@Test
	public void testGetSlope() {
		Line line = new Line(1, 1, 0, 0);
		Line line2 = new Line(0, 1, 1, 2);
		Line line3 = new Line(-5, -5, -4, -4);
		
		assertEquals("Incorrect slope for line 1", 1.0, line.getSlope(), 0.0);
		assertEquals("Line 1 and 2 Slopes do not match", line2.getSlope(), line.getSlope(), 0.0);
		assertEquals("Line 1 and 3 Slopes do not match", line3.getSlope(), line.getSlope(), 0.0);
		assertEquals("Line 2 and 3 Slopes do not match", line3.getSlope()+1, line2.getSlope(), 0.0); //Intentional Fail case
	}

	//Tests our GetDistance function
	@Test
	public void testGetDistance() {
		Line line = new Line(1, 1, 0, 0);
		Line line2 = new Line(0, 1, 1, 2);
		Line line3 = new Line(-5, -5, -3, -3);

		assertEquals("Line 1 and 2 Distances do not match", line2.getDistance(), line.getDistance(), 0.0);
		assertEquals("Line 1 and 3 Distances do not match", line3.getDistance(), line2.getDistance(), 0.0); //Fail case
		assertEquals("Line 1 Distance is not correct", 1.414, line.getDistance(), 0.0); //Fail case
		assertEquals("Distance for line 1 is not correct", 1.4142135623730951, line.getDistance(), 0.0);
	}

	//Tests our ParallelTo function
	@Test
	public void testParallelTo() {
		Line line = new Line(1, 1, 0, 0);
		Line line2 = new Line(1, 1, 0, 0);
		Line line3 = new Line(-5, -5, -4, -4);
		assertTrue("Line 1 is not Parallel to Line 2", line.parallelTo(line2));
		assertTrue("Line 1 is not Parallel to Line 3", line.parallelTo(line3));
		assertTrue("Line 2 is not Parallel to Line 3", line2.parallelTo(line3));
	}

}
