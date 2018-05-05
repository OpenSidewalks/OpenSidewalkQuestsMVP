package de.tcat.opensidewalks.quests;

import de.tcat.opensidewalks.data.osm.OsmElementQuestType;
import de.tcat.opensidewalks.quests.road_surface.AddRoadSurfaceForm;
import de.tcat.opensidewalks.data.osm.changes.StringMapEntryAdd;
import de.tcat.opensidewalks.quests.road_surface.AddRoadSurface;

public class AddRoadSurfaceTest extends AOsmElementQuestTypeTest
{
	@Override public void setUp()
	{
		super.setUp();
		tags.put("highway","residential");
	}

	public void testSurface()
	{
		bundle.putString(AddRoadSurfaceForm.SURFACE, "cobblestone");
		verify(new StringMapEntryAdd("surface","cobblestone"));
	}

	@Override protected OsmElementQuestType createQuestType()
	{
		return new AddRoadSurface(null);
	}
}
