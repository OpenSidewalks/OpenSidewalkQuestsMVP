package de.tcat.opensidewalks.quests;

import de.tcat.opensidewalks.data.osm.OsmElementQuestType;
import de.tcat.opensidewalks.data.osm.changes.StringMapEntryAdd;
import de.tcat.opensidewalks.quests.building_levels.AddBuildingLevelsForm;
import de.tcat.opensidewalks.quests.building_levels.AddBuildingLevels;

public class AddBuildingLevelsTest extends AOsmElementQuestTypeTest
{
	@Override public void setUp()
	{
		super.setUp();
		tags.put("building","residential");
	}

	public void testBuildingLevelsOnly()
	{
		bundle.putInt(AddBuildingLevelsForm.BUILDING_LEVELS, 5);
		verify(
				new StringMapEntryAdd("building:levels","5"));
	}

	public void testBuildingLevelsAndZeroRoofLevels()
	{
		bundle.putInt(AddBuildingLevelsForm.BUILDING_LEVELS, 5);
		bundle.putInt(AddBuildingLevelsForm.ROOF_LEVELS, 0);
		verify(
				new StringMapEntryAdd("building:levels","5"),
				new StringMapEntryAdd("roof:levels","0"));
	}

	public void testBuildingLevelsAndRoofLevels()
	{
		bundle.putInt(AddBuildingLevelsForm.BUILDING_LEVELS, 5);
		bundle.putInt(AddBuildingLevelsForm.ROOF_LEVELS, 3);
		verify(
				new StringMapEntryAdd("building:levels","5"),
				new StringMapEntryAdd("roof:levels","3"));
	}

	@Override protected OsmElementQuestType createQuestType()
	{
		return new AddBuildingLevels(null);
	}
}
