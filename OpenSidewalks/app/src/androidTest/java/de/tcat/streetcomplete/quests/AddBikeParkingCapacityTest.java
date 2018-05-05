package de.tcat.opensidewalks.quests;

import de.tcat.opensidewalks.data.osm.OsmElementQuestType;
import de.tcat.opensidewalks.data.osm.changes.StringMapEntryAdd;
import de.tcat.opensidewalks.quests.bike_parking_capacity.AddBikeParkingCapacity;
import de.tcat.opensidewalks.quests.bike_parking_capacity.AddBikeParkingCapacityForm;

public class AddBikeParkingCapacityTest extends AOsmElementQuestTypeTest
{
	@Override public void setUp()
	{
		super.setUp();
		tags.put("amenity","bicycle_parking");
	}

	public void testCapacity()
	{
		bundle.putInt(AddBikeParkingCapacityForm.BIKE_PARKING_CAPACITY, 10);
		verify(
				new StringMapEntryAdd("capacity","10"));
	}

	@Override protected OsmElementQuestType createQuestType()
	{
		return new AddBikeParkingCapacity(null);
	}
}
