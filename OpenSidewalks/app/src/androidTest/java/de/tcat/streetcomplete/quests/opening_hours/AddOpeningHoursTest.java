package de.tcat.opensidewalks.quests.opening_hours;

import de.tcat.opensidewalks.data.osm.OsmElementQuestType;
import de.tcat.opensidewalks.quests.opening_hours.AddOpeningHours;
import de.tcat.opensidewalks.quests.opening_hours.AddOpeningHoursForm;
import de.tcat.opensidewalks.data.osm.changes.StringMapEntryAdd;
import de.tcat.opensidewalks.quests.AOsmElementQuestTypeTest;

public class AddOpeningHoursTest extends AOsmElementQuestTypeTest
{
	@Override protected OsmElementQuestType createQuestType()
	{
		return new AddOpeningHours(null);
	}

	public void testOpeningHours()
	{
		bundle.putString(AddOpeningHoursForm.OPENING_HOURS, "my cool opening hours");
		verify(new StringMapEntryAdd("opening_hours", "my cool opening hours"));
	}
}
