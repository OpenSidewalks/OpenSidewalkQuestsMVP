package de.tcat.opensidewalks.quests.opening_hours;

import junit.framework.TestCase;

import de.tcat.opensidewalks.quests.opening_hours.Weekdays;

public class WeekdaysTest extends TestCase
{
	// hihi
	private final boolean l = true;
	private final boolean o = false;

	public void testToString() {
		assertEquals("Mo,Tu", new Weekdays(new boolean[]{l,l,o,o,o,o,o,o}).toString());
		assertEquals("Tu-Th", new Weekdays(new boolean[]{o,l,l,l,o,o,o,o}).toString());
		assertEquals("Tu-Th,Sa,Su,PH", new Weekdays(new boolean[]{o,l,l,l,o,l,l,l}).toString());
		assertEquals("Su,Mo", new Weekdays(new boolean[]{l,o,o,o,o,o,l,o}).toString());
		assertEquals("Sa-Th,PH", new Weekdays(new boolean[]{l,l,l,l,o,l,l,l}).toString());
	}
}
