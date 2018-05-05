package de.tcat.opensidewalks.quests.recycling;

import de.tcat.opensidewalks.quests.ImageListQuestAnswerFragment;

public class AddRecyclingTypeForm extends ImageListQuestAnswerFragment
{
	private final OsmItem[] TYPES = new OsmItem[] {
			new OsmItem("overground", de.tcat.opensidewalks.R.drawable.recycling_container, de.tcat.opensidewalks.R.string.overground_recycling_container),
			new OsmItem("underground", de.tcat.opensidewalks.R.drawable.recycling_container_underground, de.tcat.opensidewalks.R.string.underground_recycling_container),
			new OsmItem("centre", de.tcat.opensidewalks.R.drawable.recycling_centre, de.tcat.opensidewalks.R.string.recycling_centre)
	};

	@Override protected ImageListQuestAnswerFragment.OsmItem[] getItems() { return TYPES; }
	@Override protected int getItemsPerRow() { return 3; }
}
