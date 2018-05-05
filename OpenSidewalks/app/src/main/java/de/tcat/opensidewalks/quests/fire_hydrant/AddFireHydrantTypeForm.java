package de.tcat.opensidewalks.quests.fire_hydrant;

import de.tcat.opensidewalks.quests.ImageListQuestAnswerFragment;

public class AddFireHydrantTypeForm extends ImageListQuestAnswerFragment
{
	private final OsmItem[] TYPES = new OsmItem[] {
			new OsmItem("pillar", de.tcat.opensidewalks.R.drawable.fire_hydrant_pillar, de.tcat.opensidewalks.R.string.quest_fireHydrant_type_pillar),
			new OsmItem("underground", de.tcat.opensidewalks.R.drawable.fire_hydrant_underground, de.tcat.opensidewalks.R.string.quest_fireHydrant_type_underground),
			new OsmItem("wall", de.tcat.opensidewalks.R.drawable.fire_hydrant_wall, de.tcat.opensidewalks.R.string.quest_fireHydrant_type_wall),
			new OsmItem("pond", de.tcat.opensidewalks.R.drawable.fire_hydrant_pond, de.tcat.opensidewalks.R.string.quest_fireHydrant_type_pond)
	};

	@Override protected OsmItem[] getItems() { return TYPES; }
	@Override protected int getItemsPerRow() { return 2; }
	@Override protected int getMaxNumberOfInitiallyShownItems() { return 2; }
}
