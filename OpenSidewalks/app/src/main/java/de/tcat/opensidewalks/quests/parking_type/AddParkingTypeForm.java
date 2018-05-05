package de.tcat.opensidewalks.quests.parking_type;

import de.tcat.opensidewalks.quests.ImageListQuestAnswerFragment;

public class AddParkingTypeForm extends ImageListQuestAnswerFragment
{
	private final OsmItem[] TYPES = new OsmItem[] {
			new OsmItem("surface", de.tcat.opensidewalks.R.drawable.parking_type_surface, de.tcat.opensidewalks.R.string.quest_parkingType_surface),
			new OsmItem("underground", de.tcat.opensidewalks.R.drawable.parking_type_underground, de.tcat.opensidewalks.R.string.quest_parkingType_underground),
			new OsmItem("multi-storey", de.tcat.opensidewalks.R.drawable.parking_type_multistorey, de.tcat.opensidewalks.R.string.quest_parkingType_multiStorage)
	};

	@Override protected OsmItem[] getItems() { return TYPES; }
	@Override protected int getItemsPerRow() { return 3; }
}
