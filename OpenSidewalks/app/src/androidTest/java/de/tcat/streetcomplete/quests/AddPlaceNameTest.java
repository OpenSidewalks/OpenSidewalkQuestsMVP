package de.tcat.opensidewalks.quests;

import de.tcat.opensidewalks.data.osm.OsmElementQuestType;
import de.tcat.opensidewalks.data.osm.changes.StringMapEntryAdd;
import de.tcat.opensidewalks.quests.place_name.AddPlaceName;
import de.tcat.opensidewalks.quests.place_name.AddPlaceNameForm;

public class AddPlaceNameTest extends AOsmElementQuestTypeTest
{
	@Override public void setUp()
	{
		super.setUp();
		tags.put("shop","kiosk");
	}

	public void testNoName()
	{
		bundle.putBoolean(AddPlaceNameForm.NO_NAME, true);
		verify(
				new StringMapEntryAdd("noname","yes"));
	}

	public void testName()
	{
		bundle.putString(AddPlaceNameForm.NAME, "my name");
		verify(
				new StringMapEntryAdd("name","my name"));
	}

	@Override protected OsmElementQuestType createQuestType()
	{
		return new AddPlaceName(null);
	}
}
